package com.mycompany.bigfish.Animals;

import java.awt.*;
import com.mycompany.bigfish.*;
import com.mycompany.bigfish.Graphics.*;

public class Prey extends Animal {
    
    protected int calories;         //inidica il contenuto "calorico" della preda
    protected boolean reproduced;   //controlla se la preda si è già riprodotta
    
    public Prey(int lifeTime, int speed, Coord pos) { super(lifeTime, speed, pos, new Color(0, 255, 0)); this.calories = 10; reproduced = false; }

    @Override
        public void reproduce() { 
        for (int i = 0; i < 2; i++) {
            Prey son = new Prey(this.lifeTime, this.speed, new Coord());
            Main.getPreys().add(son);
            Main.window.add(son.sprite, 0);
        }
    }
    
}
