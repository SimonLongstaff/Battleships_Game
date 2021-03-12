/**
 * Gameboard Rendering class for Battleships
 * Renders the game board text based on the gameboard matrix values
 *
 * @author Simon Longstaff
 */

public class GameboardRendering {

    /**
     * Prints a row of the board depending on the state of the cells in the matrix
     *
     * @param row - the row to be printed
     */
    private static void renderRow(int row, int[][] theGameBoard) {
        StringBuilder render = new StringBuilder("");
        render.append(String.format("%01d ", row));

        for (int i = 0; i < 10; i++) {

            switch (theGameBoard[row][i]) {
                //Ships <Change to activate cheat mode>
                case (1):
                    render.append("◼");
                    break;
                //Misses
                case (2):
                    render.append("▢");
                    break;
                //Hits
                case (3):
                    render.append("▣");
                    break;
                //Unexplored
                default:
                    render.append("◼");
                    break;
            }

        }

        System.out.println(render);
    }

    /**
     * Prints the alphabetic row at the top of the board
     */
    private static void renderTopRow() {
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

        System.out.println("  " + A + B + C + D + E + F + G + H + I + J);
    }

    /**
     * Renders the game board in the console
     */
    public static void renderBoard(int[][] gameBoard) {
        renderTopRow();
        for (int i = 0; i < 10; i++) {
            renderRow(i, gameBoard);
        }
    }


}
