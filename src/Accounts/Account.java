/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounts;

import Controllers.Mediator;
import Json.OperationWriter;
import Operations.OperationWithOutValue;
import Operations.OperationWithValue;

/**
 *
 * @author Juan Pablo
 */
public abstract class Account {

    protected String id;
    protected String clientId;
    protected float balance;
    protected boolean isActive;
    protected String office;

    public Account(String id, String clientId, String office) {
        this.clientId = clientId;
        this.office = office;
        this.balance = 0;
        this.id = id;
        this.isActive = false;
    }

    public void consign(float value) {
        if (value >= 20000) {
            if (balance < 10000) {
                isActive = true;
            }
        }
        balance += value;
        addOperation(value, "Consignacion");
    }

    abstract public float withDraw(float value);

    public void addOperation(float value, String name) {
        OperationWithValue op = new OperationWithValue(name, this.id, this.office, value);
        Mediator mediator = new Mediator();
        mediator.addRecord(true, op);
    }

    public void addOperation(String name) {
        OperationWithOutValue op = new OperationWithOutValue(name, this.id, this.office);
        Mediator mediator = new Mediator();
        mediator.addRecord(false, op);
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
     * @return the balance
     */
    public float getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(float balance) {
        this.balance = balance;
    }

    /**
     * @return the isActive
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * @return the clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * @return the office
     */
    public String getOffice() {
        return office;
    }

    /**
     * @param office the office to set
     */
    public void setOffice(String office) {
        this.office = office;
    }

}
