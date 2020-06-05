/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounts;

/**
 *
 * @author Juan Pablo
 */
public class CurrentAccount extends Account {

    public CurrentAccount(String id, String clientId, String office) {
        super(id, clientId, office);
    }

    @Override
    public float withDraw(float value) {
        if (super.isIsActive()) {
            if (super.getBalance() >= 10000 + value + (value * 0.017)) {
                this.setBalance(this.getBalance() - value - (value*Float.parseFloat("0.017")));
                addOperation(value, "Retiro");
                return value*Float.parseFloat("0.017");
            }
        }
        else{
            if(super.getBalance() >= value + (value*0.017)){
                this.setBalance(this.getBalance() - value - (value*Float.parseFloat("0.017")));
                addOperation(value, "Retiro");
                return value*Float.parseFloat("0.017");
            }
        }
        return 0;
    }

}
