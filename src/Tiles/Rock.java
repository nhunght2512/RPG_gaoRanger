package Tiles;

import graphics.Asset;

public class Rock extends Tile{

    public Rock(int id) {
        super(Asset.rock, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
