package com.yovya.firestrategy;

import com.yovya.Audio;
import com.yovya.Tank;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 5:35 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public interface FireStrategy {

    void fire(Tank tank);

    // inside Father, implements a method to play music
    default void playMusic() {
        new Thread(() -> {
            new Audio("audio/tank_fire.wav").play();
        }).start();
    }


}
