/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;


public interface Operations {
    void sumInStack();
    void diffInStack();
    void prodInStack();

    /**
     *
     */
    void divInStack();

    /**
     *
     * @return
     */
    void creatNumber(double a, double b);
    void pushInStack(ComplexNumber a); 
    void square2InStack();
    void conjugatedInStack();
    void modInStack();
    void absInStack();
    ComplexNumber popFromStack();
}
