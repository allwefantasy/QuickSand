package net.csdn.service.load;

import com.mongodb.DBObject;
import net.csdn.common.collections.WowCollections;
import net.csdn.mongo.Document;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 6/3/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class DataLoaderImpl implements DataLoader {

    public void load(String prefix, List<Map> items) {
        List<DBObject> objects = new ArrayList<DBObject>(items.size());
        for (Map item : items) {
            objects.add(WowCollections.translateMapToDBObject(item));
            System.out.println(JSONObject.fromObject(item).toString());
        }
        Document.mongoMongo.collection(prefix).insert(objects);
    }

    public void loadAsString(String prefix, String content) {
        JSONArray abc = JSONArray.fromObject(content);
        load(prefix, abc);
    }
}
