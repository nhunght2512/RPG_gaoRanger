package Tiles;

import graphics.Asset;

public class Grass4 extends Tile {
    public Grass4(int id){ super(Asset.grass4, id);}

    @Override
    public boolean isSolid() {
        return true;
    }
}