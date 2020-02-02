/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import graph.Edge;
import graph.GraphLA;
import graph.Point;
import graph.Vertex;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

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
    
    private int minData;

    public Simulacion(Vertex[][][] matriz, int base, int profundidad, int altura, GraphLA grafo, int minData) {
        this.matriz = matriz;
        this.base = base;
        this.profundidad = profundidad;
        this.altura = altura;
        this.grafo = grafo;
        this.minData = minData;
    }
    
    @Override
    public void run() {
        Point inicio = new Point(0, r.nextInt(minData), r.nextInt(minData));
        Point fin = new Point(minData - 1, r.nextInt(minData), r.nextInt(minData));
                
        System.out.println("Buscando ruta desde coordenada: " + inicio.getX() + "." +  inicio.getY() + "." +  inicio.getZ() + "\nHasta coodenadas: " +
                fin.getX() + "." +  fin.getY() + "." +  fin.getZ());
        Vertex tempVertex = bfs(matriz, inicio, fin);
        
        if(tempVertex != null){
            System.out.println("\nEl costo de esta ruta es: " + tempVertex.getCamino().size());
            Iterator<Vertex> it = tempVertex.getCamino().iterator();

            Vertex temp;

            while(it.hasNext()){
                temp = it.next();
                temp.setCamino(true);
            }
        } else {
            System.out.println("\nEl camino no existe.");
        }
    }
    
    private Vertex bfs(Vertex mat[][][], Point src,Point dest) {
        if (mat[dest.getX()][dest.getY()][dest.getZ()].getData2().isIsObstaculo() || mat[src.getX()][src.getY()][src.getZ()].getData2().isIsObstaculo() ) 
            return null; 

        Vertex vex = mat[src.getX()][src.getY()][src.getZ()];

        vex.setVisited(true);
        vex.setPrueba(0);

        Queue<Vertex> q = new LinkedList<>();

        q.add(vex);
        
        while (!q.isEmpty()){ 
            Vertex curr = q.peek();
            if (curr.equals(mat[dest.getX()][dest.getY()][dest.getZ()])) 
                return curr;
            q.remove(); 

            for(Edge e: curr.getEdges()){
                if (!e.getDestino().getData2().isIsObstaculo() && !e.getDestino().isVisited()) {
                    e.getDestino().setVisited(true);
                    e.getDestino().setPrueba(e.getOrigen().getPrueba()+1);
                    e.getDestino().getCamino().addAll(e.getOrigen().getCamino());
                    e.getDestino().getCamino().add(e.getOrigen());
                    q.add(e.getDestino());
                }
            }
        }
       
        return null; 
    } 
}
