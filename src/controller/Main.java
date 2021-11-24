/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Core;
import model.CoreStack;
import view.GUI;

/**
 *
 * @author gigi9
 */
public class Main {

    public static void main(String[] args) {
        Core core = new Core();
        CoreStack coreStack = new CoreStack();
        
        Calcolatrice calcolatrice = new Calcolatrice(core, coreStack);
        
        GUI gui = new GUI(calcolatrice);

        System.out.println("SI ACCENDE");
    }
}
