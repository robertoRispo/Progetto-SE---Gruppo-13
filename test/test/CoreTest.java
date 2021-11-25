package test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import java.util.Random;
import model.Core;
import model.ComplexNumber;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author agostinomoffa
 */
public class CoreTest {

    public Core test;
    public Random ran;

    public CoreTest() {
        this.test = new Core();
        this.ran = new Random();
    }

    @Before
    public void setUpClass() {
        for (int i = 0; i < 0; i++) {
            test.creatNumber(ran.nextInt(), ran.nextInt());
        }

    }
    
    
    
    @Test
    public void testCreatNumber(){
        int a, b;
        ComplexNumber j;
        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            test.creatNumber(a, b);     
            j = new ComplexNumber(a, b);


            assertEquals(j.equals(test.popFromStack()), true);

        }
    }
  
    @Test
    public void testSommaInStack() {
        int a, b, c, d;
        ComplexNumber j;
        ComplexNumber k;
        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            c = ran.nextInt();
            d = ran.nextInt();
            test.creatNumber(a, b);
            test.creatNumber(c, d);
            test.sumInStack();
            j = new ComplexNumber(a, b);
            k = new ComplexNumber(c, d);

            assertEquals(ComplexNumber.sum(j, k).equals(test.popFromStack()), true);

        }
       
    }

    @Test
    public void testDiffInStack() {
        int a, b, c, d;
        ComplexNumber j;
        ComplexNumber k;
        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            c = ran.nextInt();
            d = ran.nextInt();
            test.creatNumber(a, b);
            test.creatNumber(c, d);
            test.diffInStack();
            j = new ComplexNumber(a, b);
            k = new ComplexNumber(c, d);

            assertEquals(ComplexNumber.sub(k, j).equals(test.popFromStack()), true);

        }
    }

    @Test
    public void testProdInStack() {
        int a, b, c, d;
        ComplexNumber j;
        ComplexNumber k;
        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            c = ran.nextInt();
            d = ran.nextInt();
            test.creatNumber(a, b);
            test.creatNumber(c, d);
            test.prodInStack();
            j = new ComplexNumber(a, b);
            k = new ComplexNumber(c, d);

            assertEquals(ComplexNumber.multiplication(k, j).equals(test.popFromStack()), true);

        }

    }

    
    @Test
    public void testDivInStack(){
         int a, b, c, d;
        ComplexNumber j;
        ComplexNumber k;
        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            c = ran.nextInt();
            d = ran.nextInt();
            test.creatNumber(a, b);
            test.creatNumber(c, d);
            test.divInStack();
            j = new ComplexNumber(a, b);
            k = new ComplexNumber(c, d);

            assertEquals(ComplexNumber.division(k, j).equals(test.popFromStack()), true);

        }
    } 
    
    
    @Test
    public void testsquare2InStack(){
        int a, b;
        ComplexNumber j;
        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            test.creatNumber(a, b);     
            test.square2InStack();
            j = new ComplexNumber(a, b);


            assertEquals(j.sqrt().equals(test.popFromStack()), true);

        }
    }
}
