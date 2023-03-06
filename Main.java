import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        player joueur1 = new player("Joueur 1");
        player joueur2 = new player("Joueur 2");

        for (int i = 0; i < 5; i++) {
            System.out.println(joueur1.nom + ", placez votre navire de taille " + (i+1) + " :");
            int x = sc.nextInt();
            int y = sc.nextInt();

            while (!joueur1.placeShip(x, y, i+1)) {
                System.out.println("Position invalide, veuillez réessayer :");
                x = sc.nextInt();
                y = sc.nextInt();
            }

            System.out.println(joueur2.nom + ", placez votre navire de taille " + (i+1) + " :");
            x = sc.nextInt();
            y = sc.nextInt();

            while (!joueur2.placeShip(x, y, i+1)) {
                System.out.println("Position invalide, veuillez réessayer :");
                x = sc.nextInt();
                y = sc.nextInt();
            }
        }

        player joueurActif = joueur1;

        while (!joueur1.isLost() && !joueur2.isLost()) {
            System.out.println(joueurActif.nom + ", c'est votre tour :");
            int x = sc.nextInt();
            int y = sc.nextInt();

            while (joueurActif.isShot(x, y)) {
                System.out.println("Case déjà touchée, veuillez réessayer :");
                x = sc.nextInt();
                y = sc.nextInt();
            }

            player adversaire = joueurActif == joueur1 ? joueur2 : joueur1;
            joueurActif.shoot(adversaire, x, y);

            if (adversaire.isSunk()) {
                System.out.println("Le navire de " + adversaire.nom + " a été coulé !");
            }

            joueurActif = adversaire;
        }
        System.out.println("Partie terminée !");
        System.out.println(joueur1.nom + " : " + (joueur1.isLost() ? "perdu" : "gagné"));
        System.out.println(joueur2.nom + " : " + (joueur2.isLost() ? "perdu" : "gagné"));
    }
}