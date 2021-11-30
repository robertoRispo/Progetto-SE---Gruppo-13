/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.HashMap;
import model.ComplexNumber;
import model.StackOp;
import model.StackSingle;

/**
 * Classe utilizzata per gestire le variabili nella calcolatrice.
 * Le variabili vengono gestite in una HashMap <String,ComplexNumber> dove la chiave
 * (String) rappresenta la variabile e il valore il numero complesso associato.
 * In tutte i metodi si è supposto che i controlli necessari sulle stringhe siano
 * stati fatti prima di richiamarli.
 */
public class Variables{
   
    private StackOp data;
    HashMap <String, ComplexNumber> variables;
    
    public Variables() {
        data = StackSingle.getInstance();
        variables = new HashMap<>();
    }
    
    /**
     * Metodo utilizzato per inserire nella "variabile" l'elemento
     * in cima allo stack.
     * @param a Stringa che contiene il nome della variabile
     */
    public void pushInVar(String a) {
        ComplexNumber num = (ComplexNumber) data.stackPop();
        variables.put(a, num);
        
    }

    /**
     * Metodo utilizzato per inserire il valore presente nella variabile 
     * a in cima allo stack
     * @param a Stringa che contiene il nome della variabile
     */
    public void popFromVar(String a) {
        
       ComplexNumber num = variables.get(a);
       if (num == null){
           return;
       }
       data.stackPush(num);
    }

    /**
     * Metodo utilizzato per effettuare la somma tra la variabile e l'elemento 
     * presente in cima allo stack, il risultato viene inserito nella variabile
     * @param a Stringa che contiene il nome della variabile
     */
    public void addInVar(String a) {
        ComplexNumber num = variables.get(a);
        ComplexNumber num2 = (ComplexNumber) data.stackPop();
        ComplexNumber sum = ComplexNumber.sum(num, num2);
        variables.put(a, sum);
    }

    /**
     * Metodo utilizzato per effettuare la differenza tra la variabile e l'elemento 
     * presente in cima allo stack, il risultato viene inserito nella variabile
     * @param a Stringa che contiene il nome della variabile
     */
    public void diffInVar(String a) {
        ComplexNumber num = variables.get(a);
        ComplexNumber num2 = (ComplexNumber) data.stackPop();
        ComplexNumber sub = ComplexNumber.sub(num, num2);
        variables.put(a, sub);
    }
    
    public ComplexNumber getVar(String a){
        return variables.get(a);
    }
    
    @Override
    public String toString(){
        return variables.toString();
    }
}

