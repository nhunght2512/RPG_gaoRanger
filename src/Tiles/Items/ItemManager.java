package Tiles.Items;

import Handler.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemManager {

    private Handler handler;
    private ArrayList<Item> items;

    public ItemManager(Handler handler){
        this.handler = handler;
        items = new ArrayList<Item>();
    }

    public void tick(){
        Iterator<Item> iter = items.iterator();
        while(iter.hasNext()){
            Item i = iter.next();
            i.tick();
            //XOA VAT PHAM
            if(i.isPickedUp()){
                iter.remove();
            }
        }
    }

    public void render(Graphics g){
        for(Item i : items){
            i.render(g);
        }
    }

    public void addItem(Item i){
        i.setHandler(handler);
        items.add(i);
    }

    //GETTER AND SETTER

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
