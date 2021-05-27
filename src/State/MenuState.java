package State;

import Handler.Handler;
import UI.ClickListener;
import UI.UIBackGround;
import UI.UIImageButton;
import UI.UIManager;
import graphics.Asset;

import java.awt.*;

public class MenuState extends State{
    private UIManager uiManager;

    private State chooseState;

    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        //MENU BACKGROUND
        uiManager.addObject(new UIBackGround(0,0, 800, 500, Asset.back));

        //START BUTTON
        uiManager.addObject(new UIImageButton(310,171, 200, 72, Asset.buttonStart, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                handler.getAudioPlayer().stopPlaying();
                State.setState(new GameState(handler, ChooseState.color));
            }
        }));

        //LEVEL BUTTON
        uiManager.addObject(new UIImageButton(210,261, 200, 72, Asset.buttonLevel, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                LevelState levelState = new LevelState(handler);
                State.setState(levelState);
            }
        }));

        //CHOOSE BUTTON
        uiManager.addObject(new UIImageButton(410,261, 200, 72, Asset.buttonCharacter, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                chooseState = new ChooseState(handler);
                State.setState(chooseState);
            }
        }));

        //HELPBUTTON
        uiManager.addObject(new UIImageButton(310,350, 200, 72, Asset.buttonHelp, new ClickListener(){
            public void onClick(){
                handler.getMouseManager().setUiManager(null);
                State.setState(new HelpState(handler));
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
