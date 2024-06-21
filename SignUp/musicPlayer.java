package javaSwing;

import java.io.File;
import javax.sound.sampled.*;

public class musicPlayer {

    private Clip mClip;
    private FloatControl volumeControl;
    private float volumeBeforeMute = 0.0f;

    public void plyMusic(String location) {
        try {
            File musicPath = new File(location);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                mClip = AudioSystem.getClip();
                mClip.open(audioInput);
                volumeControl = (FloatControl) mClip.getControl(FloatControl.Type.MASTER_GAIN);
                mClip.loop(Clip.LOOP_CONTINUOUSLY); // loops endlessly HAHAHA
                mClip.start();
            } else {
                System.out.println("Can't find file");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void mute() {
        if (mClip != null && volumeControl != null) {
            volumeBeforeMute = volumeControl.getValue();
            volumeControl.setValue(volumeControl.getMinimum());
        }
    }

    public void unmute() {
        if (mClip != null && volumeControl != null) {
            volumeControl.setValue(volumeBeforeMute);
        }
    }
}
