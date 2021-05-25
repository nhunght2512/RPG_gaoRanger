package State;

import Handler.Handler;
import Inventory.Inventory;
import UI.ClickListener;
import UI.UIImageButton;
import UI.UIManager;
import World.World;
import graphics.Asset;

import java.awt.*;

public class GameState extends State{
    private World world;
    private int color;
    public static int mustHaveItem = 3;

    //NUT INVENTORY
    public UIManager uiManager;

    public GameState(Handler handler, int color){
        super(handler);
        State.isMap = 1;
        this.color = color;
        world = new World(handler, "res/World/World1.txt", color, 400, 0);
        handler.setWorld(world);

        //NUT INVENTORY
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIImageButton(10,10, 30, 30, Asset.buttonStart, new ClickListener(){
            public void onClick(){
                Inventory.active = !Inventory.active;
            }
        }));
    }

    @Override
    public void tick() {
        world.tick();

        if(!handler.getEntityManager().getPlayer().isActive()){
            State.setState(new LoseState(handler));
        }

        if(handler.getWorld().getEntityManager().getPlayer().getX() > 1820 &&
                handler.getWorld().getEntityManager().getPlayer().getY() > 988 /*&&
                handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItem().size() == mustHaveItem*/){
            State.setState(new GameState1(handler, color));
        }

        //NUT INVENTORY
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);

        //NUT INVENTORY
        uiManager.render(g);
    }
}
