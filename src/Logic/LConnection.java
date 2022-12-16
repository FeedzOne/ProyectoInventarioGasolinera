/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author FeedzOne
 */
public class LConnection {
    static Connection con = null;
    
    //CONECTANDO A LA BASE DE DATOS
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBAlmacen?characterEncoding=utf8","root","");           
            //JOptionPane.showMessageDialog(null, "Successful connection!","Warning",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
}
