/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import graph.GraphLA;
import graph.Vertex;
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
        //int numero1 = r.nextInt(base);
        //int numero2 = r.nextInt(profundidad);
        //int numero3 = r.nextInt(altura);
            
        //while(true){
            
            Vertex vertexOrigen = matriz[0][0][0];
            vertexOrigen.getData().setCamino();
            
            int x;
            
            while(true){
                try {
                    Thread.sleep(200);
                    
                    x = r.nextInt(vertexOrigen.cantidadEdge());
                    
                    Vertex vertexDestino = vertexOrigen.getEdges().get(x).getDestino();
                    
                    if(!vertexDestino.getData().isIsCamino()){
                        vertexDestino.getData().setCamino();
                        vertexOrigen = vertexDestino;
                    }
                    
                    /**
                     * 
                    x = r.nextInt(6);
                    
                    switch(x){
                        case 0:
                            if(node.getNodoDelantero() != null && !node.getNodoDelantero().isIsObstaculo()){
                                node.getNodoDelantero().setCamino();
                                node = node.getNodoDelantero();
                            }
                            break;
                        case 1:
                            if(node.getNodoTrasero() != null && !node.getNodoTrasero().isIsObstaculo()){
                                node.getNodoTrasero().setCamino();
                                node = node.getNodoTrasero();
                            }
                            break;
                        case 2:
                            if(node.getNodoSuperior() != null && !node.getNodoSuperior().isIsObstaculo()){
                                node.getNodoSuperior().setCamino();
                                node = node.getNodoSuperior();
                            }
                            break;
                        case 3:
                            if(node.getNodoInferior() != null && !node.getNodoInferior().isIsObstaculo()){
                                node.getNodoInferior().setCamino();
                                node = node.getNodoInferior();
                            }
                            break;
                        case 4:
                            if(node.getNodoDerecha() != null && !node.getNodoDerecha().isIsObstaculo()){
                                node.getNodoDerecha().setCamino();
                                node = node.getNodoDerecha();
                            }
                            break;
                        case 5:
                            if(node.getNodoIzquierda() != null && !node.getNodoIzquierda().isIsObstaculo()){
                                node.getNodoIzquierda().setCamino();
                                node = node.getNodoIzquierda();
                            }
                            break;
                    }
                    * */
                        
                } catch (InterruptedException ex) {
                    Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        //}
    }
    
}
