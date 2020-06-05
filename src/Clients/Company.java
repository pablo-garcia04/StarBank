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
public class Company extends Client {
    
    private String cName;
    private String nit;
    private String commercialSection;
    
    public Company(String id, String name, String phone, String address, String occupation, String cName, String nit, String commercialSection) {
        super(id, name, phone, address, occupation);
        this.cName = cName;
        this.commercialSection = commercialSection;
        this.nit = nit;
    }

    @Override
    public String getAddress() {
        return super.getAddress(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return super.getName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOccupation() {
        return super.getOccupation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPhone() {
        return super.getPhone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAddress(String address) {
        super.setAddress(address); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(String id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIsSubscribed(boolean isSubscribed) {
        super.setIsSubscribed(isSubscribed); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) {
        super.setName(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setOccupation(String occupation) {
        super.setOccupation(occupation); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPhone(String phone) {
        super.setPhone(phone); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isIsSubscribed() {
        return super.isIsSubscribed(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the cName
     */
    public String getcName() {
        return cName;
    }

    /**
     * @param cName the cName to set
     */
    public void setcName(String cName) {
        this.cName = cName;
    }

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return the commercialSection
     */
    public String getCommercialSection() {
        return commercialSection;
    }

    /**
     * @param commercialSection the commercialSection to set
     */
    public void setCommercialSection(String commercialSection) {
        this.commercialSection = commercialSection;
    }


}
