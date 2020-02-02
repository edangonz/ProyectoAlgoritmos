/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plane3d;

import graph.GraphLA;
import graph.Vertex;
import shape.Nodo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import util.MouseHandler;
import util.Simulacion;
import java.awt.Dimension;
import java.util.Random;
import state.State;

/**
 *
 * @author ADMIN
 */
public class Plane3D extends JPanel implements Runnable{
    private Random r = new Random();
    
    public static int width;
    public static int height;
    
    public int arista;
    
    public static int oldFrameCount;
    
    private Thread thread;
    private boolean running = false;
    
    private BufferedImage img;
    private Graphics2D g;
    
    private MouseHandler mouse;
    
    private State dibujador;
    
    private Vertex[][][] matriz;
    
    private int base;
    private int profundidad;
    private int altura;
    
    private GraphLA grafo;
    
    private int mindData;
    
    public Plane3D(int width, int height){
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width,height));
        setFocusable(true);
        requestFocus();
        
        grafo = new GraphLA();
        
        mindData = 100;
        
        this.profundidad = mindData;
        this.base = mindData;
        this.altura = mindData;
        
        matriz = new Vertex[profundidad][base][altura];
    }

    public void addNotify(){
        super.addNotify();
        
        if (thread == null){
            thread = new Thread (this, "Esta es una nueva notificacion: ");
            thread.start();
        }
    }
    
    public void init(){
        running = true;
        
        int max = Math.max(profundidad, base);
        max = Math.max(max, altura);
        
        arista = 500;
        int aristaCubos = arista/max;
        
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) img.getGraphics();
        
        mouse = new MouseHandler(this);
        
        generarRepreGrafica(aristaCubos);
        
        generarObstaculos(100);
        
        generarGrafo();
        
        Thread simulacionColores = new Thread(new Simulacion(matriz, profundidad, base, altura, grafo, mindData));
        simulacionColores.start();
        
        dibujador = new State(profundidad, base, altura, arista ,aristaCubos, matriz);
    }
    
    private void generarRepreGrafica(int aristaCubos){
        for(int i = 0; i < this.profundidad; i++){
            for(int j = 0; j < this.base; j++){
                for(int k = 0; k < this.altura; k++){
                    Nodo tempNodo = new Nodo(Plane3D.width/2 - arista/4 + aristaCubos * j - ((aristaCubos/2)*(i + 1)), Plane3D.height/2 + arista/4 - aristaCubos * k + (aristaCubos/2)*(i + 1), 0, aristaCubos);;
                    matriz[i][j][k] = new Vertex();
                    Vertex tempVertex = matriz[i][j][k];
                    tempVertex.setData(tempNodo);
                    grafo.addVertex(tempVertex);
                }
            }
        }
    }
    
    private void generarGrafo(){
        for(int i = 0; i < this.profundidad; i++){
            for(int j = 0; j < this.base; j++){
                for(int k = 0; k < this.altura; k++){
                    nodoAnadirCamino(i, j, k, matriz[i][j][k]);
                }
            }
        }
    }
    
    private void nodoAnadirCamino(int profundidad, int base, int altura, Vertex tempNode){
        if(altura < this.altura - 1){
            Vertex tempNodoLlegada = matriz[profundidad][base][altura + 1];
            tempNode.setVertexSuperior(tempNodoLlegada);
            grafo.addEdge(tempNode, tempNodoLlegada, 1);
        }
        if(altura > 0){
            Vertex tempNodoLlegada = matriz[profundidad][base][altura - 1];
            tempNode.setVertexInferior(tempNodoLlegada);
            grafo.addEdge(tempNode, tempNodoLlegada, 1);
        }
        
        if(profundidad < this.profundidad - 1){
            Vertex tempNodoLlegada = matriz[profundidad + 1][base][altura];
            tempNode.setVertexDelantero(tempNodoLlegada);
            grafo.addEdge(tempNode, tempNodoLlegada, 1);
        }
        if(profundidad > 0){
            Vertex tempNodoLlegada = matriz[profundidad - 1][base][altura];
            tempNode.setVertexTrasero(tempNodoLlegada);
            grafo.addEdge(tempNode, tempNodoLlegada, 1);
        }
        
        if(base < this.base - 1){
            Vertex tempNodoLlegada = matriz[profundidad][base + 1][altura];
            tempNode.setVertexDerecha(tempNodoLlegada);
            grafo.addEdge(tempNode, tempNodoLlegada, 1);
        }
        if(base > 0){
            Vertex tempNodoLlegada = matriz[profundidad][base - 1][altura];
            tempNode.setVertexIzquierda(tempNodoLlegada);
            grafo.addEdge(tempNode, tempNodoLlegada, 1);
        }
    }
    
    private void generarObstaculos(int numeroObstaculos){
        for(int i = 0; i < numeroObstaculos; i++){
            int numero1;
            int numero2;
            int numero3;
            
            do{
                numero1 = r.nextInt(base - 6) + 3;
                numero2 = r.nextInt(profundidad - 6) + 3;
                numero3 = r.nextInt(altura - 6) + 3;
            
                crearObstaculo(numero2, numero1, numero3);
            } while(!this.matriz[numero2][numero1][numero3].isObstaculo());
        }
    }
    
    private void crearObstaculo(int profundidad, int base, int altura){
        for(int i = profundidad - 3; i < profundidad + 3; i++){
            for(int j = base - 3; j < base + 3 ; j++){
                for(int k = altura - 3; k < altura + 3; k++)
                    this.matriz[i][j][k].setObstaculo();
            }
        }
        
    }
    
    @Override
    public void run() {
        init();
        
        final double GAME_HERTZ = 60.0;
        final double TBU = 1000000000/GAME_HERTZ;
        
        final int MURB = 5;
        
        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;
        
        final double TARGET_FPS = 60;
        final double TTBR = 1000000000 / TARGET_FPS;
        
        int frameCount = 0;
        int lastSecondTime = (int) (lastUpdateTime/1000000000);
        oldFrameCount = 0;
        
        while (running){
            double now = System.nanoTime();
            int updateCount = 0; 
            
            while(((now-lastUpdateTime) > TTBR) && (updateCount < MURB)){
                update();
                input(mouse);
                lastUpdateTime += TBU;
                updateCount ++;
            }
            
            if((now - lastUpdateTime)>TBU){
                lastUpdateTime = now - TBU;
            }
            
            input(mouse);
            update();
            render();
            draw();
            
            lastRenderTime = now;
            frameCount++;
            
            int thisSecond = (int) (lastUpdateTime/1000000000);
            if(thisSecond > lastSecondTime){
                if(frameCount != oldFrameCount)
                    oldFrameCount = frameCount;
                
                frameCount = 0;
                lastSecondTime = thisSecond;
            }
            
            while((now - lastRenderTime) < TTBR && (now  - lastUpdateTime) < TBU){
                Thread.yield();
                
                try{
                    Thread.sleep(1);
                }
                catch (Exception e){
                    System.out.println("Error: yilied reander");
                }
                
                now = System.nanoTime();
            }
        }
    }
    
    //private int x = 0;
    
    public void update(){
       dibujador.update();
    }
    
    public void input(MouseHandler mouse){
        dibujador.input(mouse);
    }
    
    public void render(){
        if(g !=  null){
            g.setColor(new Color(66,134,244));
            g.fillRect(0, 0, width, height);
            dibujador.render(g);
        }
    }
    
    public void draw(){
        Graphics g2 = (Graphics) this.getGraphics();
        g2.drawImage(img, 0, 0, width, height, null);
        g2.dispose();
    }
}
