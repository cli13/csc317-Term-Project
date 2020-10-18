/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LevelManager;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author Canran
 */
public class Manager {

    private ArrayList<State> gameStates;
    private int currentLevel;

    public Manager() {
        gameStates = new ArrayList<>();
        currentLevel = 1;
        gameStates.add(new Menu(this));
        gameStates.add(new Lvl1State(this));
        gameStates.add(new Over(this));
    }

    public void setState(int state) {
        currentLevel = state;
        gameStates.get(currentLevel).init();
    }

    public ArrayList<State> getManager(){
        return gameStates;
    }
    
    public int getState() {
        return currentLevel;
    }

    public void tick() {
        gameStates.get(currentLevel).tick();
    }

    public void render(Graphics2D g) {
        gameStates.get(currentLevel).render(g);
    }

    public void keyPressed(KeyEvent k) {
        gameStates.get(currentLevel).keyPressed(k);
    }

    public void keyReleased(KeyEvent k) {
        gameStates.get(currentLevel).keyReleased(k);
    }
}
