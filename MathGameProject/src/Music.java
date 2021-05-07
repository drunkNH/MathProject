import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Music 
{
	public void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{

		Scanner scanner = new Scanner(System.in);

		File file = new File("Loop.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);

		String response = "";
		System.out.println("Do you want to listen to music while playing the game? (Y/N)");

		while(!response.equals("N")) 
		{

			response = scanner.next();
			response = response.toUpperCase();

			switch(response) 
			{
				case ("Y"): clip.start();
				break;
				case ("N"): clip.close();
				break;
				default: System.out.println("Not a valid response");
			}
		}

	}
}