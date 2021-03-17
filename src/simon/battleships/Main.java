package simon.battleships;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main class for battleships game
 * Responsible for User-Game interaction loop
 *
 * @author Simon Longstaff
 */

public class Main {

    //Game Variables
    static int hits = 0;
    static int battleshipHits = 0;
    static int destroyerOneHits = 0;
    static int destroyerTwoHits = 0;


    /**
     * Places ships, Renders the game board and start the game loop
     *
     * @throws IOException
     */
    private static void startGame() throws IOException {
        ShipPlacement.placeShips();
        GameboardRendering.renderBoard(GameBoard.theGameBoard);
        newTarget();
    }


    /**
     * Recursively asks the user for a new target
     * Loop is interrupted once all targets are hit
     *
     * @throws IOException
     */
    private static void newTarget()
            throws IOException {
        if (hits == 13) {
            endGame();
        }
        System.out.println("Enter Target (Column[A-J] Row[0-9]: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String target = reader.readLine();
        checkHit(target);

        newTarget();
    }

    /**
     * Checks if the target is entered is valid and if so updates the game board based on game board value
     * If target is not valid asks user to enter another
     *
     * @param target - string value from user
     */
    public static void checkHit(String target) {

        String[] split = target.split("");


        if (split.length == 2) {
            if (IO.validInput(split[0], split[1])) {
                int column = IO.alphaToInt(split[0].toLowerCase());
                int row = Integer.parseInt(split[1]);

                int targetSpot = GameBoard.theGameBoard[row][column];
                switch (targetSpot) {
                    case (0):
                        GameBoard.theGameBoard[row][column] = 2;
                        GameboardRendering.renderBoard(GameBoard.theGameBoard);
                        System.out.println("You Missed!");
                        break;
                    case (1):
                        GameBoard.theGameBoard[row][column] = 3;
                        GameboardRendering.renderBoard(GameBoard.theGameBoard);
                        System.out.println("You hit!");
                        checkDestroyed(row, column);
                        hits++;
                        break;
                    case (2):
                        System.out.println("You've already checked this spot!");
                        break;
                    case (3):
                        System.out.println("You've already hit this spot!");
                        break;
                }
            } else {
                System.out.println("Please enter correct coordinates!");
            }
        } else {
            System.out.println("Please enter correct coordinates!");
        }


    }

    /**
     * Checks which ship was hit and if that ship is now destroyed
     * If so informs the user.
     *
     * @param row    - row that was hit
     * @param column - column that was hit
     */
    private static void checkDestroyed(int row, int column) {
        StringBuilder coordinate = new StringBuilder("");
        coordinate.append(row);
        coordinate.append(",");
        coordinate.append(column);

        for (int i = 0; i < 5; i++) {

            if (ShipPlacement.battleshipLoc[i].equals(coordinate.toString())) {
                battleshipHits++;
                if (battleshipHits == 5) {
                    System.out.println("You sunk the Battleship!");
                }
            }
        }

        for (int i = 0; i < 4; i++) {

            if (ShipPlacement.destroyerOneLoc[i].equals(coordinate.toString())) {
                destroyerOneHits++;
                if (destroyerOneHits == 4) {
                    System.out.println("You sunk a destroyer!");
                }
            }
            if (ShipPlacement.destroyerTwoLoc[i].equals(coordinate.toString())) {
                destroyerTwoHits++;
                if (destroyerTwoHits == 4) {
                    System.out.println("You sunk a destroyer!");
                }
            }

        }

    }

    /**
     * Ends the game once all targets have been destroyed
     *
     * @throws IOException
     */
    private static void endGame() throws IOException {
        System.out.println("Congratulations! You won! ");
        System.out.println("Press any Key to Quit");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        System.exit(0);

    }


    public static void main(String[] args) throws IOException {
        startGame();
    }
}
