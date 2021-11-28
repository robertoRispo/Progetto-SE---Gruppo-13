/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author agostinomoffa
 */
public class ComplexNumber {
    
    private double pRe;
    private double pIm;
    /**
        Costruttore del numero complesso z = u + i*v
        @param u Parte reale
        @param v Parte immaginaria
    */
    public ComplexNumber(double parteReale,double parteImmaginaria){
        this.pRe = parteReale;
        this.pIm = parteImmaginaria;
    }
    /**
        Addizione di numeri complessi (non cambia questo numero complesso).
        (x+i*y) + (s+i*t) = (x+s)+i*(y+t).
        @param w è il numero da aggiungere.
        @return z+w dove z è questo numero complesso.
    */
    public static ComplexNumber sum (ComplexNumber x, ComplexNumber y) {
        return new ComplexNumber(x.pRe + y.pRe, x.pIm + y.pIm);
    }
    
    /**
        Sottrazione di numeri complessi (non cambia questo numero complesso).
        (x+i*y) - (s+i*t) = (x-s)+i*(y-t).
        @param w è il numero da sottrarre.
        @return z-w dove z è questo numero complesso.
    */
    public static ComplexNumber sub (ComplexNumber x, ComplexNumber y) {
        return new ComplexNumber(x.pRe - y.pRe, x.pIm - y.pIm);
    }
    /**
        Moltiplicazione complessa (non cambia questo numero complesso).
        @param w è il numero per cui moltiplicare.
        @return z*w dove z è questo numero complesso.
    */
    public static ComplexNumber multiplication (ComplexNumber x, ComplexNumber y) {
        double parteReale = x.pRe*y.pRe - x.pIm*y.pIm;
        double parteImmaginaria = x.pIm*y.pRe + x.pRe*y.pIm;
        return new ComplexNumber(parteReale, parteImmaginaria);
    }
    
    public static ComplexNumber multiplication (double a, ComplexNumber x) {
        return new ComplexNumber(a*x.pRe, a*x.pIm);
    }
    /**
        Divisione di numeri complessi (non modifica questo numero complesso).
        (x+i*y)/(s+i*t) = ((x*s+y*t) + i*(y*s-y*t)) / (s^2+t^2)
        @param w è il numero per cui dividere
        @return nuovo Numero complesso z/w dove z è il numero complesso
    */
    public static ComplexNumber division (ComplexNumber x, ComplexNumber y) {
        return ComplexNumber.multiplication(x, multiplication(1/y.abs()/y.abs(), y.conjugated()));
    }
    /**
        Coniugato complesso di questo numero complesso
        (il coniugato di x+i*y é x-i*y).
        @return z-bar dove z è questo numero complesso.
    */
    public ComplexNumber conjugated(){
        return new ComplexNumber(pRe, -pIm);
    }
    /**
        Parte reale di questo numero complesso 
        (la coordinata x in coordinate rettangolari).
        @return Re[z] dove z è questo numero complesso.
    */
    public double re(){
        return this.pRe;
    }
    /**
        Parte immaginaria di questo numero complesso
        (la coordinata y in coordinate rettangolari).
        @return Im[z] dove z è questo numero complesso.
    */
    public double im(){
        return this.pIm;
    }
    /**
        ABS di questo numero complesso
        (la coordinata x e la coordinata y in coordinate rettangolari).
        @return ABS[z] dove z è questo numero complesso.
    */
    public double abs(){
        return Math.sqrt(this.pRe*this.pRe+this.pIm*this.pIm);
    }
    /**
        Argomento di questo numero complesso
         (l'angolo in radianti con l'asse x in coordinate polari).
        @return arg(z) dove z è questo numero complesso.
    */
    public double arg(){
        return (Math.atan2(this.pIm, this.pRe));
    }
    
    /**
        Modulo di questo numero complesso
         (la distanza dall'origine in coordinate polari).
        @return |z| dove z è questo numero complesso.
    */
    public double mod() {
        if (this.pRe!=0 || this.pIm!=0) {
            return Math.sqrt(this.pRe*this.pRe+this.pIm*this.pIm);
        } else {
            return 0d;
        }
    }
        
    /**
        Radice quadrata complessa (non cambia questo numero complesso).
         Calcola il ramo principale della radice quadrata, che
         è il valore con 0 <= arg < pi.
        @return sqrt(z) dove z è questo numero complesso.
    */
    public ComplexNumber sqrt() {
        double r=Math.sqrt(this.mod());
        double theta=this.arg()/2;
        return new ComplexNumber(Math.floor(r*Math.cos(theta)*100)/100,Math.floor(r*Math.sin(theta)*100)/100);
    }
    /**
        Complesso uguale.
        Confronta due numeri complessi.
        @return bool dove vero è che la parte immaginaria e la parte reale sono uguali.
    */
    public boolean equals(ComplexNumber j){
        if(this.re() == j.re()){
            if(this.im() == j.im()){
                return true;
            }
        }
        return false;
    }
    /**
        Complesso String.
        Trasforma il numero complesso in una stringa.
        @return il numero complesso in stringa.
    */
    @Override
    public String toString()
    {
        String re = this.pRe+"";
        String im = "";
        if(this.pIm < 0)
            im = this.pIm+"i";
        else
            im = "+"+this.pIm+"i";
        return re+im;
    }
    
}
