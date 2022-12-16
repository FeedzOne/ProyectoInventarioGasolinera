/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Date;

/**
 *
 * @author FeedzOne
 */
public class DSales {

    int id;
    int LinesID;
    int SupplierID;
    Date EntryDate;

    public DSales() {

    }

    public DSales(int LinesID, int SupplierID, Date EntryDate, int id) {
        this.id = id;
        this.LinesID = LinesID;
        this.SupplierID = SupplierID;
        this.EntryDate = EntryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLinesID() {
        return LinesID;
    }

    public void setLinesID(int LinesID) {
        this.LinesID = LinesID;
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(int SupplierID) {
        this.SupplierID = SupplierID;
    }

    public Date getEntryDate() {
        return EntryDate;
    }

    public void setEntryDate(Date EntryDate) {
        this.EntryDate = EntryDate;
    }

}
