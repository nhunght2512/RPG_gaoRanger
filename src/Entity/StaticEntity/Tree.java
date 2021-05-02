package Entity.StaticEntity;

import Handler.Handler;
import Tiles.Tile;
import graphics.Asset;

import java.awt.*;

public class Tree extends StaticEntity{
    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
        health = 20;
        bounds.x = 26;
        bounds.y = 60;
        bounds.width = 80;
        bounds.height = 60;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width * 2, height * 2, null);

        g.setColor(Color.CYAN);
        /*g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);*/
    }

    @Override
    public void die() {

    }
}
