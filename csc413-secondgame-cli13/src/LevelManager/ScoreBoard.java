/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LevelManager;

import Default.Assets;
import Default.Game;
import GameObject.Handler;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Canran
 */
public class ScoreBoard extends JPanel {

    private int NumberOfBees;
    private int BeeSaved;
    private Handler handler;
    private boolean congrate;
    private String msg;
    private String msg2;
    private String msg3;

    public ScoreBoard(Handler handler) {
        this.handler = handler;
        BeeSaved = 0;
        NumberOfBees = handler.getBees().size();
        congrate = false;
    }

    public void render(Graphics g) {
        String str2 = "Bees left to escape: ";
        String str = BeeSaved + " / " + NumberOfBees;
        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.PLAIN, 24));
        g.drawString(str2, Game.GAME_WIDTH + 32, 32);
        g.drawString(str, Game.GAME_WIDTH + 168, 64);
        g.drawImage(Assets.rButt, Game.GAME_WIDTH + 32, 900, null);
        g.drawImage(Assets.qButt, Game.GAME_WIDTH + 180, 900, null);
        if (congrate) {
            g.setColor(Color.YELLOW);
            g.drawString("Press \"N\" to go", Game.GAME_WIDTH + 32, 700);
            g.drawString("to the next level", Game.GAME_WIDTH + 32, 734);
        }
    }

    public void updateScore() {
        BeeSaved = handler.getBeeState(2);
        NumberOfBees = handler.getBees().size();
    }

    public void setWin(boolean w) {
        congrate = w;
    }
    
    public boolean getWin(){
        return congrate;
    }
}
