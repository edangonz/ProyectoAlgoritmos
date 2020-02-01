/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.List;
import shape.Nodo;

/**
 *
 * @author ADMIN
 */
public class Vertex {
    private Nodo data;
    private List<Edge> edges;
    private boolean vistado;
    private long peso;
    private Vertex antecesor;

    public Vertex() {
        this.edges = new ArrayList();
        this.vistado = false;
    }
    
    public Nodo getData() {
        return data;
    }

    public List<Edge> getEdges() {
        return edges;
    }
    
    public void visited(boolean vistado){
        this.vistado = vistado;
    }

    public boolean isVistado() {
        return vistado;
    }

    public long getDistancia() {
        return peso;
    }

    public void setDistancia(long distancia) {
        this.peso = distancia;
    }

    public Vertex getAntecesor() {
        return antecesor;
    }

    public void setAntecesor(Vertex antecesor) {
        this.antecesor = antecesor;
    }
    
    public int cantidadEdge(){
        return this.edges.size();
    }

    public void setData(Nodo data) {
        this.data = data;
    }
}
