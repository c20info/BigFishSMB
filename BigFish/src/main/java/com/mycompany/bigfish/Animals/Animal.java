package com.mycompany.bigfish.Animals;

import com.mycompany.bigfish.*;
import com.mycompany.bigfish.Graphics.*;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

public class Animal extends Thread {
    //      Behavoiur Variables
    protected int lifeTime;         //indica i secondi di vita che restano all'animale
    protected int speed;            //indica il numero di px al secondo che percorre l'animale
    protected Coord pos;            //Coordinate dell'Animale nella Finestra
    protected Timer timer;          //timer che gestisce la lifeTime dell'Animale
    
    //      Graphic Variables
    protected int size;             //indica la grandezza degli animali (diametro del cerchio)
    protected Color color;          //indica il colore dell'Animale
    protected String spritePath;    //percorso della sprite dell'animale 
    protected Sprite sprite;        //Sprite dell'Animale
    
    public Animal(int lifeTime, int speed, Coord pos, Color color) {
        this.lifeTime = lifeTime;
        this.speed = speed;
        this.pos = new Coord(pos.x, pos.y);
        this.color = color;
        this.spritePath = Main.IMAGES_PATH;
        if (this.getClass().getSimpleName().equals("Predator")) { this.spritePath += "Predator_Sprite.png"; this.size = Main.PREDATOR_SIZE; }
        else if (this.getClass().getSimpleName().equals("Prey")) { this.spritePath += "Prey_Sprite.png"; this.size = Main.PREY_SIZE; }
        this.timer = new Timer((this.lifeTime * 1000));
        timer.start();
        this.sprite = new Sprite(new Coord(0,0), new Coord(size, size), spritePath);
        Main.window.add(sprite);
        this.sprite.setBounds(this.getAwtPoint().x, this.getAwtPoint().y, this.size, this.size);
        this.start();
    }
    
    
    @Override public String toString() { return "Coord(" + this.pos.x + ", " + this.pos.y + ") " + "lifeTime: " + this.timer.getTime(); }
    
    public boolean isItAlive() { return !this.timer.triggered; }
    
    public Coord getAwtPoint() { return new Coord(this.pos.x - this.size / 2, this.pos.y - this.size / 2); }
    
    public void canc() { Main.window.remove(this.sprite); }
    
    public void move() {
        switch(Main.random.nextInt(4)) {
            case 0: if (this.pos.x < Main.window.getDimensions().x - this.size) pos.x += this.speed; break;
            case 1: if (this.pos.x >= this.size) pos.x -= this.speed; break;
            case 2: if (pos.y < Main.window.getDimensions().y - this.size) pos.y += this.speed; break; 
            case 3: if (pos.y >= this.size) pos.y -= this.speed; break; 
        }
        this.sprite.setBounds(this.getAwtPoint().x, this.getAwtPoint().y, this.size, this.size);
    }
    
    @Override public void run() { while (isItAlive()) { this.move(); Main.wait(Main.CYCLES_MILLIS); } this.reproduce(); }
    
    public void reproduce() {  }
    
    public Sprite getSprite() { return this.sprite; }
    
}
