/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author gigi9
 */
public class Functions {

    Operations core;
    CoreStack coreStack;
    List<String> opList;
    HashMap<String, List<String>> function;

    public Functions(Operations core, CoreStack coreStack) {
        this.core = core;
        this.coreStack = coreStack;
        this.function = new HashMap<>();
        opList = new ArrayList<String>(Arrays.asList("dup", "swap", "drop", "over", "+", "-", "/", "*", "conj", "abs", "mod"));
    }

    /**
     * Metodo che trasforma una lista di parole in una mappa con chiave la prima
     * parola, e come valore una lista contenente le parole successive
     *
     * @param String stringa in input
     * @return HashMap<String, List<String>>
     * HashMap<NomeFunzione, ListaOperazioni>
     */
    public HashMap<String, List<String>> createFunction(List<String> operationsList) throws NoSuchElementException {

        String name = operationsList.remove(0);

        Iterator<String> iterOperations = operationsList.iterator();

        if (!isFunctionCorrect(iterOperations)) {
            System.out.println("Problema Trovato");
        }

        function.put(name, operationsList);

        return function;

    }

    public List<String> readOperations(String operations) {
        List<String> operationsList = new ArrayList<String>(Arrays.asList(operations.split(" ")));
        return operationsList;
    }

    /**
     * Metodo che controlla se la sequenza inserita è corretta
     *
     * @param String operation in input
     * @return bool
     */
    public boolean isFunctionCorrect(Iterator<String> operations) throws NoSuchElementException {
        /*String op = null;
        while(operations.hasNext()){
            op = operations.next();
            if(!opList.contains(op)){
                throw new NoSuchElementException ("error");
            }
         for (int i = 0; i < lung; i++) {
            if (!list.contains(testodiv[i])) {
                return "error";
            }
        }
        }*/
        return true;
    }

    /**
     * Metodo che esegue in maniera ordinata una lista di funzioni legate ad una
     * key della HashMap
     *
     * @param String operation in input HashMap<String, List<String>>
     * HashMap<NomeFunzione, ListaOperazioni>
     */
    public void executeFunction(String name) {
        if (function.containsKey(name)) {
            List<String> listOperations = function.get(name);
            Iterator<String> iterOperations = listOperations.iterator();
            String op = null;

            while (iterOperations.hasNext()) {
                op = iterOperations.next();
                switch (op) {
                    case "dup":
                        coreStack.duplicate();
                        break;
                    case "swap":
                        coreStack.swap();
                        break;
                    case "*":
                        core.prodInStack();
                        break;
                    case "-":
                        core.diffInStack();
                        break;
                    case "+":
                        core.sumInStack();
                        break;
                    case "/":
                        core.divInStack();
                        break;
                    case "sqrt":
                        core.square2InStack();
                        break;
                    case "conj":
                        core.conjugatedInStack();
                        break;
                    default:
                        if (function.containsKey(op)) {
                            this.executeFunction(op);
                        } else {
                            System.out.println("Non esiste questa funzione");
                        }
                }
            }
        } else {
            throw new NoSuchElementException("error");
        }

    }
    
    public void createFile(String name, String namefile) {  
        List<String> listOperations = function.get(name);
        Iterator<String> iterOperations = listOperations.iterator();
        try {
            FileWriter myWriter = new FileWriter(namefile);
            myWriter.write(name);
            while (iterOperations.hasNext()) {
            myWriter.write(iterOperations.next());
            myWriter.write("/n");
            }
            
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
  }

    public void readFile(String namefile) {
        try {
            File myObj = new File(namefile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                createFunction(readOperations(data));
                System.out.println(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void removeOperation(String name){
        if(function.containsKey(name)){
            function.remove(name);
        }
    }
    public void modifyOperation(String name){
        List<String> operationsList = readOperations(name);
        
        
        name = operationsList.remove(0);

        Iterator<String> iterOperations = operationsList.iterator();

        if (!isFunctionCorrect(iterOperations)) {
            System.out.println("Problema Trovato");
        }

        if(function.containsKey(name)){
            function.replace(name, operationsList);
        }
        else{
            throw new NoSuchElementException("Key non presente");
        }
    }
}
