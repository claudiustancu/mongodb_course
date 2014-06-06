import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created by cstancu on 29/05/2014.
 */
public class Main {

    public static void main(String args[]) throws UnknownHostException {

        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

        DB db = client.getDB("test");

        DBCollection collection = db.getCollection("first");

        DBObject object = collection.findOne();

        System.out.println(object);
    }
}