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
public class Scissor extends GameObject {

    public Scissor(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        ID = 34;
    }

    private void collision(Bee b) {
        if(b.getBounds().intersects(this.getBounds())){
             handler.remove(this);
             b.addScissor();
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
        g.drawImage(Assets.Scissor, x, y, width, height, null);
    }

}
