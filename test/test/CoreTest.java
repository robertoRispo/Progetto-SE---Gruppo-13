package test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Random;
import model.Core;
import model.ComplexNumber;
import model.StackOp;
import model.StackSingle;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author agostinomoffa
 */
public class CoreTest {

    public Core test;
    public Random ran;
    public int a, b, c, d;
    public ComplexNumber j;
    public ComplexNumber k;
    private final StackOp data;

    public CoreTest() {
        this.test = new Core();
        this.ran = new Random();
        this.data = StackSingle.getInstance();
    }

    @After
    public void clearStack(){
        this.data.clear();
    }
    
    
    
    @Test
    public void testCreatNumber() {

        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            test.creatNumber(a, b);
            j = new ComplexNumber(a, b);

            assertTrue(j.equals(test.popFromStack()));

        }
    }

    @Test
    public void testPushPopinStack() {

        a = ran.nextInt();
        b = ran.nextInt();
        j = new ComplexNumber(a, b);
        test.pushInStack(j);
        k = test.popFromStack();
        assertTrue(k.equals(j));

    }

    @Test(expected = NoSuchElementException.class)
    public void testPopFromStackEx() {
        test.popFromStack();
    }

    @Test
    public void testSumInStack() {
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

            assertTrue(ComplexNumber.sum(j, k).equals(test.popFromStack()));

        }

    }

    @Test(expected = EmptyStackException.class)
    public void testSumInStackEx() {

        test.sumInStack();
    }

    @Test(expected = EmptyStackException.class)
    public void testSumInStackEx1elem() {
        a = ran.nextInt();
        b = ran.nextInt();
        test.creatNumber(a, b);
        test.sumInStack();
    }

    @Test
    public void testDiffInStack() {
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

            assertTrue(ComplexNumber.sub(k, j).equals(test.popFromStack()));

        }
    }

    @Test(expected = EmptyStackException.class)
    public void testDiffInStackEx() {
        test.diffInStack();
    }

    @Test(expected = EmptyStackException.class)
    public void testDiffInStackEx1elem() {
        a = ran.nextInt();
        b = ran.nextInt();
        test.creatNumber(a, b);
        test.diffInStack();
    }

    @Test
    public void testProdInStack() {
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

            assertTrue(ComplexNumber.multiplication(k, j).equals(test.popFromStack()));

        }

    }

    @Test(expected = EmptyStackException.class)
    public void testProdInStackEx() {
        test.prodInStack();
    }

    @Test(expected = EmptyStackException.class)
    public void testProdInStackEx1elem() {
        a = ran.nextInt();
        b = ran.nextInt();
        test.creatNumber(a, b);
        test.prodInStack();
    }

    @Test
    public void testDivInStack() {
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

            assertTrue(ComplexNumber.division(k, j).equals(test.popFromStack()));

        }
    }

    @Test(expected = EmptyStackException.class)
    public void testDivInStackEx() {
        test.divInStack();
    }

    @Test(expected = EmptyStackException.class)
    public void testDivInStackEx1elem() {
        a = ran.nextInt();
        b = ran.nextInt();
        test.creatNumber(a, b);
        test.divInStack();
    }

    @Test
    public void testSquare2InStack() {

        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            test.creatNumber(a, b);
            test.square2InStack();
            j = new ComplexNumber(a, b);

            assertTrue(j.sqrt().equals(test.popFromStack()));

        }
    }

    @Test(expected = EmptyStackException.class)
    public void testSquare2InStackEx() {
        test.square2InStack();
    }

    @Test
    public void testConjugatedInStack() {

        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            test.creatNumber(a, b);
            test.conjugatedInStack();
            j = new ComplexNumber(a, b);

            assertTrue(j.conjugated().equals(test.popFromStack()));

        }
    }

    @Test(expected = EmptyStackException.class)
    public void testConjugated2InStackEx() {
        test.conjugatedInStack();
    }

    @Test
    public void testModInStack() {

        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            test.creatNumber(a, b);
            test.modInStack();
            j = new ComplexNumber(a, b);
            k = test.popFromStack();

            assertTrue(j.mod() == k.re());
            assertTrue(k.im() == 0);
        }
    }

    @Test(expected = EmptyStackException.class)
    public void testModInStackEx() {
        test.modInStack();
    }

    @Test
    public void testAbsInStack() {

        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            test.creatNumber(a, b);
            test.absInStack();
            j = new ComplexNumber(a, b);
            k = test.popFromStack();

            assertTrue(j.abs() == k.re());
            assertTrue(k.im() == 0);
        }
    }

    @Test(expected = EmptyStackException.class)
    public void testAbsInStackEx() {
        test.absInStack();
    }
}
