package main.java.climateVisualizer;

import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

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
		
		get("/hello/:name", App::message, 
				new ThymeleafTemplateEngine());
		
	}

	public static ModelAndView message(Request request, Response response) {
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", request.params(":name"));
		return new ModelAndView(parameters, "hello");
	}

}
