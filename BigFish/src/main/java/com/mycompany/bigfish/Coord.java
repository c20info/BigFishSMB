package com.mycompany.bigfish;

import java.util.Random;
import com.mycompany.bigfish.Graphics.*;

/**
 * Classe che indica un oggetto di tipo Coordinata, dunque con due valori: x, y
 * @author Barucci
 */

public class Coord {
    public int x, y;    // variabili che indicanp il valore di ascissa e di ordinata della coordinata
    
    /**
     * Costruttore che prende {@code x} e {@code y} per parametro
     * @param x
     * @param y 
     */
    public Coord(int x, int y) { this.x = x; this.y = y; }

    /**
     * Costruttore che non prende parametri e crea una Coordinata Random
     */
    public Coord() { this.x = Math.abs(Main.random.nextInt()) % Main.window.getDimensions().x; this.y = Math.abs(Main.random.nextInt()) % Main.window.getDimensions().y; }
    
    /**
     * Questo Metodo calcola la distanza tra il primo punto e il punto {@code point}
     * e la restituisce come valore di tipo double
     * @param point
     * @return 
     */
    public double distance(Coord point){ return Math.sqrt(Math.pow((this.x - point.x), 2) + Math.pow((this.y - point.y), 2)); }
}
