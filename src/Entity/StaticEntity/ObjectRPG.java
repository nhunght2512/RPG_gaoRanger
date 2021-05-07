package Entity.StaticEntity;

import Handler.Handler;
import Tiles.Tile;
import graphics.Asset;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ObjectRPG extends StaticEntity{

    BufferedImage img;
    private int width;
    private int height;

    public ObjectRPG(Handler handler, float x, float y, BufferedImage img, int width, int height, int cor_x, int cor_y, int b_w, int b_h) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
        this.img = img;
        this.width = width;
        this.height = height;
        health = 20000;
        bounds.x = cor_x;
        bounds.y = cor_y;
        bounds.width = b_w;
        bounds.height = b_h;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

//        g.setColor(Color.CYAN);
//        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
//                bounds.width, bounds.height);
    }

    @Override
    public void die() {

    }
}
