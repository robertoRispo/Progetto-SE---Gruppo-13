/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.Random;
import model.Core;
import model.ComplexNumber;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author M3ssian
 */
public class ComplexNumberTest {
    public ComplexNumber test;
    public Random ran;
    

    public ComplexNumberTest() {
        this.ran = new Random();
        double a, b;
        a = ran.nextDouble();
        b = ran.nextDouble();
        this.test = new ComplexNumber(a,b);

    }
    

    /**
        Test della somma che restituicse errore nel caso non sia coerente.
    */
    @Test
    public void testSum()
        {
        for (int i = 0; i < 999; i++) {
        double a, b, c, d;
        a = ran.nextDouble();
        b = ran.nextDouble();
        c = ran.nextDouble();
        d = ran.nextDouble();
        
        ComplexNumber ncom = new ComplexNumber(a, b);
        ComplexNumber ncomd = new ComplexNumber(c, d);
        
        ComplexNumber test = ncom.sum(ncom,ncomd);
        double re = a + c;
        double im = b + d;
        ComplexNumber comp = new ComplexNumber(re, im);
        assertEquals(test.equals(comp), true);
    }}
    
    /**
        Test della sottrazione che restituicse errore nel caso non sia coerente.
    */
    @Test
    public void testSub(){
        for (int i = 0; i < 999; i++) {
        double a, b, c, d;
        a = ran.nextDouble();
        b = ran.nextDouble();
        c = ran.nextDouble();
        d = ran.nextDouble();
        
        ComplexNumber ncom = new ComplexNumber(a, b);
        ComplexNumber ncomd = new ComplexNumber(c, d);
        
        ComplexNumber test = ncom.sub(ncom,ncomd);
        double re = a - c;
        double im = b - d;
        ComplexNumber comp = new ComplexNumber(re, im);
        assertEquals(test.equals(comp), true);
    }   
    }
    /**
        Test della moltiplicazione che restituicse errore nel caso non sia coerente.
    */
    @Test
    public void testMultiplication(){
        for (int i = 0; i < 999; i++) {
        double a, b, c, d;
        a = ran.nextDouble();
        b = ran.nextDouble();
        c = ran.nextDouble();
        d = ran.nextDouble();
        
        ComplexNumber ncom = new ComplexNumber(a, b);
        ComplexNumber ncomd = new ComplexNumber(c, d);
        ComplexNumber test = ncom.multiplication(ncom,ncomd);
        double re = a * c - b * d;
        double im = a * b + c * d;
        ComplexNumber comp = new ComplexNumber(re, im);
        assertEquals(test.equals(comp), true);
    }}
    /**
        Test della divisione che restituicse errore nel caso non sia coerente.
    */
    @Test
    public void testDivision(){
        for (int i = 0; i < 999; i++) {
        double a, b, c, d;
        a = ran.nextDouble();
        b = ran.nextDouble();
        c = ran.nextDouble();
        d = ran.nextDouble();
        
        ComplexNumber ncom = new ComplexNumber(a, b);
        ComplexNumber ncomd = new ComplexNumber(c, d);
        
        ComplexNumber test = ComplexNumber.division(ncom, ncomd);     
        
        assertEquals(test.equals(ComplexNumber.multiplication(ncom, ncom.multiplication(1/ncomd.abs()/ncomd.abs(), ncomd.conjugated()))), true);
    }}
    
    /**
        Test del coniugato che restituicse errore nel caso non sia coerente.
    */
    @Test
    public void testConjugated(){
        for (int i = 0; i < 999; i++) {
        double a, b;
        a = ran.nextDouble();
        b = ran.nextDouble();
        
        ComplexNumber ncom = new ComplexNumber(a, -b);
        assertEquals(test.equals(ncom.conjugated()), true);
    }}
    /**
        Test che verifica se la parte reale è corretta e restituicse errore nel caso non sia coerente.
    */
    @Test
    public void testRe(){
        for (int i = 0; i < 999; i++) {
        double a, b;
        a = ran.nextDouble();
        b = ran.nextDouble();
        ComplexNumber ncom = new ComplexNumber(a, b);
        ComplexNumber ncomd = new ComplexNumber(a, b);
        
        assertEquals(ncom.equals(ncomd), true);
    }}
    /**
        Test che verifica se la parte reale è corretta e restituicse errore nel caso non sia coerente.
    */
    @Test
    public void testIm(){
        for (int i = 0; i < 999; i++) {
        double a, b;
        a = ran.nextDouble();
        b = ran.nextDouble();
        ComplexNumber ncom = new ComplexNumber(a, b);
        ComplexNumber ncomd = new ComplexNumber(a, b);
        if (ncom.re()==a){
        assertEquals(true, true);}
        else{
            assertEquals(false, true);
                }
    }}
    /**
        Test che verifica se il valore assoluto è corretto e restituicse errore nel caso non sia coerente.
    */
    @Test
    public void testAbs(){
        for (int i = 0; i < 999; i++) {
            double a, b;
        a = ran.nextDouble();
        b = ran.nextDouble();
        ComplexNumber ncom = new ComplexNumber(a, b);
        double c = Math.sqrt(a*a+b*b);
        
        assertEquals(ncom.abs()==c, true);}
        
    }
    /**
        Test che verifica se l'argomento è corretto e restituicse errore nel caso non sia coerente.
    */
    @Test
    public void testArg(){
        for (int i = 0; i < 999; i++) {
            double a, b;
        a = ran.nextDouble();
        b = ran.nextDouble();
        ComplexNumber ncom = new ComplexNumber(a, b);
        double c = Math.atan2(b,a);

        assertEquals(ncom.arg()==c, true);}

    }
    /**
        Test che verifica il modulo se è corretto e restituicse errore nel caso non sia coerente.
    */
    @Test
    public void testMod(){
        for (int i = 0; i < 999; i++) {
        double a, b;
        a = ran.nextDouble();
        b = ran.nextDouble();
        ComplexNumber ncom = new ComplexNumber(a, b);
        double c;
        if (a!=0 || b!=0) {
            c = Math.sqrt(a*a+b*b);
        } else {
            c = 0d;
        }

        assertEquals(ncom.mod()==c, true);
    }}
    /**
        Test che verifica la radice quadrata e restituicse errore nel caso non sia coerente.
    */
    @Test
    public void testSqrt(){
        for (int i = 0; i < 999; i++) {
        double a, b;
        a = ran.nextDouble();
        b = ran.nextDouble();
        ComplexNumber ncom = new ComplexNumber(a, b);
        
        
        double r=Math.sqrt(ncom.mod());
        double theta=ncom.arg()/2;
        ComplexNumber c = new ComplexNumber(r*Math.cos(theta),r*Math.sin(theta));
        
        assertEquals(ncom.equals(c), true);
    }}
    /**
        Test che verifica il funzionamento della funzione equals e restituicse errore nel caso non sia coerente.
    */
    @Test
    public void testEquals(){
        for (int i = 0; i < 999; i++) {
        double a, b, c, d;
        a = ran.nextDouble();
        b = ran.nextDouble();        
        c = ran.nextDouble();
        d = ran.nextDouble();
        boolean e = true;
        ComplexNumber ncom = new ComplexNumber(a, b);
        ComplexNumber ncomd = new ComplexNumber(c, d);
    
        if(a == c){
            if(b == d){
                e = true;
            }
        }
        else{
        e = false;
        }
        

        assertEquals(ncom.equals(ncomd)==e, true);

    }}
    /**
        Test che verifica il funzionamento della funzione toString e restituicse errore nel caso non sia coerente.
    */ 
    @Test
    public void testToString(){
        for (int i = 0; i < 999; i++) {
        double a, b;
        a = ran.nextDouble();
        b = ran.nextDouble(); 
        ComplexNumber ncom = new ComplexNumber(a, b);
        String re = a+"";
        String im = "";
        String c = "";
        if(b < 0){
            im = b+"i";}
        else{
            im = "+"+b+"i";
            c = re+im;
        }

            assertEquals(ncom.toString()==c, true);
        

    }}}        
    
