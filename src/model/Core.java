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
public class Core implements Operations{
    private StackSingle data;
    public Core(){
        data = StackSingle.getInstance();
    }
    
    @Override
    public void creaNumero(){
        int a = 5;
        int b = 7;
        NumeroComplesso j = new NumeroComplesso(a,b);
        this.pushInStack(j);
    }
    
  
    
    public void pushInStack(NumeroComplesso a){
        data.StackPush(a);
    }
    
    public void sottinstack(){
        NumeroComplesso a = (NumeroComplesso) data.StackPop();
        NumeroComplesso b = (NumeroComplesso) data.StackPop();
        NumeroComplesso s = NumeroComplesso.sottrazione(a, b);
        data.StackPush(s);
    }

    @Override
    public void sommaInStack() {
               NumeroComplesso a,b,s;
        
        if(data.StackStatus())
        {
         a = (NumeroComplesso) data.StackPop();
        }
        else throw new EmptyStackException(); 
        if(data.StackStatus()){
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
        NumeroComplesso a = (NumeroComplesso) data.StackPop();
        NumeroComplesso b = (NumeroComplesso) data.StackPop();
        NumeroComplesso s = NumeroComplesso.sottrazione(a, b);
        data.StackPush(s);
    }

    @Override
    public void prodInStack() {
        NumeroComplesso a = (NumeroComplesso) data.StackPop();
        NumeroComplesso b = (NumeroComplesso) data.StackPop();
        NumeroComplesso s = NumeroComplesso.moltiplicazione(a, b);
        data.StackPush(s);
    }

    @Override
    public void divInStack() {
        NumeroComplesso a = (NumeroComplesso) data.StackPop();
        NumeroComplesso b = (NumeroComplesso) data.StackPop();
        NumeroComplesso s = NumeroComplesso.divisione(a, b);
        data.StackPush(s);
    }
   
   
    
}
