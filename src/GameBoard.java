import java.util.Arrays;

/**
 * Gameboard class for Battleships
 * @author Simon Longstaff
 */
public class GameBoard {

    //Variables
    public static int[][] theGameBoard = new int[10][10];
    static String[] battleshipLoc = new String[5];
    static String[] destroyerOneLoc = new String[5];
    static String[] destroyerTwoLoc = new String[5];


    //<<Ship Placement>>---------------------------------------------------------------------------------

    /**
     * Generates the random values for placement of ships on the board and sends them to the relevant methods.
     * If random values give an illegal placement recursively calls itself until placement is not illegal.
     * @param shipSize the size of the ship to be placed
     */
    public static void placeBattleShip(int shipSize) {
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
        if (checkPlacement(startingRow, startingColumn, direction, shipSize)) {
            makePlacement(startingRow, startingColumn, direction, shipSize);
        } else placeBattleShip(shipSize);

    }

    /**
     * Check that the placement of a ship isnt illegal, e.g space is already occupied
     * @param startRow the starting row of the ship
     * @param startCol the starting column of the ship
     * @param direction the orientation of the ship (0 = Vertical, 1 = Horizontal)
     * @param size the size of the ship
     * @return boolean, true = legal placement, false = illegal plcement
     */
    private static boolean checkPlacement(int startRow, int startCol, int direction, int size) {
        //Vertical
        if (direction == 0) {
            for (int i = 0; i < size; i++) {
                if (theGameBoard[startRow + i][startCol] == 1) {
                    return false;
                }
            }
            return true;
        }

        //Horizontal
        if (direction == 1) {
            for (int i = 0; i < size; i++) {
                if (theGameBoard[startRow][startCol = i] == 1) {
                    return false;
                }
            }
            return true;
        } else
            return false;

    }

    /**
     * Places the ship on the game board
     * @param startRow the starting row of the ship
     * @param startCol the starting column of the ship
     * @param direction the orientation of the ship (0 = Vertical, 1 = Horizontal)
     * @param size the size of the ship
     */
    private static void makePlacement(int startRow, int startCol, int direction, int size) {

        String[] shipLocation = new String[size];

        //Vertical
        if (direction == 0) {
            for (int i = 0; i < size; i++) {
                theGameBoard[startRow + i][startCol] = 1;
                shipLocation[i] = ((startRow+i) + "," + startCol);
            }
        }

        //Horizontal
        if (direction == 1) {
            for (int i = 0; i < size; i++) {
                theGameBoard[startRow][startCol + i] = 1;
                shipLocation[i] = (startRow + "," + (startCol+i));
            }
        }


        if(size == 5){
            battleshipLoc = shipLocation;
        }
        else if(size == 4 && destroyerOneLoc[0] == null){
            destroyerOneLoc = shipLocation;
        }
        else{
            destroyerTwoLoc = shipLocation;
        }
    }



    //<<Board Rendering>>---------------------------------------------------------------------------------

    /**
     * Prints a row of the board depending on the state of the cells in the matrix
     * @param row - the row to be printed
     */
    private static void renderRow(int row) {
        StringBuilder render = new StringBuilder("");
        render.append(String.format("%01d ", row));

        for (int i = 0; i < 10; i++) {

            switch (theGameBoard[row][i]) {
                //Ships <Change to activate cheat mode>
                case (1):
                    render.append("▢");
                    break;
                //Misses
                case (2):
                    render.append("◼");
                    break;
                //Hits
                case (3):
                    render.append("▣");
                    break;
                //Unexplored
                default:
                    render.append("▢");
                    break;
            }

        }

        System.out.println(render);
    }

    /**
     * Prints the alphabetic row at the top of the board
     */
    private static void renderTopRow(){
        String A = "\uD83C\uDD70";
        String B = "\uD83C\uDD71";
        String C = "\uD83C\uDD72";
        String D = "\uD83C\uDD73";
        String E = "\uD83C\uDD74";
        String F = "\uD83C\uDD75";
        String G = "\uD83C\uDD76";
        String H = "\uD83C\uDD77";
        String I = "\uD83C\uDD78";
        String J = "\uD83C\uDD79";

        System.out.println("  " +A+B+C+D+E+F+G+H+I+J);
    }

    /**
     * Renders the game board in the console
     */
    public static void renderBoard() {
        renderTopRow();
        for (int i = 0; i < 10; i++) {
            renderRow(i);
        }
    }


    //<<Misc Functions>>---------------------------------------------------------------------------------

    /**
     * Generates a random integer
     * @param min - minimum integer
     * @param max - maximum integer
     * @return - random int between min and max (inclusive)
     */
    private static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }




}
