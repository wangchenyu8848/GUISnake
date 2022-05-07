package com.wcy.GUI.snake;
/**
 * 针对游戏界面和蛇的图像处理
 */
import javax.swing.*;
import java.net.URL;

public class Data {
    //游戏界面背景
    public static URL gamebgURL = Data.class.getResource("source/gamebg.png");
    public static ImageIcon gameBG = new ImageIcon(gamebgURL);

    //蛇头
    public static URL upURL = Data.class.getResource("source/up.png");
    public static URL downURL = Data.class.getResource("source/down.png");
    public static URL leftURL = Data.class.getResource("source/left.png");
    public static URL rightURL = Data.class.getResource("source/right.png");

    public static ImageIcon up = new ImageIcon(upURL);
    public static ImageIcon down = new ImageIcon(downURL);
    public static ImageIcon left = new ImageIcon(leftURL);
    public static ImageIcon right = new ImageIcon(rightURL);

    //蛇身
    public static URL bodyURL = Data.class.getResource("source/body.png");
    public static ImageIcon body = new ImageIcon(bodyURL);

    //食物
    public static URL foodURL = Data.class.getResource("source/food.png");
    public static ImageIcon food = new ImageIcon(foodURL);
    //毒药
    public static URL poisonURL = Data.class.getResource("source/DuYao.png");
    public static ImageIcon DuYao = new ImageIcon(poisonURL);



}
