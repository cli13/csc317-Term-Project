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

/**
 *
 * @author Canran
 */
public class Flower extends GameObject {

    protected int numberAvaiable;

    public Flower(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        ID = 30;
        numberAvaiable = 1;
    }
    

    public void collision(Bee b) {
        if (b.getBounds().intersects(this.getBounds()) && numberAvaiable > 0) {
            b.setState(2);
            b.setX(-100);
            numberAvaiable--;
        }
    }

    @Override
    public void tick() {
        for (Bee bee : handler.getBees()) {
            collision(bee);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.flower, x, y, width, height, null);
    }

}
