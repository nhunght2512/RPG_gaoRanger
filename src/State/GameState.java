package State;

import Handler.Handler;
import World.World;

import java.awt.*;

public class GameState extends State{
    private World world;
    /*private State menuState;
    private State loseState;*/
    private int color;

    public GameState(Handler handler, int color){
        super(handler);
        this.color = color;
        world = new World(handler, "res/World/World1.txt", color);
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();
        if(handler.getMouseManager().isRightPressed()){
            //State.setState(new MenuState(handler));
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

    public void setColor(int color) {
        this.color = color;
    }
}
