package com.mycompany.bigfish.Graphics;

import com.mycompany.bigfish.*;
import java.awt.*;
import javax.swing.JLabel;

/**
 * Questa classe gestisce la classe preesistente JLabel ma viene creata per poter omettere tutti i richiami 
 * inseriti all'interno del costruttore 
 * @author Mercadante
 */
public class Label extends JLabel{
    
    /**
     * Costruttore che prende per parametro la variabili:
     * {@code pos}: Variabile di tipo Coord che indica la posizione della Label all'interno della Finestra
     * {@code size}: Variabile di tipo Coord che indica la grandezza della Label espressa in pixel
     * {@code txt:} Variabile di tipo String che indica il Testo da scrivere all'interno della Label
     * @param pos
     * @param size
     * @param txt 
     */
    public Label(Coord pos, Coord size, String txt) {
        super(txt);
        this.setBounds(pos.x - size.x / 2, pos.y - size.y / 2, size.x, size.y);
        this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        this.setBackground(Main.MENU_BACKGROUND_COLOR);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVisible(true);
        Main.window.add(this);
    }
    
}