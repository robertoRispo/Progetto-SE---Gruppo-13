package test;

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

/**
 *
 * @author agostinomoffa
 */
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
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testPushInVar() {
        for(int i = 0; i < 999; i++){
        String a = (String.valueOf((char)(ran.nextInt(26) + 'a')));
        ComplexNumber num = new ComplexNumber(ran.nextInt(), ran.nextInt());
        op.pushInStack(num);
        var.pushInVar(a);
        assertEquals(num.equals(var.getVar(a)),true);
        }
        System.out.println(var.toString());
    }
    
    @Test
    public void testPopFromVar(){
        for(int i = 0; i < 999; i++){
        String a = (String.valueOf((char)(ran.nextInt(26) + 'a')));
        ComplexNumber num = new ComplexNumber(ran.nextInt(), ran.nextInt());
        op.pushInStack(num);
        var.pushInVar(a);
        assertEquals(data.stackStatus(), false);
        var.popFromVar(a);
        ComplexNumber num2 = op.popFromStack();
        assertEquals(num.equals(num2), true);
    }
    }
    
    
    @Test
    public void testAddInVar(){
           for(int i = 0; i < 999; i++){
        String a = (String.valueOf((char)(ran.nextInt(26) + 'a')));
        ComplexNumber num = new ComplexNumber(ran.nextInt(), ran.nextInt());
        ComplexNumber num2 = new ComplexNumber(ran.nextInt(), ran.nextInt());
        ComplexNumber sum = ComplexNumber.sum(num, num2);
        op.pushInStack(num);
        var.pushInVar(a);
        op.pushInStack(num2);
        var.addInVar(a);
        ComplexNumber num4 = var.getVar(a);
        assertEquals(sum.equals(num4),true);
    }
}
    @Test
    public void testDiffInVar(){
           for(int i = 0; i < 999; i++){
        String a = (String.valueOf((char)(ran.nextInt(26) + 'a')));
        ComplexNumber num = new ComplexNumber(ran.nextInt(), ran.nextInt());
        ComplexNumber num2 = new ComplexNumber(ran.nextInt(), ran.nextInt());
        ComplexNumber diff = ComplexNumber.sub(num, num2);
        op.pushInStack(num);
        var.pushInVar(a);
        op.pushInStack(num2);
        var.diffInVar(a);
        ComplexNumber num4 = var.getVar(a);
        assertEquals(diff.equals(num4),true);
    }
}

}