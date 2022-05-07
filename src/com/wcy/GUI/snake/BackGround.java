package com.wcy.GUI.snake;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class BackGround extends JPanel {
    Image background;

    public BackGround(String path) {
        try {
            background = ImageIO.read(new File(path));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, null);
    }
}