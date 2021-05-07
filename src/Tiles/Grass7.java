package Tiles;

import graphics.Asset;

public class Grass7 extends Tile {
    public Grass7(int id){ super(Asset.grass7, id);}

    @Override
    public boolean isSolid() {
        return true;
    }
}