package Entity.StaticEntity;

import Entity.Entity;
import Handler.Handler;
import Tiles.Tile;

public abstract class StaticEntity extends Entity {

    public StaticEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
    }
}
