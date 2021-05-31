package Entity.StaticEntity;

import Handler.Handler;
import graphics.Animation;
import graphics.Asset;

import java.awt.*;
import java.util.Objects;

public class Gate extends StaticEntity{
    private Animation gateSwitchh;
    private int width, height;
    public Gate(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        this.width = width;
        this.height = height;

        gateSwitchh = new Animation(150, Asset.gateSwitch);
    }

    @Override
    public void tick() {
        gateSwitchh.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(gateSwitchh.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width,height,null);
    }

    @Override
    public void die() {

    }
}
