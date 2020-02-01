/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author ADMIN
 */
public class Vector2f {
    
    public float x;
    public float y;
    
    public static float wordlX;
    public static float wordlY;
    
    public Vector2f (){
        x=0;
        y=0;
    }
    
    public Vector2f (Vector2f pos){
        new Vector2f(pos.x,pos.y);
    }
    
    public Vector2f (float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public void addX(float f) {x+=f;}
    public void addY(float f) {y+=f;}
    
    public void setX(float f) {x=f;}
    public void setY(float f) {y=f;}
    
    public void setVector(Vector2f vec){
        this.x = vec.x;
        this.y = vec.y;
    }
    
    public void setVector(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public static void setWorldVar(float x, float y){
        wordlX = x;
        wordlY = y;
    }

    public static float getWorldVarX(float x) {
        return x - wordlX;
    }

    public static float getWorldVarY(float y) {
        return y - wordlY;
    }
    
    public Vector2f getWorldVar(){
        return new Vector2f(x-wordlX,y-wordlY);
    }
    
    public Vector2f getCamvar(){
        return new Vector2f(x + wordlX, y + wordlY);
    }
    
    @Override
    public String toString(){
        return x+","+y;
    }
}
