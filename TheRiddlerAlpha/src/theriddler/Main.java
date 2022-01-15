package theriddler;

import java.io.IOException;
//Created by Jonathan Obi
//This is the main method of the Game


public class Main {
		// static instance of FR to enable it's use in both game and the main
		public static FR FRInstance = new FR();
		
		  public static void main(String[] args) throws IOException {
			  	//riddle database
				  String csvFile = "riddles.csv";
				 
				 // read the riddle database
				  FRInstance.read(csvFile);
				  
				 //new instance of the StarterPage to begin day
				  new StarterPage();
				  
				  
			  
			  
	       	  }



}
