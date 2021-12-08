package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Classe utilizzare per implementare il salvataggio dei dati in logica stack.
 * La classe è implementata seguendo il pattern Singleton in modo da poter aver
 * un unica istanza della classe
 */
public class StackSingle implements StackOp {

    private static StackSingle istanza = null;
    private final ArrayDeque data;

    private StackSingle() {
        this.data = new ArrayDeque();
    }

    public static StackSingle getInstance() {
        if (istanza == null) {
            istanza = new StackSingle();
        }
        return istanza;
    }

    /**
     * Metodo utilizzato per effettuare il pop dallo stack.
     *
     * @return Object -> L'oggetto presente nello stack
     * @throws NoSuchElementException Quando lo stack è vuoto
     */
    @Override
    public Object stackPop() throws NoSuchElementException {
        Object c = data.pop();
        return c;
    }

    /**
     * Metodo utilizzato per inserire un elemento in cima allo stack
     *
     * @param E -> Ogetto da inserire nello stack
     */
    @Override
    public void stackPush(Object E) {
        data.push(E);
    }

    /**
     * Metodo che verifica se ci sono elementi nello stack
     *
     * @return Boolean -> true se ci sono elementi, false altrimenti
     */
    @Override
    public boolean stackStatus() {
        return !data.isEmpty();
    }

    /**
     * Metodo utilizzato per convertire lo stack in una lista
     *
     * @return List(ComplexNumber) Lista di Numeri Complessi
     */
    @Override
    public List<ComplexNumber> convertToList() {
        List<ComplexNumber> stackToList = new ArrayList(data);
        return stackToList;
    }

    /**
     * Metodo utilizzato per stampare il contenuto dello stack
     *
     * @return {@link String} Le stringhe da stampare
     */
    @Override
    public String stackPrint() {
        return (data.toString());
    }

    /**
     * Metodo utilizzato per ottenere l'iteratore dello stack
     *
     * @return Iterator
     */
    @Override
    public Iterator stackElements() {
        return (data.iterator());
    }

    /**
     * Metodo utilizzato per cancellare tutti gli elementi dello stack
     */
    @Override
    public void clear() {
        data.clear();
    }

    /**
     * Metodo utilizzato per duplicare l'ultimo elemento dello stack
     *
     * @throws NoSuchElementException Quando non ci sono abbastanza elementi
     * nello stack
     */
    @Override
    public void duplicate() throws NoSuchElementException {
        Iterator iter = stackElements();
        if(iter.hasNext() == false)
            throw new NoSuchElementException("Non ci sono abbastanza elementi per la funzione dup");
        Object obj = iter.next();
        stackPush(obj);
    }

    /**
     * Metodo utilizzato per scambiare gli ultimi due elementi dello stack
     *
     * @throws NoSuchElementException Quando non ci sono abbastanza elementi
     * nello stack
     */
    @Override
    public void swap() throws NoSuchElementException {
        if (data.size() < 2) {
            throw new NoSuchElementException("Non ci sono abbastanza elementi per la funzione di swap");
        }
        Object c1 = stackPop();
        Object c2 = stackPop();

        stackPush(c1);
        stackPush(c2);

    }

    /**
     * Metodo utilizzato per eliminare l'ultimo elemento inserito nello stack
     *
     * @throws NoSuchElementException Quando lo stack è vuoto
     */
    @Override
    public void drop() throws NoSuchElementException {
        stackPop();
    }

    /**
     * Metodo utilizzato per duplicare il penultimo elemento dello stack
     *
     * @throws NoSuchElementException Quando non ci sono abbastanza elementi
     * nello stack
     */
    @Override
    public void over() throws NoSuchElementException {
        Iterator iter = stackElements();
        if(iter.hasNext() == false)
            throw new NoSuchElementException("Non ci sono abbastanza elementi per la funzione over");
        iter.next();
        if(iter.hasNext() == false)
            throw new NoSuchElementException("Non ci sono abbastanza elementi per la funzione over");
        Object obj = iter.next();

        stackPush(obj);
    }
}
