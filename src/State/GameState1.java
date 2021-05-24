package State;

import Handler.Handler;
import Inventory.Inventory;
import UI.ClickListener;
import UI.UIImageButton;
import UI.UIManager;
import World.World;
import graphics.Asset;

import java.awt.*;

public class GameState1 extends State{
    private World world;
    private int color;

    //NUT INVENTORY
    public UIManager uiManager;

    public GameState1(Handler handler, int color) {
        super(handler);
        State.isMap = false;
        this.color = color;
        world = new World(handler, "res/World/World1.txt", color, handler.getWorld().getEntityManager().getPlayer().getHealth(),
                handler.getWorld().getEntityManager().getPlayer().getMp());
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

        if(World.countMonster == 0){
            State.setState(new WinState(handler));
        }

        if(handler.getMouseManager().isRightPressed()){
            System.exit(0);
        }

        if(!handler.getEntityManager().getPlayer().isActive()){
            State.setState(new LoseState(handler));
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
