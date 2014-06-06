import com.mongodb.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cstancu on 29/05/2014.
 */
public class MainMongoDBSparkFreemarker {
    public static void main(String[] args) {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(MainMongoDBSparkFreemarker.class, "/");

        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                StringWriter writer = new StringWriter();
                try {
                    Template template = configuration.getTemplate("template.ftl");
                    Map<String, Object> map = new HashMap<String, Object>();

                    MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
                    DB db = client.getDB("test");
                    DBCollection collection = db.getCollection("first");

                    template.process(collection.findOne(), writer);
                } catch (IOException e) {
                    e.printStackTrace();
                    halt(500);
                } catch (TemplateException e) {
                    e.printStackTrace();
                    halt(500);
                }
                return writer;
            }
        });
    }
}
