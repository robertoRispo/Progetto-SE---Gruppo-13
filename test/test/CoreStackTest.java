/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import model.ComplexNumber;
import model.Core;
import model.CoreStack;
import model.StackOp;
import model.StackSingle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author agostinomoffa
 */
public class CoreStackTest {
    public CoreStack coreStack;
    private final StackOp data;
    public Random ran;
    public ComplexNumber j;
    public ComplexNumber k,i;
    public Core core;
    
    
    public CoreStackTest() {
        this.coreStack = new CoreStack();
        this.data = StackSingle.getInstance();
        this.ran = new Random();
        this.core = new Core();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        data.clear();
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCompareStack() {
        List<ComplexNumber> lc1 = new ArrayList();
        List<ComplexNumber> lc2 = new ArrayList();
        j = new ComplexNumber(7, 10);
        k = new ComplexNumber(10, 7);
        
        lc1.add(j);
        lc2.add(k);
        assertFalse(coreStack.compareStack(lc1, lc2));
        lc2.clear();
        i = new ComplexNumber(7,10);
        lc2.add(i);
        assertTrue(coreStack.compareStack(lc1, lc2)
        );
        
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testOverEx(){
        coreStack.over();
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testDropEx(){
        coreStack.drop();
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testSwapEx(){
        coreStack.swap();
    }
    
      @Test(expected = NoSuchElementException.class)
    public void testDuplicateEx(){
        coreStack.duplicate();
    }
    
    @Test
    public void testSubList(){
        List<ComplexNumber> lc1;
        core.creatNumber(-1, -2);
        core.creatNumber(0, 0);
        core.creatNumber(1, 2);
        core.creatNumber(3, 4);
        core.creatNumber(5, 6);
        core.creatNumber(7, 8);
        core.creatNumber(9, 10);
        core.creatNumber(11, 12);
        core.creatNumber(13, 14);
        core.creatNumber(15, 16);
        core.creatNumber(17, 18);
        core.creatNumber(19, 20);
        core.creatNumber(21, 22);
        core.creatNumber(23, 24);
        core.creatNumber(25, 26);
        core.creatNumber(27, 28);
        lc1 = coreStack.getSubList();
        int re = 27;
        int img = 28;
        int element = 12;
        for (ComplexNumber num : lc1){
              j = new ComplexNumber(re, img);
            assertTrue(num.equals(j));
            re -= 2;
            img -= 2;
            element -= 1;
            
        }
        assertTrue(element == 0);
        
        

        
    }
}
