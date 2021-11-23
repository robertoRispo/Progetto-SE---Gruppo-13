/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.*;

/**
 *
 * @author agostinomoffa
 */
public class Core implements Operations {

    private StackSingle data;

    public Core() {
        data = StackSingle.getInstance();
    }

    @Override
    public void creaNumero(double a, double b) {
        NumeroComplesso j = new NumeroComplesso(a, b);
        this.pushInStack(j);
    }

    @Override
    public void pushInStack(NumeroComplesso a) {
        data.StackPush(a);
    }

    @Override
    public NumeroComplesso popFromStack() {
        return (NumeroComplesso) data.StackPop();
    }

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

    
    
    public void radiceInStack(){
        NumeroComplesso a, s;
         if (data.StackStatus()) {
            a = (NumeroComplesso) data.StackPop();
        } else throw new EmptyStackException();
         s = a.radiceQuadra();
         data.StackPush(s);
    
    }
    
    
    
    public void printStack() {
        System.out.println(data.stackPrint());
    }

}
