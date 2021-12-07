/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.*;

/**
 * La classe Core viene utilizzata per effettuare operazioni di modifica sullo
 * stack Implementa l'interfaccia operazione che definisce le operazioni
 * elementari che devono essere implementate
 */
public class Core implements Operations {

    private StackOp data;

    public Core() {
        data = StackSingle.getInstance();
    }

    /**
     * Il metodo viene prende in input due valori di tipo double, al primo
     * associa parte real mentre al secondo associa la parte complessa, crea un
     * oggetto di tipo Numero Complesso e ne effettua il push nello stack
     *
     * @param a parte re
     * @param b parte immaginaria
     */
    @Override
    public void creatNumber(double a, double b) {
        ComplexNumber j = new ComplexNumber(a, b);
        this.pushInStack(j);
    }

    /**
     * Metodo che effettua il push nello stack di un numero complesso
     *
     * @param a Numero Complesso
     */
    @Override
    public void pushInStack(ComplexNumber a) {
        data.stackPush(a);
    }

    /**
     * Metodo che effettua il pop dallo stack e ritorna il numero complesso che
     * si trova nella cima dello stack
     *
     * @return Numero Complesso
     */
    @Override
    public ComplexNumber popFromStack() {
        return (ComplexNumber) data.stackPop();
    }

    /**
     * Metodo per effettuare la somma tra due numeri complessi presenti nello
     * stack Tale metodo prima effettua il Pop dei due numeri, ne fa la somma ed
     * effettua il push del risultato nello stack
     */
    @Override
    public void sumInStack() {
        ComplexNumber a;
        ComplexNumber b, s;

        if (data.stackStatus()) {
            a = (ComplexNumber) data.stackPop();
        } else {
            throw new EmptyStackException();
        }
        if (data.stackStatus()) {
            b = (ComplexNumber) data.stackPop();
            s = ComplexNumber.sum(a, b);
            data.stackPush(s);
        } else {
            data.stackPush(a);
            throw new EmptyStackException();
        }
    }

    /**
     * Metodo per effettuare la differenza tra due numeri complessi presenti
     * nello stack Tale metodo prima effettua il Pop dei due numeri, ne fa la
     * differenza ed effettua il push del risultato nello stack
     */
    @Override
    public void diffInStack() {
        ComplexNumber a;
        ComplexNumber b, s;

        if (data.stackStatus()) {
            a = (ComplexNumber) data.stackPop();
        } else {
            throw new EmptyStackException();
        }
        if (data.stackStatus()) {
            b = (ComplexNumber) data.stackPop();
            s = ComplexNumber.sub(a, b);
            data.stackPush(s);
        } else {
            data.stackPush(a);
            throw new EmptyStackException();
        }
    }

    /**
     * Metodo per effettuare il prodotto tra due numeri complessi presenti nello
     * stack Tale metodo prima effettua il Pop dei due numeri, ne fa il prodotto
     * ed effettua il push del risultato nello stack
     */
    @Override
    public void prodInStack() {
        ComplexNumber a;
        ComplexNumber b, s;

        if (data.stackStatus()) {
            a = (ComplexNumber) data.stackPop();
        } else {
            throw new EmptyStackException();
        }
        if (data.stackStatus()) {
            b = (ComplexNumber) data.stackPop();
            s = ComplexNumber.multiplication(a, b);
            data.stackPush(s);
        } else {
            data.stackPush(a);
            throw new EmptyStackException();
        }
    }

    /**
     * Metodo per effettuare la division tra due numeri complessi presenti nello
     * stack Tale metodo prima effettua il Pop dei due numeri, ne fa la division
     * ed effettua il push del risultato nello stack
     */
    @Override
    public void divInStack() {
        ComplexNumber a;
        ComplexNumber b, s;

        if (data.stackStatus()) {
            a = (ComplexNumber) data.stackPop();
        } else {
            throw new EmptyStackException();
        }
        if (data.stackStatus()) {
            b = (ComplexNumber) data.stackPop();
            s = ComplexNumber.division(a, b);
            data.stackPush(s);
        } else {
            data.stackPush(a);
            throw new EmptyStackException();
        }
    }

    /**
     * Metodo per effettuare la radice quadra di un numero complesso presente
     * nello stack Tale metodo prima effettua il Pop del numero, ne calcola la
     * radice ed effettua il push del risultato nello stack
     */
    @Override
    public void square2InStack() {
        ComplexNumber a;
        ComplexNumber s;
        if (data.stackStatus()) {
            a = (ComplexNumber) data.stackPop();
        } else {
            throw new EmptyStackException();
        }
        s = a.sqrt();
        data.stackPush(s);
    }

    /**
     * Metodo utilizzato per stampare a schermo il contenuto dello stack.
     */
    public void printStack() {
        System.out.println(data.stackPrint());
    }

    /**
     * Metodo utilizzato per effettuare il coniugato del numero presente sulla
     * cima dello stack.
     */
    @Override
    public void conjugatedInStack() {
        ComplexNumber a;
        ComplexNumber s;
        if (data.stackStatus()) {
            a = (ComplexNumber) data.stackPop();
        } else {
            throw new EmptyStackException();
        }
        s = a.conjugated();
        data.stackPush(s);
    }

    /**
     * Metodo utilizzato per effettuare il modulo del numero presente sulla cima
     * dello stack, pochè il risultato è un numero reale verrà inserito nello
     * stack nella forma mod + 0i;
     */
    @Override
    public void modInStack() {
        ComplexNumber a;
        ComplexNumber s;
        if (data.stackStatus()) {
            a = (ComplexNumber) data.stackPop();
        } else {
            throw new EmptyStackException();
        }
        s = new ComplexNumber(a.mod(), 0);
        data.stackPush(s);
    }

    /**
     * Metodo utilizzato per effettuare l'abs del numero presente sulla cima
     * dello stack, pochè il risultato è un numero reale verrà inserito nello
     * stack nella forma mod + 0i;
     */
    @Override
    public void absInStack() {
        ComplexNumber a;
        ComplexNumber s;
        if (data.stackStatus()) {
            a = (ComplexNumber) data.stackPop();
        } else {
            throw new EmptyStackException();
        }
        s = new ComplexNumber(a.abs(), 0);
        data.stackPush(s);
    }
}
