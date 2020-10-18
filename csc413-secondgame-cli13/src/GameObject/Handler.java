package GameObject;

import GameObject.Movable.Bear;
import GameObject.Movable.Bee;
import java.awt.Graphics;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Canran
 */
public class Handler {

    
    //Its too late to change this... learned my mistake
    private ArrayList<GameObject> obj;
    private ArrayList<Bee> bees;
    private ArrayList<Bear> bears;
    private ArrayList<Lock> locks;
    private ArrayList<Lever> levers;

    public Handler() {
        bees = new ArrayList<>();
        obj = new ArrayList<>();
        bears = new ArrayList<>();
        levers = new ArrayList<>();
        locks = new ArrayList<>();
    }

    public void tick() {
        for (int i = 0; i < obj.size(); i++) {
            obj.get(i).tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < obj.size(); i++) {
            obj.get(i).render(g);
        }
    }

    public ArrayList<Bee> getBees() {
        return bees;
    }

    public ArrayList<Lever> getLevers() {
        return levers;
    }

    public ArrayList<Lock> getLocks() {
        return locks;
    }

    public ArrayList<Bear> getBears() {
        return bears;
    }

    public ArrayList<GameObject> getObjects() {
        return obj;
    }

    public void addObject(GameObject obj) {
        this.obj.add(obj);
    }

    public void remove(GameObject obj) {
        this.obj.remove(obj);
    }

    public void remove(int i) {
        this.obj.remove(i);
    }

    public GameObject get(int i) {
        return obj.get(i);
    }

    public int getBeeState(int b) {
        int count = 0;
        for (Bee bee : bees) {
            if (bee.getState() == b) {
                count++;
            }
        }
        return count;
    }
    
    public void clear(){
        obj.clear();
        bees.clear();
        bears.clear();
        locks.clear();
        levers.clear();
    }
}
