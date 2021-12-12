/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
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

    @Test
    public void createFunctionTest() {
        for (int i = 0; i < 999; i++) {
            String op = "test dup swap * - + / sqrt conj push ";
            List<String> opList = func.readOperations(op);

            HashMap<String, List<String>> functionMap = new HashMap<>();
            String optit = opList.get(0);
            HashMap<String, List<String>> functionMapTest = func.createFunction(opList);

            functionMap.put(optit, opList);

            assertEquals(functionMap, functionMapTest);
        }
    }

    @Test
    public void executeFunctionTest() {
        for (int i = 0; i < 999; i++) {

            int a = i % 26 + 97;
            char ch = (char) a;
            String str = String.valueOf(ch);

            int rangeMin = -100;
            int rangeMax = +100;

            coreStack.clear();
            Double a1 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
            Double a2 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
            Double b1 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
            Double b2 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
            Double c1 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
            Double c2 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
            Double d1 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
            Double d2 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
            Double e1 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
            Double e2 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
            Double f1 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
            Double f2 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
            Double g1 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
            Double g2 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
            Double h1 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
            Double h2 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
            Double i1 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();
            Double i2 = rangeMin + (rangeMax - rangeMin) * ran.nextDouble();

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
            String op3 = op2 + " >" + str + " +" + str + " -" + str + " <" + str;

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

            var.pushInVar(str);
            var.addInVar(str);
            var.diffInVar(str);
            var.popFromVar(str);

            List<ComplexNumber> listNumbers1 = coreStack.getSubList();

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

            List<String> operations = func.readOperations(op3);

            func.createFunction(operations);
            func.executeFunction(name);

            List<ComplexNumber> listNumbers2 = coreStack.getSubList();

            assertTrue(coreStack.compareStack(listNumbers1, listNumbers2));

        }
    }

    @Test
    public void saveFileTest() throws IOException {
        for (int i = 0; i < 999; i++) {
            String op = "test dup swap * - + / sqrt conj push ";

            List<String> opList = func.readOperations(op);

            HashMap<String, List<String>> functionMap = new HashMap<>();

            HashMap<String, List<String>> functionMapTest = func.createFunction(opList);

            functionMap.put(opList.remove(0), opList);

            Iterator<String> iter = opList.iterator();

            try {
                String nameFile = "testfile" + ".txt";
                FileWriter myWriter = new FileWriter(nameFile);
                myWriter.write("test");
                myWriter.write(" ");

                while (iter.hasNext()) {
                    myWriter.write(iter.next());
                    myWriter.write(" ");
                }

                myWriter.close();
            } catch (IOException e) {
                throw new IOException("Errore Creazione File");
            }
            func.saveFile("test");
            File myObj = new File("test.txt");
            Scanner myReader = new Scanner(myObj);

            String data = myReader.nextLine();

            File myObj2 = new File("testfile.txt");

            Scanner myReader2 = new Scanner(myObj2);
            String data2 = myReader2.nextLine();
            myReader2.close();
            myReader.close();
            assertTrue(data.equals(data2));
        }

    }

    @Test
    public void loadFile() throws FileNotFoundException, IOException {
        for (int i = 0; i < 999; i++) {
            String data = "test dup swap * - + / sqrt conj push ";
            try {

                String nameFile = "test" + ".txt";
                FileWriter myWriter = new FileWriter(nameFile);
                myWriter.write(data);
                myWriter.close();
            } catch (IOException e) {
                throw new IOException("Errore Creazione File");
            }

            try {
                File myObj = new File("test.txt");
                Scanner myReader = new Scanner(myObj);

                String data2 = myReader.nextLine();
                List<String> listOperations = func.readOperations(data2);

                func.createFunction(listOperations);

                myReader.close();
                assertTrue(data.equals(data2));

            } catch (FileNotFoundException e) {
                throw new FileNotFoundException("File non trovato");
            }

        }
    }

    //non funziona
    @Test
    public void deleteFunctionTest() throws NullPointerException {
        for (int i = 0; i < 999; i++) {
            String op = "test dup swap * - + / sqrt conj push ";
            HashMap<String, List<String>> functionMapTest2 = new HashMap<>();
            List<String> opList = func.readOperations(op);

            HashMap<String, List<String>> functionMapTest = func.createFunction(opList);
            if (functionMapTest.containsKey("test")) {
                functionMapTest.remove("test");
                functionMapTest2 = (HashMap<String, List<String>>) functionMapTest.clone();
            } else {
                throw new NullPointerException("Funzione non trovata");
            }
            List<String> opList2 = func.readOperations(op);
            func.createFunction(opList2);
            func.deleteFunction("test");
            assertEquals(functionMapTest2, functionMapTest);
        }
    }

    @Test
    public void strToComplexTest() throws NumberFormatException {
        coreStack.clear();
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
        core.creatNumber(a1, a2);
        core.creatNumber(b1, b2);
        core.creatNumber(c1, c2);
        core.creatNumber(d1, d2);
        core.creatNumber(e1, e2);
        core.creatNumber(f1, f2);
        core.creatNumber(g1, g2);
        core.creatNumber(h1, h2);
        core.creatNumber(i1, i2);
        List<ComplexNumber> listNumbers1 = coreStack.getSubList();

        coreStack.clear();
        func.strToComplex(i1.toString() + "+" + i2.toString() + "i");
        func.strToComplex(a1.toString() + "+" + a2.toString() + "i");
        func.strToComplex(b1.toString() + "+" + b2.toString() + "i");
        func.strToComplex(c1.toString() + "+" + c2.toString() + "i");
        func.strToComplex(d1.toString() + "+" + d2.toString() + "i");
        func.strToComplex(e1.toString() + "+" + e2.toString() + "i");
        func.strToComplex(f1.toString() + "+" + f2.toString() + "i");
        func.strToComplex(g1.toString() + "+" + g2.toString() + "i");
        func.strToComplex(h1.toString() + "+" + h2.toString() + "i");
        func.strToComplex(i1.toString() + "+" + i2.toString() + "i");

        List<ComplexNumber> listNumbers2 = coreStack.getSubList();

        assertTrue(coreStack.compareStack(listNumbers1, listNumbers2));

    }

    @Test
    public void isExpressionTest() {
        for (int i = 0; i < 999; i++) {
            String str = generateRandomWords(ran.nextInt());
            assertEquals(str.matches("[-+]?\\d+(\\.\\d+)?[-+]+\\d+(\\.\\d+)?i+"), func.isExpression(str));
        }
    }

    @Test
    public void isRealTest() {
        for (int i = 0; i < 999; i++) {
            String str = generateRandomWords(ran.nextInt());
            assertEquals(str.matches("[-+]?\\d+(\\.\\d+)?"), func.isReal(str));
        }
    }

    @Test
    public void isComplexTest() {
        for (int i = 0; i < 999; i++) {
            String str = generateRandomWords(ran.nextInt());
            assertEquals(str.matches("[-+]?\\d+(\\.\\d+)?i+"), func.isComplex(str));
            str.matches("");
        }
    }

    @Test
    public void isOperationTest() {
        for (int i = 0; i < 999; i++) {
            String str = generateRandomWords(ran.nextInt());
            assertEquals(str.matches("[-+<>][a-z]"), func.isOperation(str));
        }
    }

    @Test
    public void varFunctionTest() {
        String op = "test <a >a +a -a";
        String str;
        List<String> opList = func.readOperations(op);
        boolean bool = false;
        HashMap<String, List<String>> functionMapTest = func.createFunction(opList);

        opList.remove(0);

        Iterator<String> iter = opList.iterator();

        if (iter.hasNext()) {
            str = iter.next();

            if (str.startsWith(">")) {
                if (func.isVariable(str.substring(1, 2))) {
                    var.pushInVar(str.substring(1, 2));
                    bool = true;
                }
            }
            if (str.startsWith("<")) {
                if (func.isVariable(str.substring(1))) {
                    var.popFromVar(str.substring(1));
                    bool = true;
                }
            }
            if (str.startsWith("+")) {
                if (func.isVariable(str.substring(1))) {
                    var.addInVar(str.substring(1));
                    bool = true;
                }
            }
            if (str.startsWith("-")) {
                if (func.isVariable(str.substring(1))) {
                    var.diffInVar(str.substring(1));
                    bool = true;
                }
            }

        }
        assertEquals(bool, true);
    }

    @Test
    public void isVariableTest() {
        for (int i = 0; i < 999; i++) {
            String str = generateRandomWords(ran.nextInt());
            assertEquals(str.matches("[a-z]"), func.isVariable(str));
        }
    }

    private static String generateRandomWords(int numberOfWords) {
        // create a string of uppercase and lowercase characters and numbers
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        // combine all strings
        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 10;

        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphaNumeric.length());

            // get character specified by index
            // from the string
            char randomChar = alphaNumeric.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        String randomString = sb.toString();
        return randomString;

    }

}
