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
 * @author agostinomoffa
 */
public class Calcolatrice {

    Core core;
    CoreStack coreStack;

    public Calcolatrice(Core core, CoreStack coreStacke) {
        this.core = core;
        this.coreStack = coreStack;
    }

    public void creatComplexNumber(double real, double img) {
        core.creatNumber(real, img);
    }

    public void stackSum() {
        core.sumInStack();
    }

    public void stackDiff() {
        core.diffInStack();
    }

    public void stackProd() {
        core.prodInStack();
    }

    public void stackDiv() {
        core.divInStack();
    }

    public void stackSqr() {
        core.square2InStack();
    }

    public void stackInv() {
        core.inversionInStack();
    }

}
