package Tiles;

import graphics.Asset;

public class bound extends Tile {
    public bound(int id){ super(Asset.bound, id);}

    @Override
    public boolean isSolid() {
        return true;
    }
}
