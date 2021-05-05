package World;

import Entity.Entity;
import Entity.EntityManager;
import Entity.Character.Player;
import Entity.StaticEntity.Tree;
import Entity.Weapon.Sword;
import Entity.Weapon.Sword1;
import Entity.Weapon.Sword2;
import Entity.Character.Monster;
import Handler.Handler;
import Tiles.Items.ItemManager;
import Tiles.Tile;
import Utils.Utils;
import graphics.Asset;

import java.awt.*;

public class World {
    private Handler handler;

    private int width;
    private int heigth;
    private int spawnX;
    private int spawnY;
    private int[][] tiles;
    private int size;

    //ATTACK TIMER
    private long lastAttackTimer;
    private long timeCounter = System.currentTimeMillis();
    private long attackCooldown = 1000;
    private long attackTimer = attackCooldown;

    //SHOOTING FLAG
    private boolean isShoot = false;

    //CREATE ENTITIES
    private EntityManager entityManager;

    //CREATE ITEMS
    private ItemManager itemManager;

    public World(Handler handler, String path, int color){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100, color));
        itemManager = new ItemManager(handler);

        //CREATE ENTITIES
        entityManager.addEntity(new Tree(handler, 300, 25, Asset.tree));
        entityManager.addEntity(new Monster(handler, 500, 300));
        entityManager.addEntity(new Monster(handler, 300, 400));
        entityManager.addEntity(new Monster(handler, 800, 700));
        entityManager.addEntity(new Monster(handler, 720, 700));
        entityManager.addEntity(new Monster(handler, 740, 700));
        entityManager.addEntity(new Monster(handler, 760, 700));
        entityManager.addEntity(new Monster(handler, 780, 700));
        entityManager.addEntity(new Monster(handler, 700, 700));
        entityManager.addEntity(new Monster(handler, 200, 700));
        entityManager.addEntity(new Monster(handler, 300, 700));
        entityManager.addEntity(new Monster(handler, 400, 700));
        entityManager.addEntity(new Monster(handler, 500, 700));
        entityManager.addEntity(new Monster(handler, 600, 700));

        loadWorld(path);

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }

    public void tick(){
        makeBullet(entityManager.getPlayer().getX(), entityManager.getPlayer().getY());
        entityManager.tick();
        itemManager.tick();
    }

    private void makeBullet(float x, float y){
        Sword sword;
        if(entityManager.getPlayer().getMp() > 0 && handler.getKeyManager().space){
            sword = new Sword2(handler, x, y, 30, 40);
        }else{
            sword = new Sword1(handler, x, y, 30, 40);
        }
        //SHOOTING
        if((handler.getKeyManager().aUp || handler.getKeyManager().aDown
                || handler.getKeyManager().aLeft || handler.getKeyManager().aRight) && (!isShoot)){
            //ADD SWORD
            entityManager.addEntity(sword);
            size = entityManager.getEntities().size();
            isShoot = true;//NO MORE SWORD UNTIL ISSHOOT == FALSE
            System.out.println("t    "+size);

            //KILL COOLDOWN
            attackTimer += System.currentTimeMillis() - lastAttackTimer;
            lastAttackTimer = System.currentTimeMillis();
            if(attackTimer < attackCooldown){
                return;
            }
            attackTimer = 0;
        }else {
            //TIME EXISTENCE OF SWORD
            if(System.currentTimeMillis() - timeCounter > 1000){
                timeCounter = System.currentTimeMillis();
                isShoot = false;
            }
        }
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

        //RENDER ITEMS
        itemManager.render(g);

        //RENDER ENTITY
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

    //GETTERS AND SETTERS


    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
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

    public boolean isShoot() {
        return isShoot;
    }

    public void setShoot(boolean shoot) {
        isShoot = shoot;
    }
}
