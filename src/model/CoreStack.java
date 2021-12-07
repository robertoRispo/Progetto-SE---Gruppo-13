/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * La classe CoreStack viene utilizzata per richiamare i metodi di StackSingle
 * 
 */
public class CoreStack {

    private StackOp dataSingle;
    int indexElement = 12;

    public CoreStack() {
        dataSingle = StackSingle.getInstance();
    }

    /**
     * Il metodo getSubList() richiama il metodo stackToList per ottenere lo
     * stack in formato lista, per poi prendere i primi indexElement elementi e
     * restituirli in output sotto forma di lista di numeri complessi
     *
     * @return List({@link ComplexNumber}) -> Lista di numeri complessi
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

    /**
     * Metodo utilizzato per cancellare tutti gli elementi dello stack
     */
    public void clear() {
        dataSingle.clear();
    }

    /**
     * Metodo utilizzato per scambiare gli ultimi due elementi dello stack
     *
     * @throws NoSuchElementException Quando non ci sono abbastanza elementi
     * nello stack
     */
    public void duplicate() throws NoSuchElementException {
        dataSingle.duplicate();
    }

    /**
     * Metodo utilizzato per scambiare gli ultimi due elementi dello stack
     *
     * @throws NoSuchElementException Quando non ci sono abbastanza elementi
     * nello stack
     */
    public void swap() {
        dataSingle.swap();
    }

    /**
     * Metodo utilizzato per eliminare l'ultimo elemento inserito nello stack
     *
     * @throws NoSuchElementException Quando lo stack è vuoto
     */
    public void drop() {
        dataSingle.drop();
    }

     /**
     * Metodo utilizzato per duplicare il penultimo elemento dello stack
     *
     * @throws NoSuchElementException Quando non ci sono abbastanza elementi
     * nello stack
     */
    public void over() {
        dataSingle.over();
    }

}
