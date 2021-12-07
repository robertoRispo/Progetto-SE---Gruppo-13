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
    
    @Test
    public void testSaveRestoreVar(){
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
         op.creatNumber(c, d);   } 
        for (int i = 0; i < 199; i++){
            var.addInVar(a);
            var.diffInVar(a2);
            var.diffInVar(a3);
            var.addInVar(a4);
            var.diffInVar(a5);
            
        }
        var.restoreVar();
        
      
        assertEquals(num6.equals(var.getVar(a)),true);
        assertEquals(num7.equals(var.getVar(a2)),true);
        assertEquals(num8.equals(var.getVar(a3)),true);
        assertEquals(num9.equals(var.getVar(a4)),true);
        assertEquals(num10.equals(var.getVar(a5)),true);
        var.restoreVar();
         
        
        assertEquals(num.equals(var.getVar(a)),true);
        assertEquals(num2.equals(var.getVar(a2)),true);
        assertEquals(num3.equals(var.getVar(a3)),true);
        assertEquals(num4.equals(var.getVar(a4)),true);
        assertEquals(num5.equals(var.getVar(a5)),true);
    }

}