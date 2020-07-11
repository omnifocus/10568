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
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankU.gif"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankD.gif"));
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankL.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankR.gif"));

            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("bulletU.gif"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("bulletD.gif"));
            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("bulletL.gif"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("bulletR.gif"));

            exImages[0] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("e1.gif"));
            exImages[1] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("e2.gif"));
            exImages[2] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("e3.gif"));
            exImages[3]= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("e4.gif"));
            exImages[4]= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("e5.gif"));
            exImages[5] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("e6.gif"));
            exImages[6] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("e7.gif"));
            exImages[7] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("e8.gif"));
            exImages[8] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("e9.gif"));
            exImages[9] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("e10.gif"));
            exImages[10] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("e11.gif"));
            exImages[11] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("e12.gif"));
            exImages[12] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("e13.gif"));
            exImages[13] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("e14.gif"));
            exImages[14] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("e15.gif"));
            exImages[15] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("e16.gif"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
