package State;

import Handler.Handler;
import UI.UIBackGround;
import UI.UIManager;
import graphics.Asset;

import java.awt.*;

public class LoseState extends State{
    public UIManager uiManager;

    public LoseState(Handler handler) {
        super(handler);

        uiManager = new UIManager(handler);
        uiManager.addObject(new UIBackGround(0,0, 800, 360, Asset.loseState));
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
