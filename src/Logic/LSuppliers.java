/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DSuppliers;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FeedzOne
 */
public class LSuppliers {
    Connection cn = LConnection.getConnection();
    public DefaultTableModel showSuppliers(DSuppliers mySuppliers){
        DefaultTableModel myModel = null;
        try{
            String titles[] = {"ID", "Name", "Phone", "Address"};
            String dts[] = new String [5];
            myModel = new DefaultTableModel(null, titles);
            
            CallableStatement cst = cn.prepareCall("{ call sp_mostrarbuscar_proveedores(?)}");
            cst.setString(1, mySuppliers.getName());
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                dts[0] = rs.getString(1);
                dts[1] = rs.getString(2);
                dts[2] = rs.getString(3);
                dts[3] = rs.getString(4);    
                myModel.addRow(dts);
            }
            
        }catch(Exception ex){
            
        }
        return myModel;
    }
    
    public String insertSuppliers(DSuppliers mySuppliers){
        String msg = null;
        try{
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_proveedores(?,?,?) }");
            cst.setString(1, mySuppliers.getName());
            cst.setString(2, mySuppliers.getPhone());
            cst.setString(3, mySuppliers.getAddress());
            cst.executeUpdate();
            msg = "si";
            
        }catch(Exception ex){
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }
    
    public String editSuppliers(DSuppliers mySuppliers){
        String msg = null;
        try{
            CallableStatement cst = cn.prepareCall("{ call sp_editar_proveedores(?,?,?,?) }");
            cst.setInt(1, mySuppliers.getID());
            cst.setString(2, mySuppliers.getName());
            cst.setString(3, mySuppliers.getPhone());
            cst.setString(4, mySuppliers.getAddress());
            
            cst.executeUpdate();
            msg = "si";
            
        }catch(Exception ex){
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }
    public String deleteSuppliers(DSuppliers mySuppliers){
        String msg = null;
        try{
            CallableStatement cst = cn.prepareCall("{ call sp_eliminar_proveedores(?) }");
            cst.setInt(1, mySuppliers.getID());
            cst.executeUpdate();
            msg = "si"; 
        }catch(Exception ex){
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }
}
