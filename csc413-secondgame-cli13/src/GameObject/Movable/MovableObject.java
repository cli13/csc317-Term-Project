/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject.Movable;

import GameObject.GameObject;
import GameObject.Handler;

/**
 *
 * @author Canran
 */
public abstract class MovableObject extends GameObject {

    public static final int FIXSPEED = 6;

    //speed
    protected int vx;
    protected int vy;

    protected int pX;
    protected int pY;

    public void setPX(int a) {
        pX = a;
    }

    public void setPY(int b) {
        pY = b;
    }

    public int getPY() {
        return pY;
    }

    public int getPX() {
        return pX;
    }

    public MovableObject(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        vx = FIXSPEED;
        vy = FIXSPEED;
    }

}
