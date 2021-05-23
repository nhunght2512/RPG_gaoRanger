package World;

import Entity.EntityManager;
import Entity.Character.Player;
import Entity.StaticEntity.ObjectRPG;
import Entity.Weapon.Sword;
import Entity.Weapon.Sword1;
import Entity.Weapon.Sword2;
import Entity.Character.Monster;
import Handler.Handler;
import Tiles.Items.Item;
import Tiles.Items.ItemManager;
import Tiles.Tile;
import Utils.Utils;
import graphics.Asset;
import State.State;

import java.awt.*;

public class World {
    private Handler handler;

    private int width;
    private int heigth;
    private int spawnX;
    private int spawnY;
    private int[][] tiles;
    private int size;
    public static int countMonster;

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

    public World(Handler handler, String path, int color, int health, int mp){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 500, 500, color, health, mp));
        itemManager = new ItemManager(handler);

        //CREATE ENTITIES
        if(State.isMap == true){
            entityManager.addEntity(new ObjectRPG(handler, 512, 32, Asset.tree1, 96, 128, 0, 100, 80, 20));
            entityManager.addEntity(new ObjectRPG(handler, 64, 64, Asset.lake, 384, 352, 32, 32, 320, 288));
            entityManager.addEntity(new ObjectRPG(handler, 96, 64, Asset.rock3, 32, 64, 0, 0, 32, 64));
            entityManager.addEntity(new ObjectRPG(handler, 384, 64, Asset.rock3, 32, 64, 0, 0, 32, 64));
            entityManager.addEntity(new ObjectRPG(handler, 96, 320, Asset.rock3, 32, 64, 0, 0, 32, 64));
            entityManager.addEntity(new ObjectRPG(handler, 384, 320, Asset.rock3, 32, 64, 0, 0, 32, 64));
            entityManager.addEntity(new ObjectRPG(handler, 288, 224, Asset.bridge, 128, 64, 0, 0 , 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 128, 256, Asset.tree3, 64, 160, 0, 128, 50, 32));
            entityManager.addEntity(new ObjectRPG(handler, 320, 256, Asset.tree3, 64, 160, 0, 128, 50, 32));
            entityManager.addEntity(new ObjectRPG(handler, 512, 256, Asset.garden1, 192, 128, 0, 0, 128, 128));
            entityManager.addEntity(new ObjectRPG(handler, 704, 192, Asset.rock, 32, 96, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 864, 192, Asset.rock, 32, 96, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 736, 128, Asset.rock1, 64, 96, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 800, 128, Asset.rock2, 32, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 832, 192, Asset.rock2, 32, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 768, 224, Asset.rock2, 32, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 992, 32, Asset.tree1, 96, 128, 20, 100, 50, 20));
            entityManager.addEntity(new ObjectRPG(handler, 992, 192, Asset.tree4, 96, 160, 40, 100, 20, 20));
            entityManager.addEntity(new ObjectRPG(handler, 128, 448, Asset.tree2, 64, 96, 16, 64, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 64, 512, Asset.tree10, 32, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 320, 416, Asset.tree1, 96, 128, 25, 96, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 256, 512, Asset.tree10, 32, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 512, 448, Asset.tree2, 64, 96, 16, 64, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 448, 512, Asset.tree9, 32, 64, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 704, 416, Asset.tree1, 96, 128, 25, 96, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 640, 512, Asset.tree8, 32, 64, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 896, 448, Asset.tree2, 64, 96, 16, 64, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 832, 512, Asset.tree7, 32, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 1088, 416, Asset.tree1, 96, 128, 25, 96, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 1024, 512, Asset.tree6, 32, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 1216, 512, Asset.tree5, 32, 32, 0, 0, 0, 0));

            entityManager.addEntity(new ObjectRPG(handler, 1856, 64, Asset.rock3, 32, 64, 0, 0, 32, 64));
            entityManager.addEntity(new ObjectRPG(handler, 1664, 288, Asset.rock3, 32, 64, 0, 0, 32, 64));

            entityManager.addEntity(new ObjectRPG(handler, 96, 928, Asset.tree1, 96, 128, 25, 96, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 320, 928, Asset.tree1, 96, 128, 25, 96, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 544, 928, Asset.tree1, 96, 128, 25, 96, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 768, 928, Asset.tree1, 96, 128, 25, 96, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 992, 928, Asset.tree1, 96, 128, 25, 96, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 1216, 928, Asset.tree1, 96, 128, 25, 96, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 1440, 928, Asset.tree1, 96, 128, 25, 96, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 1664, 928, Asset.tree1, 96, 128, 25, 96, 32, 32));

            entityManager.addEntity(new ObjectRPG(handler, 32, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 128, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 224, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 320, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 416, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 512, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 608, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 704, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 800, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 896, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 992, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 1088, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 1184, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 1280, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 1472, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 1568, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 1664, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 1760, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 1856, 576, Asset.fence, 96, 32, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 1344, 480, Asset.gate, 128, 128, 0, 96, 32, 32));

            entityManager.addEntity(new ObjectRPG(handler, 1312, 32, Asset.tree2, 64, 96, 20, 64, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 1312, 128, Asset.tree2, 64, 96, 20, 64, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 1312, 224, Asset.tree2, 64, 96, 20, 64, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 1312, 320, Asset.tree2, 64, 96, 20, 64, 32, 32));

            entityManager.addEntity(new ObjectRPG(handler, 1504, 32, Asset.tree2, 64, 96, 20, 64, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 1504, 128, Asset.tree2, 64, 96, 20, 64, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 1504, 224, Asset.tree2, 64, 96, 20, 64, 32, 32));
            entityManager.addEntity(new ObjectRPG(handler, 1504, 320, Asset.tree2, 64, 96, 20, 64, 32, 32));

            entityManager.addEntity(new ObjectRPG(handler, 1504, 416, Asset.tree3, 64, 160, 20, 128, 32, 32));

            entityManager.addEntity(new ObjectRPG(handler, 1632, 32, Asset.garden2, 160, 192, 0, 0, 96, 192));
            entityManager.addEntity(new ObjectRPG(handler, 1632, 32, Asset.tree4, 96, 160, 16, 96, 32, 32));

            entityManager.addEntity(new ObjectRPG(handler, 1728, 416, Asset.tree11, 32, 64, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 1792, 416, Asset.tree11, 32, 64, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 1856, 416, Asset.tree11, 32, 64, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 1856, 352, Asset.tree11, 32, 64, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 1856, 288, Asset.tree11, 32, 64, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 1856, 224, Asset.tree11, 32, 64, 0, 0, 0, 0));
            entityManager.addEntity(new ObjectRPG(handler, 1856, 160, Asset.tree11, 32, 64, 0, 0, 0, 0));


            //CREATE MONSTER
            countMonster = 13;
            entityManager.addEntity(new Monster(handler, 450, 300, Item.iceCreamm));
            entityManager.addEntity(new Monster(handler, 260, 400, Item.iceCream1));
            entityManager.addEntity(new Monster(handler, 800, 400, Item.iceCream2));
            entityManager.addEntity(new Monster(handler, 1200, 200, Item.iceCream1));
            entityManager.addEntity(new Monster(handler, 1740, 400, Item.iceCream2));
            entityManager.addEntity(new Monster(handler, 1760, 500, Item.iceCream1));
            entityManager.addEntity(new Monster(handler, 1780, 700, Item.iceCream2));
            entityManager.addEntity(new Monster(handler, 1700, 700, Item.iceCreamm));
            entityManager.addEntity(new Monster(handler, 200, 700, Item.iceCreamm));
            entityManager.addEntity(new Monster(handler, 300, 700, Item.iceCreamm));
            entityManager.addEntity(new Monster(handler, 400, 700, Item.iceCreamm));
            entityManager.addEntity(new Monster(handler, 1500, 700, Item.iceCreamm));
            entityManager.addEntity(new Monster(handler, 600, 700, Item.iceCreamm));
        } else{
            entityManager.addEntity(new Monster(handler, 450, 300, Item.iceCream1));
            entityManager.addEntity(new Monster(handler, 260, 400, Item.iceCream2));
            entityManager.addEntity(new Monster(handler, 800, 400, Item.iceCream1));
            entityManager.addEntity(new Monster(handler, 1200, 200, Item.iceCream2));
            entityManager.addEntity(new Monster(handler, 1740, 400, Item.iceCream1));
            entityManager.addEntity(new Monster(handler, 1760, 500, Item.iceCream2));
            entityManager.addEntity(new Monster(handler, 1780, 700, Item.iceCreamm));
            entityManager.addEntity(new Monster(handler, 1700, 700, Item.iceCreamm));
            entityManager.addEntity(new Monster(handler, 200, 700, Item.iceCreamm));
        }

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

        //RENDER ENTITY
        entityManager.render(g);

        //RENDER ITEMS
        itemManager.render(g);
    }

    public Tile getTile(int x, int y){
        if(x < 0 || y < 0 || x >= width || y >= heigth){
            return Tile.grass1;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null){
            return Tile.bound;
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
