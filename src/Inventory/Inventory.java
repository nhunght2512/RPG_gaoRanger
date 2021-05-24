package Inventory;

import Handler.Handler;
import Tiles.Items.Item;
import graphics.Asset;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Inventory {

    private Handler handler;
    public static boolean active = false;
    private ArrayList<Item> inventoryItem;

    public Inventory(Handler handler){
        this.handler = handler;
        inventoryItem = new ArrayList<Item>();
    }

    public void tick(){
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)){
            active = !active;
        }
        if(!active){
            return;
        }
        for(Item i : inventoryItem){
            System.out.println(i.getName() + " " + i.getCount());
        }
    }

    //INVENTORY METHODS
    public void addItem(Item item){
        for(Item i : inventoryItem){
            if(i.getId() == item.getId()){
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        }
        if(item.getId() != 0){
            inventoryItem.add(item);
        }
    }

    public void render(Graphics g){
        if(!active){
            return;
        }
        g.drawImage(Asset.inventory,100,100,501,210,null);

        //VE VAT PHAM VAO INVENTORY SHEET
        int t = 0;
        for(Item i : inventoryItem){
            if(i.getId() != 0){
                g.drawImage(i.getTexture(), 110 + 70 * (t),150,50,50, null);
                g.drawImage(Asset.num[i.getCount()], 110 + 70*(t)+ 30,150+35, null);
                t++;
            }
        }
    }

    //GETTER AND SETTER

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<Item> getInventoryItem() {
        return inventoryItem;
    }

    public void setInventoryItem(ArrayList<Item> inventoryItem) {
        this.inventoryItem = inventoryItem;
    }
}
