package State;

import Handler.Handler;
import World.World;

import java.awt.*;

public class GameState extends State{
    private World world;
    private State MenuState;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "res/World/World1.txt");
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();
        if(handler.getMouseManager().isLeftPressed()){
            State.setState(MenuState);
        }
    }

    @Override
    public void render(Graphics g) {

        world.render(g);
        //backGround.render(g);
    }
}
