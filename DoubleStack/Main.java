public class Main {
    public static void main(String[] args) {
        // Création d'une instance de ArrayDoubleStack
        ArrayDoubleStack<Integer> doubleStack = new ArrayDoubleStack<>();

        // Test de la méthode push
        doubleStack.push(true, 10); // Pousse 10 dans la pile 1
        doubleStack.push(false, 20); // Pousse 20 dans la pile 2

        // Affichage des piles
        doubleStack.print();

        // Test de la méthode pop
        System.out.println("Pop from stack 1: " + doubleStack.pop(true)); // Devrait retourner 10
        System.out.println("Pop from stack 2: " + doubleStack.pop(false)); // Devrait retourner 20

        // Test de la méthode top
        doubleStack.push(true, 30);
        doubleStack.push(false, 40);
        System.out.println("Top of stack 1: " + doubleStack.top(true)); // Devrait retourner 30
        System.out.println("Top of stack 2: " + doubleStack.top(false)); // Devrait retourner 40

        // Test de la méthode size
        System.out.println("Size of stack 1: " + doubleStack.size(true)); // Devrait retourner 1
        System.out.println("Size of stack 2: " + doubleStack.size(false)); // Devrait retourner 1

        // Test de la méthode isFull
        for (int i = 0; i < 49; i++) {
            doubleStack.push(true, i);
            doubleStack.push(false, i);
        }
        System.out.println("Is the double stack full? " + doubleStack.isFull()); // Devrait retourner true après avoir rempli les piles
    }
}

