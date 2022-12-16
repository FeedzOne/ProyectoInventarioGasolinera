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
public class DUsers {

    int IDUsers;
    String Name;
    String User;
    String Key;
    String Profile;

    
    public DUsers(){
        
    }
    
    
    public DUsers(int IDUsers, String Name, String User, String Key, String Profile) {
    this.IDUsers = IDUsers;
    this.Name = Name;
    this.User = User;
    this.Key = Key;
    this.Profile = Profile;
    }
    
    
    public int getIDUsers() {
        return IDUsers;
    }

    public void setIDUsers(int IDUsers) {
        this.IDUsers = IDUsers;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String Key) {
        this.Key = Key;
    }

    public String getProfile() {
        return Profile;
    }

    public void setProfile(String Profile) {
        this.Profile = Profile;
    }
}
