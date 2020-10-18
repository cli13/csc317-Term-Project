/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject.Movable;

import Default.Assets;
import GameObject.GameObject;
import GameObject.Handler;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

/**
 *
 * @author Canran
 */
public class Bear extends MovableObject {

    private int distance;
    private int direction;// [0/1=up/down],[3/4=right/left]
    private int distanceWalk = 0;
    private boolean isAlive = true;

    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    public Bear(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        ID = 21;
        direction = 0;
        pX = x;
        pY = y;
        distance = 128;
    }

    public void collision(GameObject a) {
        if (a.getBounds().intersects(this.getBounds()) && a instanceof Bee) {
            ((Bee) a).setState(1);
        }
    }

    @Override
    public void tick() {
        if (isAlive) {
            for (Bee bee : handler.getBees()) {
                collision(bee);
            }
            if (distance != 0) {
                walk();
            }
        }
    }

    public void setAlive(boolean a) {
        isAlive = a;
    }

    @Override
    public void render(Graphics g) {
        if (isAlive) {
            if (direction == 2) {
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-Assets.bear.getWidth(), 0);
                AffineTransformOp op = new AffineTransformOp(tx,
                        AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                g.drawImage(op.filter(Assets.bear, null), x, y, width, height, null);
            } else {
                g.drawImage(Assets.bear, x, y, width, height, null);
            }
        } else {
            g.drawImage(Assets.bear2, x, y, width, height, null);
        }
    }

    @Override
    public Rectangle getBounds() {
        if (isAlive) {
            return new Rectangle(x, y, width, height);
        } else {
            return new Rectangle();
        }
    }

    public void setDirection(int d) {
        direction = d;
    }

    public void setDistance(int d) {
        distance = d;
    }

    public void walk() {
        switch (direction) {
            case 0:
                if (distanceWalk > distance) {
                    distanceWalk = 0;
                    direction = 1;
                } else {
                    distanceWalk += vy;
                    pY = y;
                    y -= vy;
                }
                break;
            case 1:
                if (distanceWalk > distance) {
                    distanceWalk = 0;
                    direction = 0;
                } else {
                    distanceWalk += vy;
                    pY = y;
                    y += vy;
                }
                break;
            case 2:
                if (distanceWalk > distance) {
                    distanceWalk = 0;
                    direction = 3;
                } else {
                    distanceWalk += vx;
                    pX = x;
                    x -= vx;
                }
                break;
            case 3:
                if (distanceWalk > distance) {
                    distanceWalk = 0;
                    direction = 2;
                } else {
                    distanceWalk += vx;
                    pX = x;
                    x += vx;
                }
                break;
        }
    }

}
