package climateVisualizer;

import java.util.HashMap;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import static spark.Spark.get;

/**
 * Main method to run climate visualizer web app.
 * @author roque
 *
 */
public class App {
	
	/**
	 * Main method declaring spark routes and web app.
	 * @param args
	 */
	public static void main(String[] args) {
		
		get("/", (request,response) -> {
		    HashMap<String, Object> model = new HashMap<>();
		    return new ThymeleafTemplateEngine().render(new ModelAndView(model,
                    "index"));
		});

		get("/hello", ((request, response) -> {
		    return "<h1>Hello, World!</h1>";
        }));
		
	}
}
