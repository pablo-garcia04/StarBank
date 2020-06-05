/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Accounts.*;
import Clients.*;

/**
 *
 * @author Juan Pablo
 */
public class Cashier {

    Mediator operator;

    public void addClient(String id, String name, String phone, String address, String occupation, String cName, String nit, String commercialSection) {
        Company c = new Company(id, name, phone, address, occupation, cName, nit, commercialSection);
        operator.addRecord(false, c);
    }

    public void addClient(String id, String name, String phone, String address, String occupation) {
        NaturalPerson p = new NaturalPerson(id, name, phone, address, occupation);
        operator.addRecord(true, p);

    }

    public void addAccount(String id, String idClient, boolean saving) {
        if (saving == true) {
            SavingsAccount a = new SavingsAccount(id, idClient, "prueba");
            operator.addRecord(saving, a);
        } else {
            CurrentAccount a = new CurrentAccount(id, idClient, "prueba");
            operator.addRecord(false, a);
        }
    }

    public void desactivateAccount(String id, String idClient) {
    }

}
