package State;

import Handler.Handler;
import UI.ClickListener;
import UI.UIBackGround;
import UI.UIImageButton;
import UI.UIManager;
import graphics.Asset;

import java.awt.*;

public class LoseState extends State{
    public UIManager uiManager;

    public LoseState(Handler handler) {
        super(handler);

        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIBackGround(0,0, 800, 360, Asset.loseState));

        uiManager.addObject(new UIImageButton(250,20, 300, 150, Asset.button, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                State.setState(new MenuState(handler));
            }
        }));

        uiManager.addObject(new UIImageButton(250,200, 300, 150, Asset.choosePic, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                System.exit(0);
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
