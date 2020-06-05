/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.*;
import Accounts.*;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Juan Pablo
 */
public abstract class Reader {
    
    protected String patch1;
    protected String patch2;
    
    public String getPatch1() {
        String json = "";
        try (BufferedReader br = new BufferedReader(new FileReader(patch1))) {
            String reader;
            while ((reader = br.readLine()) != null) {
                json += reader;
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
           
        }
        if (json.length() == 0) {
            return "[]";
        } else {
            return json;
        }
    }
    
    public String getPatch2() {
        String json = "";
        try (BufferedReader br = new BufferedReader(new FileReader(patch2))) {
            String reader;
            while ((reader = br.readLine()) != null) {
                json += reader;
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
        if (json.length() == 0) {
            return "[]";
        } else {
            return json;
        }
    }
}
    