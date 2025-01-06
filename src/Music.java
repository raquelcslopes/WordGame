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

            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float volume = -10.0f;
            volumeControl.setValue(volume);

            clip.start();
        } else {
            System.out.println("Can't find path");
        }
    }
}
