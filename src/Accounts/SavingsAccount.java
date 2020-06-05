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
public class SavingsAccount extends Account{
    
    float interest;
    
    public SavingsAccount(String id, String clientId, String office) {
        super(id, clientId, office);
    }
    
    @Override
    public float withDraw(float value) {
        if (super.isIsActive()) {
            if (super.getBalance() >= 10000 + value + (value * 0.02)) {
                this.setBalance(this.getBalance() - value - (value*Float.parseFloat("0.02")));
                return value*Float.parseFloat("0.02");
            }
        }
        else{
            if(super.getBalance() >= value + (value*0.02)){
                this.setBalance(this.getBalance() - value - (value*Float.parseFloat("0.02")));
                return value*Float.parseFloat("0.02");
            }
        }
        return 0;
    }
    
    
}
