package Entity;

import Handler.Handler;
import graphics.Animation;
import graphics.Asset;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{

    //CREATE ANIMATION
    private Animation animDown;
    private Animation animUp;
    private Animation animLeft;
    private Animation animRigth;
    private BufferedImage animStay;
    private int mp = 0;

    //HP BAR
    private BufferedImage hp;
    private BufferedImage MP;

    public Player(Handler handler, float x, float y, int color) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        health = 200;

        bounds.x = 13;
        bounds.y = 30;
        bounds.width = 21;
        bounds.height = 15;

        //ANIMATION
        if(color == 1){
            System.out.println(color);
            animDown = new Animation(500, Asset.blueDown);
            animUp = new Animation(500, Asset.blueUp);
            animLeft = new Animation(500, Asset.blueLeft);
            animRigth = new Animation(500, Asset.blueRight);
            animStay = Asset.blueDown[0];
        }else {
            animDown = new Animation(500, Asset.yelDown);
            animUp = new Animation(500, Asset.yelUp);
            animLeft = new Animation(500, Asset.yelLeft);
            animRigth = new Animation(500, Asset.yelRight);
            animStay = Asset.yelDown[0];
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
        handler.getGameCamera().centerOnEntity(this);

        //HP BAR
        getHpBar();
        getMpBar();
    }

    public void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up){
            yMove = -speed;
        }
        if(handler.getKeyManager().down){
            yMove = speed;
        }
        if(handler.getKeyManager().left){
            xMove = -speed;
        }
        if(handler.getKeyManager().right){
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
        g.drawImage(hp, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()) - 10, 40, 8, null);
        g.drawImage(MP, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()) - 15, 40, 8, null);
        /*g.setColor(Color.CYAN);
        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);*/
    }

    public void getHpBar(){
        if(health >160){
            hp = Asset.hpBar[0];
        }else if(health>120){
            hp = Asset.hpBar[1];
        }else if(health>80){
            hp = Asset.hpBar[2];
        }else if(health >40){
            hp = Asset.hpBar[3];
        }else if(health >0){
            hp = Asset.hpBar[5];
        }else{
            hp = Asset.hpBar[4];
            this.setActive(false);
        }
    }

    public void getMpBar(){
        if(mp >8){
            MP = Asset.mpBar[0];
        }else if(mp>6){
            MP = Asset.mpBar[1];
        }else if(mp>4){
            MP = Asset.mpBar[2];
        }else if(mp >2){
            MP = Asset.mpBar[3];
        }else if(mp > 0){
            MP = Asset.mpBar[5];
        }else{
            MP = Asset.mpBar[4];
        }
    }

    //CHECK XEM CO DUNG PHAI MONSTER KHONG DE TRU MAU
    protected boolean checkMonster(){
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)){
                continue;
            }
            if(e.getCollisionBounds(0,0).intersects(getCollisionBounds(0,0))){
                if(e instanceof Monster){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void die() {
        System.out.println("you lose");
    }

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

    public int getMp() {
        return mp;
    }

    public void setMp(int amt) {
        this.mp = mp + amt;
    }
}
