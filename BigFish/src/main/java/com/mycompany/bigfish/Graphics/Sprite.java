package com.mycompany.bigfish.Graphics;

import com.mycompany.bigfish.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Sprite extends JPanel {
    private BufferedImage image;
    private Coord size;
    
    public Sprite(Coord pos, Coord size, String path) {
        setBounds(pos.x, pos.y, size.x, size.y);
        this.setVisible(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.size = size;
        try { image = ImageIO.read(new File(path)); } catch(IOException e) { image = null; System.out.println("Image not Found"); }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image.getScaledInstance(size.x, size.y, 0), 0, 0, this);
    }
}