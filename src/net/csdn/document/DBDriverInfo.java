package net.csdn.document;

import net.csdn.common.exception.AutoGeneration;
import net.csdn.mongo.Document;
import net.csdn.mongo.association.Options;
import net.csdn.mongo.embedded.AssociationEmbedded;

import static net.csdn.common.collections.WowCollections.map;

/**
 * 5/30/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class DBDriverInfo extends Document {
    static {
        belongsToEmbedded("db", new Options(map(
                Options.n_kclass, DB.class
        )));
    }

    private String driverName;
    private String url;

    public AssociationEmbedded db() {
        throw new AutoGeneration();
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
