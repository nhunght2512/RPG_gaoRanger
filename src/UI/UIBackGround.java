package UI;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIBackGround extends UIObject{
    private BufferedImage bg ;
    public UIBackGround(float x, float y, int width, int height, BufferedImage bg) {
        super(x, y, width, height);
        this.bg = bg;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(bg, 0, 0, width, heigth, null);
    }

    @Override
    public void onClick() {

    }
}
