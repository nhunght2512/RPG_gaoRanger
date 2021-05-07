package graphics;

import java.awt.image.BufferedImage;
//CROP IMAGES FROM SPRITE SHEET
public class Asset {
    private static final int width = 47;
    private static final int height = 47;

    public static BufferedImage back, lake, gate, bridge, fence, rock, rock1, rock2, rock3, garden1, garden2, garden3,
                                brick1, bound,
                                brick2, brick3, brick4, brick5,
                                grass1, grass2, grass3, grass4, grass5, grass6, grass7, grass8, grass9, grass10, grass11, grass12, grass13, grass14, grass15, grass16,
                                tree, tree1, tree2, tree3, tree4, tree5, tree6, tree7, tree8, tree9, tree10, tree11,
                                swordUp, swordDown, swordLeft, swordRight, loseState, iceCream;
    public static BufferedImage[] buttonStart,
                                  buttonyel, buttonblu, buttonbla, buttonred, buttonwhi,
                                  redUp, redDown, redLeft, redRight,
                                  blackUp, blackDown, blackLeft, blackRight,
                                  blueUp, blueDown, blueLeft, blueRight,
                                  yelUp, yelDown, yelLeft, yelRight,
                                  whiteUp, whiteDown, whiteLeft,whiteRight,
                                  buttonCharacter, hpBar, mpBar;

    public static void init(){
        //LOAD ANH
        SpriteSheet logo = new SpriteSheet(LoadImage.loadImage("/textures/logo-gaoranger.png"));
        SpriteSheet sword1 = new SpriteSheet(LoadImage.loadImage("/textures/sword_up.png"));
        SpriteSheet sword2 = new SpriteSheet(LoadImage.loadImage("/textures/sword_down.png"));
        SpriteSheet sword3 = new SpriteSheet(LoadImage.loadImage("/textures/sword_left.png"));
        SpriteSheet sword4 = new SpriteSheet(LoadImage.loadImage("/textures/sword_right.png"));
        SpriteSheet hpmp = new SpriteSheet(LoadImage.loadImage("/textures/hp_mp.png"));
        SpriteSheet lose = new SpriteSheet(LoadImage.loadImage("/BackGround/lose.png"));
        SpriteSheet gao = new SpriteSheet(LoadImage.loadImage("/textures/gaoRangerAll.png"));
        SpriteSheet item = new SpriteSheet(LoadImage.loadImage("/textures/items.png"));
        SpriteSheet chooseGao = new SpriteSheet(LoadImage.loadImage("/textures/chooseGao.png"));
        SpriteSheet button = new SpriteSheet(LoadImage.loadImage("/textures/button_game3.png"));
        SpriteSheet vatThe = new SpriteSheet(LoadImage.loadImage("/textures/vatTheAll.png"));
        SpriteSheet gach = new SpriteSheet(LoadImage.loadImage("/BackGround/rockAll.png"));

        redDown = new BufferedImage[3];
        redUp = new BufferedImage[3];
        redLeft = new BufferedImage[3];
        redRight = new BufferedImage[3];

        blackUp = new BufferedImage[3];
        blackDown = new BufferedImage[3];
        blackLeft = new BufferedImage[3];
        blackRight = new BufferedImage[3];

        blueUp = new BufferedImage[3];
        blueDown = new BufferedImage[3];
        blueLeft = new BufferedImage[3];
        blueRight = new BufferedImage[3];

        yelUp = new BufferedImage[3];
        yelDown = new BufferedImage[3];
        yelLeft = new BufferedImage[3];
        yelRight = new BufferedImage[3];

        whiteUp = new BufferedImage[3];
        whiteDown = new BufferedImage[3];
        whiteLeft = new BufferedImage[3];
        whiteRight = new BufferedImage[3];

        Asset.buttonStart = new BufferedImage[3];
        buttonred = new BufferedImage[2];
        buttonbla = new BufferedImage[2];
        buttonyel = new BufferedImage[2];
        buttonblu = new BufferedImage[2];
        buttonwhi = new BufferedImage[2];
        buttonCharacter = new BufferedImage[2];
        hpBar = new BufferedImage[6];
        mpBar = new BufferedImage[6];

        //CAT GAO
        cut(47, 47, 0, 0, 3, 1, redDown, gao);
        cut(47, 47, 0, 1, 3, 1, redLeft, gao);
        cut(47, 47, 0, 2, 3, 1, redRight, gao);
        cut(47, 47, 0, 3, 3, 1, redUp, gao);

        cut(47, 47, 3, 0, 3, 1, blackDown, gao);
        cut(47, 47, 3, 1, 3, 1, blackLeft, gao);
        cut(47, 47, 3, 2, 3, 1, blackRight, gao);
        cut(47, 47, 3, 3, 3, 1, blackUp, gao);

        cut(47, 47, 6, 0, 3, 1, blueDown, gao);
        cut(47, 47, 6, 1, 3, 1, blueLeft, gao);
        cut(47, 47, 6, 2, 3, 1, blueRight, gao);
        cut(47, 47, 6, 3, 3, 1, blueUp, gao);

        cut(47, 47, 9, 0, 3, 1, yelDown, gao);
        cut(47, 47, 9, 1, 3, 1, yelLeft, gao);
        cut(47, 47, 9, 2, 3, 1, yelRight, gao);
        cut(47, 47, 9, 3, 3, 1, yelUp, gao);

        cut(47, 47, 12, 0, 3, 1, whiteDown, gao);
        cut(47, 47, 12, 1, 3, 1, whiteLeft, gao);
        cut(47, 47, 12, 2, 3, 1, whiteRight, gao);
        cut(47, 47, 12, 3, 3, 1, whiteUp, gao);

        //CAT CHON NUT
        buttonStart[0] = button.crop(0,0, 513, 187);
        buttonStart[1] = button.crop(577, 0, 513,187);

        //CAT CHON GAO
        cut(160, 500, 0, 0, 2, 1, buttonred, chooseGao);
        cut(160, 500, 2, 0, 2, 1, buttonblu, chooseGao);
        cut(160, 500, 4, 0, 2, 1, buttonbla, chooseGao);
        cut(160, 500, 6, 0, 2, 1, buttonyel, chooseGao);
        cut(160, 500, 8, 0, 2, 1, buttonwhi, chooseGao);

        buttonCharacter[0] = button.crop(0,445,513,187);
        buttonCharacter[1] = button.crop(577,445,513,187);



        swordUp = sword1.crop(0,0,172,230);

        swordDown = sword2.crop(0,0,193,257);

        swordLeft = sword3.crop(276,0,271,187);

        swordRight = sword4.crop(0,0,270,185);

        cut(255,40,0,0,1,6,hpBar,hpmp);
        cut(255,40,1,0,1,6,mpBar,hpmp);


        //CAT GACH
        back = logo.crop(0,0,800,360);

        brick1 = gach.crop(0, 0, 32, 32);
        brick2 = gach.crop(32, 0, 32,32);
        brick3 = gach.crop(64, 0, 32, 32);
        brick4 = gach.crop(96, 0, 32, 32);
        brick5 = gach.crop(128, 32, 32, 32);

        grass1 = gach.crop(128, 0, 32,32);
        grass2 = gach.crop(192, 0, 32, 32);
        grass3 = gach.crop(224, 0, 32, 32);
        grass4 = gach.crop(256, 0, 32, 32);
        grass5 = gach.crop(288, 0, 32, 32);
        grass6 = gach.crop(0, 32, 32, 32);
        grass7 = gach.crop(32, 32, 32, 32);
        grass8 = gach.crop(64, 32, 32, 32);
        grass9 = gach.crop(96, 32, 32, 32);
        grass10 = gach.crop(160, 32, 32, 32);
        grass11 = gach.crop(192, 32, 32, 32);
        grass12 = gach.crop(224, 32, 32, 32);
        grass13 = gach.crop(256, 32, 32, 32);
        grass14 = gach.crop(288, 32, 32, 32);
        grass15 = gach.crop(0, 64, 32, 32);
        grass16 = gach.crop(32, 64, 32, 32);

        bound = gach.crop(160,0,32,32);

        //CAT VAT THE
        tree1 = vatThe.crop(384, 128, 96, 128);
        tree2 = vatThe.crop(480, 128, 64, 96);
        tree3 = vatThe.crop(544, 128, 64, 160);
        tree4 = vatThe.crop(608, 128, 96, 160);
        tree5 = vatThe.crop(576, 0, 32, 32);
        tree6 = vatThe.crop(608, 0, 32, 32);
        tree7 = vatThe.crop(640, 0, 32, 32);
        tree8 = vatThe.crop(576, 32, 32, 64);
        tree9 = vatThe.crop(608, 32, 32, 64);
        tree10 = vatThe.crop(640, 32, 32, 32);
        tree11 = vatThe.crop(640, 64, 32, 64);

        lake = vatThe.crop(0, 0, 384, 352);
        gate = vatThe.crop(704, 194, 128, 128);
        bridge = vatThe.crop(864, 96, 128, 64);
        fence = vatThe.crop(960, 0, 96, 32);
        rock = vatThe.crop(864, 160, 32, 96);
        rock1 = vatThe.crop(896, 160, 64, 96);
        rock2 = vatThe.crop(992, 32, 32, 32);
        rock3 = vatThe.crop(960, 32, 32, 64);
        garden1 = vatThe.crop(384, 0, 192, 128);
        garden2 = vatThe.crop(704, 0, 160, 192);
        garden3 = vatThe.crop(864, 0, 96, 96);


        loseState = lose.crop(0,0,800,400);
        iceCream = item.crop(0,0,186,171);
    }

    public static void cut(int width, int height, int colx, int coly, int x, int y, BufferedImage[] bi, SpriteSheet spr){
        int count = 0;
        for(int i = colx; i < colx + x; i++){
            for(int j = coly; j < coly + y; j++){
                bi[count] = spr.crop(i*width, j*height, width, height);
                count++;
            }
        }
    }
}
