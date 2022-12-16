/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DSales;
import Presentation.FrmVentas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FeedzOne
 */
public class LSales {

    Connection cn = LConnection.getConnection();

    public DefaultTableModel showSales() {
        DefaultTableModel myModel = null;
        try {
            String titles[] = {"CODE", "SUPPLIER", "LINE", "ENTRY DATE"};
            String dts[] = new String[4];
            myModel = new DefaultTableModel(null, titles);

            CallableStatement cst = cn.prepareCall("{ call sp_mostrar_facturas()}");
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("f.BillsID");
                dts[1] = rs.getString("p.SupplierName");
                dts[2] = rs.getString("l.Name");
                dts[3] = rs.getString("f.EntryDate");
                myModel.addRow(dts);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return myModel;
    }

    public int insertSale(DSales mySales) {
        FrmVentas myFrmVentas = new FrmVentas();
        int idres = 0;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_facturas(?,?,?,?) }");
            cst.setInt(1, mySales.getLinesID());
            cst.setInt(2, mySales.getSupplierID());
            cst.setDate(3, mySales.getEntryDate());
            cst.registerOutParameter(4, Types.INTEGER);
            cst.executeUpdate();
            idres = cst.getInt(4);

        } catch (Exception ex) {
            ex.printStackTrace();
            idres = 0;
        }
        return idres;
    }
    
     public DefaultTableModel searchReceipts(DSales myid) {
        DefaultTableModel myModel = null;
        try {
            String titles[] = {"CODE", "LINE", "SUPPLIER", "ENTRY LINE"};
            String dts[] = new String[4];
            myModel = new DefaultTableModel(null, titles);

            CallableStatement cst = cn.prepareCall("{ call sp_buscar_facturas(?) }");
            cst.setInt(1, myid.getId());
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("BillsID");
                dts[1] = rs.getString("LineId");
                dts[2] = rs.getString("SupplierID");
                dts[3] = rs.getString("EntryDate");
                myModel.addRow(dts);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return myModel;
     }

}
