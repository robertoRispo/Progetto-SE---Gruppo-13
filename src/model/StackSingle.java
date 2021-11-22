package model;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Stack;

/**
 *
 * @author agostinomoffa
 */
public class StackSingle implements StackOp{
    private static StackSingle istanza = null;
    private Stack data;
    private StackSingle(){
        this.data = new Stack();
    }
    public static StackSingle getInstance(){
        if (istanza == null){
            istanza =  new StackSingle();
        }
        return istanza;
    }
   

    @Override
    public Object StackPop() {
        Object c = data.pop();
        return c;
    }

    @Override
    public void StackPush(Object E) {
      data.push(E);
    }
    
    
}
