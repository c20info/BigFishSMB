package com.mycompany.bigfish.Graphics;

import com.mycompany.bigfish.*;
import java.awt.*;
import javax.swing.JTextField;

/**
 * Questa classe gestisce un "metodo" di input da tastiera 
 * @author Mercadante
 */
public class TextBox extends JTextField {
    private int defaultValue;   //valore di tipo numerico restituito nel caso in cui la stringa inserita nella TextBox non sia valida
    
    /**
     * Costruttore che prende per parametri:
     * {@code pos}: la posizione della TextBox nella finestra
     * {@code size}: la grandezza della TextBox (espresso in pixel)
     * {@code defaultValue}: il valore che verrà restituito dalla funzione {@code getValue}
     * @param pos
     * @param size
     * @param defaultValue 
     */
    public TextBox(Coord pos, Coord size, int defaultValue) {
        this.defaultValue = defaultValue;
        this.setText(Integer.toString(defaultValue));
        this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        this.setBackground(Color.WHITE);
        this.setBounds(pos.x - size.x / 2, pos.y - size.y / 2, size.x, size.y);
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setVisible(true);
        Main.window.add(this);
    }
    
    /**
     * Questo metodo restituisce il valore numerico corrispondente alla stringa inserita all'interno della TextBox
     * nel caso in cui la stringa non sia valida restituisce la variabile {@code defaultValue}
     * @return 
     */
    public int getValue() { try { return Integer.parseInt(this.getText()); } catch(Exception e) { return defaultValue; } }
}