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
public class Plane extends Shape{
    
    private float multiplicadorx;
    private float multiplicadory;
    private float multiplicadorz;
    
    public Plane(int x, int y, int z, int arista, int ejex, int ejey, int ejez) {
        super(x, y, z, arista);
        
        generarPlano(ejex, ejey, ejez);
        
        pcostado = new Polygon();
        psuperor = new Polygon();
        pfrente = new Polygon();
        
        /**
        pfrente.addPoint(x, y);
        pfrente.addPoint(x, (int) (y - arista * multiplicadorz));
        pfrente.addPoint((int) (x + arista * multiplicadory), (int) (y - arista * multiplicadorz));
        pfrente.addPoint((int) (x + arista * multiplicadory), y);
        
        psuperor.addPoint(x, y);
        psuperor.addPoint((int) (x + arista * multiplicadory), y);
        psuperor.addPoint((int) (x + arista/2 * multiplicadory), (int) (y + arista/2 * multiplicadorx));
        psuperor.addPoint((int) (x - arista/2 * multiplicadory), (int) (y + arista/2 * multiplicadorx));
        
        pcostado.addPoint(x , y);
        pcostado.addPoint(x, (int) (y - arista * multiplicadorz));
        pcostado.addPoint((int) (x - arista/2  * multiplicadory), (int) (y + arista/2 * multiplicadorx) - (int) (arista * multiplicadorz));
        pcostado.addPoint((int) (x - arista/2  * multiplicadory), (int) (y + arista/2 * multiplicadorx));
        * */
        
        /**
        pfrente.addPoint(x, y);
        pfrente.addPoint(x, (y - arista * ejez));
        pfrente.addPoint((x + arista * ejey),(y - arista * ejez));
        pfrente.addPoint((x + arista * ejey), y);
        
        psuperor.addPoint(x, y);
        psuperor.addPoint(x + arista * ejey, y);
        psuperor.addPoint(x + arista * ejey - arista/2 * ejey, y + arista/2 * ejex);
        psuperor.addPoint(x - arista/2 * ejey, y + arista/2 * ejex);
        
        pcostado.addPoint(x , y);
        pcostado.addPoint(x, y - arista * ejez);
        pcostado.addPoint(x - arista/2 * ejey,y + arista/2 * ejex - arista * ejez);
        pcostado.addPoint(x - arista/2 * ejey,y + arista/2 * ejex);
        * */
    }

    @Override
    public void update() {
        
    }

    @Override
    public void input() {
        
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.white);
        
        g.drawPolygon(pcostado);
        
        g.drawPolygon(psuperor);
        
        g.drawPolygon(pfrente);
    }
    
    public void generarPlano (int x, int y, int z){
        int max = Math.max(x, y);
        max = Math.max(max, z);
        
        multiplicadorx = (float) x/max;
        
        multiplicadory = (float) y/max;
        
        multiplicadorz = (float) z/max;
    }
}
