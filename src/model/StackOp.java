/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public interface StackOp {

    public Object stackPop();

    public void stackPush(Object E);

    public boolean stackStatus();

    public List<ComplexNumber> convertToList();

    public String stackPrint();

    public Iterator stackElements();

    public void clear();

    public void duplicate() throws NoSuchElementException;

    public void swap() throws NoSuchElementException;

    public void drop() throws NoSuchElementException;

    public void over() throws NoSuchElementException;
}
