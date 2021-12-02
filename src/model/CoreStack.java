/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;


public class CoreStack {

    private StackOp dataSingle;
    int indexElement = 12;


    /**
     * Il metodo getSubList() richiama il metodo stackToList per ottenere lo
     * stack in formato lista, per poi prendere i primi indexElement elementi e
     * restituirli in output sotto forma di lista di numeri complessi
     *
     * @return List<ComplexNumber>
     */
    public List<ComplexNumber> getSubList() {
        LinkedList<ComplexNumber> getSubList = new LinkedList<>();
        Iterator stack = dataSingle.stackElements();

        int n = 0;

        while (stack.hasNext() && n <= indexElement) {
            getSubList.add((ComplexNumber) stack.next());
            n++;
        }

        return getSubList;
    }

    public void clear() {
        dataSingle.clear();
    }

    public void duplicate() throws NoSuchElementException {
        dataSingle.duplicate();
    }

    public void swap() {
        dataSingle.swap();

    }

    public void drop() {
        dataSingle.drop();
    }

    public void over() {
        dataSingle.over();
    }

}
