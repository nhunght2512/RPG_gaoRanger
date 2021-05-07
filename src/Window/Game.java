package Window;

import Display.Display;
import Handler.Handler;
import Input.KeyManager;
import Input.MouseManager;
import State.MenuState;
import State.State;
import audio.AudioPlayer;
import graphics.Asset;
import graphics.GameCamera;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{
    private Display display;
    private int width;
    private int height;
    private String title;

    private Thread thread;
    private boolean running;

    private BufferStrategy bs;
    private Graphics g;

    //STATE
    public State gameState;
    public State menuState;

    //INPUT
    private KeyManager keyManager;
    private MouseManager mouseManager;

    //CAMERA
    private GameCamera gameCamera;

    //SOUND
    private AudioPlayer audioPlayer;

    //HANDLER
    private Handler handler;

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;

        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Asset.init();

        handler = new Handler(this);
        gameCamera = new GameCamera(handler,0, 0);

        audioPlayer = new AudioPlayer(handler);
        handler.getAudioPlayer().playMusic("GaoMusic.wav");

        //gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(menuState);
    }

    private void tick(){
        keyManager.tick();

        if(State.getState() != null){
            State.getState().tick();
        }
    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //CLEAR THE SCREEN
        g.clearRect(0,0,width,height);
        //DRAW
        if(State.getState() != null){
            State.getState().render(g);
        }
        //END DRAW
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        long ticks = 0;

        while (running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                render();
                ticks ++;
                delta --;
            }

            if(timer >= 1000000000){
                System.out.println("Tick and Frame: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public AudioPlayer getAudioPlayer(){
        return audioPlayer;
    }

    public synchronized void start(){
        if(running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running){
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
