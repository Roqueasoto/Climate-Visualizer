import java.util.*;
import java.util.Map.Entry;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler.LegendPosition;

/**
 * A class to perform statistical analysis using the monthly temperature date
 * from 1900 to 2017 based on the user input location
 * 
 * 1) create a line chart to plot the average temperature of the 12 month in a
 * year from 1900-2017
 * 
 * 2) count which month are hottest in a year from 1900-2017
 * 
 * @author Hua
 *
 */

public class StatsAnalysis {

	// to do change lon lat into paramters
	// change all the hashmap to be sorted
	// do other summary stats
	// confirm with henry lon goes first?
	// commit to github

	// TreeMap to store values of HashMap
	TreeMap<String, Double> MaxTemp = new TreeMap<>();
	TreeMap<Integer, Double> AvgTemp = new TreeMap<>();
	List<Integer> hottest_month = new ArrayList<Integer>();
	List<Integer> count = new ArrayList<Integer>();
	List<Double> avg_temperature = new ArrayList<Double>();
	List<Integer> yearlist = new ArrayList<Integer>();
	double lat;
	double lon;

	/**
	 * take latitude and longitude as our input
	 * 
	 * @param latitude
	 * @param longitude
	 */
	public StatsAnalysis(double latitude, double longitude) {
		lat = latitude;
		lon = longitude;
	}

	/**
	 * This is portion 1 of the histogram Read in the temperature for this location
	 * across all years and identify the max temperature for this. count how many
	 * time each month is the hottest from 1900-2017. the returned list would be the
	 * y axis for the histogram
	 * 
	 * @param lon
	 * @param lat
	 * @return a list of counts of month when they are the hottest month within each
	 *         year from 1900-2017
	 */
	public List<Integer> getHottestMonCount() {
		WeatherDatabase wd = new WeatherDatabase(lon, lat);
		Year[] allData = wd.getYearlyTemp();

		Map<String, Double> maxtemp = new HashMap<String, Double>();
		for (int y = 0; y < allData.length; y++) {
			String maxYearMonth = "";
			double maxTemp = 0;

			int year = 1900 + y;

			if (allData[y].getJan() > maxTemp) {
				maxTemp = allData[y].getJan();
				maxYearMonth = "" + year + 0 + 1;
			}
			if (allData[y].getFeb() > maxTemp) {
				maxTemp = allData[y].getFeb();
				maxYearMonth = "" + year + 0 + 2;
			}
			if (allData[y].getMar() > maxTemp) {
				maxTemp = allData[y].getMar();
				maxYearMonth = "" + year + 0 + 3;
			}
			if (allData[y].getApr() > maxTemp) {
				maxTemp = allData[y].getApr();
				maxYearMonth = "" + year + 0 + 4;
			}
			if (allData[y].getMay() > maxTemp) {
				maxTemp = allData[y].getMay();
				maxYearMonth = "" + year + 0 + 5;
			}
			if (allData[y].getJun() > maxTemp) {
				maxTemp = allData[y].getJun();
				maxYearMonth = "" + year + 0 + 6;
			}
			if (allData[y].getJul() > maxTemp) {
				maxTemp = allData[y].getJul();
				maxYearMonth = "" + year + 0 + 7;
			}
			if (allData[y].getAug() > maxTemp) {
				maxTemp = allData[y].getAug();
				maxYearMonth = "" + year + 0 + 8;
			}
			if (allData[y].getSep() > maxTemp) {
				maxTemp = allData[y].getSep();
				maxYearMonth = "" + year + 0 + 9;
			}
			if (allData[y].getOct() > maxTemp) {
				maxTemp = allData[y].getOct();
				maxYearMonth = "" + year + 10;
			}
			if (allData[y].getNov() > maxTemp) {
				maxTemp = allData[y].getNov();
				maxYearMonth = "" + year + 11;
			}
			if (allData[y].getDec() > maxTemp) {
				maxTemp = allData[y].getDec();
				maxYearMonth = "" + year + 12;
			}

			maxtemp.put(maxYearMonth, maxTemp);

		}

		// Copy all data from hashMap into TreeMap
		MaxTemp.putAll(maxtemp);
		
		//get the frequency of hottest month in 1900-2017
		int sum_01 = 0;
		int sum_02 = 0;
		int sum_03 = 0;
		int sum_04 = 0;
		int sum_05 = 0;
		int sum_06 = 0;
		int sum_07 = 0;
		int sum_08 = 0;
		int sum_09 = 0;
		int sum_10 = 0;
		int sum_11 = 0;
		int sum_12 = 0;
		for (Entry<String, Double> entry : MaxTemp.entrySet()) {
			if (entry.getKey().substring(4).equals("01")) {
				sum_01 = sum_01 + 1;
			}
			if (entry.getKey().substring(4).equals("02")) {
				sum_02 = sum_02 + 1;
			}
			if (entry.getKey().substring(4).equals("03")) {
				sum_03 = sum_03 + 1;
			}
			if (entry.getKey().substring(4).equals("04")) {
				sum_04 = sum_04 + 1;
			}
			if (entry.getKey().substring(4).equals("05")) {
				sum_05 = sum_05 + 1;
			}
			if (entry.getKey().substring(4).equals("06")) {
				sum_06 = sum_06 + 1;
			}
			if (entry.getKey().substring(4).equals("07")) {
				sum_07 = sum_07 + 1;
			}
			if (entry.getKey().substring(4).equals("08")) {
				sum_08 = sum_08 + 1;
			}
			if (entry.getKey().substring(4).equals("09")) {
				sum_09 = sum_09 + 1;
			}
			if (entry.getKey().substring(4).equals("10")) {
				sum_10 = sum_10 + 1;
			}
			if (entry.getKey().substring(4).equals("11")) {
				sum_11 = sum_11 + 1;
			}
			if (entry.getKey().substring(4).equals("12")) {
				sum_12 = sum_12 + 1;
			}
		}
		count.add(sum_01);
		count.add(sum_02);
		count.add(sum_03);
		count.add(sum_04);
		count.add(sum_05);
		count.add(sum_06);
		count.add(sum_07);
		count.add(sum_08);
		count.add(sum_09);
		count.add(sum_10);
		count.add(sum_11);
		count.add(sum_12);
		return count;
	}
	
	
	/**
	 * This is portion 2 of the histogram.
	 * Read in the temperature for this location
	 * create a list of month (jan-dec). the returned list would be the x axis of
	 * the histogram
	 * 
	 * @return a list of 12 month by natural order
	 */
	public List<Integer> getMonth() {
		for (int m = 1; m < 13; m++) {
			hottest_month.add(m);
		}
		return hottest_month;

	}

	/**
	 * This is portion 1 of the bar chart get average temperature for selected
	 * location in a year in the natural order of 1900-2017
	 * 
	 * @param lon
	 * @param lat
	 * @return a a list of value as the average temperature
	 */
	public List<Double> getAvgTemp() {
		WeatherDatabase wd = new WeatherDatabase(lon, lat);
		Year[] allData = wd.getYearlyTemp();
		Map<Integer, Double> avgtemp = new HashMap<Integer, Double>();
		for (int y = 0; y < allData.length; y++) {
			int year = 1900 + y;
			double sum_temp;
			sum_temp = allData[y].getJan() + allData[y].getFeb() + allData[y].getMar() + allData[y].getApr()
					+ allData[y].getMay() + allData[y].getJun() + allData[y].getJul() + allData[y].getAug()
					+ allData[y].getSep() + allData[y].getOct() + allData[y].getNov() + allData[y].getDec();
			double avg_temp = sum_temp / 12;
			avgtemp.put(year, avg_temp);
		}

		// Copy all data from hashMap into TreeMap
		AvgTemp.putAll(avgtemp);
		
		for (int i = 0; i<AvgTemp.size(); i++) {
			int year = 1900 + i;
			avg_temperature.add(AvgTemp.get(year));
		}

		return avg_temperature;
	}
	
	/**
	 * This is portion 2 of the bar chart
	 * create a list of year (1900-2017). the returned list would be the x axis of
	 * the histogram
	 * 
	 * @return a list of 12 month by natural order
	 */
	public List<Integer> getYear() {
		for (int y = 1900; y < 2018; y++) {
			yearlist.add(y);
		}
		return yearlist;

	}	
	
}
