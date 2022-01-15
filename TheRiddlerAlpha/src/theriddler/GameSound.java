package theriddler;
//Created by Jonathan Obi

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/* 
 * This method enables to game to play a sound at any point needed
 */



public class GameSound {
	//Initializing audio variables
	AudioInputStream audioInput;
	Clip clip;
	long clipTimePosition;
	
		public void playMusic(String filepath) {
			try {
		
				File musicPath = new File(filepath);
				// if to make sure file exists before running s
				if(musicPath.exists()) {
					// uses AudioInputStream to load the audio in the file path
					audioInput = AudioSystem.getAudioInputStream(musicPath);
					//gets clip of the audio
					clip = AudioSystem.getClip();
					// opens clip
					clip.open(audioInput);
					//starts the clip and makes it loop 
					clip.start();
					clip.loop(Clip.LOOP_CONTINUOUSLY);
					
					
				}
				else {
					//error control for missing file
					System.out.println("File not found");
				}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		public void stopMusic() {
			// stops the clip
			clip.stop();
		}
		
		public void pauseMusic() {
			//collects the current time of the clip and stops the music
			clipTimePosition = clip.getMicrosecondPosition();
			clip.stop();
		}
		
		public void resumeMusic() {
			// uses the registered clip time and starts from there
			clip.setMicrosecondPosition(clipTimePosition);
			clip.start();
			
		}
		
		
		}
	