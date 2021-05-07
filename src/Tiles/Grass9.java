package Tiles;

import graphics.Asset;

public class Grass9 extends Tile {
    public Grass9(int id){ super(Asset.grass9, id);}

    @Override
    public boolean isSolid() {
        return true;
    }
}