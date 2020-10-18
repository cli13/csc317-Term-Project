/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

import GameObject.Movable.Bee;
import Default.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Canran
 */
public class Lever extends GameObject {

    private ArrayList<Lock> locks;
    private int color;
    private int state = 0;
    private int counter = 0;

    public Lever(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        locks = new ArrayList<>();
        ID = 32;
        color = 0;
    }

    public void setColor(int i) {
        color = i;
    }

    public void collision(Bee b) {
        if (b.getBounds().intersects(this.getBounds())) {
            for (Lock lock : locks) {
                if (!lock.isOpen()) {
                    lock.setOpen(true);
                    state = 1;
                } else if (lock.isOpen()) {
                    lock.setOpen(false);
                    state = 0;
                }
            }
        }
    }

    public void setLock(Lock l) {
        locks.add(l);
    }

    @Override
    public void tick() {
        if (counter > 10) {
            for (Bee bee : handler.getBees()) {
                collision(bee);
                counter = 0;
            }
        } else {
            counter++;
        }
    }

    public static final int RED = 1;
    public static final int BLUE = 0;
    
    
    @Override
    public void render(Graphics g) {
        if (color == 0) {
            if (state == 1) {
                g.drawImage(Assets.blueSwitch, x + 64, y, -width, height, null);
            } else {
                g.drawImage(Assets.blueSwitch, x, y, width, height, null);
            }
        } else if (color == 1) {
            if (state == 1) {
                g.drawImage(Assets.redSwitch, x + 64, y, -width, height, null);
            } else {
                g.drawImage(Assets.redSwitch, x, y, width, height, null);
            }
        }
    }

}
