import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {

    public Music() {

    }

    public void playMusic (String musicLocation) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File musicPath = new File(musicLocation);

        if (musicPath.exists()) {
            AudioInputStream audio = AudioSystem.getAudioInputStream(musicPath);

            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } else {
            System.out.println("Can't find path");
        }
    }
}
