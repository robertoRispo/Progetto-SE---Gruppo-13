/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;


public interface Operations {
       /**
     * Metodo per effettuare la somma tra due elementi presenti nello stack
     */
    public void sumInStack();
    
     /**
     * Metodo per effettuare la differenza tra due elementi presenti nello stack
     */
    
    public void diffInStack();
       /**
     * Metodo per effettuare il prodotto tra due elementi presenti nello stack
     */
    public void prodInStack();
    /**
     * Metodo per effettuare la divisione tra due elementi nello stack
     */
    public void divInStack();
    /**
     * Metodo per creare un numero complesso nello stack
     */
    public void creatNumber(double a, double b);
      /**
     * Metodo per effettuare il push di un numero complesso nello stack
     */
    public void pushInStack(ComplexNumber a); 
     /**
     * Metodo per effettuare la radicequadrata di un elemento nello stack
     */
    public void square2InStack();
       /**
     * Metodo per effettuare il coniugato di un elemento nello stack
     */
    public void conjugatedInStack();
     /**
     * Metodo per effettuare il modulo di un elemento nello stack
     */
    public void modInStack();
      /**
     * Metodo per effettuare l'abs  di un elemento nello stack
     */
    public void absInStack();
         /**
     * Metodo per effettuare il pop di un numero complesso dallo stack
     */
    public ComplexNumber popFromStack();
}
