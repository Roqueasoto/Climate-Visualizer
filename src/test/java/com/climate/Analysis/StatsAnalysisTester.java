package com.climate.Analysis;


/* This is for future use in a Junit Test Case.

public class StatsAnalysisTester {

	public static void main(String[] args) {
		StatsAnalysis climatedata = new StatsAnalysis(12.33, 25.66);

		// Create Line Chart
		XYChart chart = QuickChart.getChart("Average Temperature for Selected Location (1900-2017)", "Year",
				"Average Temperature", "y(x)", climatedata.getYear(), climatedata.getAvgTemp());
		new SwingWrapper<XYChart>(chart).displayChart();

		// Create Bar Chart
		CategoryChart chart3 = new CategoryChartBuilder().width(800).height(600).title("Hotest Month Histogram")
				.xAxisTitle("Month").yAxisTitle("Count").build();

		chart3.getStyler().setLegendPosition(LegendPosition.InsideNW);
		chart3.getStyler().setHasAnnotations(true);
		chart3.addSeries("Count", climatedata.getMonth(), climatedata.getHottestMonCount());
		new SwingWrapper<CategoryChart>(chart3).displayChart();	
	}
	
}
*/