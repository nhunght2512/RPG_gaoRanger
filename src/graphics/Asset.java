package graphics;

import java.awt.image.BufferedImage;
//CROP IMAGES FROM SPRITE SHEET
public class Asset {
    private static final int width = 47;
    private static final int height = 47;

    public static BufferedImage back, brick1, brick2, rock, dirt, grass, table, tomb, signPost, tree;
    public static BufferedImage[] blueUp, blueDown, blueLeft, blueRight, button;

    public static void init(){
        //LOAD ANH
        SpriteSheet sheet = new SpriteSheet(LoadImage.loadImage("/textures/gao_xanh.png"));
        SpriteSheet backGround = new SpriteSheet(LoadImage.loadImage("/BackGround/back.png"));
        SpriteSheet brick = new SpriteSheet(LoadImage.loadImage("/BackGround/brick1.jpg"));
        SpriteSheet stuff = new SpriteSheet(LoadImage.loadImage("/textures/tree.png"));
        SpriteSheet buttonStart = new SpriteSheet(LoadImage.loadImage("/textures/button2.png"));
        SpriteSheet logo = new SpriteSheet(LoadImage.loadImage("/textures/logo-gaoranger.png"));

        blueUp = new BufferedImage[3];
        blueDown = new BufferedImage[3];
        blueLeft = new BufferedImage[3];
        blueRight = new BufferedImage[3];
        button = new BufferedImage[3];

        blueDown[0] = sheet.crop(0 , 0, width, height);
        blueDown[1] = sheet.crop(width, 0, width, height);
        blueDown[2] = sheet.crop(width*2, 0, width, height);

        blueLeft[0] = sheet.crop(width*2, height, width, height);
        blueLeft[1] = sheet.crop(0, height, width, height);
        blueLeft[2] = sheet.crop(width, height, width, height);


        blueRight[0] = sheet.crop(0, height*2 + 2, width, height);
        blueRight[1] = sheet.crop(width, height*2 + 2, width, height);
        blueRight[2] = sheet.crop(width*2, height*2 + 2, width, height);

        blueUp[0] = sheet.crop(0, height*3 + 3, width,height);
        blueUp[1] = sheet.crop(width, height*3 + 3, width,height);
        blueUp[2] = sheet.crop(width*2, height*3 +3, width,height);

        button[0] = buttonStart.crop(0,0, 225, 125);
        button[1] = buttonStart.crop(225, 0, 225,125);

        //CAT GACH
        back = logo.crop(0,0,800,360);
        brick1 = brick.crop(0,0,42,42);
        brick2 = brick.crop(42,0,42,42);
        rock = brick.crop(42*2,0,42,42);
        dirt = brick.crop(42*3,0,42,42);
        grass = brick.crop(42*4,0,42,42);
        table = stuff.crop(0, 77, 87,72);
        tomb = stuff.crop(88, 75, 61, 73);
        signPost = stuff.crop(153,85, 32,42);
        tree = stuff.crop(195, 0, 116, 148);
    }
}
