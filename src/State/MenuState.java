package State;

import Handler.Handler;
import UI.ClickListener;
import UI.UIBackGround;
import UI.UIImageButton;
import UI.UIManager;
import graphics.Asset;

import java.awt.*;

public class MenuState extends State{
    public UIManager uiManager;

    public State chooseState;

    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        //MENU BACKGROUND
        uiManager.addObject(new UIBackGround(0,0, 800, 360, Asset.back));

        //START BUTTON
        uiManager.addObject(new UIImageButton(250,20, 300, 150, Asset.button, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                State.setState(new GameState(handler, ChooseState.color));
            }
        }));

        //LEVEL BUTTON
        uiManager.addObject(new UIImageButton(650,200, 90, 100, Asset.choosePic, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                LevelState levelState = new LevelState(handler);
                State.setState(levelState);
            }
        }));

        //CHOOSE BUTTON
        uiManager.addObject(new UIImageButton(650,400, 90, 100, Asset.choosePic, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                chooseState = new ChooseState(handler);
                State.setState(chooseState);
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
