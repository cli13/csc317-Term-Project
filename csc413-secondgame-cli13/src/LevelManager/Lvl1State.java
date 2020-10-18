/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LevelManager;

import Default.*;
import GameObject.Handler;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author Canran
 */
//class should be renamed PlayState
public class Lvl1State extends State {

    private Handler handler;
    private BeeControl control;
    private ScoreBoard board;

    private Level level;
    private int cLvl = 0;

    public static final int MAX_LVL = 3;

    public void setCLvl(int i) {
        cLvl = i;
    }

    public Lvl1State(Manager manager) {
        super(manager);
    }

    @Override
    public void init() {
        handler = new Handler();
        level = new Level(handler);
        if (cLvl == 0) {
            cLvl = 1;
        }
        load(cLvl);
        control = new BeeControl(handler.getBees(), KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
        board = new ScoreBoard(handler);
    }

    @Override
    public void tick() {
        if (handler != null) {
            handler.tick();
        }
        if (board != null) {
            board.updateScore();
            if (handler.getBeeState(2) == handler.getBees().size()) {
                board.setWin(true);
            }
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(Assets.bg, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
        handler.render(g);
        g.setColor(Color.BLACK);
        g.fillRect(Game.GAME_WIDTH, 0, Game.WIDTH - Game.GAME_WIDTH, Game.HEIGHT);
        board.render(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        control.keyPressed(e);
        if (e.getKeyCode() == KeyEvent.VK_R) {
            level.unLoadLevel();
            load(cLvl);
        }
        if (board.getWin() && e.getKeyCode() == KeyEvent.VK_N) {
            board.setWin(false);
            cLvl++;
            if (cLvl > MAX_LVL) {
                manager.setState(2);
            }
            level.unLoadLevel();
            load(cLvl);
        }
        if(e.getKeyCode() == KeyEvent.VK_M){
            manager.setState(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        control.keyReleased(e);
    }

    //lvl 4 & 5 incomplete
    public void load(int currentLvl) {
        switch (currentLvl) {
            case 1:
                level.LoadLevel1();
                break;
            case 2:
                level.LoadLevel2();
                break;
            case 3:
                level.LoadLevel3();
                break;
            case 4:
                level.LoadLevel4();
                break;
            case 5:
                level.LoadLevel5();
                break;
        }
    }

}
