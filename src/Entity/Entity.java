package Entity;

import Entity.Character.Player;
import Handler.Handler;

import java.awt.*;

public abstract class Entity {
    public static final int DEFAULT_HEALTH = 10;

    protected Handler handler;

    protected Rectangle bounds;

    protected float x;
    protected float y;
    protected int width;
    protected int height;
    public int health;
    protected boolean active = true;

    public Entity(Handler handler, float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.handler = handler;
        health = DEFAULT_HEALTH;

        bounds = new Rectangle(0, 0, width, height);
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    //PHUONG THUC TRU MAU
    public void hurt(int amt){
        health -= amt;
        if(health <= 0){
            active = false;
            die();
        }
    }

    public abstract void die();

    //ENTITY COLLISION
    public boolean checkEntityCollision(float xOffset, float yOffset){
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if((!(e instanceof Player)) &&
                    e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
                return true;
            }
        }
        return false;
    }

    //TRA VE HINH VUONG DUNG CHO THUAT TOAN VA CHAM
    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
