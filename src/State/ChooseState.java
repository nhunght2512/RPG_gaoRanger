package State;

import Handler.Handler;
import UI.ClickListener;
import UI.UIImageButton;
import UI.UIManager;
import graphics.Asset;

import java.awt.*;

public class ChooseState extends State{
    public UIManager uiManager;
    public static int color;

    public ChooseState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        // RED BUTTON
        uiManager.addObject(new UIImageButton(0,0, 160, 500, Asset.buttonRed, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                color = 1;
                State.setState(new MenuState(handler));
            }
        }));

        //BLUE BUTTON
        uiManager.addObject(new UIImageButton(160,0, 160, 500, Asset.buttonBlu, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                color = 2;
                State.setState(new MenuState(handler));
            }
        }));

        // BLACK BUTTON
        uiManager.addObject(new UIImageButton(320,0, 160, 500, Asset.buttonBla, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                color = 3;
                State.setState(new MenuState(handler));
            }
        }));

        //YELLOW BUTTON
        uiManager.addObject(new UIImageButton(480,0, 160, 500, Asset.buttonYel, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                color = 4;
                State.setState(new MenuState(handler));
            }
        }));

        //WHITE BUTTON
        uiManager.addObject(new UIImageButton(640,0, 160, 500, Asset.buttonWhi, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                color = 5;
                State.setState(new MenuState(handler));
            }
        }));
    }

    public int getColor() {
        return color;
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
}
