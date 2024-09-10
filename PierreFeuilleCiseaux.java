import java.util.Scanner;
import java.util.Random;

public class PierreFeuilleCiseaux {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] options = {"Pierre", "Feuille", "Ciseaux"};
        
        int playerScore = 0;
        int computerScore = 0;
        int rounds = 1;  // Initialiser rounds à 1
        
        System.out.println("Bienvenue au jeu Pierre, Feuille, Ciseaux !");
        
        boolean continuePlaying = true;  // Booléen pour continuer le jeu
        
        while (continuePlaying) {
            System.out.println("\nRound " + rounds + ":");
            System.out.println("Choisissez : 1. Pierre, 2. Feuille, 3. Ciseaux");
            
            // Lecture du choix du joueur
            int playerChoice = scanner.nextInt() - 1; // car le tableau commence a 0 
            String playerMove = options[playerChoice];
            
            // choix de l'ordinateur
            int computerChoice = random.nextInt(3);
            String computerMove = options[computerChoice];
            
            System.out.println("Vous avez choisi : " + playerMove);
            System.out.println("L'ordinateur a choisi : " + computerMove);
            
            // qui a gagné le round
            if (playerChoice == computerChoice) {
                System.out.println("Égalité !");
            } else if ((playerChoice == 0 && computerChoice == 2) || 
                       (playerChoice == 1 && computerChoice == 0) || 
                       (playerChoice == 2 && computerChoice == 1)) {
                System.out.println("Vous gagnez ce round !");
                playerScore++;
            } else {
                System.out.println("L'ordinateur gagne ce round !");
                computerScore++;
            }
            
            // Affichage du score actuel
            System.out.println("Score actuel: Vous " + playerScore + " - " + computerScore + " Ordinateur");
            
            // Demander au joueur s'il veut continuer à jouer
            System.out.println("Voulez-vous continuer ? (oui/non)");
            String answer = scanner.next();
            
            // Si le joueur entre non arrêter la boucle
            if (answer.equalsIgnoreCase("non")) {
                continuePlaying = false;
            }
            
            // Incrémenter le compteur de rounds
            rounds++;
        }
        
        // Affich du résultat final
        System.out.println("\n=== Fin du jeu ===");
        System.out.println("Nombre total de rounds joués : " + (rounds - 1));
        if (playerScore > computerScore) {
            System.out.println("Félicitations, vous avez gagné avec un score de " + playerScore + " contre " + computerScore + " !");
        } else if (playerScore < computerScore) {
            System.out.println("L'ordinateur a gagné avec un score de " + computerScore + " contre " + playerScore + ".");
        } else {
            System.out.println("Le jeu est terminé par une égalité !");
        }
        
        scanner.close(); 
    }
}
