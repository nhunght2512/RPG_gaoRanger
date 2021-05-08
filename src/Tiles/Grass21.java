package Tiles;

import graphics.Asset;

public class Grass21 extends Tile {
    public Grass21(int id){ super(Asset.grass21, id);}

    @Override
    public boolean isSolid() {
        return true;
    }
}