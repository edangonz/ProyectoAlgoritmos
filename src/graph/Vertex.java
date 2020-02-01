/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import shape.Nodo;

/**
 *
 * @author ADMIN
 */
public class Vertex {
    private Nodo data;
    private List<Edge> edges;
    private boolean vistado;
    private int peso;
    private boolean visited=false;
    private List<Vertex> camino;
    private int prueba;
    
    
    private Vertex vertexantecesor;
    private Vertex vertexSuperior;
    private Vertex vertexInferior;
    private Vertex vertexDelantero;
    private Vertex vertexTrasero;
    private Vertex vertexIzquierda;
    private Vertex vertexDerecha;

    public Vertex() {
        this.edges = new ArrayList();
        this.vistado = false;
        this.camino=new LinkedList<>();
    }
    
    
    public Nodo getData2() {
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

    public int getDistancia() {
        return peso;
    }

    public void setDistancia(int distancia) {
        this.peso = distancia;
    }

    public Vertex getAntecesor() {
        return vertexantecesor;
    }

    public void setAntecesor(Vertex antecesor) {
        this.vertexantecesor = antecesor;
    }

    public Vertex getVertexantecesor() {
        return vertexantecesor;
    }

    public void setVertexantecesor(Vertex vertexantecesor) {
        this.vertexantecesor = vertexantecesor;
    }

    public Vertex getVertexSuperior() {
        return vertexSuperior;
    }

    public void setVertexSuperior(Vertex vertexSuperior) {
        this.vertexSuperior = vertexSuperior;
    }

    public Vertex getVertexInferior() {
        return vertexInferior;
    }

    public void setVertexInferior(Vertex vertexInferior) {
        this.vertexInferior = vertexInferior;
    }

    public Vertex getVertexDelantero() {
        return vertexDelantero;
    }

    public void setVertexDelantero(Vertex vertexDelantero) {
        this.vertexDelantero = vertexDelantero;
    }

    public Vertex getVertexTrasero() {
        return vertexTrasero;
    }

    public void setVertexTrasero(Vertex vertexTrasero) {
        this.vertexTrasero = vertexTrasero;
    }

    public Vertex getVertexIzquierda() {
        return vertexIzquierda;
    }

    public void setVertexIzquierda(Vertex vertexIzquierda) {
        this.vertexIzquierda = vertexIzquierda;
    }

    public Vertex getVertexDerecha() {
        return vertexDerecha;
    }

    public void setVertexDerecha(Vertex vertexDerecha) {
        this.vertexDerecha = vertexDerecha;
    }
    
    
    
    public int cantidadEdge(){
        return this.edges.size();
    }

    public void setData(Nodo data) {
        this.data = data;
    }
    
    public void setCamino(boolean isCamino){
        if(isCamino)
            this.data.setCamino();
        else
            this.data.setDesmarcarCamino();
    }
    
    public boolean isIsCamino(){
        return this.data.isIsCamino();
    }
    
    public void render(Graphics2D g){
        this.data.render(g);
    }
    
    public void setObstaculo(){
        this.data.setObstaculo();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getPrueba() {
        return prueba;
    }

    public void setPrueba(int prueba) {
        this.prueba = prueba;
    }
    
    
}
