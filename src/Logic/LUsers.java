/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DUsers;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FeedzOne
 */
public class LUsers {
    
    Connection cn = LConnection.getConnection();
    public DefaultTableModel showUsers(DUsers myUsers){
        DefaultTableModel myModel = null;
        try{
            String titles[] = {"ID", "Name", "User", "Key", "Profile"};
            String dts[] = new String [5];
            myModel = new DefaultTableModel(null, titles);
            
            CallableStatement cst = cn.prepareCall("{ call sp_mostrarbuscar_usuarios(?)}");
            cst.setString(1, myUsers.getUser());
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                dts[0] = rs.getString("ID");
                dts[1] = rs.getString("Name");
                dts[2] = rs.getString("User");
                dts[3] = rs.getString("UKey");
                dts[4] = rs.getString("Profile");      
                myModel.addRow(dts);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return myModel;
    }
    
    public String insertUsers(DUsers myUsers){
        String msg = null;
        try{
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_usuarios(?,?,?,?) }");
            cst.setString(1, myUsers.getName());
            cst.setString(2, myUsers.getUser());
            cst.setString(3, myUsers.getKey());
            cst.setString(4, myUsers.getProfile());
            
            cst.executeUpdate();
            msg = "si";
            
        }catch(Exception ex){
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }
    
    public String editUsers(DUsers myUsers){
        String msg = null;
        try{
            CallableStatement cst = cn.prepareCall("{ call sp_editar_usuarios(?,?,?,?,?) }");
            cst.setInt(1, myUsers.getIDUsers());
            cst.setString(2, myUsers.getName());
            cst.setString(3, myUsers.getUser());
            cst.setString(4, myUsers.getKey());
            cst.setString(5, myUsers.getProfile());
            
            cst.executeUpdate();
            msg = "si";
            
        }catch(Exception ex){
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }
    public String deleteUsers(DUsers myUsers){
        String msg = null;
        try{
            CallableStatement cst = cn.prepareCall("{ call sp_eliminar_usuarios(?) }");
            cst.setInt(1, myUsers.getIDUsers());
            cst.executeUpdate();
            msg = "si"; 
        }catch(Exception ex){
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    }

    public String validateLogin(DUsers myUsers) {
        String profile = "";
        try{
            CallableStatement cst = cn.prepareCall("{ call sp_validarusuario(?,?)}");
            cst.setString(1, myUsers.getUser());
            cst.setString(2, myUsers.getKey());
            ResultSet rs = cst.executeQuery();
            if(rs.first()){
                profile = rs.getString("Profile");
            }
            
        }catch(Exception ex){
            ex.printStackTrace();    
        }
        return profile;
    }
}
