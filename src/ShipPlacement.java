/**
 * Ship placement class for Battleships
 * Places the ships onto the gameboard matrix.
 * Keep track of the locations in an array for each ship
 *
 * @author Simon Longstaff
 */

public class ShipPlacement {

    public static String[] battleshipLoc = new String[5];
    public static String[] destroyerOneLoc = new String[5];
    public static String[] destroyerTwoLoc = new String[5];

    /**
     * Places the ships on the board
     */
    public static void placeShips() {
        placeBattleShip(5, GameBoard.theGameBoard);
        placeBattleShip(4, GameBoard.theGameBoard);
        placeBattleShip(4, GameBoard.theGameBoard);
    }


    /**
     * Generates the random values for placement of ships on the board and sends them to the relevant methods.
     * If random values give an illegal placement recursively calls itself until placement is not illegal.
     *
     * @param shipSize the size of the ship to be placed
     */
    public static void placeBattleShip(int shipSize, int[][] theGameBoard) {
        int direction = randomInt(0, 1);
        int startingRow = 0;
        int startingColumn = 0;

        //Vertical
        if (direction == 0) {
            startingRow = randomInt(0, 4);
            startingColumn = randomInt(0, 9);
        }

        //Horizontal
        if (direction == 1) {
            startingRow = randomInt(0, 9);
            startingColumn = randomInt(0, 4);
        }

        //Check and make placement
        if (checkPlacement(startingRow, startingColumn, direction, shipSize, theGameBoard)) {
            makePlacement(startingRow, startingColumn, direction, shipSize, theGameBoard);
        } else placeBattleShip(shipSize, theGameBoard);

    }

    /**
     * Check that the placement of a ship isnt illegal, e.g space is already occupied
     *
     * @param startRow  the starting row of the ship
     * @param startCol  the starting column of the ship
     * @param direction the orientation of the ship (0 = Vertical, 1 = Horizontal)
     * @param size      the size of the ship
     * @return boolean, true = legal placement, false = illegal plcement
     */
    private static boolean checkPlacement(int startRow, int startCol, int direction, int size, int[][] GameBoard) {
        //Vertical
        if (direction == 0) {
            for (int i = 0; i < size; i++) {
                if (GameBoard[startRow + i][startCol] == 1) {
                    return false;
                }
            }
            return true;
        }

        //Horizontal
        if (direction == 1) {
            for (int i = 0; i < size; i++) {
                if (GameBoard[startRow][startCol = i] == 1) {
                    return false;
                }
            }
            return true;
        } else
            return false;

    }

    /**
     * Places the ship on the game board
     *
     * @param startRow  the starting row of the ship
     * @param startCol  the starting column of the ship
     * @param direction the orientation of the ship (0 = Vertical, 1 = Horizontal)
     * @param size      the size of the ship
     */
    private static void makePlacement(int startRow, int startCol, int direction, int size, int[][] gameBoard) {

        String[] shipLocation = new String[size];

        //Vertical
        if (direction == 0) {
            for (int i = 0; i < size; i++) {
                gameBoard[startRow + i][startCol] = 1;
                shipLocation[i] = ((startRow + i) + "," + startCol);
            }
        }

        //Horizontal
        if (direction == 1) {
            for (int i = 0; i < size; i++) {
                gameBoard[startRow][startCol + i] = 1;
                shipLocation[i] = (startRow + "," + (startCol + i));
            }
        }


        if (size == 5) {
            battleshipLoc = shipLocation;
        } else if (size == 4 && destroyerOneLoc[0] == null) {
            destroyerOneLoc = shipLocation;
        } else {
            destroyerTwoLoc = shipLocation;
        }
    }


    /**
     * Generates a random integer
     *
     * @param min - minimum integer
     * @param max - maximum integer
     * @return - random int between min and max (inclusive)
     */
    private static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

}
