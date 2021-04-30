package Entity;

import Handler.Handler;
import graphics.Animation;
import graphics.Asset;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{

    //ATTACK TIMER
    private long lastAttackTimer;
    private long attackCooldown = 800;
    private long attackTimer = attackCooldown;

    //CREATE ANIMATION
    private Animation animDown;
    private Animation animUp;
    private Animation animLeft;
    private Animation animRigth;
    private BufferedImage animStay;

    //private int color;

    public Player(Handler handler, float x, float y, int color) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 13;
        bounds.y = 30;
        bounds.width = 21;
        bounds.height = 15;
        //this.color = color;

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

        //ATTACK
        checkAttack();
    }

    private void checkAttack(){
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown){
            return;
        }

        Rectangle collisionBound = getCollisionBounds(0,0);

        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if(handler.getKeyManager().aUp){
            ar.x = collisionBound.x + collisionBound.width / 2 - arSize / 2;
            ar.y = collisionBound.y - arSize;
        }else if(handler.getKeyManager().aDown){
            ar.x = collisionBound.x + collisionBound.width / 2 - arSize / 2;
            ar.y = collisionBound.y + collisionBound.height;
        }else if(handler.getKeyManager().aLeft){
            ar.x = collisionBound.x - arSize;
            ar.y = collisionBound.y - collisionBound.height / 2 - arSize / 2;
        }else if(handler.getKeyManager().aRight){
            ar.x = collisionBound.x + collisionBound.x;
            ar.y = collisionBound.y + collisionBound.height / 2 - arSize / 2;
        }else{
            return;
        }

        attackTimer = 0;

        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)){
                continue;
            }
            if(e.getCollisionBounds(0,0).intersects(ar)){
                e.hurt(1);
                return;
            }
        }
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

        /*g.setColor(Color.CYAN);
        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);*/
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
}
