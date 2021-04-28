package State;

import Handler.Handler;
import UI.ClickListener;
import UI.UIBackGround;
import UI.UIImageButton;
import UI.UIManager;
import graphics.Asset;

import java.awt.*;

public class MenuState extends State{
    protected UIManager uiManager;

    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIBackGround(0,0, 800, 360, Asset.back));//MENU BACKGROUND
        uiManager.addObject(new UIImageButton(250,20, 300, 150, Asset.button, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));

    }

    @Override
    public void tick() {
        uiManager.tick();
        /*if(handler.getMouseManager().isLeftPressed()){
            State.setState(handler.getGame().gameState);
        }
        //System.out.println(handler.getMouseManager().getMouseX()+ " " + handler.getMouseManager().getMouseY());*/
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
        /*g.setColor(Color.CYAN);
        g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 10, 10);*/
    }
}
