/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author FeedzOne
 */
public class DBillsDetails {
    int BillsDetailsID;
    int BillsID;
    String ProductID;
    int Quantity;
    Double Total;

    public DBillsDetails(){
        
    }
    
    public DBillsDetails(int BillsDetailsID, int BillsID, String ProductID, int Quantity, Double Total) {
        this.BillsDetailsID = BillsDetailsID;
        this.BillsID = BillsID;
        this.ProductID = ProductID;
        this.Quantity = Quantity;
        this.Total = Total;
    }

    public int getBillsDetailsID() {
        return BillsDetailsID;
    }

    public void setBillsDetailsID(int BillsDetailsID) {
        this.BillsDetailsID = BillsDetailsID;
    }

    public int getBillsID() {
        return BillsID;
    }

    public void setBillsID(int BillsID) {
        this.BillsID = BillsID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }
    
}
