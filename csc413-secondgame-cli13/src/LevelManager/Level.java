/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LevelManager;

import GameObject.Movable.*;
import GameObject.Wall.*;
import GameObject.*;

/**
 *
 * @author Canran
 */

public class Level {

    protected Handler handler;

    public Level(Handler handler) {
        this.handler = handler;
    }
    //Bad Design
    //to make this more scalable I would make level an abstract class
    //and then I would make a bunch of levels that extends levels
    //and then I would make an arraylist to handle all the level loading and stuff just like  the object handler
    
    public void LoadLevel1() {
        int[][] map = {
            {4, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3}, //1
            {2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //2
            {2, 0, 20, 0, 0, 0, 33, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //3
            {10, 1, 1, 1, 1, 1, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //4
            {2, 0, 20, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //5
            {2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //6
            {10, 1, 1, 6, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //7
            {2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 31, 0, 0, 2}, //8
            {2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //9
            {2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //10
            {2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //11
            {2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //12
            {2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //13
            {2, 0, 32, 0, 0, 0, 21, 0, 0, 0, 0, 0, 0, 22, 0, 0, 2}, //14
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //15
            {5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 6}, //16
        };
        loadMapStuff(map);
        //lock stuff & bear stuff
        handler.getLevers().get(0).setLock(handler.getLocks().get(0));
        handler.getBears().get(0).setDirection(Bear.DOWN);
        handler.getBears().get(0).setDistance(1 * 64);

    }

    public void unLoadLevel() {
        handler.clear();
    }

    public void LoadLevel2() {
        int[][] map = {
            {4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3}, //1
            {2, 20, 33, 0, 0, 0, 0, 0, 0, 0, 0, 0, 33, 0, 33, 21, 2}, //2
            {10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 30, 4, 1, 1, 1, 9}, //3
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 1, 6, 34, 0, 0, 2}, //4
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 33, 0, 0, 0, 1, 3, 0, 2}, //5
            {2, 0, 0, 0, 0, 0, 0, 29, 0, 2, 0, 0, 0, 0, 2, 0, 2}, //6
            {2, 0, 0, 0, 0, 0, 0, 29, 0, 2, 0, 0, 0, 0, 0, 0, 2}, //7
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2}, //8
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2}, //9
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2}, //10
            {2, 0, 0, 2, 0, 20, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2}, //11
            {2, 0, 0, 2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2}, //12
            {2, 0, 1, 6, 29, 29, 0, 0, 29, 2, 0, 0, 0, 0, 0, 0, 2}, //13
            {2, 29, 29, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 29, 0, 2}, //14
            {2, 32, 29, 32, 0, 0, 0, 0, 31, 2, 0, 0, 20, 0, 29, 0, 2}, //15
            {5, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1, 1, 1, 1, 1, 6}, //16
        };
        loadMapStuff(map);
        //lock & bear configs
        handler.getLevers().get(0).setLock(handler.getLocks().get(0));
        handler.getLevers().get(0).setLock(handler.getLocks().get(2));
        handler.getBears().get(0).setDirection(Bear.LEFT);
        handler.getLevers().get(1).setColor(Lever.RED);
        handler.getLocks().get(1).setColor(Lever.RED);
        handler.getLocks().get(3).setColor(Lever.RED);
        handler.getLevers().get(1).setLock(handler.getLocks().get(1));
        handler.getLevers().get(1).setLock(handler.getLocks().get(3));
        handler.getBears().get(0).setDistance(15 * 64);
    }

    public void LoadLevel3() {
        int[][] map = {
            {4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 1, 3}, //1
            {2, 0, 20, 0, 21, 22, 0, 0, 0, 0, 0, 21, 2, 22, 0, 22, 2}, //2
            {2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 22, 0, 2}, //3
            {2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0, 22, 2}, //4
            {10, 1, 0, 1, 9, 0, 0, 0, 0, 0, 0, 0, 2, 0, 22, 0, 2}, //5
            {2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 22, 2}, //6
            {10, 1, 1, 1, 8, 1, 1, 1, 1, 1, 3, 0, 2, 0, 22, 0, 2}, //7
            {2, 21, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 22, 0, 22, 2}, //8
            {2, 4, 1, 31, 1, 3, 0, 0, 0, 1, 6, 0, 2, 0, 22, 0, 2}, //9
            {10, 6, 0, 0, 0, 5, 3, 0, 20, 22, 0, 0, 2, 21, 0, 21, 2}, //10
            {2, 22, 22, 0, 22, 22, 10, 1, 0, 1, 3, 0, 2, 0, 22, 22, 2}, //11
            {2, 0, 22, 22, 22, 0, 2, 0, 0, 0, 2, 0, 2, 0, 0, 22, 2}, //12
            {2, 22, 0, 0, 0, 22, 2, 0, 0, 0, 2, 0, 2, 0, 20, 0, 2}, //13
            {2, 0, 22, 22, 22, 0, 2, 0, 0, 0, 2, 0, 5, 1, 1, 1, 9}, //14
            {2, 0, 0, 20, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 22, 20, 2}, //15
            {5, 1, 1, 1, 1, 1, 8, 1, 1, 1, 8, 1, 1, 1, 1, 1, 6}, //16
        };
        loadMapStuff(map);
        handler.getBears().get(0).setDistance(0);
        
        handler.getBears().get(1).setDirection(Bear.DOWN);
        handler.getBears().get(1).setDistance(13 * 64);
        
        handler.getBears().get(2).setDirection(Bear.RIGHT);
        handler.getBears().get(2).setDistance(8 * 64);
        
        handler.getBears().get(3).setAlive(false);
        handler.getBears().get(4).setAlive(false);
        //lock stuff
    }

    public void LoadLevel4() {
        int[][] map = {
            {4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3}, //1
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //2
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //3
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //4
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //5
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //6
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //7
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //8
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //9
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //10
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //11
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //12
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //13
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //14
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //15
            {5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 6}, //16
        };
        loadMapStuff(map);
        //lock stuff
    }

    public void LoadLevel5() {
        int[][] map = {
            {4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3}, //1
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //2
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //3
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //4
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //5
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //6
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //7
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //8
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //9
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //10
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //11
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //12
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //13
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //14
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}, //15
            {5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 6}, //16
        };
        loadMapStuff(map);
        //lock stuff
    }

    private void loadMapStuff(int[][] map) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                switch (map[y][x]) {
                    case 1:
                        handler.addObject(new HLineWall(x * 64, y * 64, 64, 64, handler));
                        break;
                    case 2:
                        handler.addObject(new VLineWall(x * 64, y * 64, 64, 64, handler));
                        break;
                    case 3:
                        handler.addObject(new TopRightCorner(x * 64, y * 64, 64, 64, handler));
                        break;
                    case 4:
                        handler.addObject(new TopLeftCorner(x * 64, y * 64, 64, 64, handler));
                        break;
                    case 5:
                        handler.addObject(new BottomLeftCorner(x * 64, y * 64, 64, 64, handler));
                        break;
                    case 6:
                        handler.addObject(new BottomRightCorner(x * 64, y * 64, 64, 64, handler));
                        break;
                    case 7:
                        handler.addObject(new TTop(x * 64, y * 64, 64, 64, handler));
                        break;
                    case 8:
                        handler.addObject(new TBottom(x * 64, y * 64, 64, 64, handler));
                        break;
                    case 9:
                        handler.addObject(new TLeft(x * 64, y * 64, 64, 64, handler));
                        break;
                    case 10:
                        handler.addObject(new TRight(x * 64, y * 64, 64, 64, handler));
                        break;
                    case 11:
                        handler.addObject(new CrossPiece(x * 64, y * 64, 64, 64, handler));
                        break;
                    case 20:
                        Bee b = new Bee(x * 64, y * 64, 64, 64, handler);
                        handler.getBees().add(b);
                        break;
                    case 21:
                        Bear be = new Bear(x * 64, y * 64, 64, 64, handler);
                        handler.getBears().add(be);
                        handler.addObject(be);
                        break;
                    case 22:
                        handler.addObject(new Honey(x * 64, y * 64, 64, 64, handler));
                        break;
                    case 29:
                        handler.addObject(new Web(x * 64, y * 64, 64, 64, handler));
                        break;
                    case 30:
                        handler.addObject(new Flower(x * 64, y * 64, 64, 64, handler));
                        break;
                    case 31:
                        handler.addObject(new Hive(x * 64, y * 64, 64, 64, handler));
                        break;
                    case 32:
                        Lever i = new Lever(x * 64, y * 64, 64, 64, handler);
                        handler.getLevers().add(i);
                        handler.addObject(i);
                        break;
                    case 33:
                        Lock l = new Lock(x * 64, y * 64, 64, 64, handler);
                        handler.getLocks().add(l);
                        handler.addObject(l);
                        break;
                    case 34:
                        handler.addObject(new Scissor(x * 64, y * 64, 64, 64, handler));
                        break;
                }//switch
            }//loop1
        }//loop2
        for (Bee bee : handler.getBees()) {
            handler.addObject(bee);
        }
    }
}
