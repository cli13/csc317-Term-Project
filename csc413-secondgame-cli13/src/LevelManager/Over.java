/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LevelManager;

import Default.Assets;
import Default.Game;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 *
 * @author Canran
 */
public class Over extends State {

    private Manager manager;

    public Over(Manager manager) {
        super(manager);
    }

    @Override
    public void init() {
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(Assets.winScreen, 0, 0, Game.WIDTH, Game.HEIGHT, null);
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
