package theriddler;
//Created by Jonathan Obi

import java.util.List;
import java.io.*;
import java.util.ArrayList;
/*
 This class reads the csv database that stores the riddles and makes it possible for every cell to be called by using arrays
 */

public class FR {
		
	
		// initializing variables
		public final String delimiter = ",";
		public String[] riddle;
		public String[] answer;
		private File file;
		private FileReader fr;
		private BufferedReader br;
		List<String> column1;
		List<String> column2;
		
		
		//
		
		public void read(String csvFile) throws IOException {
			
				file = new File(csvFile);
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				String line = " ";
				String[] arr;
				column1 = new ArrayList<String>();
				column2 = new ArrayList<String>();
				while ((line = br.readLine()) != null) {
					arr = line.split(delimiter); //using the split option to break the line base
					 
					// for line iteration, add the value of column 1 of the csv file to the column 1 array
					column1.add(arr[0]);
					// for line iteration, add the value of column 2 of the csv file to the column 2 array
					column2.add(arr[1]);
					
				        
			
				}
				
			
				setnewarray();
				
				
		
			
				
				
			}
		
		public void setnewarray() {
			// change the generated ArrayList to standard array
			riddle = new String[ column1.size() ];
			column1.toArray(riddle);
			
			answer = new String[ column2.size() ];
			column2.toArray(answer);
		}
			
		
		public void destroy() throws IOException {
			//method to close readers if necessary
			fr.close();
			br.close();
		}
		



	

	}

