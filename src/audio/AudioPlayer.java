package audio;

import Handler.Handler;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AudioPlayer {

    private Handler handler;

    public List<AudioClip> audioClips;

    public Clip clip;

    public AudioPlayer(Handler handler) {
        this.handler = handler;
        audioClips = new ArrayList<>();
    }

/*    public void update() {
        audioClips.forEach(audioClip -> audioClip.update());

        List.copyOf(audioClips).forEach(audioClip -> {
            if(audioClip.hasFinishedPlaying()) {
                audioClip.cleanUp();
                audioClips.remove(audioClip);
            }
        });
    }*/

    public void playMusic(String fileName) {
        final Clip clip = getClip(fileName);
        audioClips.add(new MusicClip(clip));
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void playSound(String fileName) {
        final Clip clip = getClip(fileName);
        audioClips.add(new SoundClip(clip));
    }

    public static void stopPlaying() {

    }

    private static Clip getClip(String fileName) {
        final URL soundFile = AudioPlayer.class.getResource("/sound/" + fileName);
        try(AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile)) {
            //audioFormat(audioInputStream);
            final Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.setMicrosecondPosition(0);
            return clip;

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        return null;
    }

    /*private void audioFormat(AudioInputStream audioInputStream){
        AudioFormat audioFormat = new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false
        );
        Line.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        SourceDataLine sourceDataLine = null;
        try {
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            sourceDataLine.open(audioFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        int bytesRead = 0;
        byte[] buffer = new byte[1024];
        sourceDataLine.start();
        while(true) {
            try {
                if (!((bytesRead = audioInputStream.read(buffer)) != -1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            sourceDataLine.write(buffer, 0 ,bytesRead);
        }
        sourceDataLine.drain();

    }*/
}
