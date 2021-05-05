package Entity.Weapon;

import Entity.Weapon.Sword;
import Handler.Handler;
import graphics.Asset;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sword2 extends Sword {
    BufferedImage img;

    //THOI GIAN CACH NHAU GIUA MOI TRU MAU
    private long lastAttackTimer;
    private long attackCooldown = 100;// CAN CHINH THOI GIAN QUY DINH THOI GIAN TRU MAU (TRU MAU NHANH HON HAY CHAM HON)
    private long attackTimer = attackCooldown;

    private int xMove;
    private int yMove;
    private int speed = 2;

    public Sword2(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width , height );

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

        //TRU MAU CUA QUAI KHI CHAM VAO SWORD
        checkAttack(2);
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(img, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width * 2, height * 2, null);
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
}
