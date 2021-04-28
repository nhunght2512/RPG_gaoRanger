package Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    //GAN NHAN
    public static Tile[] tiles = new Tile[256];
    public static Tile brick1 = new Brick1(4);
    public static Tile brick2 = new Brick2(5);
    public static Tile rock = new Rock(6);
    public static Tile dirt = new Dirt(7);
    public static Tile grass = new Grass(8);

    public static final int TILE_WIDTH = 64;
    public static final int TILE_HEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick(){

    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT,null);
    }

    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }
}
