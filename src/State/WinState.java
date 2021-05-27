package State;

import Handler.Handler;
import UI.ClickListener;
import UI.UIBackGround;
import UI.UIImageButton;
import UI.UIManager;
import graphics.Asset;

import java.awt.*;

public class WinState extends State{
    public UIManager uiManager;

    public WinState(Handler handler) {
        super(handler);

        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIBackGround(0,0, 800, 500, Asset.youWin));

        uiManager.addObject(new UIImageButton(300,100, 200, 71, Asset.buttonRestart, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                handler.getAudioPlayer().playMusic("gaoMusic.wav");
                State.setState(new MenuState(handler));
            }
        }));

        uiManager.addObject(new UIImageButton(300,322, 200, 71, Asset.buttonExit, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                System.exit(0);
            }
        }));

        handler.getAudioPlayer().playSound("WinSound.wav");
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
