/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.namer;

/**
 *
 * @author rxiao
 */
public class Vertex {
    private double x;
    private double y;
    private double z;
    private String name;
    
    public Vertex(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vertex(double x, double y, double z, String name){
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }
    
    public String getname(){
        return name;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public double getZ(){
        return z;
    }
}
