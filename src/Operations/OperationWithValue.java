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
public class OperationWithValue extends Operation {
    private float value;
    
    public OperationWithValue(String name, String idAccount, String nameSucursal, float value){
        this.name = name;
        this.idAccount = idAccount;
        this.value = value;
        this.nameSucursal = nameSucursal;
        date = new Date();
    }
}
