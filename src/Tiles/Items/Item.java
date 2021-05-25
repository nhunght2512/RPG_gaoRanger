package Tiles.Items;

import Handler.Handler;
import graphics.Asset;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item {

    //HANDLER
    public static Item[] items = new Item[256];
    public static Item iceCreamm = new Item(Asset.iceCream, "increaseHp", 0);
    public static Item iceCream1 = new Item(Asset.icecream1, "item1", 1);
    public static Item iceCream2 = new Item(Asset.icecream2, "item2", 2);
    public static Item iceCream3 = new Item(Asset.icecream3, "item3", 3);

    //CLASS
    public static final int ITEM_WIDTH = 32;
    public static final int ITEM_HEIGHT = 32;

    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected final int id;

    protected Rectangle bounds;

    protected int x, y, count;
    protected boolean pickedUp = false;

    public Item(BufferedImage texture, String name, int id){
        this.texture = texture;
        this.name = name;
        this.id = id;
        count = 1;

        bounds = new Rectangle(x, y, ITEM_WIDTH, ITEM_HEIGHT);

        items[id] = this;
    }

    public void tick(){
        //VAT PHAM VA PLAYER CHAM NHAU THI LAM VAT PHAM BIEN MAT
        if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f,0f).intersects(bounds)){
            pickedUp = true;
            handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);

            //CONG MAU KHI AN VAT PHAM
            if(handler.getWorld().getEntityManager().getPlayer().getHealth() <= 180 && (this.getId() == 0)){
                handler.getWorld().getEntityManager().getPlayer().setHealth(80);
            }
        }
    }

    public void render(Graphics g){
        if(handler == null){
            return;
        }
        render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, ITEM_WIDTH, ITEM_HEIGHT, null);
        /*g.setColor(Color.cyan);
        g.fillRect(x, y, bounds.width, bounds.height);*/
    }

    public Item createNewItem(int x, int y){
        Item i = new Item(texture, name, id);
        i.setPosition(x, y);
        return i;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
        bounds.x = x;
        bounds.y = y;
    }

    //GETTER AND SETTER

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }
}
