public class Main {
    public static void main(String[] args) {
        // Création d'une instance de SpecialArrayStack
        SpecialArrayStack<Integer> specialStack = new SpecialArrayStack<>();

        // Test de la méthode push et getMax
        specialStack.push(10); // Ajoute 10
        System.out.println("Max: " + specialStack.getMax()); // Devrait afficher 10
        specialStack.push(20); // Ajoute 20
        System.out.println("Max: " + specialStack.getMax()); // Devrait afficher 20
        specialStack.push(5); // Ajoute 5
        System.out.println("Max: " + specialStack.getMax()); // Devrait toujours afficher 20

        // Affichage de la pile
        System.out.println(specialStack.toString()); // Devrait afficher [5, 20, 10]

        // Test de la méthode pop
        System.out.println("Pop: " + specialStack.pop()); // Devrait retirer 5
        System.out.println("Max: " + specialStack.getMax()); // Devrait toujours afficher 20

        // Test de la méthode top
        System.out.println("Top: " + specialStack.top()); // Devrait retourner 20

        // Test de la méthode size
        System.out.println("Size: " + specialStack.size()); // Devrait retourner 2

        // Test de la méthode isEmpty
        System.out.println("Is Empty: " + specialStack.isEmpty()); // Devrait retourner false

        // Test de dépassement de la capacité maximale
        try {
            for (int i = 0; i < 100; i++) {
                specialStack.push(i);
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage()); // Devrait afficher un message d'erreur indiquant que la pile est pleine
        }
    }
}

