/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObject;

import Default.Assets;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Canran
 */
public class Hive extends Flower{
    
    public Hive(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        numberAvaiable = 9999;
        ID = 31;
    }
    
    
    @Override
    public void render(Graphics g){
        g.drawImage(Assets.hive, x, y, width, height, null);
    }
    
    
    
}
