/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LevelManager;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 *
 * @author Canran
 */
public abstract class State {

    protected Manager manager;

    public State(Manager manager) {
        this.manager = manager;
    }

    public abstract void init();

    public abstract void tick();

    public abstract void render(Graphics2D g);

    public abstract void keyPressed(KeyEvent e);

    public abstract void keyReleased(KeyEvent e);

}
