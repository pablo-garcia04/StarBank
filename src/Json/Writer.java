/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Json;

import Accounts.SavingsAccount;
import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Juan Pablo
 */
public abstract class Writer {
    
    protected String patch1;
    protected String patch2;
    
    public void addPatch1(String json, String record) {
        String accounts = json.substring(0,json.length()-1); 
        if (accounts.length() == 1) {
            accounts = accounts + record+"]";
        } else {
            accounts = accounts + "," + record+ "]";
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(patch1))) {
            bw.write(accounts);
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        }
    }
    
    public void addPatch2(String json, String record) {
        String accounts = json.substring(0,json.length()-1); 
        if (accounts.length() == 1) {
            accounts = accounts + record+"]";
        } else {
            accounts = accounts + "," + record+ "]";
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(patch2))) {
            bw.write(accounts);
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        }
    }
    
    public void updatePatch1(String json){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(patch1))) {
            bw.write(json);
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        }
    }
    
    public void updatePatch2(String json){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(patch2))) {
            bw.write(json);
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        }
    }
}
