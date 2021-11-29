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
import java.util.NoSuchElementException;
import java.util.Stack;

public class StackSingle implements StackOp {

    private static StackSingle istanza = null;
    private ArrayDeque data;

    private StackSingle() {
        this.data = new ArrayDeque();
    }

    public static StackSingle getInstance() {
        if (istanza == null) {
            istanza = new StackSingle();
        }
        return istanza;
    }

    @Override
    public Object stackPop() throws NoSuchElementException {
        Object c = data.pop();
        return c;
    }

    @Override
    public void stackPush(Object E) {
        data.push(E);
    }

    @Override
    public boolean stackStatus() {
        return !data.isEmpty();
    }

    @Override
    public List<ComplexNumber> convertToList() {
        List<ComplexNumber> stackToList = new ArrayList(data);
        return stackToList;
    }

    @Override
    public String stackPrint() {
        return (data.toString());
    }

    @Override
    public Iterator stackElements() {
        return (data.iterator());
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public void duplicate() throws NoSuchElementException {
        Iterator iter = stackElements();
        Object obj = iter.next();
        stackPush(obj);
    }

    @Override
    public void swap() throws NoSuchElementException {
        if(data.size() < 2){
            throw new NoSuchElementException ("error");
        }
        Object c1 = stackPop();
        Object c2 = stackPop();

        stackPush(c1);
        stackPush(c2);
        
    }

    @Override
    public void drop() throws NoSuchElementException {
        stackPop();
    }

    @Override
    public void over() throws NoSuchElementException {
        Iterator iter = stackElements();
        iter.next();
        Object obj = iter.next();

        stackPush(obj);
    }
}
