/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DReceipts;
import Presentation.FrmRecibos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FeedzOne
 */
public class LReceipts {

    Connection cn = LConnection.getConnection();

    public DefaultTableModel showReceipts() {
        DefaultTableModel myModel = null;
        try {
            String titles[] = {"CODE", "DATE", "DELIVERY", "RECEIVING"};
            String dts[] = new String[4];
            myModel = new DefaultTableModel(null, titles);

            CallableStatement cst = cn.prepareCall("{call sp_mostrar_recibos() }");
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("ReceiptID");
                dts[1] = rs.getString("Date");
                dts[2] = rs.getString("DeliveryPerson");
                dts[3] = rs.getString("ReceivingPerson");
                myModel.addRow(dts);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return myModel;
    }

    public int insertReceipt(DReceipts myReceipts) {

        FrmRecibos myFrmRecibos = new FrmRecibos();
        int idres = 0;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_recibos(?,?,?,?) }");
            cst.setDate(1, myReceipts.getReceiptDate());
            cst.setString(2, myReceipts.getDeliveryPerson());
            cst.setString(3, myReceipts.getReceivingPerson());
            cst.registerOutParameter(4, Types.INTEGER);
            cst.executeUpdate();
            idres = cst.getInt(4);

        } catch (Exception ex) {
            ex.printStackTrace();
            idres = 0;
        }
        return idres;
    }
    
    public DefaultTableModel searchReceipts(DReceipts myid) {
        DefaultTableModel myModel = null;
        try {
            String titles[] = {"CODE", "DATE", "DELIVERY", "RECEIVING"};
            String dts[] = new String[4];
            myModel = new DefaultTableModel(null, titles);

            CallableStatement cst = cn.prepareCall("{ call sp_buscar_recibos(?) }");
            cst.setInt(1, myid.getID());
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("ReceiptID");
                dts[1] = rs.getString("Date");
                dts[2] = rs.getString("DeliveryPerson");
                dts[3] = rs.getString("ReceivingPerson");
                myModel.addRow(dts);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return myModel;
    }
}
