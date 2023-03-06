import java.util.Scanner;

public class gameBoard {
    private ship[][] gameBoard;
    public gameBoard() {
        this.gameBoard = new ship[10][10];
    }


    public boolean placeShip(ship ship){
        if(ship == null){
            return false;
        }if(ship.taille <= 0){
            return false;
        }
        if(ship.x < 0 || ship.x >= 10 || ship.y < 0 || ship.y >= 10){
            return false;
        }
        if(ship.x + ship.taille > 10 && ship.y + ship.taille > 10){
            return false;
        }
        for(int i = 0; i < ship.taille; i++){
            int x = ship.x;
            int y = ship.y;

            if (ship.taille > 1) {
                if (i > 0) {
                    if (ship.x == x) {
                        y++;
                    } else {
                        x++;
                    }
                }
            }
            if(this.gameBoard[x][y] != null){
                return false;
            }
        }
        for (int i = 0; i < ship.taille; i++) {
            int x = ship.x;
            int y = ship.y;

            if (ship.taille > 1) {
                if (i > 0) {
                    if (ship.x == x) {
                        y++;
                    } else {
                        x++;
                    }
                }
            }

            this.gameBoard[x][y] = ship;
        }
        return true;

    }
    public boolean isShot(int x, int y) {
        return this.gameBoard[x][y] != null && !this.gameBoard[x][y].isShot();
    }
    public void shoot(int x, int y){
        if (this.gameBoard[x][y] != null) {
            this.gameBoard[x][y].isShot();
            this.gameBoard[x][y].sizeDecrease();
        }
    }
    public boolean isEmpty(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.gameBoard[i][j] != null) {
                    return false;
                }
            }
        }

        return true;
    }
}
