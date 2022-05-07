package com.wcy.GUI.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    //定义蛇属性
    int length;
    int score;
    int[] snakeX = new int[600];
    int[] snakeY = new int[550];
    //蛇的速度
    int speedSlow =100;
    int speedFast =30;
    //初始方向
    String direction;
    //食物坐标
    int foodx;
    int foody;
    //毒药坐标
    int p1;
    int p2;
    Random random = new Random();
    //定时器
    Timer timer = new Timer(100,this);
    //游戏当前状态 默认不开始
    boolean isStart = false;
    //判断游戏失败 默认成功
    boolean isFail = false;

    public GamePanel() {
        init();
        this.setFocusable(true);//获取焦点事件
        this.addKeyListener(this);//获取键盘事件
        timer.start();//定时器开始
    }

    //初始化方法
    public void init(){
    //蛇初始化
        snakeX[0] = 100;snakeY[0] = 100;//头坐标
        snakeX[1] = 75;snakeY[1] = 100;//身体坐标
        length = 2;//蛇开始的节数
        direction = "Right";//初始方向
    // 食物的随机生成
        foodx = 25+25*random.nextInt(34);
        foody = 75+25*random.nextInt(24);
        p1 = 25+25*random.nextInt(34);
        p2 = 75+25*random.nextInt(24);
        score =0;
    //初始化蛇速度
        timer=new Timer(speedSlow,this);
        this.setBackground(Color.black);
    }

    //1、画板操作
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //主要面板
        Data.gameBG.paintIcon(this,g,(900-Data.gameBG.getIconWidth())/2,(720-Data.gameBG.getIconHeight())/2+18);
        //积分
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        if(length>0){
            g.setColor(Color.white);
            g.drawString("长度  "+length,750,35);
            g.drawString("分数  "+score,750,60);
        }
        //把蛇画上去
        switch (direction) {
            case "Right" -> Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
            case "Left" -> Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
            case "Up" -> Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
            case "Down" -> Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        for (int i=1;i<length;i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        //画食物
        Data.food.paintIcon(this,g,foodx,foody);
        //画毒药
        Data.DuYao.paintIcon(this,g,p1,p2);

        //控制游戏状态
        if(!isStart) {
            g.setColor(Color.white);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下Enter开始游戏",300,350);
        }
        if(isFail){
            g.setColor(Color.red);
            g.setFont(new Font("微软雅黑", Font.BOLD,40));
            g.drawString("体验结束",250,350);
            g.drawString("点击Enter键！请注册登录",250,400);
            //游客模式不提供积分排行
        }
    }
    //2、键盘监听事件
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();//获得键盘按键
        if(keyCode==KeyEvent.VK_SPACE)
            timer.setDelay(speedSlow);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();//获得键盘按键
        if (keyCode==KeyEvent.VK_ENTER){
            if(isFail) {
            this.setOpaque(true);
            new Register();
            //游客模式不提供重新开始功能
            }else{
                isStart = !isStart;//取反
            }
            repaint();
        }
            //小蛇移动
            if(keyCode==KeyEvent.VK_UP) {
                direction = "Up";
            }else  if(keyCode==KeyEvent.VK_DOWN) {
                direction = "Down";
            }else  if(keyCode==KeyEvent.VK_LEFT) {
                direction = "Left";
            }else  if(keyCode==KeyEvent.VK_RIGHT) {
                direction = "Right";
            }
           //用空格来控制速度
        if(keyCode==KeyEvent.VK_SPACE){
                timer.setDelay(speedFast);
        }
    }

    //3、事件监听
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStart && !isFail) {
            //吃食物
            if(snakeX[0]==foodx&&snakeY[0]==foody) {
                length++;
                score+=10;
                //再次生成食物
                foodx = 25+25*random.nextInt(34);
                foody = 75+25*random.nextInt(24);
                if(length%2==0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    p1 = 25 + 25 * random.nextInt(34);
                    p2 = 75 + 25 * random.nextInt(24);
                }
            }
            //吃到毒药
            if(snakeX[0]==p1&&snakeY[0]==p2) {
                length-=3;
                if(length<=0){
                    isFail = true;
                }

            }
            //移动
            for(int i=length-1;i>0;i--){//后一节移到前一节位置
                snakeX[i] =snakeX[i-1];//向右移动一节
                snakeY[i] =snakeY[i-1];//向右移动一节
            }
            //走向
            switch (direction) {
                case "Right" -> {
                    snakeX[0] = snakeX[0] + 25;
                    if (snakeX[0] > 850) {
                        snakeX[0] = 25;
                    }
                }
                case "Left" -> {
                    snakeX[0] = snakeX[0] - 25;
                    if (snakeX[0] < 25) {
                        snakeX[0] = 850;
                    }
                }
                case "Up" -> {
                    snakeY[0] = snakeY[0] - 25;
                    if (snakeY[0] < 75) {
                        snakeY[0] = 650;
                    }
                }
                case "Down" -> {
                    snakeY[0] = snakeY[0] + 25;
                    if (snakeY[0] > 650) {
                        snakeY[0] = 75;
                    }
                }
            }
            //失败判定（撞到自己）
            for(int i=1;i<length;i++){
                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                    isFail = true;
                    break;
                }
            }
            repaint();
        }
    }
}
