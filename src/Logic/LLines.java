/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DLines;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FeedzOne
 */
public class LLines {
        Connection cn = LConnection.getConnection();
        public DefaultTableModel showLines(DLines myLines){
        DefaultTableModel myModel = null;
        try{
            String titles[] = {"ID", "Lines"};
            String dts[] = new String [5];
            myModel = new DefaultTableModel(null, titles);
            
            CallableStatement cst = cn.prepareCall("{ call sp_mostrarbuscar_lineas(?)}");
            cst.setString(1, myLines.getLine());
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                dts[0] = rs.getString("LineID");
                dts[1] = rs.getString("Name");   
                myModel.addRow(dts);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return myModel;
    }
        
        public String insertLines(DLines myLines){
        String msg = null;
        try{
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_lineas(?) }");
            cst.setString(1, myLines.getLine());
            
            cst.executeUpdate();
            msg = "si";
            
        }catch(Exception ex){
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }
    
    public String editLines(DLines myLines){
        String msg = null;
        try{
            CallableStatement cst = cn.prepareCall("{ call sp_editar_lineas(?,?) }");
            cst.setInt(1, myLines.getID());
            cst.setString(2, myLines.getLine());
            
            cst.executeUpdate();
            msg = "si";
            
        }catch(Exception ex){
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }
    public String deleteLines(DLines myLines){
        String msg = null;
        try{
            CallableStatement cst = cn.prepareCall("{ call sp_eliminar_lineas(?) }");
            cst.setInt(1, myLines.getID());
            cst.executeUpdate();
            msg = "si"; 
        }catch(Exception ex){
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }
}
