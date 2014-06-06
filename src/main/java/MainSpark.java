import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by cstancu on 29/05/2014.
 */
public class MainSpark {
    public static void main(String[] args) {
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello Spark!";
            }
        });
    }
}
