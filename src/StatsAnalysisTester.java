import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.style.Styler.LegendPosition;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.style.Styler.LegendPosition;

public class StatsAnalysisTester {

	public static void main(String[] args) {
		StatsAnalysis climatedata = new StatsAnalysis(12.33, 25.66);

		
		// Create Line Chart for average temperature
		XYChart chart = QuickChart.getChart("Average Temperature for Selected Location (1900-2017)", "Year",
				"Average Temperature", "y(x)", climatedata.getYear(), climatedata.getAvgTemp());
		new SwingWrapper<XYChart>(chart).displayChart();

		// Create Bar Chart to count number of hottest month
		CategoryChart chart2 = new CategoryChartBuilder().width(800).height(600).title("Hottest Month Histogram")
				.xAxisTitle("Month").yAxisTitle("Count").build();

		chart2.getStyler().setLegendPosition(LegendPosition.InsideNW);
		chart2.getStyler().setHasAnnotations(true);
		chart2.addSeries("Count", climatedata.getMonth(), climatedata.getHottestMonCount());
		new SwingWrapper<CategoryChart>(chart2).displayChart();

		// Create Line Chart for median hottest month for each 10 years
		XYChart chart3 = QuickChart.getChart("Mode Hottest Month for Every 10 Years (1900-2017)", "Year Range",
				"Mode Hottest Month", "y(x)", climatedata.getEachTenYearsInt(), climatedata.getModeHottestMonth());
		new SwingWrapper<XYChart>(chart3).displayChart();		

		// Create Line Chart for average temperature of Jan to Dec
		XYChart chart4 = QuickChart.getChart("Average Temperature by Month", "Month",
				"Average Temperature", "y(x)", climatedata.getMonthNum(), climatedata.getMonAvgTemp());
		new SwingWrapper<XYChart>(chart4).displayChart();

	}
	
}
