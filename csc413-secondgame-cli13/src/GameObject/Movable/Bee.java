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
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

/**
 *
 * @author Canran
 */
public class Bee extends MovableObject {

    private boolean UpPressed;
    private boolean DownPressed;
    private boolean RightPressed;
    private boolean LeftPressed;

    private int pos = 1; //facing direction
    private int beeState = 0; //0 = alive, 1 = dead, 2 = escaped
    private int scissor;

    public Bee(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        ID = 20;
        pX = x;
        pY = y;
        scissor = 0;
    }

    public void collision(GameObject b) {
        if (b.getBounds().intersects(this.getBounds())) {
            x = pX;
            y = pY;
        }
    }


    @Override
    public void tick() {
        for (GameObject b : handler.getObjects()) {
            if (this != b) {
                collision(b);
            } else if (beeState == 0) {
                if (this.UpPressed) {
                    this.moveUp();
                }
                if (this.DownPressed) {
                    this.moveDown();
                }
                if (this.RightPressed) {
                    pos = 1;
                    this.moveRight();
                }
                if (this.LeftPressed) {
                    pos = -1;
                    this.moveLeft();
                }
            }
            if(beeState == 2){
                x = -100;
            }
        }

    }

    @Override
    public void render(Graphics g) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        if (beeState == 0) {
            if (pos > 0) {
                g.drawImage(Assets.bee, x, y, width, height, null);
            } else {
                tx.translate(-Assets.bee.getWidth(), 0);
                AffineTransformOp op = new AffineTransformOp(tx,
                        AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                g.drawImage(op.filter(Assets.bee, null), x, y, width, height, null);
            }
        } else if (beeState == 1) {
            g.drawImage(Assets.dbee, x, y, width, height, null);
        }

    }

    public void toggleUpPressed() {
        this.UpPressed = true;
    }

    public void toggleDownPressed() {
        this.DownPressed = true;
    }

    public void toggleRightPressed() {
        this.RightPressed = true;
    }

    public void toggleLeftPressed() {
        this.LeftPressed = true;
    }

    public void unToggleUpPressed() {
        this.UpPressed = false;
    }

    public void unToggleDownPressed() {
        this.DownPressed = false;
    }

    public void unToggleRightPressed() {
        this.RightPressed = false;
    }

    public void unToggleLeftPressed() {
        this.LeftPressed = false;
    }

    private void moveUp() {
        vy = -Math.abs(vy);
        pY = y;
        y += vy;
    }

    private void moveDown() {
        vy = Math.abs(vy);
        pY = y;
        y += vy;
    }

    private void moveRight() {
        vx = Math.abs(vx);
        pX = x;
        x += vx;
    }

    private void moveLeft() {
        vx = -Math.abs(vx);
        pX = x;
        x += vx;
    }

    public void setState(int a) {
        beeState = a;
    }

    public int getState() {
        return beeState;
    }
    
    public int getScissor(){
        return scissor;
    }
    
    public void addScissor(){
        scissor++;
    }
    
    public void delScissor(){
        scissor--;
    }

}
