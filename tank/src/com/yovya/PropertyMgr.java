package com.yovya;

import java.io.IOException;
import java.util.Properties;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 2:41 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class PropertyMgr {

    private PropertyMgr() {
    }

    private static class PropertyMgrInner {
        private static final Properties properties = new Properties();

        static {
            try {
                properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static Properties getInstance() {
        return PropertyMgrInner.properties;
    }


}
