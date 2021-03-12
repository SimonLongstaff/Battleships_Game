import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main class for battleships game
 * @author Simon Longstaff
 */

public class Main {

    //Variables
    static int hits = 0;
    static int battleshipHits = 0;
    static int destroyerOneHits = 0;
    static int destroyerTwoHits = 0;

    /**
     * Places the ships on the board
     */
    private static void placeShips(){
        GameBoard.placeBattleShip(5);
        GameBoard.placeBattleShip(4);
        GameBoard.placeBattleShip(4);
    }

    //<<Gameplay loop>>---------------------------------------------------------------------------------

    /**
     * Recursively asks the user for a new target
     * Loop is interrupted once all targets are hit
     * @throws IOException
     */
    private static void newTarget()
            throws IOException {
        GameBoard.renderBoard();
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
     * @param target - string value from user
     */
    private static void checkHit(String target) {

        String[] split = target.split("");


        if(split.length==2) {
            if (validInput(split[0], split[1])) {
                int column = alphaToInt(split[0].toLowerCase());
                int row = Integer.parseInt(split[1]) ;

                int targetSpot = GameBoard.theGameBoard[row][column];
                switch (targetSpot) {
                    case (0) -> {
                        GameBoard.theGameBoard[row][column] = 2;
                        System.out.println("You Missed!");
                    }
                    case (1) -> {
                        GameBoard.theGameBoard[row][column] = 3;
                        System.out.println("You hit!");
                        checkDestroyed(row,column);
                        hits++;
                    }
                    case (2) -> System.out.println("You've already checked this spot!");
                    case (3) -> System.out.println("You've already hit this spot!");
                }
            } else {
                System.out.println("Please enter correct coordinates!");
            }
        }else {
            System.out.println("Please enter correct coordinates!");
        }


    }

    /**
     * Checks which ship was hit and if that ship is now destroyed
     * If so informs the user.
     * @param row - row that was hit
     * @param column - column that was hit
     */
    private static void checkDestroyed(int row, int column){
        StringBuilder coordinate = new StringBuilder("");
        coordinate.append(row);
        coordinate.append(",");
        coordinate.append(column);

        for (int i=0; i<5; i++){

            if(GameBoard.battleshipLoc[i].equals(coordinate.toString())){
                battleshipHits++;
                if (battleshipHits == 5){
                    System.out.println("You sunk the Battleship!");
                }
            }
        }

        for (int i=0; i<4; i++){

            if (GameBoard.destroyerOneLoc[i].equals(coordinate.toString())) {
                destroyerOneHits++;
                if (destroyerOneHits == 4) {
                    System.out.println("You sunk a destroyer!");
                }
            }
            if (GameBoard.destroyerTwoLoc[i].equals(coordinate.toString())) {
                destroyerTwoHits++;
                if (destroyerTwoHits == 4) {
                    System.out.println("You sunk a destroyer!");
                }
            }

        }

    }

    /**
     * Ends the game once all targets have been destroyed
     * @throws IOException
     */
    private static void endGame() throws IOException {
        System.out.println("Congratulations! You won! ");
        System.out.println("Press any Key to Quit");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        System.exit(0);

    }

    //<<Input Functions>>---------------------------------------------------------------------------------

    /**
     * Checks if user input is valid
     * @param first = The first character of the input
     * @param second - The second character of the input
     * @return boolean, true = valid, false = invalid
     */
    private static boolean validInput(String first, String second) {
        if (alphaToInt(first) == -1) {
            return false;
        }
        try {
            int s = Integer.parseInt(second);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    /**
     * Converts alphabet to integer value
     * @param alpha - character entered
     * @return - column integer, Returns -1 if invalid input
     */
    private static int alphaToInt(String alpha) {
        return switch (alpha.toLowerCase()) {
            case ("a") -> 0;
            case ("b") -> 1;
            case ("c") -> 2;
            case ("d") -> 3;
            case ("e") -> 4;
            case ("f") -> 5;
            case ("g") -> 6;
            case ("h") -> 7;
            case ("i") -> 8;
            case ("j") -> 9;
            default -> -1;
        };
    }





    public static void main(String[] args) throws IOException {
        placeShips();
        newTarget();
    }
}
