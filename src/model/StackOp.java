/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author agostinomoffa
 */
public interface StackOp {
  
    public Object stackPop();
    public void stackPush(Object E);
    public boolean stackStatus();
    public List<ComplexNumber> convertiLista();
    public String stackPrint();
    public Iterator stackElements();
}
