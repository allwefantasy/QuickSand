package net.csdn.document;

import net.csdn.common.exception.AutoGeneration;
import net.csdn.mongo.Document;
import net.csdn.mongo.association.Options;
import net.csdn.mongo.embedded.AssociationEmbedded;

import static net.csdn.common.collections.WowCollections.map;
import static net.csdn.mongo.validate.ValidateHelper.presence;

/**
 * 5/30/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class Task extends Document {

    static {

        storeIn("tasks");
        alias("name", "_id");
        hasManyEmbedded("dbs", new Options(map(
                Options.n_kclass, DB.class
        )));

        validate("name", map(presence, map("message", "name should not be empty")));
        validate("cronTime", map(presence, map("message", "cronTime should not be empty")));
        validate("userName", map(presence, map("message", "userName should not be empty")));

    }


    private String name;
    private String cronTime;
    private String userName;
    private Integer batchSaveNum = 1000;
    private String created_at;


    public AssociationEmbedded dbs() {
        throw new AutoGeneration();
    }


    //getter/setter ignore them


    public Integer getBatchSaveNum() {
        return batchSaveNum;
    }

    public void setBatchSaveNum(Integer batchSaveNum) {
        this.batchSaveNum = batchSaveNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCronTime() {
        return cronTime;
    }

    public void setCronTime(String cronTime) {
        this.cronTime = cronTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }


}
