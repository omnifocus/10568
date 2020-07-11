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
    public static BufferedImage tankU, tankD, tankL, tankR, bulletU, bulletD, bulletL, bulletR;
    //should not be put inside Bullet, but as only one asset
    public static BufferedImage[] exImages = new BufferedImage[16];

    static {
        try {
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            tankD = ImageUtil.rotateImage(tankU,180);
            tankL = ImageUtil.rotateImage(tankU,-90);
            tankR = ImageUtil.rotateImage(tankU,90);

            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletD = ImageUtil.rotateImage(bulletU,180);
            bulletL = ImageUtil.rotateImage(bulletU,-90);
            bulletR = ImageUtil.rotateImage(bulletU,90);

            exImages[0] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e1.gif"));
            exImages[1] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e2.gif"));
            exImages[2] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e3.gif"));
            exImages[3]= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e4.gif"));
            exImages[4]= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e5.gif"));
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


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
