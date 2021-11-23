/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gigi9
 */
public class CoreStack {

    private StackSingle dataSingle;
    int indexElement = 12;

    public CoreStack() {
        dataSingle = StackSingle.getInstance();
    }


    public List<NumeroComplesso> getSubList() {
        List<NumeroComplesso> stackToList = dataSingle.convertiLista();
        List<NumeroComplesso> getSubList = stackToList.subList(0, indexElement);
        return getSubList;
    }
    
}
