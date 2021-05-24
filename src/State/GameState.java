package State;

import Handler.Handler;
import World.World;

import java.awt.*;

public class GameState extends State{
    private World world;
    private int color;
    public static int mustHaveItem = 2;

    public GameState(Handler handler, int color){
        super(handler);
        State.isMap = true;
        this.color = color;
        world = new World(handler, "res/World/World1.txt", color, 200, 0);
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();

        if(World.countMonster == 0){
            State.setState(new WinState(handler));
        }

        if(!handler.getEntityManager().getPlayer().isActive()){
            State.setState(new LoseState(handler));
        }

        if(handler.getWorld().getEntityManager().getPlayer().getX() > 1820 &&
                handler.getWorld().getEntityManager().getPlayer().getY() > 988 &&
                handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItem().size() == mustHaveItem){
            State.setState(new GameState1(handler, color));
        }
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }

    public void setColor(int color) {
        this.color = color;
    }
}
