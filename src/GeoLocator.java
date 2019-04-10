import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * A class used to parse street address into Latitude and Longitude data using
 * the OpenStreetMap (OSM) Nominatim service to obtain geocoding information. 
 * The class obtains JSON inputs containing the geocoding information which are
 * parsed using the GSON API. 
 * @author roque
 *
 */
public class GeoLocator {
	
	/**
	 * Default constructor for the GeoLocator Instance.
	 */
	public GeoLocator() {
	}
	
	/**
	 * Helper method to query the Nominatim web service for geocoding data.
	 * This method raises an IOException if the url is not built properly and
	 * returns null if the connection to the web service cannot be reached.
	 * @param url
	 * @return
	 * @throws IOException 
	 */
	private String urlQuery(String url) throws IOException {
		
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
	 * Method to get back Lat,Lon coordinates based on a given street address, 
	 * returning a Tuple (first,second) pair value containing (Lat,Lon). Throws
	 * IOException if urlQuery throws IOException due to malformed URL.
	 * @param address
	 * @return
	 * @throws IOException
	 */
	public Optional<Tuple<Double,Double>> getLatLon(String address) 
			throws IOException {
		// Initialize variables.
		String[] token = address.split(" ");
		StringBuilder query = new StringBuilder();
		String geoData;
		
		// Build query url
		query.append("https://nominatim.openstreetmap.org/search?q=");
		
		// Check for a nonsense input (no word characters).
		Pattern noWord = Pattern.compile("^\\W*$");
		Matcher match = noWord.matcher(address);
		if (match.find()) {
			// return empty optional if query was nonsense or empty
			return Optional.empty();
		}
		
		// Loop through the string of tokens and append to the url
		for (int ind = 0; ind < token.length; ind ++) {
			query.append(token[ind]);
			
			// Check if not the last token
			if (ind < token.length -1) {
				query.append("+");
			}
		}
		
		// After appending all tokens, finish url with output details.
		query.append("&format=json&addressdetails=1");
		
		// Request data with url query, may throw an IOException to propagate up
		geoData = urlQuery(query.toString());
		
		// Check to see if query returned nothing
		if (geoData == null) {
			// return empty optional
			return Optional.empty();
		}
		
		// Now parse query results as an array of json objects
		JsonObject[] jsonGeo = new Gson().fromJson(geoData, JsonObject[].class);
		// Then fetch the latitude and longitude from the top result
		Double latitude = jsonGeo[0].get("lat").getAsDouble();
		Double longitude = jsonGeo[0].get("lon").getAsDouble();
		
		// return empty optional if query was empty.
		return Optional.of(new Tuple<Double,Double>(latitude, longitude));
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
		
		public Tuple(T first, U second) {
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
