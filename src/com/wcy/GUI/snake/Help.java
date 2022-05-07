package com.wcy.GUI.snake;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Help extends JFrame implements ActionListener {
    JButton FanHui;
    public Help(){
        BackImage back = new BackImage();
        back.setBounds(0, 0, 300, 200);

        FanHui = new JButton("返回主页");
        FanHui.setBackground(Color.LIGHT_GRAY);
        FanHui.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBounds(225,130,50,30);
        panel.add(FanHui);

        this.add(panel);

        this.add(back);
        this.setTitle("帮助说明");
        this.setSize(300,200);
        this.setLocation(500,300);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);//设置窗体居中显示
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        new Help();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==FanHui){
            this.dispose();
            new MainMenu();
        }
    }
}
class BackImage extends JPanel{
    Image background;
    public BackImage(){
        try {
            background = ImageIO.read(new File("Bgfile/help.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, null);
        //画内容
        g.setColor(Color.gray);
//        g.setFont(new Font("微软雅黑",Font.BOLD,14));
        g.drawString("1、游客模式：不保存记录，体验一把",5,15);
        g.drawString("2、如果有账号，请先登录",5,35);
        g.drawString("3、如果没账号，建议先注册",5,55);
        g.drawString("————————————————————————————",5,75);
        g.drawString("轻按下空格键，可实现加速哦",5,95);
    }

}