/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

import GameObject.Movable.*;
import Default.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Canran
 */
public class Lock extends GameObject {

    private boolean open;
    private int color;

    public Lock(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        open = false;
        ID = 33;
        color = 0;
    }

    public void setColor(int i) {
        color = i;
    }

    public int getColor() {
        return color;
    }

    @Override
    public void tick() {
        for (GameObject object : handler.getObjects()) {
            if (object instanceof MovableObject) {
                collision((MovableObject) object);
            }
        }

    }

    @Override
    public void render(Graphics g) {
        if (!open) {
            if (color == 0) {
                g.drawImage(Assets.blueLock, x, y, width, height, null);
            } else if (color == 1) {
                g.drawImage(Assets.redLock, x, y, width, height, null);
            }
        }
    }

    /**
     * @return the open
     */
    public boolean isOpen() {
        return open;
    }

    @Override
    public Rectangle getBounds() {
        if (open) {
            return new Rectangle();
        } else {
            return new Rectangle(x,y,width,height);
        }
    }

    /**
     * @param open the open to set
     */
    public void setOpen(boolean open) {
        this.open = open;
    }

    
    //this should be in the made in collisions too late now
    public void collision(MovableObject b) {
        if (b.getBounds().intersects(this.getBounds())) {
            b.x = b.getPX();
            b.y = b.getPY();
        }
    }

}
