/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.namer;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author rxiao
 */
public class PointNamer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ArrayList<String> people = new ArrayList<String>();
        people.add("307094");
        //people.add("308059");
        //people.add("310162");
        //people.add("314601");
        //people.add("320182");
        //people.add("B");
        //people.add("C");
        //people.add("E");
        
        String username = System.getProperty("user.name");
        
        for(int index = 0; index < people.size(); index ++){
            String name = people.get(index);
            String objdirFinal = "C:\\Users\\" + username + "\\Desktop\\325276.obj";
            //String objdirICP = "C:\\Users\\" + username + "\\Desktop\\TestData Updated Set\\" + name + "\\"  + name + " ICP.obj";
            String objdirSEL = "C:\\Users\\" + username + "\\Desktop\\325276 SEL.obj";
            
            ObjReader objFinal = new ObjReader(objdirFinal);
            //ObjReader objICP = new ObjReader(objdirICP);
            ObjReader objSEL = new ObjReader(objdirSEL);
            
            /*ArrayList<Integer> OrderICP = new ArrayList<Integer>();
            for(int i = 0 ; i < objICP.compileVertices().size(); i ++){
                Vertex base = objICP.compileVertices().get(i);
                int closest = -1;
                double dist = Double.POSITIVE_INFINITY;
                for(int j = 0; j < objSEL.compileVertices().size(); j ++){
                    Vertex potential = objSEL.compileVertices().get(j);
                    double distance = Math.sqrt(Math.pow(base.getX() - potential.getX(),2) + Math.pow(base.getY() - potential.getY(),2) + Math.pow(base.getZ() - potential.getZ(),2));
                    if(distance < dist){
                        closest = j;
                        dist = distance;
                    }
                }
                OrderICP.add(closest);
            }*/
            
            ArrayList<Integer> OrderFinal = new ArrayList<Integer>();
            for(int i = 0 ; i < objFinal.compileVertices().size(); i ++){
                Vertex base = objFinal.compileVertices().get(i);
                int closest = -1;
                double dist = Double.POSITIVE_INFINITY;
                for(int j = 0; j < objSEL.compileVertices().size(); j ++){
                    Vertex potential = objSEL.compileVertices().get(j);
                    double distance = Math.sqrt(Math.pow(base.getX() - potential.getX(),2) + Math.pow(base.getY() - potential.getY(),2) + Math.pow(base.getZ() - potential.getZ(),2));
                    if(distance < dist){
                        closest = j;
                        dist = distance;
                    }
                }
                OrderFinal.add(closest);
            }
            
            /*String ICP_dir = "C:\\Users\\" + username + "\\Desktop\\Final Results\\" + name + "\\"  + name + " ICP.obj";
            PrintWriter writer = new PrintWriter(ICP_dir, "UTF-8");
            for(int i = 0; i < OrderICP.size(); i ++){
                writer.print("# ");
                writer.println(objSEL.compileVertices().get(OrderICP.get(i)).getname());
                writer.print("v ");
                writer.print(objICP.compileVertices().get(i).getX());
                writer.print(" ");
                writer.print(objICP.compileVertices().get(i).getY());
                writer.print(" ");
                writer.println(objICP.compileVertices().get(i).getZ());
            }
            writer.close();*/
            
            String Final_dir = "C:\\Users\\" + username + "\\Desktop\\325276 Final.obj";
            PrintWriter writer1 = new PrintWriter(Final_dir, "UTF-8");
            for(int i = 0; i < OrderFinal.size(); i ++){
                writer1.print("# ");
                writer1.println(objSEL.compileVertices().get(OrderFinal.get(i)).getname());
                writer1.print("v ");
                writer1.print(objFinal.compileVertices().get(i).getX());
                writer1.print(" ");
                writer1.print(objFinal.compileVertices().get(i).getY());
                writer1.print(" ");
                writer1.println(objFinal.compileVertices().get(i).getZ());
            }
            writer1.close();
        }
    }
}
