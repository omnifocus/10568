package com.yovya;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author: omnifocus
 * @Date: 2020/7/10 7:32 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class ResourceMgr {
    public static BufferedImage imageU, imageD, imageL, imageR;

    static {
        try {
            imageU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankU.gif"));
            imageD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankD.gif"));
            imageL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankL.gif"));
            imageR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("tankR.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
