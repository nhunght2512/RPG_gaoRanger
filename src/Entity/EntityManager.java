package Entity;

import Entity.Character.Monster;
import Entity.Character.Player;
import Entity.Weapon.Sword1;
import Entity.Weapon.Sword2;
import Handler.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager {
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    public static boolean winFlag = false;

    //RENDER ORDER
    private Comparator<Entity> renderSorter = new Comparator<Entity>() {
        @Override
        public int compare(Entity o1, Entity o2) {
            if(o1.getY() + o1.getHeight() < o2.getY() + o2.getHeight()){
                return -1;
            }
            return 1;
        }
    };

    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);
    }

    public void tick(){
        Iterator<Entity> iter = entities.iterator();
        while(iter.hasNext()){
            Entity e = iter.next();
            e.tick();

            //KIEM TRA XEM NHAN VAT CHET CHUA
            if(! e.isActive()){
                iter.remove();
            }
            if(! e.isActive() && e instanceof Monster){
                if(((Monster) e).getType() == 4){
                    winFlag = true;
                }
            }

            //NEU LA KIEM THI XOA SAU 1S
            if(e instanceof Sword1 && !handler.getWorld().isShoot()){
                e.setActive(false);
                break;
            }else if(e instanceof Sword2 && !handler.getWorld().isShoot()){
                e.setActive(false);
                handler.getWorld().getEntityManager().getPlayer().setMp(-1);
                break;
            }
        }
        entities.sort(renderSorter);
    }

    public void render(Graphics g){
        for(Entity e : entities){
            e.render(g);
        }
        player.postRender(g);
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    //GETTER AND SETTER

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
}
