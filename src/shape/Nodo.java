/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 *
 * @author ADMIN
 */
public class Nodo extends Shape{
    boolean isObstaculo = false;
    boolean isCamino = false;
    
    private final int posicionx;
    private final int poscionyy;
    private final int posicionz;
    
    private Color color1;
    private Color color2;
    private Color color3;
    
    private Nodo nodoSuperior;
    private Nodo nodoInferior;
    private Nodo nodoDelantero;
    private Nodo nodoTrasero;
    private Nodo nodoIzquierda;
    private Nodo nodoDerecha;
    
    public Nodo(int x, int y, int z, int arista) {
        super(x, y, z, arista);
        
        this.posicionx = x;
        this.poscionyy = y;
        this.posicionz = z;
        
        pcostado = new Polygon();
        psuperor = new Polygon();
        pfrente = new Polygon();
        
        pfrente.addPoint(x, y);
        pfrente.addPoint(x, y - arista);
        pfrente.addPoint(x + arista, y - arista);
        pfrente.addPoint(x + arista, y);
        
        psuperor.addPoint(x, y - arista);
        psuperor.addPoint(x + arista, y - arista);
        psuperor.addPoint(x + arista + arista/2, y - arista - arista/2);
        psuperor.addPoint(x + arista/2, y - arista - arista/2);
        
        pcostado.addPoint(x + arista, y);
        pcostado.addPoint(x + arista, y - arista);
        pcostado.addPoint(x + arista + arista/2, y - arista - arista/2);
        pcostado.addPoint(x + arista + arista/2, y - arista/2);
        
        this.color1 = Color.gray;
        this.color2 = Color.white;
        this.color3 = Color.green;
    }
    
    public void establecerCaminos(Nodo nodoSuperior, Nodo nodoInferior, Nodo nodoDelantero, Nodo nodoTrasero, Nodo nodoIzquierda,Nodo nodoDerecha){
        this.nodoSuperior = nodoSuperior;
        this.nodoInferior = nodoInferior;
        this.nodoDelantero = nodoDelantero;
        this.nodoTrasero = nodoTrasero;
        this.nodoIzquierda = nodoIzquierda;
        this.nodoDerecha = nodoDerecha;
    }

    @Override
    public void update() {
        
    }

    @Override
    public void input() {
        
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(color1);
        //g.drawPolygon(pcostado);
        if(isObstaculo || isCamino)
            g.fill(pcostado);
        
        g.setColor(color2);
        //g.drawPolygon(psuperor);
        if(isObstaculo || isCamino)
            g.fill(psuperor);
        
        g.setColor(color3);
        //g.drawPolygon(pfrente);
        if(isObstaculo || isCamino)
            g.fill(pfrente);
    }
    
    public void setObstaculo(){
        isObstaculo = true;
        
        this.color1 = Color.black;
        this.color2 = Color.gray;
        this.color3 = Color.white;
    }
    
    public void setCamino(){
        isCamino = true;
        
        this.color1 = Color.BLUE;
        this.color2 = Color.cyan;
        this.color3 = Color.DARK_GRAY;
    }

    public int getPosicionx() {
        return posicionx;
    }

    public int getPoscionyy() {
        return poscionyy;
    }

    public int getPosicionz() {
        return posicionz;
    }

    public Nodo getNodoSuperior() {
        return nodoSuperior;
    }

    public void setNodoSuperior(Nodo nodoSuperior) {
        this.nodoSuperior = nodoSuperior;
    }

    public Nodo getNodoInferior() {
        return nodoInferior;
    }

    public void setNodoInferior(Nodo nodoInferior) {
        this.nodoInferior = nodoInferior;
    }

    public Nodo getNodoDelantero() {
        return nodoDelantero;
    }

    public void setNodoDelantero(Nodo nodoDelantero) {
        this.nodoDelantero = nodoDelantero;
    }

    public Nodo getNodoIzquierda() {
        return nodoIzquierda;
    }

    public void setNodoIzquierda(Nodo nodoIzquierda) {
        this.nodoIzquierda = nodoIzquierda;
    }

    public Nodo getNodoDerecha() {
        return nodoDerecha;
    }

    public void setNodoDerecha(Nodo nodoDerecha) {
        this.nodoDerecha = nodoDerecha;
    }

    public Nodo getNodoTrasero() {
        return nodoTrasero;
    }

    public void setNodoTrasero(Nodo nodoTrasero) {
        this.nodoTrasero = nodoTrasero;
    }

    public boolean isIsObstaculo() {
        return isObstaculo;
    }

    public boolean isIsCamino() {
        return isCamino;
    }

    public void setIsCamino(boolean isCamino) {
        this.isCamino = isCamino;
    }
}
