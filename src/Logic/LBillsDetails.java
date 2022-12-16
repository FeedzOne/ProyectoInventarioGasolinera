/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DBillsDetails;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author FeedzOne
 */
public class LBillsDetails {
    Connection cn = LConnection.getConnection();
    
    public String RegisterDetailsBills(DBillsDetails myDetails){
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_detallefacturas(?,?,?,?) }");
            cst.setInt(1, myDetails.getBillsID());
            cst.setString(2, myDetails.getProductID());
            cst.setInt(3, myDetails.getQuantity());
            cst.setDouble(4, myDetails.getTotal());
            cst.executeUpdate();
            msg = "si";

        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    } 

    public DefaultTableModel showBillDetails(DBillsDetails myDetailsB) {
        DefaultTableModel myModel = null;
        try{
            String titles[] = {"CODE","DESCRIPTION","QUANTITY","UNIT","PRICE/UNIT","TOTAL"};
            String dts[] = new String[6];
            myModel = new DefaultTableModel(null,titles);
            CallableStatement cst = cn.prepareCall("{ call sp_mostrardetallefacturas(?) }");
            cst.setInt(1, myDetailsB.getBillsID());
            
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                dts[0] = rs.getString("d.MaterialID");
                dts[1] = rs.getString("p.Description");
                dts[2] = rs.getString("d.Quantity");
                dts[3] = rs.getString("p.MetricUnit");
                dts[4] = rs.getString("p.Price");
                dts[5] = rs.getString("d.Total");
                myModel.addRow(dts);
            } 
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return myModel;
    }
}
