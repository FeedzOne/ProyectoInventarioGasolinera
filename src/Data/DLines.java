/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author FeedzOne
 */
public class DLines {
     int ID;
     String Line;

     public DLines(){
         
     }
     public DLines(int idl, String lines){
         this.ID = idl;
         this.Line = lines;
         
     }
     
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLine() {
        return Line;
    }

    public void setLine(String Line) {
        this.Line = Line;
    }
     
     
}
