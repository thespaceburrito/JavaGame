package theriddler;
//Created by Jonathan Obi

import java.util.*;

import java.util.List;
/*
 This class takes a array list from 0 to 9 and shuffles the order every time the program is run
 This will be used to make sure the order of riddles are different
 */


public class RandomNumberArray {
	
	// Initialized variables
	List<Integer> check;
	Integer[] qcheck;
	
	public void process() {
	
	
	check = Arrays.asList( 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 );
	
	// shuffle the array
	Collections.shuffle(check);
	setnewarray();
	
	
	}
	
	public  void setnewarray() {
		// change the shuffled ArrayLisy to standard array
		qcheck = new Integer[ check.size() ];
		check.toArray(qcheck);
}
	

}