package net.csdn.service.dump;

import com.google.inject.Inject;
import com.mongodb.DBObject;
import net.csdn.common.collections.WowCollections;
import net.csdn.common.settings.Settings;
import net.csdn.document.DB;
import net.csdn.modules.persist.mysql.MysqlClient;
import net.csdn.mongo.Document;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 5/30/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class DBCrawlerImpl implements DBCrawler {

    private Settings settings;

    @Inject
    public DBCrawlerImpl(Settings settings) {
        this.settings = settings;
    }

    @Override
    public void query(final DB db) {
        MysqlClient mysqlClient = new MysqlClient(new DumpDataSourceManager(db).datasource());
        mysqlClient.settings(this.settings);
        mysqlClient.executeStreamingQuery(db.getSql(), new MysqlClient.SqlCallback<Object>() {
            @Override
            public Object execute(ResultSet rs) {

                try {
                    List<DBObject> items = new ArrayList<DBObject>(1001);
                    while (rs.next()) {
                        Map item = MysqlClient.rsToMap(rs, MysqlClient.getRsCloumns(rs));
                        items.add(WowCollections.translateMapToDBObject(item));
                        System.out.println(JSONObject.fromObject(item).toString());
                        if (items.size() > 1000) {
                            Document.mongoMongo.collection(db.getDbName()).insert(items);
                            items.clear();
                        }
                    }
                    Document.mongoMongo.collection(db.getDbName()).insert(items);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

    }
}
