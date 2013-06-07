package net.csdn.document;

import net.csdn.common.exception.AutoGeneration;
import net.csdn.mongo.Document;
import net.csdn.mongo.association.Options;
import net.csdn.mongo.embedded.AssociationEmbedded;

import static net.csdn.common.collections.WowCollections.map;

/**
 * 5/30/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class DB extends Document {


    static {
        belongsToEmbedded("task", new Options(map(
                Options.n_kclass, Task.class
        )));
        hasOneEmbedded("driver", new Options(map(
                Options.n_kclass, DBDriverInfo.class
        )));
    }

    public AssociationEmbedded driver() {
        throw new AutoGeneration();
    }

    public AssociationEmbedded task() {
        throw new AutoGeneration();
    }


    private String sql;
    private String dbHost;
    private Integer dbPort;
    private String dbUserName;
    private String dbPassword;
    private String dbName;
    private String prefix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getDbHost() {
        return dbHost;
    }

    public void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }

    public Integer getDbPort() {
        return dbPort;
    }

    public void setDbPort(Integer dbPort) {
        this.dbPort = dbPort;
    }

    public String getDbUserName() {
        return dbUserName;
    }

    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }
}
