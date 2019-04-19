
public class CoordinateWeather {

	public static void main(String[] args) {
		double testLon = -173.2;
		double testLat = 20;
		
		WeatherDatabase wd = new WeatherDatabase(testLon, testLat);
		
		Year[] allData = wd.getYearlyTemp();
		
	}
}
