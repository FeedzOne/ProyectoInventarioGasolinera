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
public class DReceiptsDetails {
    int ReceiptDetailsID;
    int ReceiptID;
    String ProductID;
    int LinesID;
    int Quantity;
    double Total;

    public DReceiptsDetails() {
    }

    public DReceiptsDetails(int ReceiptDetailsID, int ReceiptID, String ProductID, int LinesID, int Quantity, double Total) {
        this.ReceiptDetailsID = ReceiptDetailsID;
        this.ReceiptID = ReceiptID;
        this.ProductID = ProductID;
        this.LinesID = LinesID;
        this.Quantity = Quantity;
        this.Total = Total;
    }

    public int getReceiptDetailsID() {
        return ReceiptDetailsID;
    }

    public void setReceiptDetailsID(int ReceiptDetailsID) {
        this.ReceiptDetailsID = ReceiptDetailsID;
    }

    public int getReceiptID() {
        return ReceiptID;
    }

    public void setReceiptID(int ReceiptID) {
        this.ReceiptID = ReceiptID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public int getLinesID() {
        return LinesID;
    }

    public void setLinesID(int LinesID) {
        this.LinesID = LinesID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    } 
}
