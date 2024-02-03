public class ArrayStack<E> implements Stack<E> {
  private static final int NombreElementsMaximal = 100;

    private E[] Pile; // utilisation d'un simple tableau pour l'implementation
    
    /* Le haut de la pile a comme index -1 lorsque le tableau  est vide 
       0 lorsque le tableau a un element, 1 lorsque le tableau a 2 element, 
       etc. */
    private int dessus = -1; 

    // Constructeur
    public ArrayStack() {
        Pile = (E[]) new Object[NombreElementsMaximal]; 
        // safe cast; compiler may give warning
    }

    // Implémente les méthodes de l'infercae Stack.
    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == NombreElementsMaximal) throw 
          new IllegalStateException("La pile a atteint le nombre maximal d'éléments");

        //incremente l'index de dessus de pile
        this.dessus++; 
        Pile[dessus] = e; // increment t before storing new item
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E elementRetourne = Pile[dessus];
        //Efface artificiellement l'element
        Pile[dessus] = null;
        // Decremente pour avoir un index de dessus valide
        dessus--;
        return elementRetourne;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return Pile[dessus];
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

    @Override 
    public boolean isFull() {
       // Lorsque la pile est pleine, le dessus a l'index 99
      return (dessus == 99);
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
  
}
