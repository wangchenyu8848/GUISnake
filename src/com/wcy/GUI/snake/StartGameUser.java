package com.wcy.GUI.snake;

import javax.swing.*;

public class StartGameUser {
    public StartGameUser(){
        JFrame frame = new JFrame("天梯赛模式");
        frame.setBounds(50,50,900,720);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);//设置窗体居中显示
        frame.add(new GamePanelUser());
    }
}
