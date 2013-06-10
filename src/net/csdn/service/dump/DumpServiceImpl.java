package net.csdn.service.dump;

import com.google.inject.Inject;
import net.csdn.common.logging.CSLogger;
import net.csdn.common.logging.Loggers;
import net.csdn.common.settings.Settings;
import net.csdn.controller.thrift.CLoadService;
import net.csdn.document.DB;
import net.csdn.document.Task;
import net.csdn.document.TaskLog;
import net.csdn.modules.persist.mysql.MysqlClient;
import net.csdn.modules.persist.mysql.SqlClient;
import net.csdn.modules.thrift.ThriftClient;
import net.csdn.modules.thrift.ThriftConnectException;
import net.sf.json.JSONArray;
import org.apache.thrift.TException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static net.csdn.common.collections.WowCollections.map;

/**
 * 5/30/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class DumpServiceImpl implements DumpService {

    private Settings settings;
    private ThriftClient<CLoadService.Client> dbLoadServiceThriftClient;
    private final String LoadServer = "thrift.servers.load";
    private CSLogger logger = Loggers.getLogger(DumpServiceImpl.class);

    @Inject
    public DumpServiceImpl(Settings settings) {
        this.settings = settings;
        dbLoadServiceThriftClient = ThriftClient.build(CLoadService.Client.class);
    }

    @Override
    public void dump(final DB db) throws SQLException {
        SqlClient sqlClient = new SqlClient(new DumpDataSourceManager(db).datasource());
        sqlClient.executeStreamingQuery(db.getSql(), new SqlClient.SqlCallback<Object>() {
            @Override
            public Object execute(ResultSet rs) {

                try {
                    Task task = db.task().findOne();
                    final List<Map> items = new ArrayList<Map>(task.getBatchSaveNum());
                    int count = 0;
                    while (rs.next()) {
                        Map item = MysqlClient.rsToMap(rs, MysqlClient.getRsCloumns(rs));
                        items.add(item);
                        if (items.size() > task.getBatchSaveNum()) {
                            loadData(db.getPrefix(), items);
                            items.clear();
                        }
                        count++;
                    }
                    TaskLog.createLog((Task) db.task().findOne(), map(
                            "message", "task process total data:[" + count + "]"
                    ));
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
        try {
            dbLoadServiceThriftClient.execute(server, new ThriftClient.Callback<CLoadService.Client>() {
                @Override
                public void execute(CLoadService.Client client) {
                    try {
                        client.load(prefix, JSONArray.fromObject(items).toString());
                    } catch (TException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (ThriftConnectException e) {

        }
    }

}
