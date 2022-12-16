/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DReceiptsDetails;
import Data.DReceiptsDetails;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FeedzOne
 */
public class LReceiptsDetails {
    Connection cn = LConnection.getConnection();
    
    public String RegisterDetailsReceipts(DReceiptsDetails myDetails){
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_detallerecibo(?,?,?,?,?) }");
            cst.setInt(1, myDetails.getReceiptID());
            cst.setString(2, myDetails.getProductID());
            cst.setInt(3, myDetails.getLinesID());
            cst.setInt(4, myDetails.getQuantity());
            cst.setDouble(5, myDetails.getTotal());
            cst.executeUpdate();
            msg = "si";

        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "no";
        }
        return msg;
    } 
    
    public DefaultTableModel showReceiptDetails(DReceiptsDetails myDetailsB) {
        DefaultTableModel myModel = null;
        try{
            String titles[] = {"CODE","DESCRIPTION","QUANTITY","UNIT","PRICE/UNIT","LINES","TOTAL"};
            String dts[] = new String[7];
            myModel = new DefaultTableModel(null,titles);
            CallableStatement cst = cn.prepareCall("{ call sp_mostrardetallerecibos(?) }");
            cst.setInt(1, myDetailsB.getReceiptID());
            
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                dts[0] = rs.getString("d.ProductID");
                dts[1] = rs.getString("p.Description");
                dts[2] = rs.getString("d.Quantity");
                dts[3] = rs.getString("p.MetricUnit");
                dts[4] = rs.getString("p.Price");
                dts[5] = rs.getString("l.Name");
                dts[6] = rs.getString("d.Total");
                myModel.addRow(dts);
            } 
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return myModel;
    }
    
}
