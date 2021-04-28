package Entity;

import Handler.Handler;
import graphics.Asset;

import java.awt.*;

public class BackGround extends Creature{

    public BackGround(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
    }

    @Override
    public void tick() {
        /*getInput();
        move();*/
    }

    public void getInput(){
        /*xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up){
            yMove = +speed;
        }
        if(handler.getKeyManager().down){
            yMove = -speed;
        }
        if(handler.getKeyManager().left){
            xMove = +speed;
        }
        if(handler.getKeyManager().right){
            xMove = -speed;
        }*/
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.back, (int)x, (int)y, null);
    }
}

