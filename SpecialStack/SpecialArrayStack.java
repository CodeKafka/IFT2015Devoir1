/* Seules les classes qui extends l'interface Java Comparable peuvent être stockes dans 
 * la SpecialArrayStack. Notre methode push(E e) a besoin de comparer l'element qu'on est sur 
 * le point d'ajouter (e) a l'element Maximal  Maximaux[prochainMaximum]. 
 * Puisqu'on ne connait pas a l'avance le tyupe des objets stockes dans la 
 * SpecialArrayStack, il faut utiliser le type generique E */
public class SpecialArrayStack<E extends Comparable<E>> implements SpecialStack<E> {   

    private static final int NombreElementsMaximal = 100;
    private Object[] Pile;
    private Object[] Maximaux; // Tableau pour stocker les éléments maximaux
    private int dessus = -1;
    private int prochainMaximum = -1; // Index pour suivre le prochain élément maximal


    // Constructeur
    public SpecialArrayStack() {
        Pile = new Object[NombreElementsMaximal];
        // Initialisation du tableau des maximaux
        Maximaux = new Object[NombreElementsMaximal]; 
    }

    // Implémente les méthodes de l'interface Stack...
    @Override
    public void push(E e) throws IllegalStateException {
        if (isFull()) {
            throw new 
            IllegalStateException("La pile a atteint le nombre maximal d'éléments");
        }
        
        if (isEmpty() || e.compareTo(getMax()) >= 0) {
            prochainMaximum++; 
            // Ajoute le nouveau maximum au tableau des maximaux
            Maximaux[prochainMaximum] = e;
        }
        dessus++;
        Pile[dessus] = e; // Ajoute l'élément à la pile
    }

    @Override
     public E pop() {
            if (isEmpty()) {
                throw new 
                IllegalStateException("La pile est vide, vous ne pouvez pas retirer d'élément.");
            }
            
            E elementRetourne = (E) Pile[dessus];
            Pile[dessus] = null; // Efface artificiellement l'élément
            dessus--;
            
            if (elementRetourne.equals(getMax())) {
            // Retire le maximum actuel du tableau des maximaux
                Maximaux[prochainMaximum] = null; 
                prochainMaximum--;
            }
            
            return elementRetourne;
        }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return (E) Pile[dessus];
    }

    @Override
    public int size() {
        return (dessus + 1);
    }

    @Override
    public boolean isEmpty() {
      // Lorsque le dessus a l'index 1, on sait que la pile est vide
        return (dessus == -1);
    }

    public boolean isFull() {
        return (dessus == NombreElementsMaximal - 1);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Contenu de la pile: [");
        for (int i = dessus; i >= 0; i--) {
            sb.append(Pile[i]);
            if (i > 0) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public E getMax() {
        if (prochainMaximum == -1) {
            throw new IllegalStateException("La pile est vide, il n'y a pas d'élément maximal.");
        }
        return (E) Maximaux[prochainMaximum];
    }  
}



