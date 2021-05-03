package graphics;

import java.awt.image.BufferedImage;

public class Animation {
    //ANIMATION
    private int speed;
    private int index;
    private long lastTime;
    private long timer;
    private BufferedImage[] frames;

    public Animation(int speed, BufferedImage[] frames){
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer = 1;
        lastTime = System.currentTimeMillis();
    }

    public void tick(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > speed){
            index ++;
            timer = 0;
            if(index >= frames.length  ){
                index = 1;
            }
        }
    }

    public BufferedImage getCurrentFrame(){
        return frames[index];
    }
}
