package Default;

import LevelManager.Manager;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Canran
 */
public class Game extends JPanel implements Runnable, KeyListener {

    public final static String TITLE = "Synchronized Bees";
    public final static int WIDTH = 1400;
    public final static int HEIGHT = 1064;
    public final static int GAME_WIDTH = 1088;
    public final static int GAME_HEIGHT = 1024;

    private Manager manager;
    private boolean running;
    private Thread thread;
    private JFrame jf;

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    private void init() {
        Assets a = new Assets();
        a.init();
        manager = new Manager();
        manager.setState(0);
        setUpFrame();
        this.addKeyListener(this);
    }

    private void setUpFrame() {
        jf = new JFrame(TITLE);
        jf.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jf.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        jf.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        jf.add(this);
        jf.pack();
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    @Override
    public void run() {
        init();
        //credit notch loop
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            repaint();
            frames++;
            if(manager.getState() == 2){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(1);
            }

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        manager.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        manager.keyReleased(e);
    }

    public void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void tick() {
        manager.tick(); //update
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        manager.render(g2d);
    }


}
