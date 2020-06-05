/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clients;


/**
 *
 * @author Juan Pablo
 */
public abstract class Client {
    
    protected String id;
    protected String name;
    protected String phone;
    protected String address;
    protected String occupation;
    protected boolean isSubscribed;
    
    public Client(String id, String name, String phone, String address, String occupation){
        
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.name = name;
        this.occupation = occupation;
        this.isSubscribed = false;
        
    } 
    
    public void enterKey(String id, String pass){
    
        
    
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * @param occupation the occupation to set
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * @return the isSubcribed
     */
    public boolean isIsSubscribed() {
        return isSubscribed;
    }

    /**
     * @param isSubscribed the isSubscribed to set
     */
    public void setIsSubscribed(boolean isSubscribed) {
        this.isSubscribed = isSubscribed;
    }
}
