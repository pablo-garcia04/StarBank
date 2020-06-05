/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Accounts.CurrentAccount;
import Accounts.SavingsAccount;
import Clients.Company;
import Clients.NaturalPerson;
import Json.AccountReader;
import Json.ClientReader;
import Json.JsonAdapter;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.swing.JLabel;
import view.Message;

/**
 *
 * @author Juan Pablo
 */
public class Validator {

    private final AccountReader readerA;
    private final ClientReader readerC;
    private final Gson gson;
    private final JsonAdapter list;

    public Validator() {
        list = new JsonAdapter();
        readerA = new AccountReader();
        readerC = new ClientReader();
        gson = new Gson();
    }

    public boolean isDuplicateAccount(String id) {
        ArrayList<SavingsAccount> savings;
        ArrayList<CurrentAccount> currents;
        savings = list.getArraySavings(readerA.getPatch1());
        currents = list.getArrayCurrents(readerA.getPatch2());
        if (savings.stream().anyMatch((saving) -> (id.equals(saving.getId())))) {
            return true;
        }
        return currents.stream().anyMatch((current) -> (id.equals(current.getId())));
    }

    public boolean isDuplicateClient(String id, boolean person) {
        if (person) {
            ArrayList<NaturalPerson> naturalP;
            naturalP = list.getArrayNaturalPersons(readerC.getPatch1());
            if (naturalP.stream().anyMatch((naturalPerson) -> (id.equals(naturalPerson.getId())))) {
                return true;
            }
        } else {
            ArrayList<Company> companys;
            companys = list.getArrayCompany(readerC.getPatch2());
            if (companys.stream().anyMatch((company) -> (id.equals(company.getNit())))) {
                return true;
            }
        }
        return false;
    }

    public boolean isDesactiveAccount(String id) {
        ArrayList<SavingsAccount> savings;
        ArrayList<CurrentAccount> currents;
        savings = list.getArraySavings(readerA.getPatch1());
        currents = list.getArrayCurrents(readerA.getPatch2());
        if (savings.stream().anyMatch((saving) -> (id.equals(saving.getId()) && !saving.isIsActive()))) {
            return true;
        }
        return currents.stream().anyMatch((current) -> (id.equals(current.getId()) && !current.isIsActive()));
    }

    public static boolean validateAccountID(String id) {
        return id.matches("[a-zA-Z_0-9]{8}");
    }

    public static boolean validateSpecialCharacter(String id) {
        return id.matches(".*[^\\w].*");
    }

    public static boolean validateSpecialCharacterClient(String id) {
        return id.matches(".*[^0-9].*");
    }

    public static boolean validateEmptyAccountID(String id) {
        return id.isEmpty();
    }

    public static boolean validateSelectedTypeAccount(boolean savings, boolean currents) {
        return !(!savings && !currents);
    }

    public static boolean validateEmptyClientID(String idClient) {
        return idClient.isEmpty();
    }

    public static boolean validateSelectedTypeClient(boolean np, boolean cp) {
        return !(!np && !cp);
    }

    public static boolean validateClientID(String idClient) {
        return idClient.matches("[0-9]{10}");
    }

    public static boolean validateValueConsign(String value) {
        float valueF = Float.parseFloat(value);
        if (valueF >= 20000 && valueF % 10000 == 0) {
            return true;
        }
        return false;
    }

    public int validateInputAccountView(String id, boolean savings, boolean currents, String idClient, boolean np, boolean cp,
            JLabel labelID, JLabel labelType, JLabel labelClientID, JLabel labelClientType) {
        int i = 0;
        if (validateEmptyAccountID(id)) {
            Message.getMessageEmptyAccountID(labelID);
            i++;
        } else {
            if (validateSpecialCharacter(id)) {
                Message.getMessageSpecialCharacter(labelID);
                i++;
            } else {
                if (!validateAccountID(id)) {
                    Message.getMessageMinimumAccountID(labelID);
                    i++;
                } else {
                    if (isDuplicateAccount(id)) {
                        Message.getMessageDuplicateID(labelID);
                        i++;
                    }
                }
            }
        }
        if (!validateSelectedTypeAccount(savings, currents)) {
            Message.getMessageTypeAccount(labelType);
            i++;
        }
        if (validateEmptyClientID(idClient)) {
            Message.getMessageEmptyClientID(labelClientID);
            i++;
        } else {
            if (validateSpecialCharacterClient(idClient)) {
                Message.getMessageSpecialCharacterClient(labelClientID);
                i++;
            } else {
                if (!validateClientID(idClient)) {
                    Message.getMessageMinimumClientID(labelClientID);
                    i++;
                }
            }
        }
        if (!validateSelectedTypeClient(np, cp)) {
            Message.getMessageTypeClient(labelClientType);
            i++;
        }
        return i;
    }

    public boolean validateDesactivateView(String id, JLabel label) {
        if (validateEmptyAccountID(id)) {
            Message.getMessageEmptyAccountID(label);
            return false;
        }
        if (validateSpecialCharacter(id)) {
            Message.getMessageSpecialCharacter(label);
            return false;
        }
        if (!validateAccountID(id)) {
            Message.getMessageMinimumAccountID(label);
            return false;
        }
        if (!isDuplicateAccount(id)) {
            Message.getMessageNonExistentAccount(label);
            return false;
        }
        if (isDesactiveAccount(id)) {
            Message.getMessageDesactiveAccount(label);
            return false;
        }
        return true;
    }

    public int validateWithdrawView(String id, JLabel labelID, String value, JLabel labelValue) {
        int i = 0;
        if (validateEmptyAccountID(id)) {
            Message.getMessageEmptyAccountID(labelID);
            i++;
        } else {
            if (validateSpecialCharacter(id)) {
                Message.getMessageSpecialCharacter(labelID);
                i++;
            } else {
                if (!validateAccountID(id)) {
                    Message.getMessageMinimumAccountID(labelID);
                    i++;
                } else {
                    if (!isDuplicateAccount(id)) {
                        Message.getMessageNonExistentAccount(labelID);
                        i++;
                    }
                }
            }
        }
        if (value.isEmpty()) {
            Message.getMessageEmptyValue(labelValue);
            i++;
        } else {
            if (!validateValueConsign(value)) {
                Message.getMessageErrorValue(labelValue);
                i++;
            }
        }
        return i;
    }

    public int validateConsignView(String id, JLabel labelID, String value, JLabel labelValue) {
        int i = 0;
        if (validateEmptyAccountID(id)) {
            Message.getMessageEmptyAccountID(labelID);
            i++;
        } else {
            if (validateSpecialCharacter(id)) {
                Message.getMessageSpecialCharacter(labelID);
                i++;
            } else {
                if (!validateAccountID(id)) {
                    Message.getMessageMinimumAccountID(labelID);
                    i++;
                } else {
                    if (!isDuplicateAccount(id)) {
                        Message.getMessageNonExistentAccount(labelID);
                        i++;
                    }
                }
            }
        }
        if (value.isEmpty()) {
            Message.getMessageEmptyValue(labelValue);
            i++;

        }       
        return i;
    }
}
