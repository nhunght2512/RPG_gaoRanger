package Handler;

import Entity.EntityManager;
import Input.KeyManager;
import Input.MouseManager;
import Window.Game;
import World.World;
import graphics.GameCamera;

public class Handler {
    private Game game;
    private World world;

    public Handler(Game game){
        this.game = game;
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public EntityManager getEntityManager(){
        return getWorld().getEntityManager();
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
