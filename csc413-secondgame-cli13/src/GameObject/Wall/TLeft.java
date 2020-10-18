/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject.Wall;

import Default.Assets;
import GameObject.Handler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Canran
 */
public class TLeft extends Wall {

    public TLeft(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        ID = 1;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tLeft, x, y, width, height, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y + 12, width, 40);
    }

}
