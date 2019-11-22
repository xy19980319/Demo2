package com.xiaoxiao.frame;


import javax.swing.*;
import java.io.File;
import java.io.IOException;


/**
 * @author Xiaoyu
 * @date 2019/11/20 - 21:09
 */
public class Myframe {
    public static void main(String[] args) throws IOException {
        JFrame myframe = new JFrame("滑稽蛇");
        myframe.setBounds(100,100,700,900);
        myframe.setResizable(false);
        myframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myframe.add(new MyPanel());
        myframe.setVisible(true);

    }
}
