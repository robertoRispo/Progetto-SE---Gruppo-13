/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import model.ComplexNumber;
import model.Core;
import model.CoreStack;
import model.Operations;
import model.Variables;

public class Calcolatrice {

    Operations core;
    CoreStack coreStack;
    Variables var;
    List<String> opList;

    public Calcolatrice(Operations core, CoreStack coreStacke, Variables var) {
        this.core = core;
        this.coreStack = coreStack;
        this.var = var;
        opList = new ArrayList<String>(Arrays.asList("dup", "swap", "drop", "over", "+", "-", "/", "*", "conj", "abs", "mod"));
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
    public void stackSum() throws EmptyStackException{
        
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
     * Metodo che trasforma una lista di parole in una mappa con chiave la prima
     * parola, e come valore una lista contenente le parole successive
     *
     * @param String stringa in input
     * @return HashMap<String, List<String>>
     * HashMap<NomeFunzione, ListaOperazioni>
     */
    public HashMap<String, List<String>> Function(String operations) throws NoSuchElementException {
        List<String> operationsList = new ArrayList<String>(Arrays.asList(operations.split(" ")));

        String name = operationsList.remove(0);

        System.out.println(operationsList);

        Iterator<String> iterOperations = operationsList.iterator();

        if (!isFunctionCorrect(iterOperations)) {
            System.out.println("Problema Trovato");
        }

        HashMap<String, List<String>> function = new HashMap<>();;
        function.put(name, operationsList);

        return function;

    }

    /**
     * Metodo che controlla se la sequenza inserita è corretta
     *
     * @param String stringa in input
     * @return HashMap<String, List<String>>
     * HashMap<NomeFunzione, ListaOperazioni>
     */
    public boolean isFunctionCorrect(Iterator<String> operations) throws NoSuchElementException {
        /*String op = null;
        while(operations.hasNext()){
            op = operations.next();
            if(!opList.contains(op)){
                throw new NoSuchElementException ("error");
            }
        }*/
        return true;
    }
}
