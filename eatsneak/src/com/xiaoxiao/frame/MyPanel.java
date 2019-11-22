package com.xiaoxiao.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Xiaoyu
 * @date 2019/11/20 - 21:37
 */
public class MyPanel extends JPanel implements KeyListener, ActionListener {
    //载入图片
    ImageIcon xuenai = new ImageIcon("D:/Ideaworkspace/project01/eatsneak/src/xuenai.jpg");
    ImageIcon up = new ImageIcon("D:/Ideaworkspace/project01/eatsneak/src/uphj.jpg");
    ImageIcon down = new ImageIcon("D:/Ideaworkspace/project01/eatsneak/src/downhj.jpg");
    ImageIcon right = new ImageIcon("D:/Ideaworkspace/project01/eatsneak/src/righthj.jpg");
    ImageIcon left = new ImageIcon("D:/Ideaworkspace/project01/eatsneak/src/lefthj.jpg");
    ImageIcon body = new ImageIcon("D:/Ideaworkspace/project01/eatsneak/src/bodyhj.jpg");
    ImageIcon food = new ImageIcon("D:/Ideaworkspace/project01/eatsneak/src/food.jpg");
    //初始化数组
    int len = 3;
    int score = 0;
    int[] sneakx = new int[650];
    int[] sneaky = new int[650];
    boolean isStart = false;//判断是不是开始了
    boolean isDeath = false;//判断死亡否
    ImageIcon head = right;//将头的默认方向设置为右边
    Timer timer = new Timer(100, this);
    Food eatFood = new Food();
    Graphics g = getGraphics();


    //游戏初始化
    public MyPanel() {
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();


    }

    //将素材加入画板
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.green);
        xuenai.paintIcon(this, g, 25, 10);
        g.setColor(Color.white);
        g.fillRect(25, 200, 650, 650);
        head.paintIcon(this, g, sneakx[0], sneaky[0]);
        for (int i = 1; i < len; i++) {
            body.paintIcon(this, g, sneakx[i], sneaky[i]);
        }
        food.paintIcon(this, g, eatFood.x, eatFood.y);
        startAndStop(g);
        border();
        checkBody();
        checkFood(g);
        if (isDeath == true) {
            timer.stop();
            g.setColor(Color.black);
            g.setFont(new Font("宋体", Font.BOLD, 40));
            g.drawString("大侠请按\"R\"重新来过", 150, 500);
            g.drawString("你的得分是" + score + "分", 150, 550);
        }


    }

    public void checkFood(Graphics g) {
        if (isDeath == false) {
            if (eatFood.x == sneakx[0] && eatFood.y == sneaky[0]) {
                len++;
                eatFood.init();
                food.paintIcon(this, g, eatFood.x, eatFood.y);
                score += 10;
            }
        }
    }

    public void checkBody() {
        for (int i = 1; i < len; i++) {
            if (sneakx[0] == sneakx[i] && sneaky[0] == sneaky[i]) {
                isDeath = true;
            }
        }
    }

    public void startAndStop(Graphics g) {
        if (isStart == false) {
            g.setColor(Color.black);
            g.setFont(new Font("宋体", Font.BOLD, 40));
            g.drawString("请按下空格键开始", 200, 500);

        }

    }

    public void init() {
        len = 3;
        head = right;
        sneakx[0] = 200;
        sneaky[0] = 300;
        sneakx[1] = 175;
        sneaky[1] = 300;
        sneakx[2] = 150;
        sneaky[2] = 300;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_SPACE) {
            if (isDeath == false) {
                isStart = !isStart;
                repaint();
            }
        } else if (keyCode == KeyEvent.VK_UP) {
            if(head != up && head != down) {
                head = turn("up");
            }
        } else if (keyCode == KeyEvent.VK_DOWN) {
            if (head != down && head != up) {
                head = turn("down");
            }
        } else if (keyCode == KeyEvent.VK_LEFT) {
            if (head != left && head != right) {
                head = turn("left");
            }
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            if (head != right && head != left) {
                head = turn("right");
            }
        } else if (keyCode == KeyEvent.VK_R) {
            if (isDeath == true) {
                isDeath = !isDeath;
                init();
                repaint();
                timer.start();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        stop();
        timer.start();
        repaint();
    }

    public void stop() {
        if (isStart == true) {
            move();
        }
    }

    private void move() {
        if (isDeath == false) {
            for (int i = len - 1; i > 0; i--) {
                sneakx[i] = sneakx[i - 1];
                sneaky[i] = sneaky[i - 1];
            }
            headMove();

        }
    }

    public void border() {
        if (sneakx[0] > 650) {
            //sneakx[0] = 25;
            isDeath = true;
        } else if (sneakx[0] < 25) {
            //sneakx[0] = 650;
            isDeath = true;
        } else if (sneaky[0] < 200) {
            //sneaky[0] = 825;
            isDeath = true;
        } else if (sneaky[0] > 825) {
            //sneaky[0] = 200;
            isDeath = true;
        }
    }

    public void headMove() {
        if (isStart == true) {
            if (head == right) {
                sneakx[0] += 25;
            } else if (head == left) {
                sneakx[0] -= 25;
            } else if (head == up) {
                sneaky[0] -= 25;
            } else if (head == down) {
                sneaky[0] += 25;
            }
        }

    }

    public ImageIcon turn(String head) {
        if (isStart == true) {
            switch (head) {
                case "up":
                    sneaky[0] -= 25;
                    return up;
                case "down":
                    sneaky[0] += 25;
                    return down;
                case "left":
                    sneakx[0] -= 25;
                    return left;
                case "right":
                    sneakx[0] += 25;
                    return right;
                default:
                    return right;
            }
        }
        return right;

    }
}
