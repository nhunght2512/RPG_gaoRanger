package audio;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public abstract class AudioClip {

    protected final Clip clip;

    public AudioClip(Clip clip) {
        this.clip = clip;
        clip.start();
    }

    public void update() {
        final FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        control.setValue(getVolume(0));
    }

    protected abstract float getVolume(float volume);

/*    public boolean hasFinishedPlaying() {
        return !clip.isRunning();
    }*/

    public void cleanUp() {
        clip.close();
    }

    public Clip getClip() {
        return clip;
    }
}