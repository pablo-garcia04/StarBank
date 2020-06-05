/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import java.util.Date;

/**
 *
 * @author Juan Pablo
 */
public class OperationWithOutValue extends Operation{
    
    public OperationWithOutValue(String name, String idAccount, String nameSucursal){
        this.name = name;
        this.idAccount = idAccount;
        this.nameSucursal = nameSucursal;
        date = new Date();
    }
}
