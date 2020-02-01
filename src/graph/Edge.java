/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author ADMIN
 */
public class Edge {
    private int peso;
    private Vertex origen;
    private Vertex destino;

    public Edge(int peso, Vertex origen, Vertex destino) {
        this.peso = peso;
        this.origen = origen;
        this.destino = destino;
    }

    public Vertex getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }

    public Vertex getOrigen() {
        return origen;
    }
}
