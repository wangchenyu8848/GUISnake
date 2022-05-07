package com.wcy.GUI.snake;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

//游客模式 登录 注册 帮助
public class MainMenu extends JFrame implements ActionListener {
    JPanel jPanel1;
    JPanel jPanel2;
    JPanel jPanel3;
    JPanel jPanel4;
    JButton YouKeMoshi;
    JButton login;
    JButton register;
    JButton help;
    public MainMenu(){
        JFrame jFrame = new JFrame();

        BackGround back = new BackGround("Bgfile/index.jpg");
        back.setBounds(0, 0, 416, 233);

        Container container = getContentPane();
        container.setLayout(null);

        jPanel1 = new JPanel();
        jPanel1.setSize(100,40);
        jPanel1.setLocation(0,10);

        jPanel2 = new JPanel();
        jPanel2.setSize(100,40);
        jPanel2.setLocation(0,50);

        jPanel3 = new JPanel();
        jPanel3.setSize(100,40);
        jPanel3.setLocation(0,90);

        jPanel4 = new JPanel();
        jPanel4.setSize(100,40);
        jPanel4.setLocation(0,130);

        YouKeMoshi =  new JButton("游客");
        YouKeMoshi.setBackground(Color.LIGHT_GRAY);
        login =  new JButton("登录");
        login.setBackground(Color.LIGHT_GRAY);
        register =  new JButton("注册");
        register.setBackground(Color.LIGHT_GRAY);
        help =  new JButton("帮助");
        help.setBackground(Color.LIGHT_GRAY);

        jPanel1.setOpaque(false);
        jPanel2.setOpaque(false);
        jPanel3.setOpaque(false);
        jPanel4.setOpaque(false);

        jPanel1.add(YouKeMoshi);
        jPanel2.add(login);
        jPanel3.add(register);
        jPanel4.add(help);

        container.add(jPanel1);
        container.add(jPanel2);
        container.add(jPanel3);
        container.add(jPanel4);

        this.add(back);//这个一定要放这个位置
        this.setBounds(500,70,416,233);
        this.setTitle("贪吃蛇蛇");
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);//设置窗体居中显示


        //监听器
        YouKeMoshi.addActionListener(this);
        login.addActionListener(this);
        register.addActionListener(this);
        help.addActionListener(this);

    }
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==YouKeMoshi){
//            this.dispose();
            new StartGame();
        }
        if(e.getSource()==login){
//            this.dispose();
            new LoginPanel();
        }
        if(e.getSource()==register){
            this.dispose();
            new Register();
        }
        if(e.getSource()==help){
//            this.dispose();
            new Help();
        }

    }

}





