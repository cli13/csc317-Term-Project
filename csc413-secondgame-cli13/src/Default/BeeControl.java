/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import GameObject.Movable.Bee;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author Canran
 */
public class BeeControl {

    private int up;
    private int down;
    private int left;
    private int right;
    private ArrayList<Bee> bs;

    public BeeControl(ArrayList<Bee> b, int up, int down, int left, int right) {
        this.bs = b;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public void keyPressed(KeyEvent ke) {
        int keyPressed = ke.getKeyCode();
        if (keyPressed == up) {
            bs.forEach((n) -> n.toggleUpPressed());
        }
        if (keyPressed == down) {
            bs.forEach((n) -> n.toggleDownPressed());
        }
        if (keyPressed == left) {
            bs.forEach((n) -> n.toggleLeftPressed());
        }
        if (keyPressed == right) {
            bs.forEach((n) -> n.toggleRightPressed());
        }
    }

    public void keyReleased(KeyEvent ke) {
        int keyReleased = ke.getKeyCode();
        if (keyReleased == up) {
            bs.forEach((n) -> n.unToggleUpPressed());
        }
        if (keyReleased == down) {
            bs.forEach((n) -> n.unToggleDownPressed());
        }
        if (keyReleased == left) {
            bs.forEach((n) -> n.unToggleLeftPressed());
        }
        if (keyReleased == right) {
            bs.forEach((n) -> n.unToggleRightPressed());
        }
    }

}
