package graphics;

import java.awt.image.BufferedImage;
//CROP IMAGES FROM SPRITE SHEET
public class Asset {
    private static final int width = 47;
    private static final int height = 47;

    public static BufferedImage back, brick1, brick2, rock, dirt, grass, table, tomb, signPost, tree, swordUp, swordDown, swordLeft, swordRight;
    public static BufferedImage[] blueUp, blueDown, blueLeft, blueRight, button, buttonyel, buttonblu,
                                  yelUp, yelDown, yelLeft, yelRight, choosePic;

    public static void init(){
        //LOAD ANH
        SpriteSheet sheet = new SpriteSheet(LoadImage.loadImage("/textures/gao_xanh.png"));
        SpriteSheet sheet1 = new SpriteSheet(LoadImage.loadImage("/textures/gaoRanger_Yellow.png"));
        SpriteSheet yellow = new SpriteSheet(LoadImage.loadImage("/textures/Yellow.png"));
        SpriteSheet blue = new SpriteSheet(LoadImage.loadImage("/textures/blue.png"));
        SpriteSheet pic = new SpriteSheet(LoadImage.loadImage("/textures/pic.png"));
        SpriteSheet backGround = new SpriteSheet(LoadImage.loadImage("/BackGround/back.png"));
        SpriteSheet brick = new SpriteSheet(LoadImage.loadImage("/BackGround/brick1.jpg"));
        SpriteSheet stuff = new SpriteSheet(LoadImage.loadImage("/textures/tree.png"));
        SpriteSheet buttonStart = new SpriteSheet(LoadImage.loadImage("/textures/button2.png"));
        SpriteSheet logo = new SpriteSheet(LoadImage.loadImage("/textures/logo-gaoranger.png"));
        SpriteSheet sword1 = new SpriteSheet(LoadImage.loadImage("/textures/sword_up.png"));
        SpriteSheet sword2 = new SpriteSheet(LoadImage.loadImage("/textures/sword_down.png"));
        SpriteSheet sword3 = new SpriteSheet(LoadImage.loadImage("/textures/sword_left.png"));
        SpriteSheet sword4 = new SpriteSheet(LoadImage.loadImage("/textures/sword_right.png"));

        blueUp = new BufferedImage[3];
        blueDown = new BufferedImage[3];
        blueLeft = new BufferedImage[3];
        blueRight = new BufferedImage[3];

        yelUp = new BufferedImage[3];
        yelDown = new BufferedImage[3];
        yelLeft = new BufferedImage[3];
        yelRight = new BufferedImage[3];

        button = new BufferedImage[3];
        buttonyel = new BufferedImage[2];
        buttonblu = new BufferedImage[2];
        choosePic = new BufferedImage[2];

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

        yelDown[0] = sheet1.crop(0 , 0, width, height);
        yelDown[1] = sheet1.crop(width, 0, width, height);
        yelDown[2] = sheet1.crop(width*2, 0, width, height);

        yelLeft[0] = sheet1.crop(width*2, height, width, height);
        yelLeft[1] = sheet1.crop(0, height, width, height);
        yelLeft[2] = sheet1.crop(width, height, width, height);


        yelRight[0] = sheet1.crop(0, height*2 + 2, width, height);
        yelRight[1] = sheet1.crop(width, height*2 + 2, width, height);
        yelRight[2] = sheet1.crop(width*2, height*2 + 2, width, height);

        yelUp[0] = sheet1.crop(0, height*3 + 3, width,height);
        yelUp[1] = sheet1.crop(width, height*3 + 3, width,height);
        yelUp[2] = sheet1.crop(width*2, height*3 +3, width,height);

        button[0] = buttonStart.crop(0,0, 225, 125);
        button[1] = buttonStart.crop(225, 0, 225,125);

        buttonblu[0] = blue.crop(45, 0, 45, 47);
        buttonblu[1] = blue.crop(0, 0, 45, 47);

        buttonyel[0] = yellow.crop(40, 0, 40, 49);
        buttonyel[1] = yellow.crop(0, 0, 40, 49);

        choosePic[0] = pic.crop(0,0,285,300);
        choosePic[1] = pic.crop(285,0,285,300);

        swordUp = sword1.crop(0,0,172,230);

        swordDown = sword2.crop(0,0,193,257);

        swordLeft = sword3.crop(276,0,271,187);

        swordRight = sword4.crop(0,0,270,185);

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
