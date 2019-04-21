import org.apache.*;
import org.apache.commons.math3.stat.Frequency;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.awt.Color;

import org.knowm.xchart.*;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.demo.charts.bar.BarChart01;
import org.knowm.xchart.demo.charts.bar.BarChart05;
import org.knowm.xchart.demo.charts.bar.BarChart06;
import org.knowm.xchart.internal.ChartBuilder;
import org.knowm.xchart.internal.chartpart.Chart;
import org.knowm.xchart.style.Styler.LegendPosition;

/**
 * A class to perform statistical analysis using the monthly temperature date
 * from 1900 to 2017 based on the user input location
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
	TreeMap<Double, Double> AvgTemp = new TreeMap<>();
	List<Integer> hottest_month = new ArrayList<Integer>();
	List<Integer> count = new ArrayList<Integer>();

	double lat;
	double lon;

	private ArrayList<Double> climate = new ArrayList<Double>();
	public static ArrayList<Integer> num = new ArrayList<Integer>();
	int number = 0;

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
	 * Read in the temperature for this location across all years and identify the
	 * max temperature for this.
	 * 
	 * @param lon
	 * @param lat
	 * @return
	 */
	public Map<String, Double> max_temp_year() {
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
			if (y < 2) {

				System.out.println("temp for jan is " + allData[y].getJan());
				System.out.println("temp for feb is " + allData[y].getFeb());
				System.out.println("temp for mar is " + allData[y].getMar());
				System.out.println("temp for apr is " + allData[y].getApr());
				System.out.println("temp for may is " + allData[y].getMay());
				System.out.println("temp for jun is " + allData[y].getJun());
				System.out.println("temp for jul is " + allData[y].getJul());
				System.out.println("temp for aug is " + allData[y].getAug());
				System.out.println("temp for sep is " + allData[y].getSep());
				System.out.println("temp for oct is " + allData[y].getOct());
				System.out.println("temp for nov is " + allData[y].getNov());
				System.out.println("temp for dec is " + allData[y].getDec());
			}
		}

		// Copy all data from hashMap into TreeMap
		MaxTemp.putAll(maxtemp);

		// Display the TreeMap which is naturally sorted
		for (Entry<String, Double> entry : MaxTemp.entrySet())
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

		return MaxTemp;

	}

	/**
	 * count how many time each month is the hottest from 1900-2017
	 * 
	 * @param maxtemplist
	 * @return
	 */
	public List<Integer> getHottestMonCount(Map<String, Double> maxtemplist) {
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
		for (Entry<String, Double> entry : maxtemplist.entrySet()) {
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
	 * create a
	 * 
	 * @return
	 */
	public List<Integer> getMonth() {
		for (int m = 1; m < 13; m++) {
			hottest_month.add(m);
		}
		return hottest_month;

	}

	/**
	 * get average temperature for selected location in a year
	 * 
	 * @param lon
	 * @param lat
	 * @return
	 */
	public Map<Double, Double> avg_temp_year() {
		WeatherDatabase wd = new WeatherDatabase(lon, lat);
		Year[] allData = wd.getYearlyTemp();
		Map<Double, Double> avgtemp = new HashMap<Double, Double>();
		for (int y = 0; y < allData.length; y++) {
			double year = 1900 + y;
			double sum_temp;
			sum_temp = allData[y].getJan() + allData[y].getFeb() + allData[y].getMar() + allData[y].getApr()
					+ allData[y].getMay() + allData[y].getJun() + allData[y].getJul() + allData[y].getAug()
					+ allData[y].getSep() + allData[y].getOct() + allData[y].getNov() + allData[y].getDec();
			double avg_temp = sum_temp / 12;
			avgtemp.put(year, avg_temp);
		}

		// Copy all data from hashMap into TreeMap
		AvgTemp.putAll(avgtemp);

		// Display the TreeMap which is naturally sorted
		for (Entry<Double, Double> entry : AvgTemp.entrySet())
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

		System.out.println(AvgTemp);
		return AvgTemp;

	}

	public static void main(String[] args) {

		StatsAnalysis climatedata = new StatsAnalysis(12.33, 25.66);

		climatedata.max_temp_year();
		climatedata.avg_temp_year();

		Set<Entry<Double, Double>> AvgTempEntrySet = climatedata.AvgTemp.entrySet();
		ArrayList<Entry<Double, Double>> yearList = new ArrayList<Entry<Double, Double>>(AvgTempEntrySet);

		Collection<Double> AvgTempValues = climatedata.AvgTemp.values();
		ArrayList<Double> listOfValues = new ArrayList<Double>(AvgTempValues);

		double[] yearlist = new double[yearList.size()];
		double[] avgtemplist = new double[listOfValues.size()];

		for (int i = 0; i < yearlist.length; i++) {
			yearlist[i] = yearList.get(i).getKey();
			avgtemplist[i] = yearList.get(i).getValue();
		}

		System.out.println(Arrays.toString(yearlist));

		// Create Line Chart
		XYChart chart = QuickChart.getChart("Average Temperature for Selected Location (1900-2017)", "Year",
				"Average Temperature", "y(x)", yearlist, avgtemplist);
		new SwingWrapper<XYChart>(chart).displayChart();

		// Create Bar Chart
		CategoryChart chart3 = new CategoryChartBuilder().width(800).height(600).title("Hotest Month Histogram")
				.xAxisTitle("Month").yAxisTitle("Count").build();

		chart3.getStyler().setLegendPosition(LegendPosition.InsideNW);
		chart3.getStyler().setHasAnnotations(true);
		chart3.addSeries("Count", climatedata.getMonth(), climatedata.getHottestMonCount(climatedata.MaxTemp));
		new SwingWrapper<CategoryChart>(chart3).displayChart();

	}
}
