/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author agostinomoffa
 */
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
    void inversionInStack();
    ComplexNumber popFromStack();
}
