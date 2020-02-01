/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import graph.GraphLA;
import graph.Point;
import graph.Vertex;
import java.util.Iterator;
import shape.Nodo;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Simulacion implements Runnable{
    private Random r = new Random();
    
    private Vertex[][][] matriz;
    private GraphLA grafo;
    
    private int base;
    private int profundidad;
    private int altura;

    public Simulacion(Vertex[][][] matriz, int base, int profundidad, int altura, GraphLA grafo) {
        this.matriz = matriz;
        this.base = base;
        this.profundidad = profundidad;
        this.altura = altura;
        this.grafo = grafo;
    }
    
    @Override
    public void run() {
        grafo.BFS(matriz, new Point(29,29,29), new Point(99, 20, 20));
        
        Iterator<Vertex> it = matriz[99][20][20].getCamino().iterator();
        
        Vertex temp;
        
        while(it.hasNext()){
            temp = it.next();
            temp.setCamino(true);
        }
    }
}
