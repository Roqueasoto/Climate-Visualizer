import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeatherDatabase {
	
	//Longitude from data set is -179.750 to 179.750 (0.5 Degree increments)
	
	public Year[] yearlyTemp = new Year[118];
	
	
	public String[] allFiles() {
		String[] files = new String[118];
		//Add filepath here
		String filepath = "";
		String beg = "air_temp.";
		int year = 1900;
		for (int i = 0; i < 118; i++) {
			files[i] = filepath + beg + Integer.toString(year);
			year++;
		}
		return files;
	}
	
	public WeatherDatabase(double actualLon, double actualLat) {
		//First, find the nearest lon in the dataset
		double bestLon = 0;
		double nearest = -179.75;		
		boolean notFound = true;
		while (notFound) {
			double distance = Math.abs(nearest - actualLon);
			if (distance < 0.5) {
				bestLon = nearest;
				notFound = false;	
			}
			nearest = nearest + 0.5;
		}	
		
		//Initialize bestRow, which will be found in the first file
		int bestRow = 0;
		
		String[] yearlyFiles = allFiles();
		for (int i = 0; i < 118; i++) {
			File f = new File(yearlyFiles[i]);
			
			double bestLat = -1000;

			
			if (i == 0) {
				try {
					Scanner sc = new Scanner(f);
					int currentLine = 0;
					
					while (sc.hasNextLine()) {
						String rowData = sc.nextLine();
						String[] columnData = rowData.split("\\s+");	
						
						int emptyFirstColumn = 0;
						if (columnData[0].equals("")) {
							emptyFirstColumn++;
						}
						
						double currentLon = Double.parseDouble(columnData[0 + emptyFirstColumn]);
						double currentLat = Double.parseDouble(columnData[1 + emptyFirstColumn]);
						
						if (currentLon == bestLon) {
							
							double distanceFromBestLat = Math.abs(bestLat - actualLat);
							double distanceFromCurrentLat = Math.abs(currentLat - actualLat);
							
							if (distanceFromCurrentLat < distanceFromBestLat) {
								bestLat = currentLat;
								bestRow = currentLine;
								
								double month1 = Double.parseDouble(columnData[2 + emptyFirstColumn]);
								double month2 = Double.parseDouble(columnData[3 + emptyFirstColumn]);
								double month3 = Double.parseDouble(columnData[4 + emptyFirstColumn]);
								double month4 = Double.parseDouble(columnData[5 + emptyFirstColumn]);
								double month5 = Double.parseDouble(columnData[6 + emptyFirstColumn]);
								double month6 = Double.parseDouble(columnData[7 + emptyFirstColumn]);
								double month7 = Double.parseDouble(columnData[8 + emptyFirstColumn]);
								double month8 = Double.parseDouble(columnData[9 + emptyFirstColumn]);
								double month9 = Double.parseDouble(columnData[10 + emptyFirstColumn]);
								double month10 = Double.parseDouble(columnData[11 + emptyFirstColumn]);
								double month11 = Double.parseDouble(columnData[12 + emptyFirstColumn]);
								double month12 = Double.parseDouble(columnData[13 + emptyFirstColumn]);
								
								Year y = new Year(month1, month2, month3, month4, month5, month6, month7,
										month8, month9, month10, month11, month12);
								yearlyTemp[i] = y;
								
							}
							

						
						}
						
						currentLine++;
					}				
					sc.close();			
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else {
				try {
					Scanner sc = new Scanner(f);
					int currentLine = 0;
					
					while (sc.hasNextLine()) {
						String rowData = sc.nextLine();
						if (currentLine == bestRow) { 
							String[] columnData = rowData.split("\\s+");
							
							int emptyFirstColumn = 0;
							if (columnData[0].equals("")) {
								emptyFirstColumn++;
							}
							
							double month1 = Double.parseDouble(columnData[2 + emptyFirstColumn]);
							double month2 = Double.parseDouble(columnData[3 + emptyFirstColumn]);
							double month3 = Double.parseDouble(columnData[4 + emptyFirstColumn]);
							double month4 = Double.parseDouble(columnData[5 + emptyFirstColumn]);
							double month5 = Double.parseDouble(columnData[6 + emptyFirstColumn]);
							double month6 = Double.parseDouble(columnData[7 + emptyFirstColumn]);
							double month7 = Double.parseDouble(columnData[8 + emptyFirstColumn]);
							double month8 = Double.parseDouble(columnData[9 + emptyFirstColumn]);
							double month9 = Double.parseDouble(columnData[10 + emptyFirstColumn]);
							double month10 = Double.parseDouble(columnData[11 + emptyFirstColumn]);
							double month11 = Double.parseDouble(columnData[12 + emptyFirstColumn]);
							double month12 = Double.parseDouble(columnData[13 + emptyFirstColumn]);
							
							Year y = new Year(month1, month2, month3, month4, month5, month6, month7,
									month8, month9, month10, month11, month12);
							yearlyTemp[i] = y;					
						}				
						currentLine++;
					}				
					sc.close();			
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}

		}
		
		
		
	}

	public Year[] getYearlyTemp() {
		return yearlyTemp;
	}

	
}
