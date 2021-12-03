/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Core;
import model.CoreStack;
import model.Operations;
import view.Gui;
import model.Functions;

/**
 *
 * @author gigi9
 */
public class Main {

    public static void main(String[] args) {
        Functions function = new Functions();
        function.read("asdasd asdasdasd nhgbrfve");
        /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        Operations core = new Core();
        CoreStack coreStack = new CoreStack();
        
        Calcolatrice calcolatrice = new Calcolatrice(core, coreStack);
        
        Gui gui = new Gui(calcolatrice, coreStack);
        gui.setVisible(true);*/
    }
}
