public class MovingDay {

    // Creations des piles et du compteur 
    private ArrayStack<String> nam;
    private ArrayStack<String> pam;
    private ArrayStack<String> sam;
    private int dayCount;

    // Constructeur mettant en place les parametres du jour
    // de déménagement
    public MovingDay() {

        nam = new ArrayStack<>();
        pam = new ArrayStack<>();
        sam = new ArrayStack<>();
        dayCount = 0;

        /* Initialisation des sections dans Nam 
         * L'ordre des operations est important et la derniere section, N1, 
         * est ajoutee tee est au sommet) */
        nam.push("N5: Le Roi");
        nam.push("N4: Gouvernement");
        nam.push("N3: Académie");
        nam.push("N2: Manufacture");
        nam.push("N1: Agriculture");
    }

    public void DeplacerSection(ArrayStack<String> origine, ArrayStack<String> destination) {
        destination.push(origine.pop());
    }

    public void DeplacerVille() {
        while (!nam.isEmpty() || !pam.isEmpty()) {
            if (!nam.isEmpty()) {
                // Deplacement Nam --> Pam, tant que Nam contient un element
                DeplacerSection(nam, pam);
            } else if (!pam.isEmpty()) {
                /* Deplacement Pam --> Sam, lorsque Nam est vide 
                 * et tant que Pam n'est pas vide */
                DeplacerSection(pam, sam);
            }
            dayCount++;
            printStatus();
            if (dayCount == 10) {
                break;
            }
        }
    }

    public void printStatus() {
        System.out.println("Jour " + dayCount + ": Nam (" + formatStack(nam) + "), Pam (" + formatStack(pam) + ") et Sam (" + formatStack(sam) + ")");
    }

    // Méthode auxiliaire pour formater le contenu de la pile pour l'affichage
    private String formatStack(ArrayStack<String> stack) {
        // Retirer les crochets pour l'affichage selon le format de l'enonce
        return stack.toString().replaceAll("[\\[\\]]", ""); 
    }

    public String getResult() {
        if (sam.size() == 5) {
            return "Il est POSSIBLE de déplacer la ville dans les 10 jours, car " 
              + dayCount + " jours sont nécessaires.";
        } else {
            return "Il est NON POSSIBLE de déplacer la ville dans les 10 jours" 
              + ", car plus de 10 jours sont nécessaires.";
        }
    }
}


