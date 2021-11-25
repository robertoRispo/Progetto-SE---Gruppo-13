/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author agostinomoffa
 */
public interface StackOp {
    public Object StackPop();
    public void StackPush(Object E);
    public boolean StackStatus();
    public List<ComplexNumber> convertiLista();
    public String stackPrint();
}
