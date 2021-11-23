package test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import java.util.Random;
import model.Core;
import model.NumeroComplesso;
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
            test.creaNumero(ran.nextInt(), ran.nextInt());
        }

    }
    
    
    
    @Test
    public void testCreaNumero(){
        int a, b;
        NumeroComplesso j;
        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            test.creaNumero(a, b);     
            j = new NumeroComplesso(a, b);


            assertEquals(j.equals(test.popFromStack()), true);

        }
    }
  
    @Test
    public void testSommaInStack() {
        int a, b, c, d;
        NumeroComplesso j;
        NumeroComplesso k;
        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            c = ran.nextInt();
            d = ran.nextInt();
            test.creaNumero(a, b);
            test.creaNumero(c, d);
            test.sommaInStack();
            j = new NumeroComplesso(a, b);
            k = new NumeroComplesso(c, d);

            assertEquals(NumeroComplesso.somma(j, k).equals(test.popFromStack()), true);

        }
       
    }

    @Test
    public void testDiffInStack() {
        int a, b, c, d;
        NumeroComplesso j;
        NumeroComplesso k;
        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            c = ran.nextInt();
            d = ran.nextInt();
            test.creaNumero(a, b);
            test.creaNumero(c, d);
            test.diffInStack();
            j = new NumeroComplesso(a, b);
            k = new NumeroComplesso(c, d);

            assertEquals(NumeroComplesso.sottrazione(k, j).equals(test.popFromStack()), true);

        }
    }

    @Test
    public void testProdInStack() {
        int a, b, c, d;
        NumeroComplesso j;
        NumeroComplesso k;
        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            c = ran.nextInt();
            d = ran.nextInt();
            test.creaNumero(a, b);
            test.creaNumero(c, d);
            test.prodInStack();
            j = new NumeroComplesso(a, b);
            k = new NumeroComplesso(c, d);

            assertEquals(NumeroComplesso.moltiplicazione(k, j).equals(test.popFromStack()), true);

        }

    }

    
    @Test
    public void testDivInStack(){
         int a, b, c, d;
        NumeroComplesso j;
        NumeroComplesso k;
        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            c = ran.nextInt();
            d = ran.nextInt();
            test.creaNumero(a, b);
            test.creaNumero(c, d);
            test.divInStack();
            j = new NumeroComplesso(a, b);
            k = new NumeroComplesso(c, d);

            assertEquals(NumeroComplesso.divisione(k, j).equals(test.popFromStack()), true);

        }
    } 
    
    
    @Test
    public void testradiceInStack(){
        int a, b;
        NumeroComplesso j;
        for (int i = 0; i < 999; i++) {
            a = ran.nextInt();
            b = ran.nextInt();
            test.creaNumero(a, b);     
            test.radiceInStack();
            j = new NumeroComplesso(a, b);


            assertEquals(j.radiceQuadra().equals(test.popFromStack()), true);

        }
    }
}
