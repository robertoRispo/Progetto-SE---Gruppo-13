/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.HashMap;
import model.ComplexNumber;
import model.StackOp;
import model.StackSingle;

/**
 *
 * @author agostinomoffa
 */
public class Variables{
    private StackOp data;
    HashMap <String, ComplexNumber> variables;
    
    public Variables() {
        data = StackSingle.getInstance();
        variables = new HashMap<>();
    }
    
    public void pushInVar(String a) {
        ComplexNumber num = (ComplexNumber) data.stackPop();
        variables.put(a, num);
        
    }


    public void popFromVar(String a) {
        
       ComplexNumber num = variables.get(a);
       if (num == null){
           return;
       }
       data.stackPush(num);
    }

 
    public void addInVar(String a) {
        ComplexNumber num = variables.get(a);
        ComplexNumber num2 = (ComplexNumber) data.stackPop();
        ComplexNumber sum = ComplexNumber.sum(num, num2);
        variables.put(a, sum);
    }


    public void diffInVar(String a) {
        ComplexNumber num = variables.get(a);
        ComplexNumber num2 = (ComplexNumber) data.stackPop();
        ComplexNumber sub = ComplexNumber.sub(num, num2);
        variables.put(a, sub);
    }
    
    public ComplexNumber getVar(String a){
        return variables.get(a);
    }
    
    @Override
    public String toString(){
        return variables.toString();
    }
}

