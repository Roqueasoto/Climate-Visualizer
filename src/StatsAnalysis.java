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
 * 3) create a line chart get median hottest month for each ten years in the
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
		List<Integer> hottest_month = new ArrayList<Integer>();
		for (int m = 1; m < 13; m++) {
			hottest_month.add(m);
		}
		return hottest_month;

	}

	/**
	 * This is portion 1 of the line chart get average temperature for selected
	 * location in a year in the natural order of 1900-2017
	 * this returns the y axis for the line chart
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
	 * This is portion 2 of the line chart
	 * create a list of year (1900-2017). the returned list would be the x axis of
	 * the line chart
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
	 * This is portion 1 of the line chart get median hottest month for selected
	 * location for each ten years in the natural order of 1900-2017
	 * this returns the y axis for the line chart
	 * 
	 * @param lon
	 * @param lat
	 * @return a a list of value as the median hottest month
	 */
	public List<Double> getMedianHottestMonth() {
		
		TreeMap<Integer, Double> MaxMonth = new TreeMap<>();
		Map<Integer, Double> maxmonth = new HashMap<Integer, Double>();
		List<Double> medianHottestMonth = new ArrayList<Double>();
		
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
			int yr_lower_bount = 1900 + (j - 1) * 10;
			int yr_upper_bound = 1900 + (j * 10) - 1;
			double[] month_list = new double[10];
			int iso = 0;
			for (Entry<Integer, Double> entry : MaxMonth.entrySet()) {
				if (entry.getKey() >= yr_lower_bount & entry.getKey() <= yr_upper_bound) {
					month_list[iso] = entry.getValue();
					iso++;
				}
			}
			
			//calculate the median
			double median = 0;
			double numerator = 0;

			Arrays.sort(month_list);

			if (month_list.length % 2 == 1) {
				median = month_list[month_list.length / 2];
			} else {
				numerator = month_list[(month_list.length - 1) / 2] + month_list[month_list.length / 2];
				median = numerator / 2;

			}
			medianHottestMonth.add(median);
		}
		return medianHottestMonth;		
	}
	
	/**
	 * This is portion 2 of the line chart get median hottest month for selected
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
	 * supplement section for the line chart to get median hottest month for
	 * selected location for each ten years in the natural order of 1900-2017. if a
	 * list of double needed
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
		
		double sum_jan_temp = 0;
		double sum_feb_temp = 0;
		double sum_mar_temp = 0;
		double sum_apr_temp = 0;
		double sum_may_temp = 0;
		double sum_jun_temp = 0;
		double sum_jul_temp = 0;
		double sum_aug_temp = 0;
		double sum_sep_temp = 0;
		double sum_oct_temp = 0;
		double sum_nov_temp = 0;
		double sum_dec_temp = 0;
		
		for (int y = 0; y < allData.length; y++) {
			int year = 1900 + y;
			sum_jan_temp = sum_jan_temp + allData[y].getJan();
			sum_feb_temp = sum_feb_temp + allData[y].getFeb();
			sum_mar_temp = sum_mar_temp + allData[y].getMar();
			sum_apr_temp = sum_apr_temp + allData[y].getApr();
			sum_may_temp = sum_may_temp + allData[y].getMay();
			sum_jun_temp = sum_jun_temp + allData[y].getJun();
			sum_jul_temp = sum_jul_temp + allData[y].getJul();
			sum_aug_temp = sum_aug_temp + allData[y].getAug();
			sum_sep_temp = sum_sep_temp + allData[y].getSep();
			sum_oct_temp = sum_oct_temp + allData[y].getOct();
			sum_nov_temp = sum_nov_temp + allData[y].getNov();
			sum_dec_temp = sum_dec_temp + allData[y].getDec();
		}
		
		double avg_jan_temp = sum_jan_temp/allData.length;
		double avg_feb_temp = sum_feb_temp/allData.length;
		double avg_mar_temp = sum_mar_temp/allData.length;
		double avg_apr_temp = sum_apr_temp/allData.length;
		double avg_may_temp = sum_may_temp/allData.length;
		double avg_jun_temp = sum_jun_temp/allData.length;
		double avg_jul_temp = sum_jul_temp/allData.length;
		double avg_aug_temp = sum_aug_temp/allData.length;
		double avg_sep_temp = sum_sep_temp/allData.length;
		double avg_oct_temp = sum_oct_temp/allData.length;
		double avg_nov_temp = sum_nov_temp/allData.length;
		double avg_dec_temp = sum_dec_temp/allData.length;
		
		avgmontemp.put(1, avg_jan_temp);
		avgmontemp.put(2, avg_feb_temp);
		avgmontemp.put(3, avg_mar_temp);
		avgmontemp.put(4, avg_apr_temp);
		avgmontemp.put(5, avg_may_temp);
		avgmontemp.put(6, avg_jun_temp);
		avgmontemp.put(7, avg_jul_temp);
		avgmontemp.put(8, avg_aug_temp);
		avgmontemp.put(9, avg_sep_temp);
		avgmontemp.put(10, avg_oct_temp);
		avgmontemp.put(11, avg_nov_temp);
		avgmontemp.put(12, avg_dec_temp);
		
		// Copy all data from hashMap into TreeMap
		AvgMonTemp.putAll(avgmontemp);
		
		for (int i = 0; i<AvgMonTemp.size(); i++) {
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
