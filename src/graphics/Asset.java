package graphics;

import java.awt.image.BufferedImage;

//CROP IMAGES FROM SPRITE SHEET
public class Asset {
    private static final int width = 47;
    private static final int height = 47;

    public static BufferedImage back, lake, gate, bridge, fence, rock, rock1, rock2, rock3, garden1, garden2, garden3,
            brick1, bound,
            brick2, brick3, brick4, brick5,
            grass1, grass2, grass3, grass4, grass5, grass6, grass7, grass8, grass9, grass10,
            grass11, grass12, grass13, grass14, grass15, grass16, grass17, grass18, grass19, grass20,
            grass21, grass22, grass23, grass24, grass25,
            tree1, tree2, tree3, tree4, tree5, tree6, tree7, tree8, tree9, tree10, tree11,
            swordUp, swordDown, swordLeft, swordRight, loseState, iceCream;
    public static BufferedImage[] buttonStart, buttonCharacter, buttonLevel, buttonEasy, buttonHard, buttonExit, buttonRestart,
            buttonyel, buttonblu, buttonbla, buttonred, buttonwhi,
            redUp, redDown, redLeft, redRight,
            blackUp, blackDown, blackLeft, blackRight,
            blueUp, blueDown, blueLeft, blueRight,
            yelUp, yelDown, yelLeft, yelRight,
            whiteUp, whiteDown, whiteLeft, whiteRight,
            pigUp, pigDown, pigLeft, pigRight,
            virusUp, virusDown, virusLeft, virusRight,
            bossUp, bossDown, bossLeft, bossRight, boss1Up, boss1Down, boss1Left, boss1Right,
            hpBar, mpBar;

    public static void init() {
        //LOAD ANH
        SpriteSheet logo = new SpriteSheet(LoadImage.loadImage("/textures/bg_gao1.png"));
        SpriteSheet hpmp = new SpriteSheet(LoadImage.loadImage("/textures/hp_mp.png"));
        SpriteSheet lose = new SpriteSheet(LoadImage.loadImage("/BackGround/endGame.png"));
        SpriteSheet gao = new SpriteSheet(LoadImage.loadImage("/textures/gaoRangerAll.png"));
        SpriteSheet item = new SpriteSheet(LoadImage.loadImage("/textures/items.png"));
        SpriteSheet chooseGao = new SpriteSheet(LoadImage.loadImage("/textures/chooseGao.png"));
        SpriteSheet button = new SpriteSheet(LoadImage.loadImage("/textures/buttonAll.png"));
        SpriteSheet vatThe = new SpriteSheet(LoadImage.loadImage("/textures/vatTheAll.png"));
        SpriteSheet gach = new SpriteSheet(LoadImage.loadImage("/BackGround/rockAll.png"));
        SpriteSheet monster = new SpriteSheet(LoadImage.loadImage("/textures/monsterAll.png"));
        SpriteSheet boss1= new SpriteSheet(LoadImage.loadImage("/textures/boss_xoanen.png"));

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

        virusUp = new BufferedImage[3];
        virusDown = new BufferedImage[3];
        virusLeft = new BufferedImage[3];
        virusRight = new BufferedImage[3];

        pigUp = new BufferedImage[3];
        pigDown = new BufferedImage[3];
        pigLeft = new BufferedImage[3];
        pigRight = new BufferedImage[3];

        bossUp = new BufferedImage[3];
        bossDown = new BufferedImage[3];
        bossLeft = new BufferedImage[3];
        bossRight = new BufferedImage[3];

        boss1Up=new BufferedImage[4];
        boss1Right= new BufferedImage[4];
        boss1Down= new BufferedImage[4];
        boss1Left= new BufferedImage[4];

        buttonStart = new BufferedImage[3];
        buttonred = new BufferedImage[2];
        buttonbla = new BufferedImage[2];
        buttonyel = new BufferedImage[2];
        buttonblu = new BufferedImage[2];
        buttonwhi = new BufferedImage[2];
        buttonCharacter = new BufferedImage[2];
        buttonLevel = new BufferedImage[2];
        buttonRestart = new BufferedImage[2];
        buttonExit = new BufferedImage[2];
        buttonHard = new BufferedImage[2];
        buttonEasy = new BufferedImage[2];
        hpBar = new BufferedImage[6];
        mpBar = new BufferedImage[6];

        //CAT GAO
        cut(47, 48, 0, 0, 3, 1, redDown, gao);
        cut(47, 48, 0, 1, 3, 1, redLeft, gao);
        cut(47, 48, 0, 2, 3, 1, redRight, gao);
        cut(47, 48, 0, 3, 3, 1, redUp, gao);

        cut(47, 48, 3, 0, 3, 1, blackDown, gao);
        cut(47, 48, 3, 1, 3, 1, blackLeft, gao);
        cut(47, 48, 3, 2, 3, 1, blackRight, gao);
        cut(47, 48, 3, 3, 3, 1, blackUp, gao);

        cut(47, 48, 6, 0, 3, 1, blueDown, gao);
        cut(47, 48, 6, 1, 3, 1, blueLeft, gao);
        cut(47, 48, 6, 2, 3, 1, blueRight, gao);
        cut(47, 48, 6, 3, 3, 1, blueUp, gao);

        cut(47, 48, 9, 0, 3, 1, yelDown, gao);
        cut(47, 48, 9, 1, 3, 1, yelLeft, gao);
        cut(47, 48, 9, 2, 3, 1, yelRight, gao);
        cut(47, 48, 9, 3, 3, 1, yelUp, gao);

        cut(47, 48, 12, 0, 3, 1, whiteDown, gao);
        cut(47, 48, 12, 1, 3, 1, whiteLeft, gao);
        cut(47, 48, 12, 2, 3, 1, whiteRight, gao);
        cut(47, 48, 12, 3, 3, 1, whiteUp, gao);

        //CAT CHON GAO
        cut(160, 500, 0, 0, 2, 1, buttonred, chooseGao);
        cut(160, 500, 2, 0, 2, 1, buttonblu, chooseGao);
        cut(160, 500, 4, 0, 2, 1, buttonbla, chooseGao);
        cut(160, 500, 6, 0, 2, 1, buttonyel, chooseGao);
        cut(160, 500, 8, 0, 2, 1, buttonwhi, chooseGao);

        //CAT CHON QUAI
        cut(48, 48, 0, 0, 3, 1, virusDown, monster);
        cut(48, 48, 0, 1, 3, 1, virusLeft, monster);
        cut(48, 48, 0, 2, 3, 1, virusRight, monster);
        cut(48, 48, 0, 3, 3, 1, virusUp, monster);

        cut(48, 48, 3, 0, 3, 1, pigDown, monster);
        cut(48, 48, 3, 1, 3, 1, pigLeft, monster);
        cut(48, 48, 3, 2, 3, 1, pigRight, monster);
        cut(48, 48, 3, 3, 3, 1, pigUp, monster);

        cut(58,115,0,0, 4,1,boss1Down,boss1);
        cut(58,115,0,1,4,1,boss1Left,boss1);
        cut(58,115,0,2,4,1,boss1Right,boss1);
        cut(58,115,0,3,4,1,boss1Up,boss1);

        //CAT CHON NUT
        buttonStart[0] = button.crop(0, 0, 250, 91);
        buttonStart[1] = button.crop(255, 0, 250, 91);
        buttonLevel[0] = button.crop(0, 100, 250, 91);
        buttonLevel[1] = button.crop(255, 100, 250, 91);
        buttonCharacter[0] = button.crop(0, 200, 250, 91);
        buttonCharacter[1] = button.crop(255, 200, 250, 91);
        buttonEasy[0] = button.crop(510, 0, 250, 91);
        buttonEasy[1] = button.crop(510, 100, 250, 91);
        buttonHard[0] = button.crop(510, 200, 250, 91);
        buttonHard[1] = button.crop(510, 300, 250, 91);
        buttonRestart[0] = button.crop(0, 300, 250, 91);
        buttonRestart[1] = button.crop(255, 300, 250, 91);
        buttonExit[0] = button.crop(0, 400, 250, 91);
        buttonExit[1] = button.crop(255, 400, 250, 91);

        //CAT KIEM
        swordUp = monster.crop(49, 282, 45, 144);
        swordDown = monster.crop(0, 282, 45, 144);
        swordLeft = monster.crop(0, 237, 144, 45);
        swordRight = monster.crop(0, 192, 144, 45);

        cut(255, 40, 0, 0, 1, 6, hpBar, hpmp);
        cut(255, 40, 1, 0, 1, 6, mpBar, hpmp);


        //CAT GACH
        back = logo.crop(0, 0, 800, 500);

        brick1 = gach.crop(0, 0, 32, 32);
        brick2 = gach.crop(32, 0, 32, 32);
        brick3 = gach.crop(64, 0, 32, 32);
        brick4 = gach.crop(96, 0, 32, 32);
        brick5 = gach.crop(128, 32, 32, 32);

        grass1 = gach.crop(128, 0, 32, 32);
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
        grass17 = vatThe.crop(864, 0, 32, 32);
        grass18 = vatThe.crop(896, 0, 32, 32);
        grass19 = vatThe.crop(928, 0, 32, 32);
        grass20 = vatThe.crop(864, 32, 32, 32);
        grass21 = vatThe.crop(896, 32, 32, 32);
        grass22 = vatThe.crop(928, 32, 32, 32);
        grass23 = vatThe.crop(864, 64, 32, 32);
        grass24 = vatThe.crop(896, 64, 32, 32);
        grass25 = vatThe.crop(928, 64, 32, 32);

        bound = gach.crop(160, 0, 32, 32);

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


        loseState = lose.crop(0, 0, 800, 500);
        iceCream = item.crop(0, 0, 186, 171);
    }

    public static void cut(int width, int height, int colx, int coly, int x, int y, BufferedImage[] bi, SpriteSheet spr) {
        int count = 0;
        for (int i = colx; i < colx + x; i++) {
            for (int j = coly; j < coly + y; j++) {
                bi[count] = spr.crop(i * width, j * height, width, height);
                count++;
            }
        }
    }
}
