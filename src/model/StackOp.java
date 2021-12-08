/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public interface StackOp {

    /**
     * Metodo per effettuare il pop dallo stack
     *
     * @return l'elemento presenta sulla cima dello stack
     * @throws NoSuchElementException se non ci sono elementi nello stack
     */
    public Object stackPop() throws NoSuchElementException;

    /**
     * Metodo per effettuare il push di un elemento nello stack
     */
    public void stackPush(Object E);

    /**
     * Metodo che controlla lo stato dello stack
     *
     * @return true/false in correlazione allo stato dello stack
     */
    public boolean stackStatus();

    /**
     * Metodo che ritorna una lista iterabile dello stack
     *
     * @return lista iterabile dello stack
     */
    public List<ComplexNumber> convertToList();

    /**
     * Metodo utilizzato per effettuare il print dello stack
     *
     * @return la stringa da printare
     */
    public String stackPrint();

    /**
     * Metodo utilizzato per creare un iteratore sullo stack
     *
     * @return Iteratore dello stack
     */
    public Iterator stackElements();

    /**
     * Metodo utilizzato per rimuovere tutti gli elementi dallo stack
     */
    public void clear();

    /**
     * Metodo utilizzato per duplicare l'elemento in cima allo stack
     *
     * @throws NoSuchElementException se non ci sono elementi nello stack
     */
    public void duplicate() throws NoSuchElementException;

    /**
     * Metodo utilizzato per swappare gli ultimi due elementi nello stack
     *
     * @throws NoSuchElementException se non ci sono abaastanza elementi
     */
    public void swap() throws NoSuchElementException;

    /**
     * Metodo utilizzato per rimuovere l'elemento in cima allo stack
     *
     * @throws NoSuchElementException se non ci sono abaastanza elementi
     */
    public void drop() throws NoSuchElementException;

    /**
     * Metodo utilizzato per copiare il penultimo elemento presente nello stack
     *
     * @throws NoSuchElementException se non ci sono abaastanza elementi
     */
    public void over() throws NoSuchElementException;
}
