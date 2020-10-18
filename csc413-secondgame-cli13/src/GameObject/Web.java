/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

import Default.Assets;
import GameObject.Movable.Bee;
import java.awt.Graphics;

/**
 *
 * @author Canran
 */
public class Web extends GameObject {
    
    private int num = 1;
    
    public Web(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        ID = 29;
    }
    
    public void collision(Bee b) {
        if (b.getScissor() >= 1 && b.getBounds().intersects(this.getBounds())) {
            b.delScissor();
            handler.remove(this);
        } else if (b.getBounds().intersects(this.getBounds()) && num > 0) {
            b.setX(x);
            b.setY(y);
            b.setPX(x);
            b.setPY(y);
            b.setState(1);
            num--;
        }
    }
    
    @Override
    public void tick() {
        for (Bee b : handler.getBees()) {
            collision(b);
        }
    }
    
    @Override
    public void render(Graphics g) {
        if (num > 0) {
            g.drawImage(Assets.web2, x, y, width, height, null);
        } else {
            g.drawImage(Assets.web, x, y, null);
        }
    }
    
}
