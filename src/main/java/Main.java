import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> shootingHistory = new ArrayList<>();

        Board board = new Board(); // initialize board and player board

//        to test randomized boards
//        for (int i = 0; i < 10; i++) {
//            System.out.println();
//            for (int j = 0; j < 10; j++) {
//                if (Board.shipBoard[i][j] != null)
//                System.out.print("[" + Board.shipBoard[i][j].hitPoints + "]");
//                else {
//                    System.out.print("[ ]");
//                }
//            }
//        }


        System.out.println("Welcome, there are 3 ships length of 3, 4 and 5 in the 10x10 grid.\n" +
            "Start shooting!\n");
        board.printPlayerBoard();

        while (true) {
            int xLoc = getValidInput(sc, "x");
            int yLoc = getValidInput(sc, "y");
            if (shootingHistory.contains(Integer.parseInt(String.valueOf(xLoc) + yLoc))) {
                System.out.println("You have already guessed these coordinates.\n");
                continue;
            }
            else {
                shootingHistory.add(Integer.parseInt(String.valueOf(xLoc) + yLoc));
            }
            board.shoot(xLoc,yLoc);
            board.printPlayerBoard();
            if (gameOver(board)) {
                sc.close();
                break;
            }
        }
    }

    private static boolean gameOver(Board board) {
        if (board.shipOf3.hasSunk()) { //&& board.shipOf4.hasSunk() && board.shipOf5.hasSunk()) {
            System.out.println("You won the game!");
            return true;
        }
        return false;
    }

    private static int getValidInput(Scanner sc, String xOry) {
        int coordinate;
        while (true) {
            System.out.printf("Please, enter your %s coordinate: ", xOry);
            try {
                coordinate = sc.nextInt();
                checkValidness(coordinate);
                return coordinate;
            } catch (Exception e) {
                System.out.println("Not a valid coordinate");
                sc.nextLine();
            }
        }
    }

    private static void checkValidness(int coordinate) throws Exception {
        if (coordinate < 0 || coordinate > 9) throw new Exception();
    }
}
