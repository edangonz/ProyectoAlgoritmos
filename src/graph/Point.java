/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author Ricardo
 */
public class Point {
    int x; 
    int y; 
    int z;
  
    public Point(int x, int y,int z) 
    { 
        this.x = x; 
        this.y = y;
        this.z=z;
        
    } 

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
    
    
}
