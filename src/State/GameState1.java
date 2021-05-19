package State;

import Handler.Handler;
import World.World;

import java.awt.*;

public class GameState1 extends State{
    private World world;
    private int color;
    public GameState1(Handler handler, int color) {
        super(handler);
        State.isMap = false;
        this.color = color;
        world = new World(handler, "res/World/World2.txt", color);
        handler.setWorld(world);
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
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }
}
