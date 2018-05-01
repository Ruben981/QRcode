package qrporject;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	

	protected static final int QR1 = 1; // Go to engineering message
	protected static final int QR2 = 2;
	protected static final int QR3 = 3;
	protected static final int date = 4;
	protected static final int room = 5;
	protected static final int time = 6;
	protected static final int form = 7;
		/*
		playit(GOTO_ENGINEERING);
		delayfor(7);	// delay for 7 seconds

	*/
	
	public static void delayfor(int n)
	{
		try {
		    Thread.sleep(n * 1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
    /*
	 * Method is passed a sound flag it will play that sound there is only one
	 * currently supported. To use this sound - call new playit(SOUND);
	 */
	public static void playit(int soundRequired) {
		String fn = null;
		File sound; 
        URL location = Sound.class.getProtectionDomain().getCodeSource().getLocation();
        
		switch (soundRequired) {
		case QR1:
			fn = location.getFile() + "QR1_V2.wav";
			break;
		case QR2:
			fn = location.getFile() + "QR2.wav";
			break;
		case QR3:
			fn = location.getFile() + "QR3.wav";
			break;
		case date:
			fn = location.getFile() + "rightdat.wav";
			break;
		case room:
			fn = location.getFile() + "unknowndir.wav";
			break;
		case time:
			fn = location.getFile() + "theclasshas.wav";
			break;
		case form:
			fn = location.getFile() + "unfitformat.wav";
			break;

		default:
			break;

		}

		// Go for it!
		try {
			// Open an audio input stream.
			sound = new File(fn);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
			// plays
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}

