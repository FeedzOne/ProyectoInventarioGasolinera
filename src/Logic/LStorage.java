/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DStorage;
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
public class LStorage {

    Connection cn = LConnection.getConnection();

    public DefaultTableModel showInventory(DStorage myProduct) {
        DefaultTableModel myModel = null;
        try {
            String titles[] = {"CODE", "DESCRIPTION", "QUANTITY", "UNIT", "PRICE", "TOTAL", "LINE"};
            String dts[] = new String[7];
            myModel = new DefaultTableModel(null, titles);

            CallableStatement cst = cn.prepareCall("{ call sp_mostrar_inventario(?)}");
            cst.setString(1, myProduct.getStorageID());
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("a.StorageID");
                dts[1] = rs.getString("a.Description");
                dts[2] = rs.getString("a.Stock");
                dts[3] = rs.getString("a.MetricUnit");
                dts[4] = rs.getString("a.Price");
                dts[5] = rs.getString("Total");
                dts[6] = rs.getString("l.Name");
                myModel.addRow(dts);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return myModel;
    }

    public String[] searchshowProducts(DStorage myProducts) {
        String dts[] = null;
        try {
            dts = new String[6];
            CallableStatement cst = cn.prepareCall("{ call sp_mostrarbuscar_productos(?) }");
            cst.setString(1, myProducts.getStorageID());

            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("StorageID");
                dts[1] = rs.getString("Description");
                dts[2] = "1";
                dts[3] = rs.getString("MetricUnit");
                dts[4] = rs.getString("Price");
                dts[5] = rs.getString("Price");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dts;
    }

    public String[] searchshowProductsRec(DStorage myProducts) {
        String dts[] = null;
        try {
            dts = new String[8];
            CallableStatement cst = cn.prepareCall("{ call sp_mostrarproductosrecibos(?) }");
            cst.setString(1, myProducts.getStorageID());

            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("a.StorageID");
                dts[1] = rs.getString("a.Description");
                dts[2] = "1";
                dts[3] = rs.getString("a.Price");
                dts[4] = rs.getString("a.MetricUnit");
                dts[5] = rs.getString("l.Name");
                dts[6] = rs.getString("a.Price");
                dts[7] = rs.getString("l.LineID");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dts;
    }

    public String insertProducts(DStorage myProducts) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_insertar_productos(?,?,?,?,?,?) }");
            cst.setString(1, myProducts.getStorageID());
            cst.setInt(2, myProducts.getLinesID());
            cst.setString(3, myProducts.getDescription());
            cst.setInt(4, myProducts.getStock());
            cst.setDouble(5, myProducts.getPrice());
            cst.setString(6, myProducts.getMetricUnit());

            cst.executeUpdate();
            msg = "Successfully registered";

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return msg;
    }

    public String decreaseStock(DStorage myProducts) {
        String msg = null;
        try {
            CallableStatement cst = cn.prepareCall("{ call sp_disminuir_stock(?,?) }");
            cst.setString(1, myProducts.getStorageID());
            cst.setInt(2, myProducts.getStock());

            cst.executeUpdate();
            msg = "Successfully updated";

        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "Uh oh, an error has occurred";
        }
        return msg;
    }
}
