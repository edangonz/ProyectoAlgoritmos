/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author ADMIN
 */
public class GraphLA {
    private List<Vertex> vertexes;

    public GraphLA() {
        this.vertexes = new ArrayList<>();
    }
    
    public boolean isEmpty(){
        return vertexes.isEmpty();
    }
    
    public boolean addVertex(Vertex data){
        //Vertex v = new Vertex(data);
        //if(data==null || this.vertexes.contains(data))
        //    return false;
        return this.vertexes.add(data);
    }
    
    public boolean removeVertex(Vertex data){
        if(data==null)
            return false;
        
        //Vertex v = new Vertex(data);
        
        Iterator<Vertex> it = this.vertexes.iterator();
        
        while(it.hasNext()){
            Vertex v1 = it.next();
            ListIterator<Edge> it2 = v1.getEdges().listIterator();
            while(it2.hasNext()){
                Edge e1 = it2.next();
                if(e1.getDestino().equals(data))
                    it.remove();
            }
        }
        data.getEdges().clear();
        return this.vertexes.remove(data);
    }
    
    public boolean addEdge(Vertex origen, Vertex destino, int peso){
        if(origen!=null && destino!=null){
                Edge e1 = new Edge(peso, origen, destino);
                if(!origen.getEdges().contains(e1)){
                    origen.getEdges().add(e1);
                    return true;
                }
        }
        return false;
    }
    
    public boolean removeEdge(Vertex origen, Vertex destino){
        if(origen!=null && destino!=null){
            Edge e1 = new Edge(1, origen, destino);
            origen.getEdges().remove(e1);
            return true;
        }
        return false;
    }
}
