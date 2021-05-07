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

        uiManager.addObject(new UIImageButton(300,100, 200, 75, Asset.buttonStart, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                State.setState(new MenuState(handler));
            }
        }));

        uiManager.addObject(new UIImageButton(300,200, 200, 75, Asset.buttonCharacter, new ClickListener(){
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
