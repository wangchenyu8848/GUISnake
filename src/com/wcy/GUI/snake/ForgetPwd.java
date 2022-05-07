package com.wcy.GUI.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ForgetPwd extends JFrame implements ActionListener {
    ArrayList<User> users = new ArrayList<User>();
    UserDomo userDomo = new UserDomo();
//    User user =new User();
    Container container;
    JTextField jt;//用户名
    JLabel jtl;
    JPasswordField jpd;//密码
    JLabel jpdl;
    JButton button;//修改按钮

    public ForgetPwd(){
        JFrame frame =  new JFrame();
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        this.setLayout(new GridLayout(3,1,5,5));//绝对布局
        jtl = new JLabel("账号");
        jt = new JTextField(14);
        jpdl = new JLabel("新密码");
        jpd = new JPasswordField(14);
        button = new JButton("修   改");
        panel.add(jtl);
        panel.add(jt);
        panel1.add(jpdl);
        panel1.add(jpd);
        panel2.add(button);
        this.add(panel);
        this.add(panel1);
        this.add(panel2);
        this.setTitle("忘记密码");
        this.setSize(300,200);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //找到用户名相同吗？是否匹配集里面的对象 相同：就修改密码：现在输入框里面的密码赋值文件里面的密码
        button.addActionListener(this);
    }

    public static void main(String[] args) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            if(jt.getText().isEmpty()||String.valueOf(jpd.getPassword()).isEmpty()){
                JOptionPane.showMessageDialog(this, "账号、密码不能为空", "修改失败", JOptionPane.WARNING_MESSAGE);
            }
            else {
                User u1 = new User(jt.getText(), String.valueOf(jpd.getPassword()));
                try {
                    if (userDomo.hasNameSimilar(u1.getName())) {
                       if ( userDomo.resetDemo(u1.getName(),String.valueOf(jpd.getPassword()))){

                           JOptionPane.showMessageDialog(this, "修改成功，请再次登录", "修改成功", JOptionPane.INFORMATION_MESSAGE);
                           this.dispose();

                       }
                       else {
                           JOptionPane.showMessageDialog(this, "修改失败", "修改失败", JOptionPane.ERROR_MESSAGE);
                       }
                            // JOptionPane.showMessageDialog(this, "账号已存在", "修改成功", JOptionPane.ERROR_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(this, "无账号，请重新填写或者重新注册", "修改失败", JOptionPane.ERROR_MESSAGE);
                        this.dispose();
                        new ForgetPwd();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        }
    }
}