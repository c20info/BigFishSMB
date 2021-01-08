package com.mycompany.bigfish.Animals;

import com.mycompany.bigfish.*;
import java.awt.*;

public class Predator extends Animal {
    protected int hunger;           //indica quanto è sazio l'animale (0 - 100)
    protected int eyesight;         //indica quanto riesce a vedeer lontano (px)
    
    public Predator(int lifeTime, int speed, int eyesight, Coord pos) {
        super(lifeTime, speed, pos, new Color(255, 0, 0));
        this.hunger = 100;
        this.eyesight = eyesight;
    }
    
    private Prey searchPrey() {
        int nearestPrey = -1;
        double distMin = eyesight;
        for (int i = 0; i < Main.getPreys().size(); i++) {    
            if (Main.getPreys().get(i) != null && this.pos.distance(Main.getPreys().get(i).pos) <= distMin) { 
                distMin = this.pos.distance(Main.getPreys().get(i).pos);
                nearestPrey = i;
            }
        }
        return Main.getPreys().get(nearestPrey);
    }
    
    @Override 
    public void run() {
        while (isItAlive()) { this.move(); hunger--; Main.wait(Main.CYCLES_MILLIS); }
        this.reproduce();
    }
    
    @Override
    public void move() {
        Prey prey;
        try { prey = searchPrey(); } catch(IndexOutOfBoundsException e) { super.move(); return; }
        if (this.pos.x > prey.pos.x) this.pos.x -= speed;
        else if (this.pos.x < prey.pos.x) this.pos.x += speed;
        if (this.pos.y > prey.pos.y) this.pos.y -= speed;
        else if (this.pos.y < prey.pos.y) this.pos.y += speed;
        this.sprite.setBounds(this.getAwtPoint().x, this.getAwtPoint().y, this.size, this.size);
        if (this.pos.distance(prey.pos) <= this.size) prey.timer.triggered = true;
        this.hunger += 10;
    }
    
    @Override
    public void reproduce() {
        if (this.hunger <= 20) return;
        for (int i = 0; i < 2; i++) {
            Predator son = new Predator(this.lifeTime, this.speed, this.eyesight, new Coord());
            Main.getPredators().add(son);
            Main.window.add(son.sprite);
        }
    }
    
    
}
