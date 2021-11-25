package model;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author agostinomoffa
 */
public class StackSingle implements StackOp{
    
    private static StackSingle istanza = null;
    private ArrayDeque data;
    private StackSingle(){
        this.data = new ArrayDeque();
    }
    public static StackSingle getInstance(){
        if (istanza == null){
            istanza =  new StackSingle();
        }
        return istanza;
    }
   

    @Override
    public Object StackPop() {
        Object c = data.pop();
        return c;
    }

    @Override
    public void StackPush(Object E) {
      data.push(E);
    }

    @Override
    public boolean StackStatus() {
        return !data.isEmpty();
    }
    
    @Override
    public List<ComplexNumber> convertiLista(){
        List<ComplexNumber> stackToList = new ArrayList(data);
        return stackToList;
    }
    
    @Override
    public String stackPrint(){
        return(data.toString());
    }
    
    @Override
    public Iterator stackElements(){
        return(data.iterator());
    }
}
