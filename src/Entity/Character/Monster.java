package Entity.Character;

import Entity.Entity;
import Handler.Handler;
import Tiles.Items.Item;
import Tiles.Tile;
import World.World;
import graphics.Animation;
import graphics.Asset;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Monster extends Creature {

    //CREATE ANIMATION
    private Animation animDown;
    private Animation animUp;
    private Animation animLeft;
    private Animation animRigth;
    private BufferedImage animStay;

    private Item item;

    private BufferedImage hp;

    private int width;
    private int height;

    //RANDOM HUONG DI CUA NHAN VAT
    private Random random = new Random();

    //THOI GIAN CACH NHAU GIUA NHUNG LAN RANDOM HUONG DI
    private long lastMove;
    private long moveCooldown = 1000;//CAN CHINH THOI GIAN QUY DINH THOI GIAN CACH NHAU GIUA MOI LAN RANDOM
    private long moveTimer = moveCooldown;

    public final int r=400;

    public Monster(Handler handler, float x, float y, int width, int height, int type, Item item) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.item = item;
        this.width = width;
        this.height = height;

        //CHON LOAI QUAI VAT
        if(type == 1){
            animDown = new Animation(500, Asset.pigDown);
            animUp = new Animation(500, Asset.pigUp);
            animLeft = new Animation(500, Asset.pigLeft);
            animRigth = new Animation(500, Asset.pigRight);
            animStay = Asset.pigDown[0];
            bounds.x =5;
            bounds.y = 5;
            bounds.width = 35;
            bounds.height = 30;
        } else if (type == 2){
            animDown = new Animation(500, Asset.ghostDown);
            animUp = new Animation(500, Asset.ghostUp);
            animLeft = new Animation(500, Asset.ghostLeft);
            animRigth = new Animation(500, Asset.ghostRight);
            animStay = Asset.ghostDown[0];
            bounds.x =5;
            bounds.y = 5;
            bounds.width = 35;
            bounds.height = 30;
        } else if (type == 3){
            animDown = new Animation(500, Asset.virusDown);
            animUp = new Animation(500, Asset.virusUp);
            animLeft = new Animation(500, Asset.virusLeft);
            animRigth = new Animation(500, Asset.virusRight);
            animStay = Asset.virusDown[0];
            bounds.x =5;
            bounds.y = 5;
            bounds.width = 35;
            bounds.height = 30;
        } else {
            animDown = new Animation(500, Asset.boss1Down);
            animUp = new Animation(500, Asset.boss1Up);
            animLeft = new Animation(500, Asset.boss1Left);
            animRigth = new Animation(500, Asset.boss1Right);
            animStay = Asset.boss1Down[0];
            bounds.x =5;
            bounds.y = 5;
            bounds.width = 35;
            bounds.height = 60;
        }


    }

    @Override
    public void tick() {
        //ANIMATION
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRigth.tick();

        //MOVE
        getInput();
        move();
        checkPlayer();
        getHpBar();
    }

    //CHECK XEM CO DUNG PHAI PLAYER KHONG DE TRU MAU
    protected void checkPlayer(){
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)){
                continue;
            }
            if(e.getCollisionBounds(0,0).intersects(getCollisionBounds(0,0))){
                if(e instanceof Player){
                    handler.getWorld().getEntityManager().getPlayer().hurt(1);
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
        g.drawImage(hp, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()) - 10, 40, 8, null);
//        g.setColor(Color.cyan);
//        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
//                bounds.width, bounds.height);
    }

    //RANDOM HUONG DI CUA MONSTER
    public void getInput(){
        moveTimer += System.currentTimeMillis() - lastMove;
        lastMove = System.currentTimeMillis();
        if(moveTimer < moveCooldown){
            return;
        }
        xMove = 0;
        yMove = 0;
        float check = random.nextFloat();
        if(check < 0.25){
            yMove = -speed;
        }
        else if(check >= 0.25 && check < 0.5){
            yMove = speed;
        }
        else if(check >= 0.5 && check < 0.75){
            xMove = -speed;
        }
        else{
            xMove = speed;
        }
        moveTimer = 0;

        double dx= handler.getWorld().getEntityManager().getPlayer().getX();
        double dy= handler.getWorld().getEntityManager().getPlayer().getY();
        if (Math.sqrt(Math.pow(x- dx,2) + Math.pow(y-dy,2)) < r){
            if(Math.abs(x-dx) > Math.abs(y-dy)){
                if(x >= dx){
                    xMove -= 1;
                }else{
                    xMove+=1;
                }
            }else if ( y < dy){
                yMove += 1;
            } else if( y >= dy){
                yMove -= 1;
            }

        }
    }

    public void getHpBar(){
        if(health >8){
            hp = Asset.hpBar[0];
        }else if(health>6){
            hp = Asset.hpBar[1];
        }else if(health>4){
            hp = Asset.hpBar[2];
        }else if(health >2){
            hp = Asset.hpBar[3];
        }else if(health >0){
            hp = Asset.hpBar[5];
        }else{
            hp = Asset.hpBar[4];
            this.setActive(false);
        }
    }

    @Override
    public void die() {
        //KHI QUAI VAT CHET THI HIEN VAT PHAM
        World.countMonster = World.countMonster - 1;
        System.out.println("countMonster" + World.countMonster);
        handler.getWorld().getItemManager().addItem(item.createNewItem((int) x, (int) y));

    }

    //ANIMATION
    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){
            return animRigth.getCurrentFrame();
        }else if(yMove < 0){
            return animUp.getCurrentFrame();
        }else if(yMove > 0){
            return animDown.getCurrentFrame();
        }else {
            return animStay;
        }
    }
}
