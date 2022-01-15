package theriddler;
//Created by Jonathan Obi


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/*
 This is the core game
 */
	

	public class Game extends JFrame implements ActionListener{
			
			
		  	
	
		private static final long serialVersionUID = 1L;
			// initialization of variables
			String[] questions = Main.FRInstance.riddle;
			String[] answers = Main.FRInstance.answer;
	        String userguess;
	        String answer;
	        int index;
	        public static int correct_guesses;
	        int total_questions = questions.length;
	        int result;
	      	public static int seconds=60;
	      	
	        // creation of all JFrame objects
	        public JFrame frame = new JFrame();
	        public JTextField textfield = new JTextField();
	        public JTextArea textarea = new JTextArea();
	        public JButton buttonA = new JButton();
	        public JButton btnTryAgain = new JButton();
	        public JLabel time_label = new JLabel();
	        public JLabel seconds_left = new JLabel();
	        public JTextField number_right = new JTextField();
	        public JTextField percentage = new JTextField();
	        public JTextArea textarea_1 = new JTextArea();
	        public JTextField txtCanYouBeat;
	        public JTextField txtCorrect = new JTextField();
	        
	        // Starting a new timer
	        Timer timer = new Timer(1000, new ActionListener() {
	                
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                		// timer counts down from set value of seconds
	                        seconds--;
	                        //output the current time on the countdown
	                        seconds_left.setText(String.valueOf(seconds));
	                        // if the time runs to 0, stop the time and display the answer, parameter timeup to notify why displayAnswer is called
	                        if(seconds<=0) {
	                        		timer.stop();
	                                displayAnswer("timeup");
	                        }
	                        }
	                });
	       
	       // instance of GameSound to enable to play of music through out game
	        GameSound gs = new GameSound();
	        // instance of RandomNumberArray to get new order of array
	        RandomNumberArray rna = new RandomNumberArray();
    		
	        
	        
	        public Game() {
	        		
	        		// run  RandomNumberArray array shuffle
	        	    rna.process();
	        		
	        	    // Initialize beginning of correct guesses and seconds
	        		correct_guesses =0;
	        		seconds=60;
	        		
	        		// play theme.wav file
	        		String filepath = "theme.wav";
	        		gs.playMusic(filepath);
	        		
	        		// Building of JFrame objects
	        		frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));
	        	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                frame.setSize(650,650);
	                frame.getContentPane().setLayout(null);
	                frame.setResizable(false);
	                
	                textfield.setBounds(0,48,635,50);
	                textfield.setBackground(new Color(25,25,25));
	                textfield.setForeground(new Color(25,255,0));
	                textfield.setFont(new Font("Ink Free",Font.BOLD,30));
	                textfield.setBorder(null);
	                textfield.setHorizontalAlignment(JTextField.CENTER);
	                textfield.setEditable(false);
	                frame.getContentPane().add(textfield);
	                
	                textarea.setBounds(0,98,635,100);
	                textarea.setLineWrap(true);
	                textarea.setWrapStyleWord(true);
	                textarea.setBackground(new Color(25,25,25));
	                textarea.setForeground(new Color(25,255,0));
	                textarea.setFont(new Font("MV Boli",Font.BOLD,25));
	                textarea.setBorder(null);
	                textarea.setEditable(false);
	                frame.getContentPane().add(textarea);
	                
	                // change cursor type when on a button
	                buttonA.getCursor();
	                buttonA.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	                
	                buttonA.setBounds(200,337,209,65);
	                buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
	                buttonA.setFocusable(false);
	                buttonA.addActionListener(this);
	                buttonA.setText("Submit");
	                buttonA.setVisible(true);
	                frame.getContentPane().add(buttonA);
	                
	               
	                seconds_left.setBounds(535,510,100,100);
	                seconds_left.setBackground(new Color(25,25,25));
	                seconds_left.setForeground(new Color(255,0,0));
	                seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
	                seconds_left.setBorder(BorderFactory.createBevelBorder(1));
	                seconds_left.setOpaque(true);
	                seconds_left.setHorizontalAlignment(JTextField.CENTER);
	                seconds_left.setText(String.valueOf(seconds));
	                frame.getContentPane().add(seconds_left);
	                
	                time_label.setBounds(535,475,100,25);
	                time_label.setBackground(new Color(50,50,50));
	                time_label.setForeground(new Color(255,0,0));
	                time_label.setFont(new Font("MV Boli",Font.PLAIN,16));
	                time_label.setHorizontalAlignment(JTextField.CENTER);
	                time_label.setText("timer");
	                frame.getContentPane().add(time_label);
	                
	                number_right.setBounds(225,225,200,100);
	                number_right.setBackground(new Color(25,25,25));
	                number_right.setForeground(new Color(25,255,0));
	                number_right.setFont(new Font("Ink Free",Font.BOLD,50));
	                number_right.setBorder(BorderFactory.createBevelBorder(1));
	                number_right.setHorizontalAlignment(JTextField.CENTER);
	                number_right.setEditable(false);
	                
	                percentage.setBounds(225,325,200,100);
	                percentage.setBackground(new Color(25,25,25));
	                percentage.setForeground(new Color(25,255,0));
	                percentage.setFont(new Font("Ink Free",Font.BOLD,50));
	                percentage.setBorder(BorderFactory.createBevelBorder(1));
	                percentage.setHorizontalAlignment(JTextField.CENTER);
	                percentage.setEditable(false);
	                
	                txtCanYouBeat = new JTextField();
	                txtCanYouBeat.setText("Can You Beat The Riddler?");
	                txtCanYouBeat.setHorizontalAlignment(SwingConstants.CENTER);
	                txtCanYouBeat.setForeground(new Color(25, 255, 0));
	                txtCanYouBeat.setFont(new Font("Ink Free", Font.BOLD, 30));
	                txtCanYouBeat.setEditable(false);
	                txtCanYouBeat.setBorder(null);
	                txtCanYouBeat.setBackground(new Color(25, 25, 25));
	                txtCanYouBeat.setBounds(0, 0, 635, 50);
	                frame.getContentPane().add(txtCanYouBeat);
	                
	                textarea_1.setWrapStyleWord(true);
	                textarea_1.setLineWrap(true);
	                textarea_1.setForeground(new Color(25, 255, 0));
	                textarea_1.setFont(new Font("MV Boli", Font.BOLD, 25));
	                textarea_1.setBorder(BorderFactory.createBevelBorder(1));
	                textarea_1.setBackground(Color.WHITE);
	                textarea_1.setBounds(41, 230, 540, 50);
	                textarea_1.setEditable(true);	
	                frame.getContentPane().add(textarea_1);
	              
	                btnTryAgain.setText("Try Again");
	                btnTryAgain.setFont(new Font("MV Boli", Font.BOLD, 35));
	                btnTryAgain.setFocusable(false);
	                btnTryAgain.setBounds(200, 337, 209, 65);
	                btnTryAgain.setVisible(false);
	                
	                //changes try again button cursor
	                btnTryAgain.getCursor();
	                btnTryAgain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	                frame.getContentPane().add(btnTryAgain);
	                
	                txtCorrect.setText("Correct!");
	                txtCorrect.setHorizontalAlignment(SwingConstants.CENTER);
	                txtCorrect.setForeground(new Color(25, 255, 0));
	                txtCorrect.setFont(new Font("Ink Free", Font.BOLD, 30));
	                txtCorrect.setEditable(false);
	                txtCorrect.setBorder(BorderFactory.createBevelBorder(1));
	                txtCorrect.setBackground(new Color(50, 50, 50));
	                txtCorrect.setBounds(173, 459, 273, 50);
	                txtCorrect.setVisible(false);
	                frame.getContentPane().add(txtCorrect);
	                
	                // show the frame
	                frame.setVisible(true);
	                
	                // move to next question
	                nextQuestion();
	        }
 public void nextQuestion() {
	 		
	 
                textarea_1.setText(" ");
                //if game has iterated through all question go to result page
                if(index>=total_questions) {
                        results();
                }
                else {	
                		// first hide the correct indicator, 
                		txtCorrect.setVisible(false);
                		
                		//update the question label
                        textfield.setText("Riddle "+(index+1));
                        
                        // output the question from the csv file based on the random array
                        textarea.setText(questions[rna.qcheck[index]]);
                      
                        
                        // start the new timer
                        timer.start();
                }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        				// Action Listener to listen for the click of the submit button
                
                        buttonA.setEnabled(false);
            
                        userguess = textarea_1.getText().toLowerCase();
                        
                        // if button is clicked
                        if(e.getSource()==buttonA) {
                        		// store the user's answer
                                answer = userguess;
                                // check user's answer contains the correct answer
                                if(answer.contains(answers[rna.qcheck[index]].toLowerCase())) {
                                		// if so they guessed right, so increment correct guesses, 
                                        correct_guesses++;
                                       //stop the timer 
                                        timer.stop();                             
                                        buttonA.setEnabled(false);
                                       // and show that they are correct
                                        txtCorrect.setVisible(true);
                                        
                                        // new time for a pause between two questions to reset  seconds and seconds label, increment index and move then move to next question                                        
                                        Timer pause = new Timer(500, new ActionListener() {
                                            
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                    
                                                   	
                                                    seconds=60;
                                                    seconds_left.setText(String.valueOf(seconds));
                                                    buttonA.setEnabled(true);
                                                    
                                                    index++;
                                                    nextQuestion();
                                            }
                                    });
                                    pause.setRepeats(false);
                                    // start timer
                                    pause.start();
                                        
                                }
                                
                                else {         
                                	//this means that the got it wrong send them to defeat screen and show their wining streak
                                	// wrong parameter to indicate why user goes to lose screen
                                	displayAnswer("wrong");
                                	txtCorrect.setVisible(true);
                                	txtCorrect.setText("You got " + correct_guesses + " correct!");
                                	
                                }
                               
                                
                               
                        }
                        
                       
        }
        public void displayAnswer(String outcome) {
        	// stops game Music
        	
        	gs.stopMusic();
        	buttonA.setEnabled(true);
        	
        	// plays losing music
        	GameSound gs3 = new GameSound();
            String filepath = "lose.wav";
     		gs3.playMusic(filepath);
     		
     		//stops the timer
            timer.stop();
               // if statements to check why user lost
            
               if (outcome.equals("wrong")) {
            	// if user lost because there answered wrong, set custom text   
            	    
            	   	answer();
            	   	textarea_1.setText("That's wrong, better luck next time ha ha");
            	   	
            	   	// enable TryAgain button
            	   	buttonA.setVisible(false);
            	   	btnTryAgain.setVisible(true);
            	   	
            	   	// Action Listener for try again button click
            	   	btnTryAgain.addActionListener(new ActionListener() {
            	   		
            	   		public void actionPerformed(ActionEvent e) {
            	   		//close frame, stop music and load restart
            	   			frame.setVisible(false);
            	   			gs.stopMusic();
            	   			gs3.stopMusic();
            	   			new Restart();
            	   		
           	   			
            	   		}
            	   		
            	   	});

            	   	
            	    }   	   	
            	
        
               else if(outcome.equals("timeup")) {
            	// if user lost because time ran out, set custom text   
            	  
            		answer();
	                textarea_1.setText("Time's up! better luck next time ha ha");	           
	            	buttonA.setVisible(false);
	            	btnTryAgain.setVisible(true);
	            	
	             	// Action Listener for try again button click
	            	btnTryAgain.addActionListener(new ActionListener() {
            	   		
            	   		public void actionPerformed(ActionEvent e) {
            	   			//close frame, stop music and load restart
            	   			frame.setVisible(false);
            	   			gs.stopMusic();
            	   			gs3.stopMusic();
            	   			new Restart();
            	   		
           	   			
            	   		}
            	   		
            	   	});
	            	
	            	
               }
                              
               
        }
        
      
        
        public void answer() {
        	// custom setting for textarea_1 to show answer
        	
        	textarea_1.setWrapStyleWord(true);
            textarea_1.setLineWrap(true);
            textarea_1.setForeground(new Color(25, 255, 0));
            textarea_1.setFont(new Font("MV Boli", Font.BOLD, 25));
            textarea_1.setBorder(BorderFactory.createBevelBorder(1));
            textarea_1.setBackground(new Color(50, 50, 50));
            textarea_1.setBounds(41, 230, 540, 50);
            textarea_1.setEditable(false);	
        }
        
        
        public void results(){
        		// result if user finishes game
        		// stop game music
               gs.stopMusic();
               //play wining music
               GameSound gs2 = new GameSound();
               String filepath = "win.wav";
       		   gs2.playMusic(filepath);
       		   
       		   // clear Jframe
               buttonA.setEnabled(false);
               textarea_1.setVisible(false);
               buttonA.setVisible(false);
               txtCorrect.setVisible(false);                              
               seconds_left.setVisible(false);
               time_label.setVisible(false);
               
               // congratulations message
               textfield.setText("");
               textarea.setText("CONGRATUALTIONS! YOU DEFEATED THE RIDDLER!!!");
               
            
               // show that they got it all
               number_right.setText("("+correct_guesses+"/"+total_questions+")");
               frame.getContentPane().add(number_right);
          
                
        }
	}