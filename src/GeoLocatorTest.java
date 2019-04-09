import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class GeoLocatorTest {
	// GeoLocator Instance
	static GeoLocator geo = new GeoLocator();
	
	// For tuple tests
	static GeoLocator.Tuple<Double,Double> latLonMix =  null;
	static GeoLocator.Tuple<Double,Double> latLon0 =  null;
	static GeoLocator.Tuple<Double,Double> latLonMinMax =  null;
	
	// For urlQuery and getLatLon tests
	static String emptyAddress = "";
	static String nonWordAddress = "??: >?";
	static String oneWordAddress = "Philadelphia";
	static String commaAddress = "Philadelphia, Pennsylvania";
	static String fullAddress = 
			"1400 John F Kennedy Blvd, Philadelphia, PA 19107, USA";
	static String nonsenseAddress = "Blue98f sbdbbsld A";
	
	static GeoLocator.Tuple<Double,Double> oneWordLatLon =  null;
	static GeoLocator.Tuple<Double,Double> commaLatLon =  null;
	static GeoLocator.Tuple<Double,Double> fullLatLon =  null;
	static GeoLocator.Tuple<Double,Double> nonsenseLatLon =  null;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		// Setup Tuple values to test the subclass
		latLonMix = new GeoLocator.Tuple<Double,Double>(45.2, -160.4);
		latLon0 = new GeoLocator.Tuple<Double,Double>(0., 0.);
		latLonMinMax = new GeoLocator.Tuple<Double,Double>(-90.0, 180.0);
		
		// TODO
		// Setup urlQuery and getLatLon answers
		oneWordLatLon = new GeoLocator.Tuple<Double,Double>(45.2, -160.4);
		commaLatLon = new GeoLocator.Tuple<Double,Double>(0., 0.);
		fullLatLon = new GeoLocator.Tuple<Double,Double>(-90.0, 180.0);
		nonsenseLatLon = new GeoLocator.Tuple<Double,Double>(-90.0, 180.0);
	}
	
	/**
	 * Tests of the Tuple subclass of the GeoLocation class.
	 */
	@Test
	void tupleTest() {
		// Mixed positive and negative double test.
		assertEquals((Double) 45.2, latLonMix.getFirst(), 
				"Tuple is not outputting first positive values correctly.");
		assertEquals((Double) (-160.4), latLonMix.getSecond(), 
				"Tuple is not outputting second negative values correctly.");
		
		// Zero as double test.
		assertEquals((Double) 0., latLon0.getFirst(), 
				"Tuple is not outputting first zero values correctly.");
		assertEquals((Double) 0.0, latLon0.getSecond(), 
				"Tuple is not outputting second zero values correctly.");
		
		// Minimum and Maximum lat lon values test.
		assertEquals((Double) (-90.0), latLonMinMax.getFirst(), 
				"Tuple is not outputting first mininum lat values correctly.");
		assertEquals((Double) 180., latLonMinMax.getSecond(), 
				"Tuple is not outputting second maximum lon values correctly.");
	}

	@Test
	void queryTest() {
		// Comma Address Test - normally formed input to query, test lat & lon
		try {
		assertEquals(commaLatLon.getFirst(), 
				geo.getLatLon(commaAddress).get().getFirst(), 
				"Comma address is not returning the correct latitude");
		assertEquals(commaLatLon.getSecond(), 
				geo.getLatLon(commaAddress).get().getSecond(), 
					"Comma address is not returning the correct longitude");
		} catch (Exception e) {
			fail("Comma address caused exception.");
		}
		
		// Nonsense Address Test - Possible malformed input to query
		try {
		assertEquals(nonsenseLatLon.getFirst(), 
				geo.getLatLon(nonsenseAddress).get().getFirst(), 
				"Nonsense address is not returning the correct latitude");
		assertEquals(nonsenseLatLon.getSecond(), 
				geo.getLatLon(nonsenseAddress).get().getSecond(), 
				"Nonsense address is not returning the correct longitude");
		} catch (Exception e) {
			fail("Nonsense address caused exception.");
		}
	}
	
	@Test
	void getLatLonTest() {
		// Empty Address Test
		try {
		assertEquals(Optional.empty(), geo.getLatLon(emptyAddress), 
				"Empty address is not returning the empty optional.");
		} catch (Exception e) {
			fail("Empty address caused exception.");
		}
		
		// NonWord Address Test
		try {
		assertEquals(Optional.empty(), geo.getLatLon(nonWordAddress), 
				"Non word address is not returning the empty optional.");
		} catch (Exception e) {
			fail("Non word address caused exception.");
		}
		
		// One word address Test - normally formed input, test lat & lon
		try {
		assertEquals(oneWordLatLon.getFirst(), 
				geo.getLatLon(oneWordAddress).get().getFirst(), 
				"One word address is not returning the correct latitude");
		assertEquals(oneWordLatLon.getSecond(), 
				geo.getLatLon(oneWordAddress).get().getSecond(), 
				"One word address is not returning the correct longitude");
		} catch (Exception e) {
			fail("One word address caused exception.");
		}
		
		// Full Address Test - normally formed input, test lat & lon
		try {
		assertEquals(fullLatLon.getFirst(), 
				geo.getLatLon(fullAddress).get().getFirst(), 
				"Full address is not returning the correct latitude");
		assertEquals(fullLatLon.getSecond(), 
				geo.getLatLon(fullAddress).get().getSecond(), 
				"Full address is not returning the correct longitude");
		} catch (Exception e) {
			fail("Full address caused exception.");
		}
	}
}

