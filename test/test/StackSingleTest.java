/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test;

import java.util.NoSuchElementException;
import model.StackOp;
import model.StackSingle;
import org.junit.Test;
import static org.junit.Assert.*;


public class StackSingleTest {
    private final StackOp data;
    Integer a,b,c,d;
    public StackSingleTest() {
        this.data = StackSingle.getInstance();
         
    }
    
 
     @Test
    public void testDuplicate() {
    a = 100;
    data.stackPush(a);
    data.duplicate();
    b = (Integer) data.stackPop();
    c = (Integer) data.stackPop();
    assertTrue(b.equals(c));
    
    }
    
    
    
    @Test(expected = NoSuchElementException.class)
    public void testDupEx(){
        data.clear();
        data.duplicate();
    }
    
    
    
    @Test
    public void testSwap(){
        a = 100;
        b = 200;
        data.stackPush(a);
        data.stackPush(b);
        data.swap();
        c = (Integer) data.stackPop();
        assertTrue(c.equals(a));
        d = (Integer) data.stackPop();
        assertTrue(d.equals(b));
        
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testSwapEx(){
        data.clear();
        data.swap();
    }
    
    

    
    @Test
    public void testOver(){
         a = 100;
         b = 500;
         c = 700;
        data.stackPush(a);
        data.stackPush(b);
        data.stackPush(c);
        data.over();
        assertTrue(b.equals(data.stackPop()));
        
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testOverEx(){
        a = 100;
        data.stackPush(a);
        data.swap();
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testStackPopEx(){
        data.clear();
        data.stackPop();
    }
}
