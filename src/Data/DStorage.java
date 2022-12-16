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
public class DStorage {
    String StorageID;
    int LinesID;
    String Description;
    int Stock;
    String MetricUnit;
    double Price;

    public DStorage(){
        
    }
    
    public DStorage(String StorageID, int LinesID, String Description, int Stock, String MetricUnit, double Price) {
        this.StorageID = StorageID;
        this.LinesID = LinesID;
        this.Description = Description;
        this.Stock = Stock;
        this.MetricUnit = MetricUnit;
        this.Price = Price;
    }

    public String getStorageID() {
        return StorageID;
    }

    public void setStorageID(String StorageID) {
        this.StorageID = StorageID;
    }

    public int getLinesID() {
        return LinesID;
    }

    public void setLinesID(int LinesID) {
        this.LinesID = LinesID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getMetricUnit() {
        return MetricUnit;
    }

    public void setMetricUnit(String MetricUnit) {
        this.MetricUnit = MetricUnit;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    
    
}
