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
        Constructs the complex number z = u + i*v
        @param u Real part
        @param v Imaginary part
    */
    public ComplexNumber(double parteReale,double parteImmaginaria){
        this.pRe = parteReale;
        this.pIm = parteImmaginaria;
    }
    /**
        Addition of Complex numbers (doesn't change this Complex number).
        (x+i*y) + (s+i*t) = (x+s)+i*(y+t).
        @param w is the number to add.
        @return z+w where z is this Complex number.
    */
    public static ComplexNumber sum (ComplexNumber x, ComplexNumber y) {
        return new ComplexNumber(x.pRe + y.pRe, x.pIm + y.pIm);
    }
    
    /**
        Subtraction of Complex numbers (doesn't change this Complex number).
        (x+i*y) - (s+i*t) = (x-s)+i*(y-t).
        @param w is the number to subtract.
        @return z-w where z is this Complex number.
    */
    public static ComplexNumber sub (ComplexNumber x, ComplexNumber y) {
        return new ComplexNumber(x.pRe - y.pRe, x.pIm - y.pIm);
    }
    /**
        Complex multiplication (doesn't change this Complex number).
        @param w is the number to multiply by.
        @return z*w where z is this Complex number.
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
        Division of Complex numbers (doesn't change this Complex number).
        (x+i*y)/(s+i*t) = ((x*s+y*t) + i*(y*s-y*t)) / (s^2+t^2)
        @param w is the number to divide by
        @return new Complex number z/w where z is this Complex number  
    */
    public static ComplexNumber division (ComplexNumber x, ComplexNumber y) {
        return ComplexNumber.multiplication(x, multiplication(1/y.abs()/y.abs(), y.conjugated()));
    }
    /**
        Complex conjugate of this Complex number
        (the conjugate of x+i*y is x-i*y).
        @return z-bar where z is this Complex number.
    */
    public ComplexNumber conjugated(){
        return new ComplexNumber(pRe, -pIm);
    }
    /**
        Real part of this Complex number 
        (the x-coordinate in rectangular coordinates).
        @return Re[z] where z is this Complex number.
    */
    public double re(){
        return pRe;
    }
    /**
        Imaginary part of this Complex number 
        (the y-coordinate in rectangular coordinates).
        @return Im[z] where z is this Complex number.
    */
    public double im(){
        return pIm;
    }
    /**
     * ABS of this Complex number
        (the x-coordinate and the y-coordinate in rectangular coordinates).
        @return ABS[z] where z is this Complex number.
    */
    public double abs(){
        return Math.sqrt(pRe*pRe+pIm*pIm);
    }
    /**
        Argument of this Complex number 
        (the angle in radians with the x-axis in polar coordinates).
        @return arg(z) where z is this Complex number.
    */
    public double arg(){
        return (Math.atan2(pIm, pRe));
    }
    
    /**
        Modulus of this Complex number
        (the distance from the origin in polar coordinates).
        @return |z| where z is this Complex number.
    */
    public double mod() {
        if (pRe!=0 || pIm!=0) {
            return Math.sqrt(pRe*pRe+pIm*pIm);
        } else {
            return 0d;
        }
    }
        
    /**
        Complex square root (doesn't change this complex number).
        Computes the principal branch of the square root, which 
        is the value with 0 <= arg < pi.
        @return sqrt(z) where z is this Complex number.
    */
    public ComplexNumber sqrt() {
        double r=Math.sqrt(this.mod());
        double theta=this.arg()/2;
        return new ComplexNumber(r*Math.cos(theta),r*Math.sin(theta));
    }
    /**
        Complex equals.
        Compare two complex number.
        @return bool where true is that the immaginary part and real part are equals.
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
        Complex String.
        Parse the complex number in a string.
        @return the complex number in string.
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
