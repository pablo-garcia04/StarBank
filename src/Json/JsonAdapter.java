/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Json;

import Accounts.Account;
import Accounts.CurrentAccount;
import Accounts.SavingsAccount;
import Clients.Client;
import Clients.Company;
import Clients.NaturalPerson;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Juan Pablo
 */
public class JsonAdapter {
    
    public JsonAdapter(){}

    public ArrayList<SavingsAccount> getArraySavings(String json) {
        Gson gson = new Gson();
        SavingsAccount[] savingsArray = gson.fromJson(json, SavingsAccount[].class);
        ArrayList<SavingsAccount> finalSavings = new ArrayList<>();
        finalSavings.addAll(Arrays.asList(savingsArray));
        return finalSavings;
    }

    public ArrayList<CurrentAccount> getArrayCurrents(String json) {
        Gson gson = new Gson();
        CurrentAccount[] currentArray = gson.fromJson(json, CurrentAccount[].class);
        ArrayList<CurrentAccount> finalCurrent = new ArrayList<>();
        finalCurrent.addAll(Arrays.asList(currentArray));
        return finalCurrent;
    }

    public ArrayList<NaturalPerson> getArrayNaturalPersons(String json) {
        Gson gson = new Gson();
        NaturalPerson[] array = gson.fromJson(json, NaturalPerson[].class);
        ArrayList<NaturalPerson> finalArray = new ArrayList<>();
        finalArray.addAll(Arrays.asList(array));
        return finalArray;
    }

    public ArrayList<Company> getArrayCompany(String json) {
        Gson gson = new Gson();
        Company[] array = gson.fromJson(json, Company[].class);
        ArrayList<Company> finalArray = new ArrayList<>();
        finalArray.addAll(Arrays.asList(array));
        return finalArray;
    }
    
}
