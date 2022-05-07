package com.wcy.GUI.snake;

import javax.swing.*;
import java.awt.*;

public class StartGame {
    public StartGame(){
        JFrame frame = new JFrame("小小贪吃蛇");
        frame.setBounds(50,50,900,720);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);//设置窗体居中显示
        frame.add(new GamePanel());//普通游客模式
    }
}
