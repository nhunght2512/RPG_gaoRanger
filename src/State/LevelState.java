package State;

import Handler.Handler;
import UI.ClickListener;
import UI.UIImageButton;
import UI.UIManager;
import graphics.Asset;

import java.awt.*;

public class LevelState extends State{
    public UIManager uiManager;
    public static float speed;

    public LevelState(Handler handler) {
        super(handler);

        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        //BLUE BUTTON
        uiManager.addObject(new UIImageButton(300,150, 250, 91, Asset.buttonEasy, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                speed = 1;
                State.setState(new MenuState(handler));
            }
        }));
        //YELLOW BUTTON
        uiManager.addObject(new UIImageButton(300,250, 250, 91, Asset.buttonHard, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                speed = 2;
                State.setState(new MenuState(handler));
            }
        }));
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
