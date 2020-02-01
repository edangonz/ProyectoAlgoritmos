/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import graph.Vertex;
import shape.Nodo;
import shape.Plane;
import util.MouseHandler;
import util.Vector2f;
import java.awt.Color;
import java.awt.Graphics2D;
import plane3d.Plane3D;

/**
 *
 * @author ADMIN
 */
public class State {
    public static Vector2f map;
    
    private int x;
    private int y;
    private int z;
    
    private Nodo cubito = new Nodo(500, 500,  500, 100);
    
    private Plane plane;
    
    private Vertex[][][] matriz;
    
    public State(int x, int y, int z, int arista ,int aristaCubos, Vertex[][][] matriz){
        this.x = x;
        this.y = y;
        this.z = z;
        
        this.matriz = matriz;
        
        map = new Vector2f(Plane3D.width, Plane3D.height);
        
        Vector2f.setWorldVar(map.x, map.y);
        
        this.plane = new Plane(Plane3D.width/2 - arista/4, Plane3D.height/2 + arista/4, 0 , aristaCubos, x, y, z);
    }
    
    public void update(){
        Vector2f.setWorldVar(map.x,map.y);
        
    }
    
    public void input(MouseHandler mouse){
        
    }
    
    public void render(Graphics2D g){
        g.setColor(Color.WHITE);
        //g.drawRect(20,20,20,20);
        
        /*
        
        
        Polygon p = new Polygon();
        for (int i = 0; i < 8; i++)
            p.addPoint((int) (100 + 50 * Math.cos(i * 2 * Math.PI / 5)),
            (int) (100 + 50 * Math.sin(i * 2 * Math.PI / 5)));

        g.drawPolygon(p);
        
        Polygon s = new Polygon();
        for (int i = 0; i < 360; i++) {
            double t = i / 360.0;
            s.addPoint((int) (150 + 50 * t * Math.cos(8 * t * Math.PI)),(int) (150 + 50 * t * Math.sin(8 * t * Math.PI)));
        }
        
        g.drawPolygon(s);
        g.fill(s);
        */
        
        
        
        for(int i = 0; i < this.x; i++){
                for(int j = 0; j < this.y; j++){
                    for(int k = 0; k < this.z; k++){
                        matriz[i][j][k].render(g);
                    }
                }
            }
        
        plane.render(g);
        //cubito.render(g);
        
        //g.fill3DRect(300, 500, 200, 100, true);
    }
}
