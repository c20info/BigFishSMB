package com.mycompany.bigfish;

import com.mycompany.bigfish.Graphics.*;
import com.mycompany.bigfish.Animals.*;
import java.awt.Color;
import javax.swing.*;
import java.util.*;

public class Main {
    //                  GRAPHIC VARIABLES/CONSTANTS
    public static final Coord MENU_SIZE = new Coord(400, 400);
    public static final Coord WINDOW_SIZE = new Coord(800, 600);
    public static final Color MENU_BACKGROUND_COLOR = new Color(220,220,220);       //gainsboro color
    public static final Color BACKGROUND_COLOR = new Color(0, 102, 204);
    public static final int PREY_SIZE = 40;
    public static final int PREDATOR_SIZE = 70;
    public static final int HORIZONTAL_SHIFT = 16;
    public static final int VERTICAL_SHIFT = 39;
    public static final String IMAGES_PATH = "Images\\";
    
    //                  PUBLIC VARIABLES/CONSTANTS
    public static Random random = new Random();
    public static Window window = new Window("BigFish", MENU_SIZE, MENU_BACKGROUND_COLOR);
    public static int CYCLES_MILLIS = 20;
    
    //                  MAIN VARIABLES/CONSTANTS
    private static int predatorsLifeTime = 10, preysLifeTime = 10, predatorSpeed = 3, preysSpeed = 3, predatorSight = 100;             //variabili inserite da menu
    private static int preysStartNumber = 10;
    private static int predatorsStartNumber = 10;
    private static ArrayList<Predator> predators = new ArrayList<Predator>();
    private static ArrayList<Prey> preys = new ArrayList<Prey>();
    
    public static void main(String args[]) {   
        menu(); 
        wait(1000);
        window.resize(WINDOW_SIZE);
        window.setBackground(BACKGROUND_COLOR);
        spawnAnimals();
        window.setBackground(IMAGES_PATH + "Background.png");
        while (true) {         
            window.repaint();
            removeDeads(predators);
            removeDeads(preys);
        }
        
    }
    
    public static void menu() {
        Button startButton = new Button(new Coord(MENU_SIZE.x / 2, MENU_SIZE.y - 50), new Coord(70, 40), "Start", Button.BUTTON_COLOR);
        
        TextBox predatorsStartNumberInput = new TextBox(new Coord(100, 90), new Coord(70, 22), predatorsStartNumber);
        TextBox preysStartNumberInput = new TextBox(new Coord(300, 90), new Coord(70, 22), preysStartNumber);
        TextBox predatorsLifeTimeInput = new TextBox(new Coord(100, 165), new Coord(70, 22), 10);
        TextBox preysLifeTimeInput = new TextBox(new Coord(300, 165), new Coord(70, 22), 10);
        TextBox predatorSpeedInput = new TextBox(new Coord(100, 240), new Coord(70, 22), 3);
        TextBox preysSpeedInput = new TextBox(new Coord(300, 240), new Coord(70, 22), 3);
        TextBox predatorSightInput = new TextBox(new Coord(100, 315), new Coord(70, 22), 100);
        
        Label preyslabel = new Label(new Coord(100, 25), new Coord(100, 22), "Predators:");
        Label predatorlabel = new Label(new Coord(300, 25), new Coord(100, 22), "Preys:");
        
        Label predatorsStartNumberLabel = new Label(new Coord(100, 65), new Coord(200, 22), "Start Number:");
        Label preysStartNumberLabel = new Label(new Coord(300, 65), new Coord(200, 22), "Start Number:");
        Label predatorsLifeTimeLabel = new Label(new Coord(100, 140), new Coord(100, 22), "Lifetime:");
        Label preysLifeTimeLabel = new Label(new Coord(300, 140), new Coord(100, 22), "Lifetime:");
        Label predatorSpeedLabel = new Label(new Coord(100, 215), new Coord(100, 22), "Speed:");
        Label preysSpeedLabel = new Label(new Coord(300, 215), new Coord(100, 22), "Speed:");
        Label predatorSightLabel = new Label(new Coord(100, 290), new Coord(100, 22), "FOV:");
        
        window.repaint();
        while (!startButton.isActive()) { 
            predatorsStartNumber = predatorsStartNumberInput.getValue();
            preysStartNumber = preysStartNumberInput.getValue();
            predatorsLifeTime = predatorsLifeTimeInput.getValue();
            preysLifeTime = preysLifeTimeInput.getValue();
            predatorSpeed = predatorSpeedInput.getValue();
            preysSpeed = preysSpeedInput.getValue();
            predatorSight = predatorSightInput.getValue();
            System.out.println(startButton.isActive());
        }
        //Actions to do before starting after pressing start
        window.remove(predatorsStartNumberInput);
        window.remove(preysStartNumberInput);
        window.remove(predatorsStartNumberLabel);
        window.remove(preysStartNumberLabel);
        window.remove(startButton);
        window.remove(predatorsLifeTimeInput);
        window.remove(preysLifeTimeInput);
        window.remove(predatorSpeedInput);
        window.remove(preysSpeedInput);
        window.remove(predatorSightInput);
        window.remove(preyslabel);
        window.remove(predatorlabel);
        window.remove(predatorsLifeTimeLabel);
        window.remove(preysLifeTimeLabel);
        window.remove(predatorSpeedLabel);
        window.remove(preysSpeedLabel);
        window.remove(predatorSightLabel);
    }
    
    public static void spawnAnimals() {
        for (int i = 0; i < preysStartNumber; i++) { preys.add(new Prey(preysLifeTime, preysSpeed, new Coord())); window.add(preys.get(i).getSprite()); }
        for (int i = 0; i < predatorsStartNumber; i++) { predators.add(new Predator(predatorsLifeTime, predatorSpeed, predatorSight, new Coord())); window.add(predators.get(i).getSprite()); }
        window.repaint();
    }
    
    public static <Type extends Animal> void removeDeads(ArrayList<Type> animals) { for (int i = 0; i < animals.size(); i++) if (!animals.get(i).isItAlive()) { animals.get(i).canc(); animals.remove(i);} window.repaint(); }

    public static ArrayList<Predator> getPredators() { return predators; }

    public static ArrayList<Prey> getPreys() { return preys; }
    
    public static void wait(int ms) { try { Thread.sleep(ms); } catch(Exception e) { } }
}
