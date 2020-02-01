/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import shape.Nodo;

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
    static int BFS(Vertex mat[][][], Point src, 
                            Point dest) 
{ 
    // check source and destination cell 
    // of the matrix have value 1 
    if (mat[dest.getX()][dest.getY()][dest.getZ()] || mat[src.getX()][src.getY()] != 1) 
        return -1; 
  
    boolean [][]visited = new boolean[ROW][COL]; 
      
    // Mark the source cell as visited 
    visited[src.x][src.y] = true; 
  
    // Create a queue for BFS 
    Queue<queueNode> q = new LinkedList<>(); 
      
    // Distance of source cell is 0 
    queueNode s = new queueNode(src, 0); 
    q.add(s); // Enqueue source cell 
  
    // Do a BFS starting from source cell 
    while (!q.isEmpty()) 
    { 
        queueNode curr = q.peek(); 
        Point pt = curr.pt; 
  
        // If we have reached the destination cell, 
        // we are done 
        if (pt.x == dest.x && pt.y == dest.y) 
            return curr.dist; 
  
        // Otherwise dequeue the front cell  
        // in the queue and enqueue 
        // its adjacent cells 
        q.remove(); 
  
        for (int i = 0; i < 4; i++) 
        { 
            int row = pt.x + rowNum[i]; 
            int col = pt.y + colNum[i]; 
              
            // if adjacent cell is valid, has path  
            // and not visited yet, enqueue it. 
            if (isValid(row, col) &&  
                    mat[row][col] == 1 &&  
                    !visited[row][col]) 
            { 
                // mark cell as visited and enqueue it 
                visited[row][col] = true; 
                queueNode Adjcell = new queueNode(new Point(row, col), 
                                                      curr.dist + 1 ); 
                q.add(Adjcell); 
            } 
        } 
    } 
  
    // Return -1 if destination cannot be reached 
    return -1; 
} 
}
