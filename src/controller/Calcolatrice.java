/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Core;
import model.CoreStack;

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
    
    /**
     * Metodo utilizzato per creare un numero complesso e inserirlo nello stack
     */
    public void creatComplexNumber(double real, double img) {
        core.creatNumber(real, img);
    }
    
    /**
     * Metodo utilizzato per sommare due elementi nello stack
     */
    public void stackSum() {
        core.sumInStack();
    }
    
    /**
     * Metodo utilizzato per fare la differenza tra due elementi nello stack
     */
    public void stackDiff() {
        core.diffInStack();
    }

    /**
     * Metodo utilizzato per moltiplicare due elementi nello stack
     */
    public void stackProd() {
        core.prodInStack();
    }
    
    /**
     * Metodo utilizzato per dividere due elementi nello stack
     */
    public void stackDiv() {
        core.divInStack();
    }
    
    /**
     * Metodo utilizzato per calcolare la radice quadrata di un elemento
     * nello stack
     */
    public void stackSqr() {
        core.square2InStack();
    }
    
    /**
     * Metodo utilizzato per invertire il segno di un elemento nello stack
     */
    public void stackInv() {
        core.conjugatedInStack();
    }

}
