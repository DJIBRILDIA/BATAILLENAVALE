import java.util.Scanner;

public class player {

    public String nom;
    private ship[] fleet;
    private gameBoard gameBoard;


    public player(String nom) {
        this.nom = nom;
        this.fleet = new ship[5];
        this.gameBoard = new gameBoard();
    }

    public boolean placeShip(int x, int y, int taille) {
        ship ship = new ship(x, y, taille);
        return this.gameBoard.placeShip(ship);
    }
    public boolean isShot(int x, int y) {
        return this.gameBoard.isShot(x, y);
    }

    public void shoot(player opponent, int x, int y) {
        opponent.gameBoard.shoot(x, y);
    }

    public boolean isSunk() {
        for (ship navire : this.fleet) {
            if (!navire.isSunk()) {
                return false;
            }
        }
        return true;
    }

    public boolean isLost() {
        return this.gameBoard.isEmpty() || this.isSunk();
    }
}


