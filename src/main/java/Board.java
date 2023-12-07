import java.util.Random;

public class Board {

    Ship shipOf3;
    Ship shipOf4;
    Ship shipOf5;

    public static Ship[][] shipBoard;
    private final String[][] playerBoard;

    Board() {
        shipBoard = new Ship[10][10];
        playerBoard = new String[10][10];

        shipOf3 = new Ship(3);
        shipOf4 = new Ship(4);
        shipOf5 = new Ship(5);
        fillPlayerBoard();
        fillShipBoard();
    }

    public void printPlayerBoard() {
        System.out.print("'x' = missed shot, 'o' = hit, 'O' = destroyed ship");
        for (int i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 0; j < 10; j++) {
                System.out.print("[" + playerBoard[i][j] + "]");
            }
        }
        System.out.println("\n");
    }

    private void fillPlayerBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                playerBoard[i][j] = " ";
            }
        }
    }

    private void fillShipBoard() {
        /*
         "randomize" the ship positions,
               ship of 4 will always be horizontal,
                   ships of 3 and 5 will always be vertical.
         */
        Random rand = new Random();

        shipBoard[0][0] = shipOf3;
        shipBoard[0][1] = shipOf3;
        shipBoard[0][2] = shipOf3;

    }

    public void shoot(int xLoc, int yLoc) {
        if (shipBoard[xLoc][yLoc] != null) {
            System.out.println("Hit!\n");
            playerBoard[xLoc][yLoc] = "o";
            shipBoard[xLoc][yLoc].decrementHitPoints();
            if (shipBoard[xLoc][yLoc].hasSunk()) {
                sinkShip(shipBoard[xLoc][yLoc]);
            }
        }
        else {
            System.out.println("Miss!\n");
            playerBoard[xLoc][yLoc] = "x";
        }
    }

    private void sinkShip(Ship ship) {
        System.out.println("You sunk a ship!\n");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (shipBoard[i][j] == ship) playerBoard[i][j] = "O";
            }
        }
    }
}
