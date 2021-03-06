package test;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Random;
import model.ComplexNumber;
import model.Core;
import model.Operations;
import model.StackOp;
import model.StackSingle;
import model.Variables;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class VariablesTest {

    public Variables var;
    public Random ran;
    public Operations op;
    public StackOp data;

    public VariablesTest() {
        this.var = new Variables();
        this.ran = new Random();
        this.op = new Core();
        this.data = StackSingle.getInstance();
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
    public void clearVar() {
        var.clearVar();

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testPushInVar() {
        for (int i = 0; i < 999; i++) {
            String a = (String.valueOf((char) (ran.nextInt(26) + 'a')));
            ComplexNumber num = new ComplexNumber(ran.nextInt(), ran.nextInt());
            op.pushInStack(num);
            var.pushInVar(a);
            assertTrue(num.equals(var.getVar(a)));
        }
        System.out.println(var.toString());
    }

    @Test
    public void testPopFromVar() {
        for (int i = 0; i < 999; i++) {
            String a = (String.valueOf((char) (ran.nextInt(26) + 'a')));
            ComplexNumber num = new ComplexNumber(ran.nextInt(), ran.nextInt());
            op.pushInStack(num);
            var.pushInVar(a);
            assertFalse(data.stackStatus());
            var.popFromVar(a);
            ComplexNumber num2 = op.popFromStack();
            assertTrue(num.equals(num2));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopFromVarEx() {
        String a = (String.valueOf((char) (ran.nextInt(26) + 'a')));
        var.popFromVar(a);
    }

    @Test
    public void testAddInVar() {
        for (int i = 0; i < 999; i++) {
            String a = (String.valueOf((char) (ran.nextInt(26) + 'a')));
            ComplexNumber num = new ComplexNumber(ran.nextInt(), ran.nextInt());
            ComplexNumber num2 = new ComplexNumber(ran.nextInt(), ran.nextInt());
            ComplexNumber sum = ComplexNumber.sum(num, num2);
            op.pushInStack(num);
            var.pushInVar(a);
            op.pushInStack(num2);
            var.addInVar(a);
            ComplexNumber num4 = var.getVar(a);
            assertTrue(sum.equals(num4));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testAddInVarEx() {
        String a = (String.valueOf((char) (ran.nextInt(26) + 'a')));
        var.addInVar(a);
    }

    @Test
    public void testDiffInVar() {
        for (int i = 0; i < 999; i++) {
            String a = (String.valueOf((char) (ran.nextInt(26) + 'a')));
            ComplexNumber num = new ComplexNumber(ran.nextInt(), ran.nextInt());
            ComplexNumber num2 = new ComplexNumber(ran.nextInt(), ran.nextInt());
            ComplexNumber diff = ComplexNumber.sub(num, num2);
            op.pushInStack(num);
            var.pushInVar(a);
            op.pushInStack(num2);
            var.diffInVar(a);
            ComplexNumber num4 = var.getVar(a);
            assertTrue(diff.equals(num4));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testDiffInVarEx() {
        String a = (String.valueOf((char) (ran.nextInt(26) + 'a')));
        var.diffInVar(a);
    }

    @Test
    public void testSaveRestoreVar() {
        ComplexNumber num = new ComplexNumber(ran.nextInt(), ran.nextInt());
        ComplexNumber num2 = new ComplexNumber(ran.nextInt(), ran.nextInt());
        ComplexNumber num3 = new ComplexNumber(ran.nextInt(), ran.nextInt());
        ComplexNumber num4 = new ComplexNumber(ran.nextInt(), ran.nextInt());
        ComplexNumber num5 = new ComplexNumber(ran.nextInt(), ran.nextInt());
        String a = "a";
        String a2 = "b";
        String a3 = "c";
        String a4 = "d";
        String a5 = "e";
        op.pushInStack(num);
        var.pushInVar(a);
        op.pushInStack(num2);
        var.pushInVar(a2);
        op.pushInStack(num3);
        var.pushInVar(a3);
        op.pushInStack(num4);
        var.pushInVar(a4);
        op.pushInStack(num5);
        var.pushInVar(a5);

        var.saveVar();

        ComplexNumber num6 = new ComplexNumber(ran.nextInt(), ran.nextInt());
        ComplexNumber num7 = new ComplexNumber(ran.nextInt(), ran.nextInt());
        ComplexNumber num8 = new ComplexNumber(ran.nextInt(), ran.nextInt());
        ComplexNumber num9 = new ComplexNumber(ran.nextInt(), ran.nextInt());
        ComplexNumber num10 = new ComplexNumber(ran.nextInt(), ran.nextInt());

        op.pushInStack(num6);
        var.pushInVar(a);
        op.pushInStack(num7);
        var.pushInVar(a2);
        op.pushInStack(num8);
        var.pushInVar(a3);
        op.pushInStack(num9);
        var.pushInVar(a4);
        op.pushInStack(num10);
        var.pushInVar(a5);

        var.saveVar();

        //Riempio lo stack
        int c, d;
        for (int i = 0; i < 999; i++) {
            c = ran.nextInt();
            d = ran.nextInt();
            op.creatNumber(c, d);
        }
        for (int i = 0; i < 199; i++) {
            var.addInVar(a);
            var.diffInVar(a2);
            var.diffInVar(a3);
            var.addInVar(a4);
            var.diffInVar(a5);

        }
        var.restoreVar();

        assertTrue(num6.equals(var.getVar(a)));
        assertTrue(num7.equals(var.getVar(a2)));
        assertTrue(num8.equals(var.getVar(a3)));
        assertTrue(num9.equals(var.getVar(a4)));
        assertTrue(num10.equals(var.getVar(a5)));
        var.restoreVar();

        assertTrue(num.equals(var.getVar(a)));
        assertTrue(num2.equals(var.getVar(a2)));
        assertTrue(num3.equals(var.getVar(a3)));
        assertTrue(num4.equals(var.getVar(a4)));
        assertTrue(num5.equals(var.getVar(a5)));
    }

    @Test(expected = NoSuchElementException.class)
    public void testSaveEx() {
        var.saveVar();
    }

    @Test(expected = EmptyStackException.class)
    public void testRestoreVarEx() {
        var.restoreVar();
    }
}
