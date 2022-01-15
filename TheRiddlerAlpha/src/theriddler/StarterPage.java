package theriddler;
//Created by Jonathan Obi

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Cursor;


public class StarterPage extends JFrame  {

	/*
	 Game Home page
	 Starter Page launches the game
	 */
	private static final long serialVersionUID = 1L;
	
	// create frame
	public JFrame frame = new JFrame();

	//instance of GameSound to set up using music
	GameSound gs = new GameSound();
	
	public StarterPage(){
	// play theme.wav		
	String filepath = "theme.wav";
	gs.playMusic(filepath);
	
	
	
	//frame building
	frame.getContentPane().setBackground(Color.BLACK);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(650,650);
    frame.getContentPane();
    frame.getContentPane().setLayout(null);
    frame.setContentPane(new JLabel(new ImageIcon("background3.png")));
    
    
    // Start button creation and build
    JButton btnNewButton = new JButton("Begin");
    
    btnNewButton.getCursor();
    
    btnNewButton.setFont(new Font("MV Boli",Font.BOLD,35));
    btnNewButton.setFocusable(false);
    btnNewButton.setForeground(Color.GREEN);
    btnNewButton.setOpaque(false);
    btnNewButton.setContentAreaFilled(false);
    btnNewButton.setBorderPainted(false);
    
    // change cursor type when on a button
    btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    // Action Listener to listen for when start button is clicked
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		// when start button is clicked stop music, dispose of frame and start the game
    		
    		gs.stopMusic();
    		frame.setVisible(false);
    		new Game();
    	}
    });
    btnNewButton.setBounds(230, 520, 155, 45);
    frame.getContentPane().add(btnNewButton);
    
    //Instructions creation and building
    
    JTextArea txtrYoooooo = new JTextArea();
    txtrYoooooo.setBackground(Color.BLACK);
    txtrYoooooo.setForeground(Color.GREEN);
    txtrYoooooo.setWrapStyleWord(true);
    txtrYoooooo.setOpaque(false);
    txtrYoooooo.setText("Do you believe you have what it takes to defeat The Riddler? You have 60 seconds for each riddle or you lose. Goodluck!");
    txtrYoooooo.setBounds(98, 110, 428, 176);
    txtrYoooooo.setLineWrap(true);
    txtrYoooooo.setWrapStyleWord(true);
    txtrYoooooo.setFont(new Font("MV Boli",Font.BOLD,20));
    txtrYoooooo.setEditable(false);
    frame.getContentPane().add(txtrYoooooo);
    
    frame.setResizable(false);
    frame.setVisible(true);

    
 
    
		
		
	}
}
