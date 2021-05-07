package Tiles;

import graphics.Asset;

public class Grass6 extends Tile {
    public Grass6(int id){ super(Asset.grass6, id);}

    @Override
    public boolean isSolid() {
        return true;
    }
}