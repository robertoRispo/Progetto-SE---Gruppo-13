/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Set;
import model.ComplexNumber;
import model.StackOp;
import model.StackSingle;

/**
 * Classe utilizzata per gestire le variabili nella calcolatrice. Le variabili
 * vengono gestite in una HashMap <String,ComplexNumber> dove la chiave (String)
 * rappresenta la variabile e il valore il numero complesso associato. In tutte
 * i metodi si è supposto che i controlli necessari sulle stringhe siano stati
 * fatti prima di richiamarli.
 */
public class Variables {

    private StackOp data;
    private HashMap<String, ComplexNumber> variables;
    private ArrayDeque<Tuple> variableStack;

    public Variables() {
        data = StackSingle.getInstance();
        variables = new HashMap<>();
        variableStack = new ArrayDeque();
    }

    /**
     * Metodo utilizzato per inserire nella "variabile" l'elemento in cima allo
     * stack.
     *
     * @param a Stringa che contiene il nome della variabile
     */
    public void pushInVar(String a) {
        ComplexNumber num = (ComplexNumber) data.stackPop();
        variables.put(a, num);

    }

    /**
     * Metodo utilizzato per inserire il valore presente nella variabile a in
     * cima allo stack
     *
     * @param a Stringa che contiene il nome della variabile
     * @throws NoSuchElementException nel caso in cui la variabile non fosse
     * inizializzata
     */
    public void popFromVar(String a) throws NoSuchElementException {

        ComplexNumber num = variables.get(a);
        if (num == null) {
            throw new NoSuchElementException("La variabile non è inizializzata");
        }
        data.stackPush(num);
    }

    /**
     * Metodo utilizzato per effettuare la somma tra la variabile e l'elemento
     * presente in cima allo stack, il risultato viene inserito nella variabile
     *
     * @param a Stringa che contiene il nome della variabile
     */
    public void addInVar(String a) {
        ComplexNumber num = variables.get(a);
        ComplexNumber num2 = (ComplexNumber) data.stackPop();
        ComplexNumber sum = ComplexNumber.sum(num, num2);
        variables.put(a, sum);
    }

    /**
     * Metodo utilizzato per effettuare la differenza tra la variabile e
     * l'elemento presente in cima allo stack, il risultato viene inserito nella
     * variabile
     *
     * @param a Stringa che contiene il nome della variabile
     */
    public void diffInVar(String a) {
        ComplexNumber num = variables.get(a);
        ComplexNumber num2 = (ComplexNumber) data.stackPop();
        ComplexNumber sub = ComplexNumber.sub(num, num2);
        variables.put(a, sub);
    }

    /**
     * Metodo utilizzato per prendere il valore della variabile passata come
     * stringa
     *
     * @param a stringa con il nome della variabile
     * @return Oggetto contenuto nella variabile
     */
    public ComplexNumber getVar(String a) {
        return variables.get(a);
    }

    /**
     * Metodo utilizzato per salvare lo stato attuale delle variabili nello
     * stack variables
     *
     * @throws NoSuchElementException in caso non ci siano variabili da salvare
     */
    public void saveVar() throws NoSuchElementException {
        if (variables.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Tuple breakpoint = new Tuple("stop", null);
            variableStack.push(breakpoint);
            for (String key : variables.keySet()) {
                Tuple backup = new Tuple(key, this.getVar(key));
                variableStack.push(backup);
            }
        }
    }

    /**
     * Metodo utilizzato per recuperare lo stato delle variabili salvate nello
     * stackVariables
     *
     * @throws EmptyStackException in caso lo stackVariables sia vuoto
     */
    public void restoreVar() throws EmptyStackException {
        if (variableStack.isEmpty()) {
            throw new EmptyStackException();
        } else {

            variables.clear();
            while (true) {
                Tuple backup = variableStack.pop();
                if (backup.getKey().equalsIgnoreCase("stop")) {
                    break;
                } else {
                    variables.put(backup.getKey(), backup.getNum());
                }
            }
        }
    }

    @Override
    public String toString() {
        return variables.toString();
    }
}
