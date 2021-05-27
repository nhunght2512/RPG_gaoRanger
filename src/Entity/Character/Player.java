package Entity.Character;

import Handler.Handler;
import Inventory.Inventory;
import graphics.Animation;
import graphics.Asset;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    //CREATE ANIMATION
    private Animation animDown;
    private Animation animUp;
    private Animation animLeft;
    private Animation animRigth;
    private BufferedImage animStay;
    private int mp;
    private BufferedImage lastKnownAnimationFrame;

    //HP BAR
    private BufferedImage hp;
    private BufferedImage MP;

    //INVENTORY
    private Inventory inventory;

    public Player(Handler handler, float x, float y, int color, int health, int mp) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        this.health = health;
        this.mp = mp;

        bounds.x = 22;
        bounds.y = 25;
        bounds.width = 20;
        bounds.height = 20;

        //ANIMATION
        if(color == 1){
            System.out.println(color);
            animDown = new Animation(500, Asset.redDown);
            animUp = new Animation(500, Asset.redUp);
            animLeft = new Animation(500, Asset.redLeft);
            animRigth = new Animation(500, Asset.redRight);
            animStay = Asset.redDown[0];
            lastKnownAnimationFrame = Asset.redDown[0];
        }else if (color == 2){
            animDown = new Animation(500, Asset.blueDown);
            animUp = new Animation(500, Asset.blueUp);
            animLeft = new Animation(500, Asset.blueLeft);
            animRigth = new Animation(500, Asset.blueRight);
            animStay = Asset.blueDown[0];
            lastKnownAnimationFrame = Asset.blueDown[0];
        }else if (color == 3){
            animDown = new Animation(500, Asset.blackDown);
            animUp = new Animation(500, Asset.blackUp);
            animLeft = new Animation(500, Asset.blackLeft);
            animRigth = new Animation(500, Asset.blackRight);
            animStay = Asset.blackDown[0];
            lastKnownAnimationFrame = Asset.blackDown[0];
        }else if (color == 4){
            animDown = new Animation(500, Asset.yelDown);
            animUp = new Animation(500, Asset.yelUp);
            animLeft = new Animation(500, Asset.yelLeft);
            animRigth = new Animation(500, Asset.yelRight);
            animStay = Asset.yelDown[0];
            lastKnownAnimationFrame = Asset.yelDown[0];
        }else {
            animDown = new Animation(500, Asset.whiteDown);
            animUp = new Animation(500, Asset.whiteUp);
            animLeft = new Animation(500, Asset.whiteLeft);
            animRigth = new Animation(500, Asset.whiteRight);
            animStay = Asset.whiteDown[0];
            lastKnownAnimationFrame = Asset.whiteDown[0];
        }

        inventory = new Inventory(handler);
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
        handler.getGameCamera().centerOnEntity(this);

        //HP BAR
        getHpBar();
        getMpBar();

        //INVENTORY
        inventory.tick();
    }

    public void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up){
            yMove = -3;
        }
        if(handler.getKeyManager().down){
            yMove = 3;
        }
        if(handler.getKeyManager().left){
            xMove = -3;
        }
        if(handler.getKeyManager().right){
            xMove = 3;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
        g.drawImage(hp, (int)(x - handler.getGameCamera().getxOffset() + 14), (int)(y - handler.getGameCamera().getyOffset()) - 8, 40, 8, null);
        g.drawImage(MP, (int)(x - handler.getGameCamera().getxOffset() + 10 ), (int)(y - handler.getGameCamera().getyOffset()) - 15, 40, 8, null);
        g.setColor(Color.CYAN);
//        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
//                bounds.width, bounds.height);
//        postRender(g);
    }
    //INVENTORY RENDER
    public void postRender(Graphics g){
        inventory.render(g);
    }

    public void getHpBar(){
        if(health > 320){
            hp = Asset.hpBar[0];
        }else if(health > 240){
            hp = Asset.hpBar[1];
        }else if(health > 160){
            hp = Asset.hpBar[2];
        }else if(health > 80){
            hp = Asset.hpBar[3];
        }else if(health > 0){
            hp = Asset.hpBar[5];
        }else{
            hp = Asset.hpBar[4];
            this.setActive(false);
        }
    }

    public void getMpBar(){
        if(mp > 8){
            MP = Asset.mpBar[0];
        }else if(mp > 6){
            MP = Asset.mpBar[1];
        }else if(mp > 4){
            MP = Asset.mpBar[2];
        }else if(mp > 2){
            MP = Asset.mpBar[3];
        }else if(mp > 0){
            MP = Asset.mpBar[5];
        }else{
            MP = Asset.mpBar[4];
        }
    }

    @Override
    public void die() {
        System.out.println("you lose");
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            lastKnownAnimationFrame = animLeft.getCurrentFrame();
        } else if (xMove > 0) {
            lastKnownAnimationFrame = animRigth.getCurrentFrame();
        } else if (yMove < 0) {
            lastKnownAnimationFrame = animUp.getCurrentFrame();
        } else if (yMove > 0) {
            lastKnownAnimationFrame = animDown.getCurrentFrame();
        }
        return lastKnownAnimationFrame;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int amt) {
        this.mp = mp + amt;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
