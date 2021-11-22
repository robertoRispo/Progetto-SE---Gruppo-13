/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author agostinomoffa
 */
public class NumeroComplesso {
    
    private double parteReale;
    private double parteImmaginaria;
    
    public NumeroComplesso(double parteReale,double parteImmaginaria){
        this.parteReale = parteReale;
        this.parteImmaginaria = parteImmaginaria;
    }
    
    public static NumeroComplesso somma (NumeroComplesso x, NumeroComplesso y) {
        return new NumeroComplesso(x.parteReale + y.parteReale, x.parteImmaginaria + y.parteImmaginaria);
    }
    
    public static NumeroComplesso sottrazione (NumeroComplesso x, NumeroComplesso y) {
        return new NumeroComplesso(x.parteReale - y.parteReale, x.parteImmaginaria - y.parteImmaginaria);
    }

    public static NumeroComplesso moltiplicazione (NumeroComplesso x, NumeroComplesso y) {
        double parteReale = x.parteReale*y.parteReale - x.parteImmaginaria*y.parteImmaginaria;
        double parteImmaginaria = x.parteImmaginaria*y.parteReale + x.parteReale*y.parteImmaginaria;
        return new NumeroComplesso(parteReale, parteImmaginaria);
    }
    public static NumeroComplesso moltiplicazione (double a, NumeroComplesso x) {
        return new NumeroComplesso(a*x.parteReale, a*x.parteImmaginaria);
    }
    public static NumeroComplesso divisione (NumeroComplesso x, NumeroComplesso y) {
        return moltiplicazione(x, moltiplicazione(1/y.radicequadrata()/y.radicequadrata(), y.coniugato()));
    }
    public NumeroComplesso coniugato(){
        return new NumeroComplesso(parteReale, -parteImmaginaria);
    }

    public double reale(){
        return parteReale;
    }
    public double immmaginaria(){
        return parteImmaginaria;
    }
    public double radicequadrata(){
        return Math.sqrt(parteReale*parteReale+parteImmaginaria*parteImmaginaria);
    }
    public double arg(){
        return (2*Math.PI + Math.atan2(parteImmaginaria, parteReale)) % (2*Math.PI);
    }
}
