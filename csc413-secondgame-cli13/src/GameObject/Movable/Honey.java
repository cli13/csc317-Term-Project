/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject.Movable;

import Default.Assets;
import GameObject.GameObject;
import GameObject.Handler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Canran
 */
public class Honey extends MovableObject {

    public boolean isVis = true;

    public Honey(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        ID = 22;
        pX = x;
        pY = y;
    }

    public Rectangle topRec() {
        return new Rectangle(x + 8, y, width - 16, 2);
    }

    public Rectangle leftRec() {
        return new Rectangle(x - 2, y + 8, 2, height - 16);
    }

    public Rectangle bottomRec() {
        return new Rectangle(x + 8, y + height - 2, width - 16, 2);
    }

    public Rectangle rightRec() {
        return new Rectangle(x + width - 2, y + 8, 2, height - 16);
    }

    public void collision(GameObject a) {
        if ( !(a instanceof Bear) ) {
            if (a.getBounds().intersects(this.leftRec())) {
                pX = x;
                x += vx;
            } else if (a.getBounds().intersects(this.rightRec())) {
                pX = x;
                x -= vx;
            } else if (a.getBounds().intersects(this.topRec())) {
                pY = y;
                y += vy;
            } else if (a.getBounds().intersects(this.bottomRec())) {
                pY = y;
                y -= vy;
            }
        }
    }

    @Override
    public void tick() {
        for (GameObject object : handler.getObjects()) {
            if (object instanceof Bear) {
                sleep((Bear) object);
            }
            if (object != this) {
                collision(object);
            }
        }
    }

    @Override
    public void render(Graphics g) {
        if (isVis) {
            g.drawImage(Assets.honey, x, y, width, height, null);
        }
    }

    private void sleep(Bear b) {
        if (b.getBounds().intersects(this.getBounds())) {
            isVis = false;
            b.setAlive(false);
            x = -100;
            y = -100;
        }
    }

}
