import java.util.*;
import java.util.Map.Entry;

/**
 * A class to perform statistical analysis using the monthly temperature date
 * from 1900 to 2017 based on the user input location
 * 
 * 1) create a line chart to plot the average temperature of the 12 month in a
 * year from 1900-2017
 * 
 * 2) count which month are hottest in a year from 1900-2017 create a histogram
 * of this
 * 
 * 3) create a line chart get mode hottest month for each ten years in the
 * natural order of 1900-2017
 * 
 * 
 * 4) create a line chart to get average temperature by month for selected
 * location of 1900-2017
 * 
 * @author Hua
 *
 */

public class StatsAnalysis {

	private double lat;
	private double lon;

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

		TreeMap<String, Double> MaxTemp = new TreeMap<>();
		Map<String, Double> maxtemp = new HashMap<String, Double>();
		List<Integer> count = new ArrayList<Integer>();

		WeatherDatabase wd = new WeatherDatabase(lon, lat);
		Year[] allData = wd.getYearlyTemp();

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

		// get the frequency of hottest month in 1900-2017
		int sum[] = new int[12];

		// aggregate the counts to the month level
		for (Entry<String, Double> entry : MaxTemp.entrySet()) {
			for (int i = 0; i < 12; i++) {
				if (i < 9) {
					if (Integer.valueOf(entry.getKey().substring(5)) == i + 1) {
						sum[i] = sum[i] + 1;
					}
				} else {
					if (Integer.valueOf(entry.getKey().substring(4)) == i + 1) {
						sum[i] = sum[i] + 1;
					}
				}
			}
		}

		// put the counts into ArrayList
		for (int i : sum) {
			count.add(i);
		}

		return count;
	}

	/**
	 * This is portion 2 of the histogram. Read in the temperature for this location
	 * create a list of month (jan-dec). the returned list would be the x axis of
	 * the histogram
	 * 
	 * @return a list of 12 month by natural order
	 */
	public List<Integer> getMonth() {
		List<Integer> hottest_month = new ArrayList<Integer>();
		for (int m = 1; m < 13; m++) {
			hottest_month.add(m);
		}
		return hottest_month;

	}

	/**
	 * This is portion 1 of the line chart get average temperature for selected
	 * location in a year in the natural order of 1900-2017 this returns the y axis
	 * for the line chart
	 * 
	 * @param lon
	 * @param lat
	 * @return a a list of value as the average temperature
	 */
	public List<Double> getAvgTemp() {

		Map<Integer, Double> avgtemp = new HashMap<Integer, Double>();
		TreeMap<Integer, Double> AvgTemp = new TreeMap<>();
		List<Double> avg_temperature = new ArrayList<Double>();

		WeatherDatabase wd = new WeatherDatabase(lon, lat);
		Year[] allData = wd.getYearlyTemp();
		
		//calculate the average temperature for each year
		for (int y = 0; y < allData.length; y++) {
			int year = 1900 + y;
			double sum_temp;
			sum_temp = allData[y].getJan() + allData[y].getFeb() + allData[y].getMar() + allData[y].getApr()
					+ allData[y].getMay() + allData[y].getJun() + allData[y].getJul() + allData[y].getAug()
					+ allData[y].getSep() + allData[y].getOct() + allData[y].getNov() + allData[y].getDec();
			double avg_temp = sum_temp / 12;
			if (y == 0 | y == allData.length - 1) {
				System.out.println("year is " + year);
				System.out.println("temp is " + sum_temp);
			}
			avgtemp.put(year, avg_temp);
		}

		// Copy all data from hashMap into TreeMap
		AvgTemp.putAll(avgtemp);

		for (int i = 0; i < AvgTemp.size(); i++) {
			int year = 1900 + i;
			avg_temperature.add(AvgTemp.get(year));
		}

		return avg_temperature;
	}

	/**
	 * This is portion 2 of the line chart create a list of year (1900-2017). the
	 * returned list would be the x axis of the line chart
	 * 
	 * @return a list of 12 month by natural order
	 */
	public List<Integer> getYear() {
		List<Integer> yearlist = new ArrayList<Integer>();
		for (int y = 1900; y < 2018; y++) {
			yearlist.add(y);
		}
		return yearlist;
	}

	/**
	 * This is portion 1 of the line chart get mode hottest month for selected
	 * location for each ten years in the natural order of 1900-2017 this returns
	 * the y axis for the line chart
	 * 
	 * @param lon
	 * @param lat
	 * @return a a list of value as the mode hottest month
	 */
	public List<Integer> getModeHottestMonth() {

		TreeMap<Integer, Double> MaxMonth = new TreeMap<>();
		Map<Integer, Double> maxmonth = new HashMap<Integer, Double>();
		List<Integer> modeHottestMonth = new ArrayList<Integer>();

		WeatherDatabase wd = new WeatherDatabase(lon, lat);
		Year[] allData = wd.getYearlyTemp();

		for (int y = 0; y < allData.length; y++) {

			double maxTemp = 0;
			double maxMonth = 0;
			int year = 1900 + y;

			if (allData[y].getJan() > maxTemp) {
				maxTemp = allData[y].getJan();
				maxMonth = 1;
			}
			if (allData[y].getFeb() > maxTemp) {
				maxTemp = allData[y].getFeb();
				maxMonth = 2;
			}
			if (allData[y].getMar() > maxTemp) {
				maxTemp = allData[y].getMar();
				maxMonth = 3;
			}
			if (allData[y].getApr() > maxTemp) {
				maxTemp = allData[y].getApr();
				maxMonth = 4;
			}
			if (allData[y].getMay() > maxTemp) {
				maxTemp = allData[y].getMay();
				maxMonth = 5;
			}
			if (allData[y].getJun() > maxTemp) {
				maxTemp = allData[y].getJun();
				maxMonth = 6;
			}
			if (allData[y].getJul() > maxTemp) {
				maxTemp = allData[y].getJul();
				maxMonth = 7;
			}
			if (allData[y].getAug() > maxTemp) {
				maxTemp = allData[y].getAug();
				maxMonth = 8;
			}
			if (allData[y].getSep() > maxTemp) {
				maxTemp = allData[y].getSep();
				maxMonth = 9;
			}
			if (allData[y].getOct() > maxTemp) {
				maxTemp = allData[y].getOct();
				maxMonth = 10;
			}
			if (allData[y].getNov() > maxTemp) {
				maxTemp = allData[y].getNov();
				maxMonth = 11;
			}
			if (allData[y].getDec() > maxTemp) {
				maxTemp = allData[y].getDec();
				maxMonth = 12;
			}

			maxmonth.put(year, maxMonth);

		}

		// Copy all data from hashMap into TreeMap
		MaxMonth.putAll(maxmonth);

		for (int j = 1; j < 13; j++) {
			Map<Integer, Integer> monthcount = new HashMap<Integer, Integer>();

			int yr_lower_bount = 1900 + (j - 1) * 10;
			int yr_upper_bound = 1900 + (j * 10) - 1;

			int[] counts = new int[12];

			for (Entry<Integer, Double> entry : MaxMonth.entrySet()) {
				if (entry.getKey() >= yr_lower_bount & entry.getKey() <= yr_upper_bound) {

					for (int i = 0; i < 12; i++) {
						if (entry.getValue() == i + 1) {
							counts[i] = counts[i] + 1;
						}
					}
				}
			}

			for (int i = 0; i < 12; i++) {
				monthcount.put(i + 1, counts[i]);
			}

			int max_month_count = 0;
			int max_month_name = 0;
			for (Entry<Integer, Integer> entry : monthcount.entrySet()) {
				if (entry.getValue() > max_month_count) {
					max_month_name = entry.getKey();
					max_month_count = entry.getValue();
				}
			}

			modeHottestMonth.add(max_month_name);
		}
		return modeHottestMonth;
	}

	/**
	 * This is portion 2 of the line chart get mode hottest month for selected
	 * location for each ten years in the natural order of 1900-2017. the returned
	 * list would be the x axis of the line chart
	 * 
	 * @return a list of year range.
	 */
	public List<String> getEachTenYears() {
		List<String> year_range_list = new ArrayList<String>();
		for (int j = 1; j < 13; j++) {
			int yr_lower_bound = 1900 + (j - 1) * 10;
			int yr_upper_bound = 1900 + (j * 10) - 1;
			String year_range = "" + yr_lower_bound + " - " + yr_upper_bound;
			year_range_list.add(year_range);
		}
		return year_range_list;
	}

	/**
	 * supplement section for the line chart to get mode hottest month for selected
	 * location for each ten years in the natural order of 1900-2017. if a list of
	 * double needed
	 * 
	 * @return a list of start year.
	 */
	public List<Double> getEachTenYearsInt() {
		List<Double> year_range_list = new ArrayList<Double>();
		for (int j = 1; j < 13; j++) {
			double yr_lower_bound = 1900 + (j - 1) * 10;
			double yr_upper_bound = 1900 + (j * 10) - 1;
			year_range_list.add(yr_lower_bound);
		}
		return year_range_list;
	}

	/**
	 * This is portion 1 of the line chart to get average temperature by month for
	 * selected location of 1900-2017
	 * 
	 * this returns the y axis for the line chart
	 * 
	 * @return a list of value as the average temperature for Jan to Dec
	 */
	public List<Double> getMonAvgTemp() {

		Map<Integer, Double> avgmontemp = new HashMap<Integer, Double>();
		TreeMap<Integer, Double> AvgMonTemp = new TreeMap<>();
		List<Double> avg_mon_temperature = new ArrayList<Double>();

		WeatherDatabase wd = new WeatherDatabase(lon, lat);
		Year[] allData = wd.getYearlyTemp();

		double[] sum_month_temp = new double[12];
		double[] avg_month_temp = new double[12];
		
		//sum up the temperature
		for (int y = 0; y < allData.length; y++) {
			int year = 1900 + y;
			sum_month_temp[1 - 1] = sum_month_temp[1 - 1] + allData[y].getJan();
			sum_month_temp[2 - 1] = sum_month_temp[2 - 1] + allData[y].getFeb();
			sum_month_temp[3 - 1] = sum_month_temp[3 - 1] + allData[y].getMar();
			sum_month_temp[4 - 1] = sum_month_temp[4 - 1] + allData[y].getApr();
			sum_month_temp[5 - 1] = sum_month_temp[5 - 1] + allData[y].getMay();
			sum_month_temp[6 - 1] = sum_month_temp[6 - 1] + allData[y].getJun();
			sum_month_temp[7 - 1] = sum_month_temp[7 - 1] + allData[y].getJul();
			sum_month_temp[8 - 1] = sum_month_temp[8 - 1] + allData[y].getAug();
			sum_month_temp[9 - 1] = sum_month_temp[9 - 1] + allData[y].getSep();
			sum_month_temp[10 - 1] = sum_month_temp[10 - 1] + allData[y].getOct();
			sum_month_temp[11 - 1] = sum_month_temp[11 - 1] + allData[y].getNov();
			sum_month_temp[12 - 1] = sum_month_temp[12 - 1] + allData[y].getDec();

		}
		
		//calculate the average monthly temperature
		for (int i = 0; i < 12; i++) {
			avg_month_temp[i] = sum_month_temp[i] / allData.length;
			avgmontemp.put(i + 1, avg_month_temp[i]);
		}

		// Copy all data from hashMap into TreeMap
		AvgMonTemp.putAll(avgmontemp);

		for (int i = 0; i < AvgMonTemp.size(); i++) {
			int mon = i + 1;
			avg_mon_temperature.add(AvgMonTemp.get(mon));
		}

		return avg_mon_temperature;
	}

	/**
	 * This is portion 2 of the line chart create a list of month, Jan - Dec (1-12).
	 * the returned list would be the x axis of the line chart
	 * 
	 * @return a list of 12 month by natural order
	 */
	public List<Double> getMonthNum() {

		List<Double> month_num = new ArrayList<Double>();
		for (int m = 1; m < 13; m++) {
			double mon = m;
			month_num.add(mon);
		}

		return month_num;

	}
}
