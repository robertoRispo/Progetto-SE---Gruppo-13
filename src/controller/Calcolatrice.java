/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;
import model.CoreStack;
import model.Functions;
import model.Operations;
import model.Variables;

public class Calcolatrice {

    Operations core;
    CoreStack coreStack;
    Variables var;
    Functions function;

    public Calcolatrice(Operations core, CoreStack coreStack, Variables var, Functions function) {
        this.core = core;
        this.coreStack = coreStack;
        this.var = var;
        this.function = function;
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
    public void stackSum() throws EmptyStackException {

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
     * Metodo utilizzato per calcolare la radice quadrata di un elemento nello
     * stack
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

    /**
     * Metodo che esegue una determinata operazione su una determinata variabile
     *
     * @param String stringa in input
     * @return boolean (True o False)
     */
    public void executeOperation(String str) throws NoSuchElementException {

        String op = str.substring(0, 1);
        String variable = str.substring(1, 2);

        System.out.println(op);
        System.out.println(variable);

        if (op.equals("+")) {
            var.addInVar(variable);
        } else if (op.equals("-")) {
            var.diffInVar(variable);
        } else if (op.equals(">")) {
            var.pushInVar(variable);
        } else if (op.equals("<")) {
            var.popFromVar(variable);
        }

    }

    /**
     * Metodo utilizzato per cancellare tutti gli elementi dello stack
     */
    public void clear() {
        coreStack.clear();
    }

    /**
     * Metodo utilizzato per scambiare gli ultimi due elementi dello stack
     */
    public void duplicate() throws NoSuchElementException {
        coreStack.duplicate();
    }

    /**
     * Metodo utilizzato per scambiare gli ultimi due elementi dello stack
     */
    public void swap() {
        coreStack.swap();
    }

    /**
     * Metodo utilizzato per eliminare l'ultimo elemento inserito nello stack
     */
    public void drop() {
        coreStack.drop();
    }

    /**
     * Metodo utilizzato per duplicare il penultimo elemento dello stack
     */
    public void over() {
        coreStack.over();
    }

    public void functionController(String operations) throws NumberFormatException, NoSuchElementException, NullPointerException {
        List<String> listOperations = function.readOperations(operations);

        if (listOperations.size() == 1) {
            function.executeFunction(listOperations.get(0)); //Il primo elemento è il nome della funzione
        } else {
            function.createFunction(listOperations);
        }

    }

    public void saveFile(String name) throws IOException {
        function.saveFile(name);
    }

    public void loadFile(String name) throws IOException, FileNotFoundException {
        function.loadFile(name);
    }

    public void deleteFunction(String name) throws NullPointerException {
        function.deleteFunction(name);
    }

    public void saveVar() throws NoSuchElementException {
        var.saveVar();
    }

    public void restoreVar() throws EmptyStackException {
        var.restoreVar();
    }
}
