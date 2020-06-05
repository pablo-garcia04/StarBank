/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Json.*;
import Accounts.*;
import Clients.*;
import Operations.Operation;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author Juan Pablo
 */
public class Mediator {

    private final AccountReader readerA;
    private final AccountWriter writerA;
    private final ClientReader readerC;
    private final ClientWriter writerC;
    private final OperationWriter writerO;
    private final OperationReader readerO;
    private final JsonAdapter list;
    private final Gson gson;

    public Mediator() {
        readerA = new AccountReader();
        writerA = new AccountWriter();
        readerC = new ClientReader();
        writerC = new ClientWriter();
        writerO = new OperationWriter();
        readerO = new OperationReader();
        list = new JsonAdapter();
        gson = new Gson();
    }

    public void addRecord(boolean isPatch1, Account account) {
        if (isPatch1) {
            String record = gson.toJson(account);
            writerA.addPatch1(readerA.getPatch1(), record);
        } else {
            String record = gson.toJson(account);
            writerA.addPatch2(readerA.getPatch2(), record);
        }
    }

    public void addRecord(boolean isPatch1, Client client) {
        if (isPatch1) {
            String record = gson.toJson(client);
            writerC.addPatch1(readerC.getPatch1(), record);
        } else {
            String record = gson.toJson(client);
            writerC.addPatch2(readerC.getPatch2(), record);
        }
    }
    public void addRecord(boolean isPatch1, Operation op) {
        if (isPatch1) {
            String record = gson.toJson(op);
            writerO.addPatch1(readerO.getPatch1(), record);
        } else {
            String record = gson.toJson(op);
            writerO.addPatch2(readerO.getPatch2(), record);
        }
    }

    public void updateDesactiveAccount(String id) {
        String json = "[]";
        boolean isPatch1 = false;
        ArrayList<SavingsAccount> savings;
        ArrayList<CurrentAccount> currents;
        savings = list.getArraySavings(readerA.getPatch1());
        currents = list.getArrayCurrents(readerA.getPatch2());
        for (SavingsAccount saving : savings) {
            if (id.equals(saving.getId()) && saving.isIsActive()) {
                saving.setIsActive(false);
                isPatch1 = true;
            }
        }
        if (!isPatch1) {
            currents.stream().filter((current) -> (id.equals(current.getId()) && current.isIsActive())).forEachOrdered((current) -> {
                current.setIsActive(false);
            });
        }
        if (isPatch1) {
            for (SavingsAccount saving : savings) {
                String record = gson.toJson(saving);
                writerA.addPatch1(json, record);
                json = readerA.getPatch1();
            }
        } else {
            for (CurrentAccount current : currents) {
                String record = gson.toJson(current);
                writerA.addPatch2(json, record);
                json = readerA.getPatch2();
            }
        }
    }

    public void updateBalanceAccount(String id, float value, boolean consign, String office) {
        String json = "[]";
        boolean isPatch1 = false;
        ArrayList<SavingsAccount> savings;
        ArrayList<CurrentAccount> currents;
        savings = list.getArraySavings(readerA.getPatch1());
        currents = list.getArrayCurrents(readerA.getPatch2());
        for (SavingsAccount saving : savings) {
            if (id.equals(saving.getId())) {
                if (consign) {
                    saving.consign(value);
                } else {
                    float res = saving.withDraw(value);
                    if (office.equals("Floresta/Medellin")) {
                        this.updateBalanceAccount("01", res, true, office);
                    } else {
                        if (office.equals("Poblado/Medellin")) {
                            this.updateBalanceAccount("02", res, true, office);
                        } else {
                            if (office.equals("Centro/Medellin")) {
                                this.updateBalanceAccount("03", res, true, office);
                            }
                        }
                    }
                }
                isPatch1 = true;
            }
        }
        if (!isPatch1) {
            currents.stream().filter((current) -> (id.equals(current.getId()))).forEachOrdered((current) -> {
                if (consign) {
                    current.consign(value);
                } else {
                    float res = current.withDraw(value);
                    if (office.equals("Floresta/Medellin")) {
                        this.updateBalanceAccount("01", res, true, office);
                    } else {
                        if (office.equals("Poblado/Medellin")) {
                            this.updateBalanceAccount("02", res, true, office);
                        } else {
                            if (office.equals("Centro/Medellin")) {
                                this.updateBalanceAccount("03", res, true, office);
                            }
                        }
                    }
                }
            });
        }
        if (isPatch1) {
            for (SavingsAccount saving : savings) {
                String record = gson.toJson(saving);
                writerA.addPatch1(json, record);
                json = readerA.getPatch1();
            }
        } else {
            for (CurrentAccount current : currents) {
                String record = gson.toJson(current);
                writerA.addPatch2(json, record);
                json = readerA.getPatch2();
            }
        }
    }
}
