package com.mycompany.bigfish;

import com.mycompany.bigfish.*;
import java.util.*;


/**
 * Questa classe quando fatta partire aspetta per un numero di secondi prestabilito e si "attiva" alla scadenza
 * @author Barucci
 */

public class Timer extends Thread {
    private int time;               // variabile che indica il numero di millisecondi che il timer deve aspettare
    public boolean triggered;       // variabile che indica se il timer è scaduto
    
    /**
     * Questo è un costruttore che prende per parametro la variabile time {@code time}
     * @param time 
     */
    
    public Timer(int time) { this.time = time; this.triggered = false; }
    
    /**
     * Questo metodo è il costruttore di copia
     * @param timer 
     */
    public Timer(Timer timer) { this.time = timer.time; this.triggered = timer.triggered; }
    
    /**
     * Questo metodo aspetta per {@code time} millisecondi e quando scadono attiva la variabile {@code triggered}
     */
    @Override public void run() { while(time > 0) { time -= 100; Main.wait(100);} triggered = true; }
    
    /**
     *Questo metodo restituisce la variabile {@code time}
     */
    
    public int getTime() { return this.time; }
}
