package com.yovya;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author: omnifocus
 * @Date: 2020/7/10 7:32 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class ResourceMgr {
    public static BufferedImage badTankU, badTankD, badTankL, badTankR;
    public static BufferedImage bad2TankU, bad2TankD, bad2TankL, bad2TankR;
    public static BufferedImage mainTankU, mainTankD, mainTankL, mainTankR;
    public static BufferedImage main2TankU, main2TankD, main2TankL, main2TankR;
    public static BufferedImage bulletU, bulletD, bulletL, bulletR;
    public static BufferedImage wall;
    //should not be put inside Bullet, but as only one asset
    public static BufferedImage[] exImages = new BufferedImage[16];

    static {
        try {
            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankD = ImageUtil.rotateImage(badTankU, 180);
            badTankL = ImageUtil.rotateImage(badTankU, -90);
            badTankR = ImageUtil.rotateImage(badTankU, 90);
            bad2TankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank2.png"));
            bad2TankD = ImageUtil.rotateImage(bad2TankU, 180);
            bad2TankL = ImageUtil.rotateImage(bad2TankU, -90);
            bad2TankR = ImageUtil.rotateImage(bad2TankU, 90);

            mainTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            mainTankD = ImageUtil.rotateImage(mainTankU, 180);
            mainTankL = ImageUtil.rotateImage(mainTankU, -90);
            mainTankR = ImageUtil.rotateImage(mainTankU, 90);
            main2TankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank2.png"));
            main2TankD = ImageUtil.rotateImage(main2TankU, 180);
            main2TankL = ImageUtil.rotateImage(main2TankU, -90);
            main2TankR = ImageUtil.rotateImage(main2TankU, 90);

            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletD = ImageUtil.rotateImage(bulletU, 180);
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);

            exImages[0] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e1.gif"));
            exImages[1] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e2.gif"));
            exImages[2] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e3.gif"));
            exImages[3] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e4.gif"));
            exImages[4] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e5.gif"));
            exImages[5] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e6.gif"));
            exImages[6] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e7.gif"));
            exImages[7] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e8.gif"));
            exImages[8] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e9.gif"));
            exImages[9] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e10.gif"));
            exImages[10] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e11.gif"));
            exImages[11] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e12.gif"));
            exImages[12] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e13.gif"));
            exImages[13] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e14.gif"));
            exImages[14] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e15.gif"));
            exImages[15] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e16.gif"));


            wall = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/square0.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
