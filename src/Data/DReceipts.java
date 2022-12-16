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
public class DReceipts {
    int ID;
    Date ReceiptDate;
    String DeliveryPerson;
    String ReceivingPerson;

    public DReceipts() {
    }

    public DReceipts(Date ReceiptDate, String DeliveryPerson, String ReceivingPerson, int ID) {
        this.ID = ID;
        this.ReceiptDate = ReceiptDate;
        this.DeliveryPerson = DeliveryPerson;
        this.ReceivingPerson = ReceivingPerson;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public Date getReceiptDate() {
        return ReceiptDate;
    }

    public void setReceiptDate(Date ReceiptDate) {
        this.ReceiptDate = ReceiptDate;
    }

    public String getDeliveryPerson() {
        return DeliveryPerson;
    }

    public void setDeliveryPerson(String DeliveryPerson) {
        this.DeliveryPerson = DeliveryPerson;
    }

    public String getReceivingPerson() {
        return ReceivingPerson;
    }

    public void setReceivingPerson(String ReceivingPerson) {
        this.ReceivingPerson = ReceivingPerson;
    }
    
    
    
}
