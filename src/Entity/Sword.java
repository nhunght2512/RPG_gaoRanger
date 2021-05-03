package Entity;

import Handler.Handler;
import graphics.Asset;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sword extends Entity{

    BufferedImage img;

    //THOI GIAN CACH NHAU GIUA MOI TRU MAU
    private long lastAttackTimer;
    private long attackCooldown = 200;// CAN CHINH THOI GIAN QUY DINH THOI GIAN TRU MAU (TRU MAU NHANH HON HAY CHAM HON)
    private long attackTimer = attackCooldown;

    private int xMove;
    private int yMove;
    private int speed = 2;

    public Sword(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 20;
        bounds.height = 20;
    }

    @Override
    public void tick() {
        getInput();
        x += xMove;
        y += yMove;

        //ATTACK
        checkAttack();
    }

    private void checkAttack() {

        //THOI GIAN CACH NHAU GIUA MOI LAN TRU MAU
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown){
            return;
        }

        attackTimer = 0;

        //NEU DUNG TRUNG QUAI VAT THI TIEN HANH TRU MAU VA CONG MP
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            System.out.println(e.health);
            if(e.equals(handler.getWorld().getEntityManager().getPlayer()) || e instanceof Sword){
                continue;
            }
            if(e.getCollisionBounds(0,0).intersects(getCollisionBounds(0,0))){
                e.hurt(1);//TRU MAU QUAI VAT
                handler.getWorld().getEntityManager().getPlayer().setMp(1);//TANG MP
                return;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
        //g.fillRect((int) (x + bounds.x), (int) (y+ bounds.y), bounds.width, bounds.height);
    }

    public void getInput(){
        if(handler.getKeyManager().aUp && xMove == 0 && yMove == 0){
            yMove = -speed;
            xMove = 0;
            img = Asset.swordUp;
        }
        if(handler.getKeyManager().aDown && xMove == 0 && yMove == 0){
            yMove = speed;
            xMove = 0;
            img = Asset.swordDown;
        }
        if(handler.getKeyManager().aLeft && xMove == 0 && yMove == 0){
            xMove = -speed;
            yMove = 0;
            img = Asset.swordLeft;
        }
        if(handler.getKeyManager().aRight && xMove == 0 && yMove == 0){
            xMove = speed;
            yMove = 0;
            img = Asset.swordRight;
        }
    }

    @Override
    public void die() {

    }
}
