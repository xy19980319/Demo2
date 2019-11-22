package com.xiaoxiao.frame;

import javax.swing.*;
import java.util.Random;

/**
 * @author Xiaoyu
 * @date 2019/11/21 - 17:11
 */
public class Food {
    ImageIcon body = new ImageIcon("D:/Ideaworkspace/project01/eatsneak/src/bodyhj.jpg");
    int x;
    int y;

    public Food() {
        init();
    }

    public void init() {
        this.x = 25 + 25 * new Random().nextInt(26);
        this.y = 200 + 25 * new Random().nextInt(26);
    }

}
