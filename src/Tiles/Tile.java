package Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    //GAN NHAN
    public static Tile[] tiles = new Tile[256];
    public static Tile brick1 = new Brick1(0);
    public static Tile brick2 = new Brick2(1);
    public static Tile brick3 = new Brick3(2);
    public static Tile brick4 = new Brick4(3);
    public static Tile brick5 = new Brick5(14);

    public static Tile grass1 = new Grass1(4);
    public static Tile grass2 = new Grass2(6);
    public static Tile grass3 = new Grass3(7);
    public static Tile grass4 = new Grass4(8);
    public static Tile grass5 = new Grass5(9);
    public static Tile grass6 = new Grass6(10);
    public static Tile grass7 = new Grass7(11);
    public static Tile grass8 = new Grass8(12);
    public static Tile grass9 = new Grass9(13);
    public static Tile grass10 = new Grass10(15);
    public static Tile grass11 = new Grass11(16);
    public static Tile grass12 = new Grass12(17);
    public static Tile grass13 = new Grass13(18);
    public static Tile grass14 = new Grass14(19);
    public static Tile grass15 = new Grass15(20);
    public static Tile grass16 = new Grass16(21);
    public static Tile grass17 = new Grass17(22);
    public static Tile grass18 = new Grass18(23);
    public static Tile grass19 = new Grass19(24);
    public static Tile grass20 = new Grass20(25);
    public static Tile grass21 = new Grass21(26);
    public static Tile grass22 = new Grass22(27);
    public static Tile grass23 = new Grass23(28);
    public static Tile grass24 = new Grass24(29);
    public static Tile grass25 = new Grass25(30);

    public static Tile bound = new bound(5);

    public static final int TILE_WIDTH = 32;
    public static final int TILE_HEIGHT = 32;

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
