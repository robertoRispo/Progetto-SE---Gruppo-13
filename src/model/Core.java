/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.*;

/**
 * La classe Core viene utilizzata per effettuare operazioni di modifica sullo stack
 * Implementa l'interfaccia operazione che definisce le operazioni elementari che devono 
 * essere implementate 
 */
public class Core implements Operations {

    private StackSingle data;

    public Core() {
        data = StackSingle.getInstance();
    }

    /**
     * Il metodo viene prende in input due valori di tipo double, al primo
     * associa parte real mentre al secondo associa la parte complessa, crea un 
     * oggetto di tipo Numero Complesso e ne effettua il push nello stack
     * @param a parte reale
     * @param b parte immaginaria
     */
    @Override
    public void creaNumero(double a, double b) {
        NumeroComplesso j = new NumeroComplesso(a, b);
        this.pushInStack(j);
    }

    /**
     * Metodo che effettua il push nello stack di un numero complesso
     * @param a Numero Complesso
     */
    @Override
    public void pushInStack(NumeroComplesso a) {
        data.StackPush(a);
    }

    /**
     * Metodo che effettua il pop dallo stack e ritorna il numero complesso che
     * si trova nella cima dello stack
     * @return Numero Complesso
     */
    @Override
    public NumeroComplesso popFromStack() {
        return (NumeroComplesso) data.StackPop();
    }

    /**
     * Metodo per effettuare la somma tra due numeri complessi presenti nello stack
     * Tale metodo prima effettua il Pop dei due numeri, ne fa la somma ed effettua il push
     * del risultato nello stack
     */
    @Override
    public void sommaInStack() {
        NumeroComplesso a, b, s;

        if (data.StackStatus()) {
            a = (NumeroComplesso) data.StackPop();
        } else {
            throw new EmptyStackException();
        }
        if (data.StackStatus()) {
            b = (NumeroComplesso) data.StackPop();
            s = NumeroComplesso.somma(a, b);
            data.StackPush(s);
        } else {
            data.StackPush(a);
            throw new EmptyStackException();
        }
    }

    /**
     * Metodo per effettuare la differenza tra due numeri complessi presenti nello stack
     * Tale metodo prima effettua il Pop dei due numeri, ne fa la differenza ed effettua il push
     * del risultato nello stack
     */
    @Override
    public void diffInStack() {
        NumeroComplesso a, b, s;

        if (data.StackStatus()) {
            a = (NumeroComplesso) data.StackPop();
        } else {
            throw new EmptyStackException();
        }
        if (data.StackStatus()) {
            b = (NumeroComplesso) data.StackPop();
            s = NumeroComplesso.sottrazione(a, b);
            data.StackPush(s);
        } else {
            data.StackPush(a);
            throw new EmptyStackException();
        }
    }

    /**
     * Metodo per effettuare il prodotto tra due numeri complessi presenti nello stack
     * Tale metodo prima effettua il Pop dei due numeri, ne fa il prodotto ed effettua il push
     * del risultato nello stack
     */
    @Override
    public void prodInStack() {
        NumeroComplesso a, b, s;

        if (data.StackStatus()) {
            a = (NumeroComplesso) data.StackPop();
        } else {
            throw new EmptyStackException();
        }
        if (data.StackStatus()) {
            b = (NumeroComplesso) data.StackPop();
            s = NumeroComplesso.moltiplicazione(a, b);
            data.StackPush(s);
        } else {
            data.StackPush(a);
            throw new EmptyStackException();
        }
    }

    /**
     * Metodo per effettuare la divisione tra due numeri complessi presenti nello stack
     * Tale metodo prima effettua il Pop dei due numeri, ne fa la divisione ed effettua il push
     * del risultato nello stack
     */
    @Override
    public void divInStack() {
        NumeroComplesso a, b, s;

        if (data.StackStatus()) {
            a = (NumeroComplesso) data.StackPop();
        } else {
            throw new EmptyStackException();
        }
        if (data.StackStatus()) {
            b = (NumeroComplesso) data.StackPop();
            s = NumeroComplesso.divisione(a, b);
            data.StackPush(s);
        } else {
            data.StackPush(a);
            throw new EmptyStackException();
        }
    }

    /**
     * Metodo per effettuare la radice quadra di un numero complesso presente nello stack
     * Tale metodo prima effettua il Pop del numero, ne calcola la radice ed effettua il push
     * del risultato nello stack
     */
    @Override
    public void radiceInStack(){
        NumeroComplesso a, s;
         if (data.StackStatus()) {
            a = (NumeroComplesso) data.StackPop();
        } else throw new EmptyStackException();
         s = a.radiceQuadra();
         data.StackPush(s);
    
    }
    
    /**
     * Metodo utilizzato per stampare a schermo il contenuto dello stack.
     */
    public void printStack() {
        System.out.println(data.stackPrint());
    }

}
