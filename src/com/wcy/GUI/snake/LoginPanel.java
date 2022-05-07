package com.wcy.GUI.snake;

import com.wcy.GUI.snake.source.UserCharts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginPanel extends JFrame implements ActionListener {
    static String name = "";
    static int uscore = 0;
  UserDomo userDomo =  new UserDomo();
    static JTextField jt;
    JPasswordField jpd;
    JPasswordField jpd1;

    JPanel jPanel1 ;
    JPanel jPanel2 ;
    JPanel jPanel3 ;
    JPanel jPanel4 ;
    JButton DengLu;
    JButton WangJi;
    JButton FanHui;
    public LoginPanel(){

        JFrame jFrame = new JFrame("longin");
        this.setTitle("登录界面");
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(5,1));
        BackGround back = new BackGround("Bgfile/login_header.png");
        this.add(back);

         jPanel1 = new JPanel();
         jPanel2 = new JPanel();
         jPanel3 = new JPanel();
         jPanel4 = new JPanel();

        jPanel1.add(new JLabel("用户名 "));
        jt = new JTextField(14);
        jPanel1.add(jt);

        jPanel2.add(new JLabel("密    码  "));
        jpd = new JPasswordField(14);
        jPanel2.add(jpd);


        jPanel3.add(new JLabel("确认密码"));
        jpd1 = new JPasswordField(14);
        jPanel3.add(jpd1);


        DengLu =new JButton("登录");
        WangJi = new JButton("忘记密码");
        FanHui = new JButton("返回主页");
        jPanel4.add(DengLu);
        jPanel4.add(WangJi);
        jPanel4.add(FanHui);

        container.add(jPanel1);
        container.add(jPanel2);
        container.add(jPanel3);
        container.add(jPanel4);

        DengLu.addActionListener(this);
        WangJi.addActionListener(this);
        FanHui.addActionListener(this);

        this.setBounds(650,170,747,382);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);//设置窗体居中显示

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==FanHui){
            this.dispose();
//            new MainMenu();
        }
        if(e.getSource()==WangJi) {
            new ForgetPwd();
        }
        if (e.getSource()==DengLu){
            if(jt.getText().isEmpty()||String.valueOf(jpd.getPassword()).isEmpty()||String.valueOf(jpd1.getPassword()).isEmpty()||!(String.valueOf(jpd.getPassword()).equals(String.valueOf(jpd1.getPassword())))){
                JOptionPane.showMessageDialog(this, "账号、密码不能为空或者密码不一样", "登录失败", JOptionPane.WARNING_MESSAGE);
            }
            else {
                try {
                    if(userDomo.msgRead(jt.getText(),String.valueOf(jpd.getPassword()))){
                        //这里可以进去用户模式 （可设置排行榜）
                        new StartGameUser();
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "未查询到账户，请重新注册", "登录失败", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        new LoginPanel();
    }
    //传数据到排行榜
    public static void pass(int score) throws IOException {
        uscore = score;
        name =  jt.getText();
        System.out.println(name);
        System.out.println(uscore);
        UserDomo.chartmsg(new UserCharts(name,uscore));
    }

}

