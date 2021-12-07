/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Tuple {
    private final String key;
    private final ComplexNumber num;

    public Tuple(String key, ComplexNumber num) {
        this.key = key;
        this.num = num;
    }

    public String getKey() {
        return key;
    }

    public ComplexNumber getNum() {
        return num;
    }
    
}
