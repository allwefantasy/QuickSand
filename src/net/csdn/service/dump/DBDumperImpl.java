package net.csdn.service.dump;

import com.google.inject.Inject;
import net.csdn.api.DBLoadService;
import net.csdn.common.settings.Settings;
import net.csdn.document.DB;
import net.csdn.document.Task;
import net.csdn.modules.persist.mysql.MysqlClient;
import net.csdn.modules.thrift.ThriftClient;
import net.csdn.service.load.DataLoader;
import net.csdn.service.load.DataLoaderImpl;
import net.sf.json.JSONArray;
import org.apache.thrift.TException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 5/30/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class DBDumperImpl implements DBDumper {

    private Settings settings;
    private ThriftClient<DBLoadService.Client> dbLoadServiceThriftClient;
    private final String LoadServer = "thrift.servers.load";

    @Inject
    public DBDumperImpl(Settings settings) {
        this.settings = settings;
        dbLoadServiceThriftClient = ThriftClient.build(DBLoadService.Client.class);
    }

    @Override
    public void dump(final DB db) {
        MysqlClient mysqlClient = new MysqlClient(new DumpDataSourceManager(db).datasource());
        mysqlClient.settings(this.settings);
        mysqlClient.executeStreamingQuery(db.getSql(), new MysqlClient.SqlCallback<Object>() {
            @Override
            public Object execute(ResultSet rs) {

                try {
                    Task task = db.task().findOne();
                    final List<Map> items = new ArrayList<Map>(task.getBatchSaveNum());
                    while (rs.next()) {
                        Map item = MysqlClient.rsToMap(rs, MysqlClient.getRsCloumns(rs));
                        items.add(item);
                        if (items.size() > task.getBatchSaveNum()) {
                            loadData(db.getPrefix(), items);
                            items.clear();
                        }
                    }
                    loadData(db.getPrefix(), items);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

    }

    private void loadData(final String prefix, final List<Map> items) {
        String server = settings.getAsArray(LoadServer)[0];
        dbLoadServiceThriftClient.execute(server, new ThriftClient.Callback<DBLoadService.Client>() {
            @Override
            public void execute(DBLoadService.Client client) {
                try {
                    client.load(prefix, JSONArray.fromObject(items).toString());
                } catch (TException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
