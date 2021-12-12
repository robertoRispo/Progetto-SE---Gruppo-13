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

public class Functions {

    Operations core;
    CoreStack coreStack;
    Variables var;
    List<String> opList;
    HashMap<String, List<String>> function;

    public Functions(Operations core, CoreStack coreStack, Variables var) {
        this.var = var;
        this.core = core;
        this.coreStack = coreStack;
        this.function = new HashMap<>();
        opList = new ArrayList<String>(Arrays.asList("dup", "swap", "drop", "over", "+", "-", "/", "*", "conj", "abs", "mod"));
    }

    /**
     * Metodo che trasforma una lista di parole in una mappa con chiave la prima
     * parola, e come valore una lista contenente le parole successive
     *
     * @param operationsList
     * @return HashMap (Strings, List(Strings))
     * @throws IllegalArgumentException Quando il nome della funzione esiste già
     */
    public HashMap<String, List<String>> createFunction(List<String> operationsList) throws IllegalArgumentException {

        String name = operationsList.remove(0);

        function.put(name, operationsList);

        return function;

    }

    /**
     * Metodo che prende in input una stringa di operazioni divise da un
     * carattere di spazio " ", ed effettua lo split della stringa in modo da
     * creare una lista contenente il nome di ogni operazione da eseguire
     *
     * @param String operations -> Stringa delle operazioni da eseguire
     * @return List({@link List}) -> Lista di operazioni
     */
    public List<String> readOperations(String operations) {
        List<String> operationsList = new ArrayList<String>(Arrays.asList(operations.split(" ")));
        return operationsList;
    }

    /**
     * Metodo che esegue in maniera ordinata una lista di funzioni legate ad una
     * key della HashMap
     *
     * @param String name -> nome funzione
     * @throws NumberFormatException Quando il il numero da inserire nello stack
     * non è nella forma corretta
     * @throws NullPointerException Quando la funzione non viene trovata
     */
    public void executeFunction(String name) throws NumberFormatException, NoSuchElementException, NullPointerException {
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
                    case "save":
                        var.saveVar();
                        break;
                    case "restore":
                        var.restoreVar();
                        break;
                    case "push":
                        String numb = iterOperations.next();
                        strToComplex(numb);
                        break;
                    case "pop":
                        core.popFromStack();
                        break;
                    default:
                        if (function.containsKey(op)) {
                            this.executeFunction(op);
                        } else {
                            if (op.length() == 2) {
                                if (op.matches("[-+<>][a-z]")) {
                                    varFunction(op);
                                } else {
                                    throw new NoSuchElementException("Questa operazione non esiste");
                                }
                            } else {
                                throw new NoSuchElementException("Questa operazione non esiste");
                            }

                        }
                }
            }
        } else {
            throw new NullPointerException("Funzione non trovata");
        }

    }

    /**
     * Metodo che salva una funzione esistente su file di testo
     * "nomefunzione.txt"
     *
     * @param name
     * @throws IOException
     * @throws NullPointerException Quando non viene trovata la funzione
     * corrispondente al nome passato in input al metodo
     */
    public void saveFile(String name) throws IOException, NullPointerException {
        List<String> listOperations = function.get(name);
        if (listOperations.isEmpty()) {
            throw new NullPointerException("Lista Vuota");
        }
        Iterator<String> iterOperations = listOperations.iterator();
        try {
            String nameFile = name + ".txt";
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(name);
            myWriter.write(" ");

            while (iterOperations.hasNext()) {
                myWriter.write(iterOperations.next());
                myWriter.write(" ");
            }

            myWriter.close();
        } catch (IOException e) {
            throw new IOException("Errore Creazione File");
        }
    }

    /**
     * Metodo che carica una funzione da file di testo
     *
     * @param name
     * @throws FileNotFoundException Quando il file indicato non viene trovato
     */
    public void loadFile(String name) throws FileNotFoundException {
        String nameFile = name + ".txt";

        try {
            File myObj = new File(nameFile);
            Scanner myReader = new Scanner(myObj);

            String data = myReader.nextLine();
            List<String> listOperations = readOperations(data);

            createFunction(listOperations);
            System.out.println(data);

            myReader.close();

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File non trovato");
        }
    }

    /**
     * Metodo necessario per poter eliminare una funzione
     *
     * @param name
     * @throws NullPointerException Quando il nome della funzione da eliminare
     * non viene trovato
     */
    public void deleteFunction(String name) throws NullPointerException {
        if (function.containsKey(name)) {
            function.remove(name);
        } else {
            throw new NullPointerException("Funzione non trovata");
        }
    }

    /**
     * Trasforma una stringa di numeri, in un numero complesso, reale o solo
     * immaginario
     *
     * @param expression
     * @throws NumberFormatException Quando non viene riconosciuto il numero
     * passato in input sottoforma di stringa
     */
    public void strToComplex(String expression) throws NumberFormatException {

        double real = 0, complex = 0;
        String realPart = null;
        String complexPart = null;

        if (isExpression(expression)) {
            if ((expression.lastIndexOf("+") == -1) || (expression.lastIndexOf("+") == 0)) {
                realPart = expression.substring(0, expression.lastIndexOf("-"));
                complexPart = expression.substring(expression.lastIndexOf("-") + 1, expression.lastIndexOf("i"));
            } else {
                realPart = expression.substring(0, expression.lastIndexOf("+"));
                complexPart = expression.substring(expression.lastIndexOf("+") + 1, expression.lastIndexOf("i"));
            }
        } else if (isReal(expression)) {
            realPart = expression.substring(0, expression.lastIndexOf(""));
            complexPart = "0";
        } else if (isComplex(expression)) {
            realPart = "0";
            complexPart = expression.substring(0, expression.lastIndexOf("i"));
        } else {
            throw new NumberFormatException("Variabile non compatibile");
        }

        real = Double.parseDouble(realPart);
        complex = Double.parseDouble(complexPart);

        core.creatNumber(real, complex);
    }

    /**
     * Metodo che ritorna True se in String sono presenti solo caratteri
     * numerici complessi nella forma cartesiana
     *
     * @param str
     * @return boolean (True se è un espressione corretta, False altrimenti)
     */
    public static boolean isExpression(String str) {
        return str.matches("[-+]?\\d+(\\.\\d+)?[-+]+\\d+(\\.\\d+)?i+");
    }

    /**
     * Metodo che ritorna True se in String sono presenti solo caratteri
     * numerici eventualmente seguiti da un segno
     *
     * @param str
     * @return (True se è un espressione corretta, False altrimenti)
     */
    public static boolean isReal(String str) {
        return str.matches("[-+]?\\d+(\\.\\d+)?");
    }

    /**
     * Metodo che ritorna True se in String sono presenti solo caratteri
     * numerici seguiti dal simbolo "i" ed eventualmente seguiti da un segno
     *
     * @param str
     * @return (True se è un espressione corretta, False altrimenti)
     */
    public static boolean isComplex(String str) {
        return str.matches("[-+]?\\d+(\\.\\d+)?i+");
    }

    /**
     * Metodo che ritorna True se in String sono presenti solo caratteri
     * numerici eventualmente seguiti da un segno
     *
     * @param str
     * @return (True se è un espressione corretta, False altrimenti)
     */
    public static boolean isOperation(String str) {
        return str.matches("[-+<>][a-z]");
    }

    /**
     * Metodo che esegue operazioni sulle variabili se in String sono presenti
     * solo il segno di operazione e la variabile
     *
     * @param str
     */
    public void varFunction(String str) {

        if (str.startsWith(">")) {
            if (isVariable(str.substring(1, 2))) {
                var.pushInVar(str.substring(1, 2));
                System.out.print(str.substring(1, 2));
            }
        }
        if (str.startsWith("<")) {
            if (isVariable(str.substring(1))) {
                var.popFromVar(str.substring(1));

            }
        }
        if (str.startsWith("+")) {
            if (isVariable(str.substring(1))) {
                var.addInVar(str.substring(1));
            }
        }
        if (str.startsWith("-")) {
            if (isVariable(str.substring(1))) {
                var.diffInVar(str.substring(1));
            }
        }
    }

    /**
     * Metodo che ritorna True se in String sono presenti solo un carattere alfabetico
     *
     *
     * @param str
     * @return (True se è un espressione corretta, False altrimenti)
     */
    public static boolean isVariable(String str) {
        return str.matches("[a-z]");
    }
}
