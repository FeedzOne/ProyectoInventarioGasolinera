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
public class DSuppliers {
    int ID;
    String Name;
    String Phone;
    String Address;
    
    public DSuppliers(){
        
    }

    public DSuppliers(int ID, String Name, String Phone, String Address) {
        this.ID = ID;
        this.Name = Name;
        this.Phone = Phone;
        this.Address = Address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
}
