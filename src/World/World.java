package World;

import Entity.EntityManager;
import Entity.Player;
import Entity.StaticEntity.Tree;
import Handler.Handler;
import Tiles.Tile;
import Utils.Utils;

import java.awt.*;

public class World {
    private Handler handler;

    private int width;
    private int heigth;
    private int spawnX;
    private int spawnY;
    private int[][] tiles;

    //CREATE ENTITIES
    private EntityManager entityManager;

    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));

        //CREATE ENTITIES
        entityManager.addEntity(new Tree(handler, 300, 25));

        loadWorld(path);

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }

    public void tick(){
        entityManager.tick();
    }

    public void render(Graphics g){
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH +1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_WIDTH);
        int yEnd = (int) Math.min(heigth, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_WIDTH +1);

        for(int y = yStart; y < yEnd; y++){
            for(int x = xStart; x < xEnd; x++){
                getTile(x,y).render(g,
                        (int) ((x * Tile.TILE_WIDTH) - handler.getGameCamera().getxOffset()),
                        (int) ((y * Tile.TILE_HEIGHT) - handler.getGameCamera().getyOffset()));
            }
        }
        entityManager.render(g);
    }

    public Tile getTile(int x, int y){
        if(x < 0 || y < 0 || x >= width || y >= heigth){
            return Tile.grass;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null){
            return Tile.dirt;
        }
        return t;
    }

    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        heigth = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][heigth];

        for(int i = 0; i < width; i++){
            for(int j = 0; j < heigth; j++){
                tiles[i][j] = Utils.parseInt(tokens[(i + j * width) + 4]);
            }
        }


    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
