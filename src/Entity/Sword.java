package Entity;

import Handler.Handler;
import graphics.Asset;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sword extends Creature{

    BufferedImage img;

    public Sword(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public void tick() {
        getInput();
        /*x = handler.getEntityManager().getPlayer().getX()+30;
        y = handler.getEntityManager().getPlayer().getY()+10;*/
        x += xMove;
        y +=yMove;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img,(int)x,(int)y, 30, 40, null);
    }

    public void getInput(){
        if(handler.getKeyManager().aUp){
            yMove = -speed;
            img = Asset.swordUp;
        }
        if(handler.getKeyManager().aDown){
            yMove = speed;
            img = Asset.swordDown;
        }
        if(handler.getKeyManager().aLeft){
            xMove = -speed;
            img = Asset.swordLeft;
        }
        if(handler.getKeyManager().aRight){
            xMove = speed;
            img = Asset.swordRight;
        }
    }

    @Override
    public void die() {

    }
}
