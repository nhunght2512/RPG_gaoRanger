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

    private BufferedImage hp;

    //RANDOM HUONG DI CUA NHAN VAT
    private Random random = new Random();

    //THOI GIAN CACH NHAU GIUA NHUNG LAN RANDOM HUONG DI
    private long lastMove;
    private long moveCooldown = 800;//CAN CHINH THOI GIAN QUY DINH THOI GIAN CACH NHAU GIUA MOI LAN RANDOM
    private long moveTimer = moveCooldown;

    public Monster(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        animDown = new Animation(500, Asset.blueDown);
        animUp = new Animation(500, Asset.blueUp);
        animLeft = new Animation(500, Asset.blueLeft);
        animRigth = new Animation(500, Asset.blueRight);
        animStay = Asset.blueDown[0];

        bounds.x = 20;
        bounds.y = 10;
        bounds.width = 23;
        bounds.height = 30;
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
        handler.getWorld().getItemManager().addItem(Item.iceCreamm.createNewItem((int) x, (int) y));

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
