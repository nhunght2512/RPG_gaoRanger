package Entity.Weapon;

import Entity.Character.Monster;
import Entity.Entity;
import Handler.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Sword extends Entity {

    BufferedImage img;

    //THOI GIAN CACH NHAU GIUA MOI TRU MAU
    private long lastAttackTimer;
    private long attackCooldown = 200;// CAN CHINH THOI GIAN QUY DINH THOI GIAN TRU MAU (TRU MAU NHANH HON HAY CHAM HON)
    private long attackTimer = attackCooldown;

    public Sword(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public abstract void tick();

    public void checkAttack(int amt) {

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
            if(e.getCollisionBounds(0,0).intersects(getCollisionBounds(0,0))
            && (e instanceof Monster)){
                e.hurt(amt);//TRU MAU QUAI VAT
                if(handler.getWorld().getEntityManager().getPlayer().getMp() <= 10){
                    handler.getWorld().getEntityManager().getPlayer().setMp(1);//TANG MP
                }
                return;
            }
        }
    }

    @Override
    public abstract void render(Graphics g);

    @Override
    public void die() {

    }
}
