package State;

import Handler.Handler;

import java.awt.*;

public abstract class State {
    public static int isMap;
    private static State currentState = null;
    public State previousState;
    protected Handler handler;

    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }

    public State getPreviousState() {
        return previousState;
    }

    public State(Handler handler){
        this.handler = handler;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
