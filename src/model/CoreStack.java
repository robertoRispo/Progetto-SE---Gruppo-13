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

/**
 * Il metodo getSubList() richiama il metodo stackToList per ottenere lo stack
 * in formato lista, per poi prendere i primi indexElement elementi e
 * restituirli in output sotto forma di lista di numeri complessi
 * @return List<ComplexNumber>
 */
    public List<ComplexNumber> getSubList() {
        List<ComplexNumber> stackToList = dataSingle.convertiLista();
        List<ComplexNumber> getSubList = stackToList.subList(0, indexElement);
        return getSubList;
    }

}
