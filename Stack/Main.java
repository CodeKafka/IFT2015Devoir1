public class Main {
    public static void main(String[] args) {
        // Création d'une instance de ArrayStack
        ArrayStack<Integer> stack = new ArrayStack<>();

        // Test de la méthode push
        stack.push(10); // Ajoute 10
        stack.push(20); // Ajoute 20

        // Affichage de la pile
        System.out.println(stack.toString()); // Devrait afficher [20, 10]

        // Test de la méthode pop
        System.out.println("Pop: " + stack.pop()); // Devrait retourner 20

        // Test de la méthode top
        System.out.println("Top: " + stack.top()); // Devrait retourner 10

        // Test de la méthode size
        System.out.println("Size: " + stack.size()); // Devrait retourner 1

        // Test de la méthode isEmpty
        System.out.println("Is Empty: " + stack.isEmpty()); // Devrait retourner false

        // Test de dépassement de la capacité maximale
        try {
            for (int i = 0; i < 100; i++) {
                stack.push(i);
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage()); // Devrait afficher un message d'erreur indiquant que la pile est pleine
        }
    }
}

