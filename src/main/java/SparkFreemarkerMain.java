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
public class SparkFreemarkerMain {
    public static void main(String[] args) {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(SparkFreemarkerMain.class, "/");

        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                StringWriter writer = new StringWriter();
                try {
                    Template template = configuration.getTemplate("template.ftl");
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("name", "Spark Freemarker");

                    template.process(map, writer);
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