package com.climate.geolocator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GeoLocatorTest {
	// GeoLocator Instance
	private static GeoLocator geo = new GeoLocator();
	
	// For tuple tests
    private static GeoLocator.Tuple<Double,Double> latLonMix =  null;
    private static GeoLocator.Tuple<Double,Double> latLon0 =  null;
    private static GeoLocator.Tuple<Double,Double> latLonMinMax =  null;
	
	// For urlQuery and getLatLon tests
    private static String emptyAddress = "";
    private static String nonWordAddress = "??: >?";
    private static String oneWordAddress = "Philadelphia";
    private static String commaAddress = "Philadelphia, Pennsylvania";
    private static String fullAddress =
			"1400 John F Kennedy Blvd, Philadelphia, PA 19107, USA";
    private static String nonsenseAddress = "Blue98f sbdbbsld A";

    private static GeoLocator.Tuple<Double,Double> oneWordLatLon =  null;
    private static GeoLocator.Tuple<Double,Double> commaLatLon =  null;
    private static GeoLocator.Tuple<Double,Double> fullLatLon =  null;
	
	@BeforeAll
	private static void setUpBeforeClass() {
		// Setup Tuple values to test the subclass
		latLonMix = new GeoLocator.Tuple<Double,Double>(45.2, -160.4);
		latLon0 = new GeoLocator.Tuple<Double,Double>(0., 0.);
		latLonMinMax = new GeoLocator.Tuple<Double,Double>(-90.0, 180.0);
		
		// Setup urlQuery and getLatLon answers
		oneWordLatLon = new GeoLocator.Tuple<Double,Double>(
				39.9524152, -75.1635755);
		commaLatLon = new GeoLocator.Tuple<Double,Double>(
				39.9524152, -75.1635755);
		fullLatLon = new GeoLocator.Tuple<Double,Double>(
				39.9545921, -75.1732373);
	}
	
	/**
	 * Tests of the Tuple subclass of the GeoLocation class.
	 */
	@Test
    public void tupleTest() {
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

	/**
	 * Tests of the urlQuery for various inputs.
	 */
	@Test
    public void queryTest() {
		// Comma Address Test - normally formed input to query, test lat & lon
		try {
		assertEquals(commaLatLon.getFirst(), 
				geo.getLatLon(commaAddress).get().getFirst(), 
				"Comma address is not returning the correct latitude");
		assertEquals(commaLatLon.getSecond(), 
				geo.getLatLon(commaAddress).get().getSecond(), 
					"Comma address is not returning the correct longitude");
		} catch (Exception e) {
			fail("Comma address caused exception.", e);
		}
		
		// Nonsense Address Test - Possible malformed input to query
		try {
		assertEquals(Optional.empty(), geo.getLatLon(nonsenseAddress),
				"Nonsense address is not returning the empty optional.");
		} catch (Exception e) {
			fail("Nonsense address caused exception.",e);
		}
	}
	
	/**
	 * Test of the getLatLon method with various input.
	 */
	@Test
    public void getLatLonTest() {
		// Empty Address Test
		try {
		assertEquals(Optional.empty(), geo.getLatLon(emptyAddress), 
				"Empty address is not returning the empty optional.");
		} catch (Exception e) {
			fail("Empty address caused exception.", e);
		}
		
		// NonWord Address Test
		try {
		assertEquals(Optional.empty(), geo.getLatLon(nonWordAddress), 
				"Non word address is not returning the empty optional.");
		} catch (Exception e) {
			fail("Non word address caused exception.", e);
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
			fail("One word address caused exception.", e);
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
			fail("Full address caused exception.", e);
		}
	}
}

