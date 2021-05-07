package Tiles;

import graphics.Asset;

public class Grass1 extends Tile {
    public Grass1(int id){ super(Asset.grass1, id);}

    @Override
    public boolean isSolid() {
        return true;
    }
}