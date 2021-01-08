package com.mycompany.bigfish.Graphics;

import java.awt.*;
import javax.swing.*;
import com.mycompany.bigfish.*;
import com.mycompany.bigfish.Graphics.*;

public class Window extends JFrame {
        
    private JLabel background;
    
    public Window(String title, Coord size, Color backgroundColor) {
        this.setSize(size.x + Main.HORIZONTAL_SHIFT, size.y + Main.VERTICAL_SHIFT);
        this.setResizable(false);
        this.setTitle(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        this.setBackground(backgroundColor);
    }
    
    public void setBackground(String imageName) { 
      Sprite background = new Sprite(new Coord(0, 0), this.getDimensions(), imageName);
      this.add(background);
    }
    
    public void setBackground(Color backgroundColor) { this.getContentPane().setBackground(backgroundColor); }
    
    public Coord getDimensions() { return new Coord(super.getWidth() - Main.HORIZONTAL_SHIFT, super.getHeight() - Main.VERTICAL_SHIFT); }
    
    public void resize(Coord newSize) { this.setBounds(this.getX(), this.getY(), newSize.x, newSize.y); }
    
}