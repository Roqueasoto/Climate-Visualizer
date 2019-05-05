import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StatsAnalysisTest {
	
	@Test
	void testGetHottestMonCount() {
		StatsAnalysis analysis = new StatsAnalysis(12.33, 25.66);
		
		//check April
		assertEquals(28, (int)analysis.getHottestMonCount().get(3));

		//check May
		assertEquals(75, (int)analysis.getHottestMonCount().get(4));
		
		//check June
		assertEquals(15, (int)analysis.getHottestMonCount().get(5));
		
		// check the size
		assertEquals(12, analysis.getHottestMonCount().size());
	}
	
	@Test
	void testGetMonth() {
		StatsAnalysis analysis = new StatsAnalysis(12.33, 25.66);
		//check month sequence;
		for (int i = 0; i < analysis.getMonth().size(); i++) {
			assertEquals(i + 1, (int) analysis.getMonth().get(i));
		}

	}

	@Test
	void testGetAvgTemp() {
		StatsAnalysis analysis = new StatsAnalysis(12.33, 25.66);

		// check if the first month average temperature is calculated as expected
		assertEquals(27.57, Math.round(analysis.getAvgTemp().get(0) * 100.0) / 100.0);
		// check if the last month average temperature is calculated as expected
		assertEquals(28.34, Math.round(analysis.getAvgTemp().get(117) * 100.0) / 100.0);

		// check if the study period we looked is 118 years
		assertEquals(analysis.getAvgTemp().size(), 118);
	}

	@Test
	void testGetYear() {
		StatsAnalysis analysis = new StatsAnalysis(12.33, 25.66);

		// check if first year is 1900 and last year is 2017
		assertEquals(Integer.valueOf(1900), analysis.getYear().get(0));
		assertEquals(Integer.valueOf(2017), analysis.getYear().get(analysis.getYear().size() - 1));

		// check if the study period we looked is 118 years
		assertEquals(analysis.getYear().size(), 118);

	}

	@Test
	void testGetModeHottestMonth() {
		StatsAnalysis analysis = new StatsAnalysis(12.33, 25.66);
		
		//check values of 1900 and 2017
		assertEquals(Integer.valueOf(5), analysis.getModeHottestMonth().get(1-1));
		assertEquals(Integer.valueOf(5), analysis.getModeHottestMonth().get(12-1));
		
		// check the size
		assertEquals(12, analysis.getModeHottestMonth().size());
	}
	
	@Test
	void testGetMonAvgTemp() {
		StatsAnalysis analysis = new StatsAnalysis(12.33, 25.66);

		// check values of Jan and Dec
		assertEquals(23.29, Math.round(analysis.getMonAvgTemp().get(1 - 1) * 100.0) / 100.0);
		assertEquals(23.77, Math.round(analysis.getMonAvgTemp().get(12 - 1) * 100.0) / 100.0);

		// check the size
		assertEquals(12, analysis.getMonAvgTemp().size());
		
	}
	
	@Test
	void testGetMonthNum() {
		StatsAnalysis analysis = new StatsAnalysis(12.33, 25.66);

		//check month sequence;
		for (int i = 0; i < analysis.getMonthNum().size(); i++) {
			assertEquals(i + 1, analysis.getMonthNum().get(i).intValue());
		}
		
	}
}
