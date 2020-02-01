/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 *
 * @author ADMIN
 */
public abstract class Shape {
    
    protected int x;
    protected int y;
    protected int z;
    protected int arista;
    protected Polygon pcostado;
    protected Polygon psuperor;
    protected Polygon pfrente;
    
    public Shape(int x, int y, int z, int arista){
        this.x = x;
        this.y = y;
        this.z = z;
        this.arista = arista;
    }
    
    public abstract void update();
    
    public abstract void input();
    
    public abstract void render(Graphics2D g);
}
