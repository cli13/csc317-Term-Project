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
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 *
 * @author Canran
 */
public class Menu extends State {

    private int currentChoice = 0;
    private String[] options = {"START", "LEVEL SELECT", "EXIT"};
    private String[] lvls = {"LVL 1", "LVL 2", "LVL 3", "Back"};
    boolean loadSelect = false;

    private Font font;

    public Menu(Manager manager) {
        super(manager);
        font = new Font("Arial", Font.BOLD, 28);
    }

    @Override
    public void init() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(Assets.bg, 0, 0, Game.WIDTH, Game.HEIGHT, null);

        g.setFont(font);
        if (!loadSelect) {
            g.drawImage(Assets.title, Game.WIDTH / 8, 0, 3 * Game.WIDTH / 4, 3 * Game.HEIGHT / 4, null);
            for (int i = 0; i < options.length; i++) {
                if (i == currentChoice) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.drawString(options[i], (Game.WIDTH / 2) - 150, (Game.HEIGHT / 4) + Game.HEIGHT / 2 + i * 50);
            }
        } else {
            for (int i = 0; i < lvls.length; i++) {
                if (i == currentChoice) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.drawString(lvls[i], (Game.WIDTH / 2) - 150, (Game.HEIGHT / 4) + i * 50);
            }
        }

    }

    private void lvlSelect() {
        switch (currentChoice) {
            case 0:
                manager.setState(1);
                ((Lvl1State) manager.getManager().get(1)).setCLvl(1);
                break;
            case 1:
                manager.setState(1);
                ((Lvl1State) manager.getManager().get(1)).setCLvl(2);
                break;
            case 2:
                manager.setState(1);
                ((Lvl1State) manager.getManager().get(1)).setCLvl(3);
                break;
            case 3:
                loadSelect = false;
                currentChoice = 0;
                break;
        }
    }

    private void select() {
        switch (currentChoice) {
            case 0:
                manager.setState(1);
                break;
            case 1:
                loadSelect = true;
                currentChoice = 0;
                break;
            case 2:
                System.exit(0);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        if (k == KeyEvent.VK_ENTER) {
            if (!loadSelect) {
                select();
            } else {
                lvlSelect();
            }
        }
        if (k == KeyEvent.VK_UP) {
            currentChoice--;
            if (currentChoice == -1 && loadSelect) {
                currentChoice = lvls.length - 1;
            } else if (currentChoice == -1) {
                currentChoice = options.length - 1;
            }
        }
        if (k == KeyEvent.VK_DOWN) {
            currentChoice++;
            if (currentChoice == lvls.length && loadSelect) {
                currentChoice = 0;
            } else if (currentChoice == options.length && !loadSelect) {
                currentChoice = 0;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
