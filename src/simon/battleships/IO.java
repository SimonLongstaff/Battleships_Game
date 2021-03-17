package simon.battleships;

/**
 * Input handling class for Battleships game
 * Checks if inputs are valid and converts them to numeric values
 *
 * @author Simon Longstaff
 */

public class IO {

    /**
     * Checks if user input is valid
     *
     * @param first  = The first character of the input
     * @param second - The second character of the input
     * @return boolean, true = valid, false = invalid
     */
    public static boolean validInput(String first, String second) {
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
     *
     * @param alpha - character entered
     * @return - column integer, Returns -1 if invalid input
     */
    public static int alphaToInt(String alpha) {
        switch (alpha.toLowerCase()) {
            case ("a"):
                return 0;
            case ("b"):
                return 1;
            case ("c"):
                return 2;
            case ("d"):
                return 3;
            case ("e"):
                return 4;
            case ("f"):
                return 5;
            case ("g"):
                return 6;
            case ("h"):
                return 7;
            case ("i"):
                return 8;
            case ("j"):
                return 9;
            default:
                return -1;
        }
    }

}
