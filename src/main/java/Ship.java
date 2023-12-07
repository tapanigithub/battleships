public class Ship {

    int hitPoints;
    boolean sunk = false;

    Ship(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void decrementHitPoints() {
        hitPoints--;
        if (hitPoints == 0) {
            sunk = true;
        }
    }
    public boolean hasSunk() {
        return sunk;
    }
}
