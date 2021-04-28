package Tiles;

import graphics.Asset;

public class Brick2 extends Tile{

    public Brick2(int id) {
        super(Asset.brick2, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
