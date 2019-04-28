import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StatsAnalysisTest {

	@Test
	void testGetHottestMonCount() {
		StatsAnalysis analysis = new StatsAnalysis(12.33, 25.66);
		
	}

	@Test
	void testGetMonth() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAvgTemp() {
		fail("Not yet implemented");
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

}
