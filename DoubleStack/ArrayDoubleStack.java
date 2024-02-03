public class ArrayDoubleStack<E> implements DoubleStack<E> {
    private E[] doublePile;
    private int nombreMaximalElements = 100;
    private int dessus1;
    private int dessus2;

    public ArrayDoubleStack() {
        doublePile = (E[]) new Object[nombreMaximalElements];
        // Le dessus de la pile 1 se trouve du cote "gauche" du tableau
        dessus1 = -1;

        // Le dessus de la pile 2 se trouve du cote "droit" du tableau
        dessus2 = nombreMaximalElements;
    }

    /* La pile est pleine lorsque l'index de pile 1 est -1 (index initial) + 50 + 1= 50 et 
     * l'index de pile 2 est 100 (index initial) - 50 = 50*/
    public boolean isFull() {
        return (dessus1 + 1 == dessus2);
    }

    /* La methode verifie d'abord si la double pile est pleine et ajoute 
     * l'element au dessus du bon cote de la doublePile en fonction 
     * de l'argument fourni (true ou false) */
    public boolean push(boolean one, E element) {
        if (isFull()) {
            return false;
        }
        if (one) {
            /* On increment le dessus de pile 1 et met 
             * l'element au 'nouveau' desuss1 */
              doublePile[++dessus1] = element;
        } else {
            /* Ou alors On decrement le dessus de pile 2 et met 
             * l'element au 'nouveau' desuss2 */
            doublePile[--dessus2] = element;
        }
        return true;
    }
    
    public E pop(boolean one) {
        if (one) {
            // Verifie que la pile contient au moin un element
            if (dessus1 >= 0) {
                /* Decrement l'index de dessus, efface le contenu de dessus 
                et retourne la valeur qui etait au dessus1 */ 
                E reponse = doublePile[dessus1];
                doublePile[dessus1] = null; 
                dessus1--; 
                return reponse;
            }
        } else if (!one && dessus2 < nombreMaximalElements) {
            E reponse = doublePile[dessus2]; 
            doublePile[dessus2] = null;
            dessus2++;
            return reponse;  
            
        }
          else {
        // Si aucune des pile ne contient d'element 
            throw new IllegalStateException(
                "La double pile est vide, vous ne pouvez pas obtenir d'element. ")
        }
    }

    /* En fonction du boolean fourni, on verifie si la pile 
     * est plein et retourne l'element du dessus1 ou dessus2 */
    public E top(boolean one) {
        if (one) {
            if (dessus1 >= 0) {
                return doublePile[dessus1];
            }
        } else if (!one && dessus2 < nombreMaximalElements)  {
            return doublePile[dessus2];
        }
          else {
              throw new IllegalStateException(
                  "La double pile est vide, vous ne pouvez pas regarder l'element. ")
        }
    }
    
    /* En fonction du boolean fourni, on retourne la valeur   
     * dessus1 + 1 (taille pile 1) ou nbMaximalElements - dessus (taille pile 2) */
    public int size(boolean one) {
        if (one) {
            return dessus1 + 1;
        } else {
            return nombreMaximalElements - dessus2;
        }
    }


    public void print() {
        System.out.println("Pile 1:");
        for (int i = 0; i <= dessus1; i++) {
            System.out.println(doublePile[i]);
        }
        System.out.println("Pile 2:");
        for (int i = nombreMaximalElements - 1; i >= dessus2; i--) {
            System.out.println(doublePile[i]);
        }
    }
}

