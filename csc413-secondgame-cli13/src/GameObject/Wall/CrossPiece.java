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

/**
 *
 * @author Canran
 */
public class CrossPiece extends VLineWall {

    public CrossPiece(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        ID = 1;
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.crossPiece, x, y, width, height, null);
    }
}
