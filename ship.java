public class ship {
    public int taille;
    public int x;
    public int y;
    private boolean isSunk;
    private boolean isShot;

    public ship(int taille, int x, int y) {
        this.taille = taille;
        this.x = x;
        this.y = y;
        this.isSunk = false;
    }

    //public boolean isSunk(int x, int y) {
        //return this.x == x && this.y == y;
    //}

    public boolean isShot() {
        this.taille--;
        if(this.taille == 0) {
            this.isShot = true;
        }
        return false;
    }

    public boolean isSunk() {
        return this.isSunk && this.taille == 0;
    }

    public void sizeDecrease() {
        this.taille--;
    }
}
