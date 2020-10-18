/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject.Wall;

import GameObject.Movable.MovableObject;
import GameObject.*;
import GameObject.Handler;

/**
 *
 * @author Canran
 */
public abstract class Wall extends GameObject {

    public Wall(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
    }

    public void collision(MovableObject a) {
        if (a.getBounds().intersects(this.getBounds())) {
            a.setX(a.getPX());
            a.setY(a.getPY());
        }
    }

    @Override
    public void tick() {
        for (int i = 0; i < handler.getObjects().size(); i++) {
            if (handler.get(i) instanceof MovableObject) {
                collision((MovableObject) handler.get(i));
            }
        }
    }
}
