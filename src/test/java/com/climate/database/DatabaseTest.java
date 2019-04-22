package com.climate.database;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;


import org.junit.jupiter.api.Test;

class DatabaseTest {

	@Test
	void test() {
		double testLon = -173.2;
		double testLat = 20;
		
		WeatherDatabase wd = new WeatherDatabase(testLon, testLat);
		
		Year[] allData = wd.getYearlyTemp();
		
		String bestLat = Double.toString(wd.getBestLat());
		String bestLon = Double.toString(wd.getBestLon());
		
		
		try {
			FileWriter nf = new FileWriter("testData1.txt");
			for (Year year : allData) {
				nf.write(Double.toString(year.getJan()));
				nf.write("\n");
				nf.write(Double.toString(year.getFeb()));
				nf.write("\n");
				nf.write(Double.toString(year.getMar()));
				nf.write("\n");
				nf.write(Double.toString(year.getApr()));
				nf.write("\n");
				nf.write(Double.toString(year.getMay()));
				nf.write("\n");
				nf.write(Double.toString(year.getJun()));
				nf.write("\n");
				nf.write(Double.toString(year.getJul()));
				nf.write("\n");
				nf.write(Double.toString(year.getAug()));
				nf.write("\n");
				nf.write(Double.toString(year.getSep()));
				nf.write("\n");
				nf.write(Double.toString(year.getOct()));
				nf.write("\n");
				nf.write(Double.toString(year.getNov()));
				nf.write("\n");
				nf.write(Double.toString(year.getDec()));
				nf.write("\n");
			}
			nf.close();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
