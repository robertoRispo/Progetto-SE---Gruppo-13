/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Functions {

    private List<String> list;
    CoreStack coreStack;
    Operations core;

    public Functions() {
        List<String> list = new LinkedList<String>();
        coreStack = new CoreStack();
        core = new Core();
    }

    /**
     * Legge la stringa ed esegue i calcoli in ordine per come sono scritti
     *
     * @param text è il test da aggiungere.
     * @return La stringa noerror se non sono stati inseriti caratteri errati
     * error altrimenti.
     */
    public String read(String text) {
        String[] testodiv = text.split(" ");
        String errore = "noerror";

        Integer lung = testodiv.length;
        List<String> list = Arrays.asList("dup", "swap", "*", "-", "+", "/", "sqrt", "conj", "abs", "mod");

        for (int i = 0; i < lung; i++) {
            if (!list.contains(testodiv[i])) {
                return "error";
            }
        }

        if (errore.equals("noerror")) {
            for (int i = 0; i < lung; i++) {
                switch (testodiv[i]) {
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
                    case "abs":
                        core.absInStack();
                        break;
                    case "mod":
                        core.modInStack();
                        break;
                }
            }
        }
        return errore;
    }

}
