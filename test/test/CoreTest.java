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


public class CoreTest {

    public Core core;
    public Random ran;
    public int a, b, c, d;
    public ComplexNumber j;
    public ComplexNumber k;
    private final StackOp data;

    public CoreTest() {
        this.core = new Core();
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
            core.creatNumber(a, b);
            j = new ComplexNumber(a, b);

            assertTrue(j.equals(core.popFromStack()));

        }
    }

    @Test
    public void testPushPopinStack() {

        a = ran.nextInt();
        b = ran.nextInt();
        j = new ComplexNumber(a, b);
        core.pushInStack(j);
        k = core.popFromStack();
        assertTrue(k.equals(j));

    }

    @Test(expected = NoSuchElementException.class)
    public void testPopFromStackEx() {
        core.popFromStack();
    }

    @Test
    public void testSumInStack() {
        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            c = ran.nextInt();
            d = ran.nextInt();
            core.creatNumber(a, b);
            core.creatNumber(c, d);
            core.sumInStack();
            j = new ComplexNumber(a, b);
            k = new ComplexNumber(c, d);

            assertTrue(ComplexNumber.sum(j, k).equals(core.popFromStack()));

        }

    }

    @Test(expected = EmptyStackException.class)
    public void testSumInStackEx() {

        core.sumInStack();
    }

    @Test(expected = EmptyStackException.class)
    public void testSumInStackEx1elem() {
        a = ran.nextInt();
        b = ran.nextInt();
        core.creatNumber(a, b);
        core.sumInStack();
    }

    @Test
    public void testDiffInStack() {
        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            c = ran.nextInt();
            d = ran.nextInt();
            core.creatNumber(a, b);
            core.creatNumber(c, d);
            core.diffInStack();
            j = new ComplexNumber(a, b);
            k = new ComplexNumber(c, d);

            assertTrue(ComplexNumber.sub(k, j).equals(core.popFromStack()));

        }
    }

    @Test(expected = EmptyStackException.class)
    public void testDiffInStackEx() {
        core.diffInStack();
    }

    @Test(expected = EmptyStackException.class)
    public void testDiffInStackEx1elem() {
        a = ran.nextInt();
        b = ran.nextInt();
        core.creatNumber(a, b);
        core.diffInStack();
    }

    @Test
    public void testProdInStack() {
        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            c = ran.nextInt();
            d = ran.nextInt();
            core.creatNumber(a, b);
            core.creatNumber(c, d);
            core.prodInStack();
            j = new ComplexNumber(a, b);
            k = new ComplexNumber(c, d);

            assertTrue(ComplexNumber.multiplication(k, j).equals(core.popFromStack()));

        }

    }

    @Test(expected = EmptyStackException.class)
    public void testProdInStackEx() {
        core.prodInStack();
    }

    @Test(expected = EmptyStackException.class)
    public void testProdInStackEx1elem() {
        a = ran.nextInt();
        b = ran.nextInt();
        core.creatNumber(a, b);
        core.prodInStack();
    }

    @Test
    public void testDivInStack() {
        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            c = ran.nextInt();
            d = ran.nextInt();
            core.creatNumber(a, b);
            core.creatNumber(c, d);
            core.divInStack();
            j = new ComplexNumber(a, b);
            k = new ComplexNumber(c, d);

            assertTrue(ComplexNumber.division(k, j).equals(core.popFromStack()));

        }
    }

    @Test(expected = EmptyStackException.class)
    public void testDivInStackEx() {
        core.divInStack();
    }

    @Test(expected = EmptyStackException.class)
    public void testDivInStackEx1elem() {
        a = ran.nextInt();
        b = ran.nextInt();
        core.creatNumber(a, b);
        core.divInStack();
    }

    @Test
    public void testSquare2InStack() {

        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            core.creatNumber(a, b);
            core.square2InStack();
            j = new ComplexNumber(a, b);

            assertTrue(j.sqrt().equals(core.popFromStack()));

        }
    }

    @Test(expected = EmptyStackException.class)
    public void testSquare2InStackEx() {
        core.square2InStack();
    }

    @Test
    public void testConjugatedInStack() {

        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            core.creatNumber(a, b);
            core.conjugatedInStack();
            j = new ComplexNumber(a, b);

            assertTrue(j.conjugated().equals(core.popFromStack()));

        }
    }

    @Test(expected = EmptyStackException.class)
    public void testConjugated2InStackEx() {
        core.conjugatedInStack();
    }

    @Test
    public void testModInStack() {

        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            core.creatNumber(a, b);
            core.modInStack();
            j = new ComplexNumber(a, b);
            k = core.popFromStack();

            assertTrue(j.mod() == k.re());
            assertTrue(k.im() == 0);
        }
    }

    @Test(expected = EmptyStackException.class)
    public void testModInStackEx() {
        core.modInStack();
    }

    @Test
    public void testAbsInStack() {

        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            core.creatNumber(a, b);
            core.absInStack();
            j = new ComplexNumber(a, b);
            k = core.popFromStack();

            assertTrue(j.abs() == k.re());
            assertTrue(k.im() == 0);
        }
    }

    @Test(expected = EmptyStackException.class)
    public void testAbsInStackEx() {
        core.absInStack();
    }
}
