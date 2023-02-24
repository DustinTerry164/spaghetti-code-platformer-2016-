package soundPlayer;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class sound_player {

	
	Clip clip;
	boolean playing = false;
	public void play(String song,boolean plays_continuously){
		
	
	      try {
	          // Open an audio input stream.
//	          URL url = this.getClass().getClassLoader().getResource(song + ".wav");
//	    	  if(clip.isActive()) clip.stop();
	    	  
	    	  URL url = getClass().getResource(song + ".wav");
	          AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	          // Get a sound clip resource.
	          clip = AudioSystem.getClip();
	          // Open audio clip and load samples from the audio input stream.
	          clip.open(audioIn);
	          clip.start();
	          if(plays_continuously)clip.loop(clip.LOOP_CONTINUOUSLY);
	          playing = true;
	       } catch (UnsupportedAudioFileException e) {
	          e.printStackTrace();
	       } catch (IOException e) {
	          e.printStackTrace();
	       } catch (LineUnavailableException e) {
	          e.printStackTrace();
	       } catch (Exception e){
	    	   e.printStackTrace();
	       }
	      	
	    }
	
	public void stop(){
		if(playing == true) clip.stop();
		
	}
	}

