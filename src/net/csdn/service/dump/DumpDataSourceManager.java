package net.csdn.service.dump;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.csdn.document.DB;
import net.csdn.document.DBDriverInfo;

import javax.sql.DataSource;
import java.util.Map;

import static net.csdn.common.logging.support.MessageFormat.format;

/**
 * 5/30/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class DumpDataSourceManager {

    private Map<String, DataSource> dataSourceMap;
    private DB db;
    private DataSource dataSource;

    public DumpDataSourceManager(DB db) {
        this.db = db;
        buildPool();
    }


    public DataSource datasource() {
        return dataSource;
    }

    //jdbc:mysql://{}:{}/{}?useUnicode=true&characterEncoding=utf8
    private ComboPooledDataSource buildPool() {
        DBDriverInfo dbDriverInfo = db.driver().findOne();
        try {
            Class.forName(dbDriverInfo.getDriverName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = dbDriverInfo.getUrl();

        url = format(url, db.getDbHost(), db.getDbPort(), db.getDbName());

        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setUser(db.getDbUserName());
            dataSource.setPassword(db.getDbPassword());
            dataSource.setJdbcUrl(url);
            dataSource.setMaxPoolSize(1);
            dataSource.setDriverClass(dbDriverInfo.getDriverName());
            this.dataSource = dataSource;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
