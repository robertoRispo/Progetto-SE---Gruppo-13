/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import model.ComplexNumber;
import model.Core;
import model.CoreStack;
import model.Operations;
import model.StackOp;
import model.StackSingle;
import model.Variables;
import model.Functions;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class FunctionsTest {

    public Variables var;
    public CoreStack coreStack;
    public Random ran;
    public Operations core;
    public StackOp data;
    public Functions func;

    public FunctionsTest() {
        this.var = new Variables();
        this.ran = new Random();
        this.core = new Core();
        this.coreStack = new CoreStack();
        this.func = new Functions(core, coreStack, var);
        this.data = StackSingle.getInstance();

    }

    @Test
    public void readOperationsTest() {
        List<String> listOp1 = new ArrayList<String>(Arrays.asList("uno"));
        String op1 = "uno";
        List<String> listOp2 = new ArrayList<String>(Arrays.asList("uno", "due"));
        String op2 = "uno due";
        List<String> listOp3 = new ArrayList<String>(Arrays.asList("uno", "due", "tre"));
        String op3 = "uno due tre";
        List<String> listOp4 = new ArrayList<String>(Arrays.asList("uno", "due", "tre", "quattro"));
        String op4 = "uno due tre quattro";

        assertEquals(listOp1, func.readOperations(op1));
        assertEquals(listOp2, func.readOperations(op2));
        assertEquals(listOp3, func.readOperations(op3));
        assertEquals(listOp4, func.readOperations(op4));
    }

    //Serve un metodo per comparare le Mappe
    @Test
    public void createFunctionTest() {
        String op = "test dup swap * - + / sqrt conj push ";
        List<String> opList = func.readOperations(op);

        HashMap<String, List<String>> functionMap = new HashMap<>();

        HashMap<String, List<String>> functionMapTest = func.createFunction(opList);

        functionMap.put(opList.remove(0), opList);

        assertEquals(functionMap, functionMapTest);
    }

    @Test
    public void executeFunctionTest() {

        Double a1 = ran.nextDouble();
        Double a2 = ran.nextDouble();
        Double b1 = ran.nextDouble();
        Double b2 = ran.nextDouble();
        Double c1 = ran.nextDouble();
        Double c2 = ran.nextDouble();
        Double d1 = ran.nextDouble();
        Double d2 = ran.nextDouble();
        Double e1 = ran.nextDouble();
        Double e2 = ran.nextDouble();
        Double f1 = ran.nextDouble();
        Double f2 = ran.nextDouble();
        Double g1 = ran.nextDouble();
        Double g2 = ran.nextDouble();
        Double h1 = ran.nextDouble();
        Double h2 = ran.nextDouble();
        Double i1 = ran.nextDouble();
        Double i2 = ran.nextDouble();

        core.creatNumber(i1, i2);
        ComplexNumber cn = core.popFromStack();

        core.creatNumber(a1, a2);
        core.creatNumber(b1, b2);
        core.creatNumber(c1, c2);
        core.creatNumber(d1, d2);
        core.creatNumber(e1, e2);
        core.creatNumber(f1, f2);
        core.creatNumber(g1, g2);
        core.creatNumber(h1, h2);
        core.creatNumber(i1, i2);

        String op = "test dup swap * - + / sqrt conj push ";
        String op1 = op + cn.toString();
        String op2 = op1 + " pop";

        String name = "test";

        coreStack.duplicate();
        coreStack.swap();
        core.prodInStack();
        core.diffInStack();
        core.sumInStack();
        core.divInStack();
        core.square2InStack();
        core.conjugatedInStack();
        core.pushInStack(cn);
        core.popFromStack();

        List<ComplexNumber> listNumbers1 = coreStack.getSubList();
        System.out.println(listNumbers1);

        coreStack.clear();

        core.creatNumber(a1, a2);
        core.creatNumber(b1, b2);
        core.creatNumber(c1, c2);
        core.creatNumber(d1, d2);
        core.creatNumber(e1, e2);
        core.creatNumber(f1, f2);
        core.creatNumber(g1, g2);
        core.creatNumber(h1, h2);
        core.creatNumber(i1, i2);

        List<String> operations = func.readOperations(op2);
        System.out.println("Lista Operazioni:" + operations.toString());

        func.createFunction(operations);
        func.executeFunction(name);

        List<ComplexNumber> listNumbers2 = coreStack.getSubList();
        System.out.println(listNumbers2);

        assertTrue(coreStack.compareStack(listNumbers1, listNumbers2));

    }

}
