package com.wcy.GUI.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Register extends JFrame implements ActionListener {

    ArrayList<User> users = new ArrayList<User>();
    UserDomo userDomo = new UserDomo();
    User u1 = new User();
    boolean flag;
    int id = 1;
    JTextField jt;
    JPasswordField jpd;
    JPasswordField jpd1;

    JButton button;//注册按钮
    JButton FanHui;
    public Register(){
        //设置窗体的title
        this.setTitle("注册页面");
        //获取窗体的容器
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout(5,1,5,5));
        //******************************用户名********************
        JLabel username = new JLabel("用户名");
        jt=new JTextField("",14);
        JPanel jp1=new JPanel();
        jp1.setSize(150,50);
        jp1.add(username);
        jp1.add(jt);
        contentPane.add(jp1);

        //******************************密码框********************
        JLabel userpsd = new JLabel("密   码");
         jpd=new JPasswordField(14);
        jpd.setEchoChar('*');//内容以“*”显示
        JPanel jp2=new JPanel();
        jp2.setSize(150,100);
        jp2.add(userpsd);
        jp2.add(jpd);
        contentPane.add(jp2);
        //******************************密码框********************
        JLabel userpsd1 = new JLabel("验证密码");
         jpd1=new JPasswordField(14);
        jpd1.setEchoChar('*');//内容以“*”显示
        JPanel jp2_1=new JPanel();
        jp2_1.setSize(150,100);
        jp2_1.add(userpsd1);
        jp2_1.add(jpd1);
        contentPane.add(jp2_1);
        //******************************其他资料********************
        JLabel sex =  new JLabel("性别");
        JRadioButton man = new JRadioButton("男");
        JRadioButton male = new JRadioButton("女");
        ButtonGroup group = new ButtonGroup();
        group.add(man);
        group.add(male);
        JPanel jp3 = new JPanel();
        jp3.add(sex);
        jp3.add(man);
        jp3.add(male);
        contentPane.add(jp3);
        //******************************按钮********************
        button = new JButton("注册");
        FanHui = new JButton("返回主页");
        JPanel jp4 =  new JPanel();
        jp4.setSize(150,100);
        jp4.add(button);
        jp4.add(FanHui);
        contentPane.add(jp4);

        this.setBounds(200,200,280,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);//设置窗体居中显示

        FanHui.addActionListener(this);
        button.addActionListener(this);
        man.addActionListener(this);
        male.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==FanHui){
            this.dispose();
            new MainMenu();
        }
        if (e.getSource()==button){
            if(jt.getText().isEmpty()||String.valueOf(jpd.getPassword()).isEmpty()||String.valueOf(jpd1.getPassword()).isEmpty()||!(String.valueOf(jpd.getPassword()).equals(String.valueOf(jpd1.getPassword())))){
                JOptionPane.showMessageDialog(this, "账号、密码不能为空或者密码不一样", "注册失败", JOptionPane.WARNING_MESSAGE);
            }
            else {
                u1= new User(jt.getText(), String.valueOf(jpd.getPassword()));
                try {
                    if (userDomo.isExist(u1.getName(), users)&&userDomo.hasNameSimilar(u1.getName())) {
                        JOptionPane.showMessageDialog(this, "账号已存在", "注册失败", JOptionPane.ERROR_MESSAGE);
                    } else {
                        users.add(u1);
                        try {;
                            if (!(userDomo.hasNameSimilar(u1.getName()))){
                                userDomo.msg(users);
//                            添加完成，立马调到登录页面（重复数据的处理）
                                this.dispose();
                                JOptionPane.showMessageDialog(this, "注册成功", "注册成功", JOptionPane.INFORMATION_MESSAGE);
                                new MainMenu();
                            }
                           else {
                                JOptionPane.showMessageDialog(this, "账号已存在", "注册失败", JOptionPane.ERROR_MESSAGE);
                                this.dispose();
                                new Register();
                           }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
//
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }

        }
    }


    public static void main(String[] args) {
    }
}

