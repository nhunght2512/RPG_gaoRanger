package Tiles;

import graphics.Asset;

public class Grass8 extends Tile {
    public Grass8(int id){ super(Asset.grass8, id);}

    @Override
    public boolean isSolid() {
        return true;
    }
}