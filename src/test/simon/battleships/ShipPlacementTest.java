package test.simon.battleships;

import org.junit.Test;
import simon.battleships.ShipPlacement;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ShipPlacement Junit tests.
 *
 * @author Simon Longstaff
 */
public class ShipPlacementTest {

    public static int[][] theGameBoard = new int[10][10];


    /**
     * Generates 100 gameboards and adds battleships to each of them.
     * Ships are added as a 1 value for each square of ship in the underlying matrix.
     * Counts the values in the gameboard matrix and checks they equal 13.
     */
    @Test
    public void testPlacement() {
        for (int r = 0; r < 100; r++) {
            theGameBoard = new int[10][10];
            ShipPlacement.placeBattleShip(5, theGameBoard);
            ShipPlacement.placeBattleShip(4, theGameBoard);
            ShipPlacement.placeBattleShip(4, theGameBoard);
            int total = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    total += theGameBoard[i][j];
                }
            }
            //System.out.println("Board #" + r + " total: " + total );
            assertEquals(13, total);
        }


    }

    /**
     * Checks that the placement check successfully returns false when something is blocking the placement
     */
    @Test
    public void checkPlacementTest() {
        theGameBoard = new int[10][10];
        theGameBoard[4][0] = 1;
        assertFalse(ShipPlacement.checkPlacement(0, 0, 0, 5, theGameBoard));
    }


    /**
     * Method: randomInt(int min, int max)
     * Generates random integers in an exponentially increasing range from a range of 0-0 to 999-1,000,000
     */
    @Test
    public void testRandomInt() {
        for (int i = 0; i < 1000; i++) {
            int max = i + (i * 1000);
            int testNum = ShipPlacement.randomInt(i, max);
            //System.out.println(testNum);
            assertTrue(i <= testNum && testNum <= max);
        }


    }

    /**
     * Method: randomInt(int min, int max)
     * Generates random negative integers in an expoentially increasingly negative range
     */
    @Test
    public void testRandomIntNeg() {
        for (int i = 0; i > -1000; i--) {
            int max = i + (i * 1000);
            int testNum = ShipPlacement.randomInt(i, max);
            //System.out.println(testNum);
            assertTrue(i >= testNum && testNum >= max);
        }


    }

} 
