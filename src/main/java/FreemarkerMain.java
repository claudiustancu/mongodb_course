import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cstancu on 29/05/2014.
 */
public class FreemarkerMain {
    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(FreemarkerMain.class, "/");

        Template template = configuration.getTemplate("template.ftl");
        StringWriter writer = new StringWriter();
        Map<String, Object> objectMap = new HashMap<String, Object>();
        objectMap.put("name", "Claudiu");

        template.process(objectMap, writer);

        System.out.println(writer);
    }
}
