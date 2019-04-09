import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

/**
 * A class used to parse street address into Latitude and Longitude data using
 * the OpenStreetMap (OSM) Nominatim service to obtain geocoding information. 
 * The class obtains JSON inputs containing the geocoding information which are
 * parsed using the GSON API. 
 * @author roque
 *
 */
public class GeoLocator {
	
	private Gson jsonParser;
	
	/**
	 * Default constructor for the GeoLocator Instance.
	 */
	public GeoLocator() {
		 jsonParser = new Gson();
	}
	
	/**
	 * Helper method to query the Nominatim web service for geocoding data.
	 * This method raises an IOException if the url is not built properly and
	 * returns null if the connection to the web service cannot be reached.
	 * @param url
	 * @return
	 * @throws IOException 
	 */
	private String requestData(String url) throws IOException {
		
		// First build URL object and setup connection to site.
		URL urlFull = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) 
				urlFull.openConnection();
		
		// Set the appropriate connection method and test the response.
		connection.setRequestMethod("GET");
		if (connection.getResponseCode() != 200) {
			return null;
		}
		
		// Read the input stream from the connection
		BufferedReader br = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		
		// Store input line and Initialize a StringBuilder 
		String line =  br.readLine();
		StringBuilder input = new StringBuilder();
		
		// Loop until stream is empty as you append to the StringBuilder
		while (line != null) {
			input.append(line);
			line = br.readLine();
		}
		
		// Close the stream and return StringBuilder as a String.
		br.close();
		
		return input.toString();
	}
	
	/**
	 * A Tuple sub-class for use in returning multiple values of generic type
	 * from a given method.
	 * @author roque
	 *
	 * @param <T>
	 * @param <U>
	 */
	public static class Tuple<T,U> {
		private final T first;
		private final U second;
		
		private Tuple(T first, U second) {
			this.first = first;
			this.second = second;
		}
		
		public T getFirst() {
			return first;
		}
		
		public U getSecond() {
			return second;
		}
	}
	
}
