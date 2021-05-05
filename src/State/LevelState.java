package State;

import Handler.Handler;
import UI.ClickListener;
import UI.UIImageButton;
import UI.UIManager;
import graphics.Asset;

import java.awt.*;

public class LevelState extends State{
    public UIManager uiManager;

    public LevelState(Handler handler) {
        super(handler);

        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        //BLUE BUTTON
        uiManager.addObject(new UIImageButton(150,400, 100, 100, Asset.buttonblu, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                State.setState(new MenuState(handler));
            }
        }));
        //YELLOW BUTTON
        uiManager.addObject(new UIImageButton(650,400, 90, 100, Asset.buttonyel, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
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
