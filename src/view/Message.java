/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

/**
 *
 * @author Juan Pablo
 */
public class Message {

    public static void getMessageTypeAccount(JLabel label) {
        label.setText("Seleccione un tipo de cuenta");
        label.setForeground(Color.red);
        label.setVisible(true);
    }

    public static void getMessageTypeClient(JLabel label) {
        label.setText("Seleccione un tipo de cliente");
        label.setForeground(Color.red);
        label.setVisible(true);
    }

    public static void getMessageDesactiveAccount(JLabel label) {
        label.setText("La cuenta ingresada ya se encuentra desactivada");
        label.setForeground(Color.red);
        label.setVisible(true);
    }

    public static void getMessageNonExistentAccount(JLabel label) {
        label.setText("El ID ingresado no corresponde a una cuenta existente");
        label.setForeground(Color.red);
        label.setVisible(true);
    }

    public static void getMessageEmptyClientID(JLabel label) {
        label.setText("Agregue una identificacion");
        label.setForeground(Color.red);
        label.setVisible(true);
    }

    public static void getMessageEmptyValue(JLabel label) {
        label.setText("Agregue un valor para la operacion");
        label.setForeground(Color.red);
        label.setVisible(true);
    }

    public static void getMessageErrorValue(JLabel label) {
        label.setText("El valor ingresado no es valido");
        label.setForeground(Color.red);
        label.setVisible(true);
    }

    public static void getMessageEmptyAccountID(JLabel label) {
        label.setText("Agregue un ID para la cuenta");
        label.setForeground(Color.red);
        label.setVisible(true);
    }

    public static void getMessageSpecialCharacter(JLabel label) {
        label.setText("Caracteres especiales no permitidos");
        label.setForeground(Color.red);
        label.setVisible(true);
    }

    public static void getMessageSpecialCharacterClient(JLabel label) {
        label.setText("Ingrese una identificacion numerica");
        label.setForeground(Color.red);
        label.setVisible(true);
    }

    public static void getMessageMinimumClientID(JLabel label) {
        label.setText("La identificacion debe tener minimo 10 caracteres");
        label.setForeground(Color.red);
        label.setVisible(true);
    }

    public static void getMessageMinimumAccountID(JLabel label) {
        label.setText("El ID debe tener minimo 8 caracteres");
        label.setForeground(Color.red);
        label.setVisible(true);
    }

    public static void getMessageDuplicateID(JLabel label) {
        label.setText("el ID ya se encuentra en uso");
        label.setForeground(Color.red);
        label.setVisible(true);
    }

    public static void getMessageValueMimimun(JLabel label) {
        label.setText("El valor minimo es 20.000");
        label.setForeground(Color.red);
        label.setVisible(true);
    }

    public static void getMessageSuccefullAccount() {
        JOptionPane.showMessageDialog(null, "Cuenta creada", "Operacion exitosa", JOptionPane.WARNING_MESSAGE);
    }

    public static void getMessageSuccefullDesactivateAccount() {
        JOptionPane.showMessageDialog(null, "Cuenta desactivada", "Operacion exitosa", JOptionPane.WARNING_MESSAGE);
    }

    public static void getMessageSuccefullConsign() {
        JOptionPane.showMessageDialog(null, "Consignacion completa", "Operacion exitosa", JOptionPane.WARNING_MESSAGE);
    }

    public static void getMessageSuccefullWithdraw() {
        JOptionPane.showMessageDialog(null, "Retiro completo", "Operacion exitosa", JOptionPane.WARNING_MESSAGE);
    }
    public static void getMessageSuccefullClient() {
        JOptionPane.showMessageDialog(null, "Cliente registrado", "Operacion exitosa", JOptionPane.WARNING_MESSAGE);
    }
}
