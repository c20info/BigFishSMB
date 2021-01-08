package com.mycompany.bigfish.Graphics;

import com.mycompany.bigfish.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Button extends JPanel {

    public static final Color BUTTON_COLOR = new Color(220,220,220);                //gainsboro color    
    private JLabel label;
    private Color color;
    private Button button;
    private boolean activated;
    
    public Button(Coord pos, Coord size, String msg, Color color) {
        this.label = new JLabel();
        this.button = this;
        this.activated = false;
        this.setBounds(pos.x - size.x / 2, pos.y - size.y / 2, size.x, size.y);
        this.setLayout(null);
        labelManager(msg);
        this.color = color;
        this.add(label);
        this.setVisible(true);
        Main.window.add(button);
        this.addMouseListener(new MouseAdapter(){   
            @Override
            public void mousePressed (MouseEvent e) {
                button.setBackground(new Color(color.getRed() - 30, color.getGreen() - 30, color.getBlue() - 30));
                button.activated = true;
            }
            
            @Override
            public void mouseReleased (MouseEvent e) {
                button.setBackground(new Color(color.getRed(), color.getGreen(), color.getBlue()));
            }
        });
    }
               
    public boolean isActive() { return button.activated; }
    
    private void labelManager(String msg) {
        label = new JLabel(msg, SwingConstants.CENTER);
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        label.setForeground(Color.BLACK);
        label.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.add(label);
    }
    
    @Override
    public void setBackground(Color backgroundColor)
    {
        this.color = backgroundColor;
        this.repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 10, 10);
    }
    
}