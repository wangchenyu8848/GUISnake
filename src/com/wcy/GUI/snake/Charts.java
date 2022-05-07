package com.wcy.GUI.snake;

import com.wcy.GUI.snake.source.UserCharts;
import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.io.IOException;
import java.util.*;

/*
* 排行榜功能
* 排行榜基本面板
* 1、将score读入文件
* 2、读取文件后，在Charts类里面用列表排出（画出也可以）
*
* */
public class Charts extends JFrame{
    int i=1;
    ArrayList<UserCharts> list;
    public Charts() throws IOException {
        List l1 = new List(15 );
        l1.setFont(new Font("微软雅黑",Font.BOLD,16));
        list = UserDomo.chartsMsgRead();

        Collections.sort(list, new Comparator<UserCharts>() {
            @Override
            public int compare(UserCharts o1, UserCharts o2) {
                int num1 = o2.getScore()- o1.getScore();
                int num2 = num1 == 0? o1.getName().compareTo(o2.getName()):num1;
                return num2;
            }
        });
        for (UserCharts u : list) {

            l1.add(i+++"                    "+u.getName()+"                "+u.getScore());
        }
        l1.setBounds(0,100,300,400);
        this.add(l1);
        this.setLayout(null);
        this.setTitle("排行榜");
        this.setSize(300,400);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);//设置窗体居中显示
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    public static void main(String[] args) throws IOException {
        new Charts();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("微软雅黑",Font.BOLD,18));
        g.drawString("排行榜",120,70);

        g.setColor(Color.black);
        g.setFont(new Font("微软雅黑",Font.BOLD,16));
        g.drawString("排名",10,120);
        g.drawString("用户",100,120);
        g.drawString("分数",220,120);
    }


}
