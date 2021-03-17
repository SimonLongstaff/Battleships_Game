package test.simon.battleships; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import simon.battleships.IO;

import static org.junit.Assert.*;

/** 
* IO Junit Tests.
* 
* @author Simon Longstaff
*/ 
public class IOTest { 


/** 
* 
* Method: validInput(String first, String second) 
* Checks input checkers only return true for correct input
*/ 
@Test
public void testValidInput() {

    //Correct
    assertTrue(IO.validInput("a","0"));
    assertTrue(IO.validInput("b","1"));
    assertTrue(IO.validInput("c","2"));
    assertTrue(IO.validInput("d","3"));
    assertTrue(IO.validInput("e","4"));
    assertTrue(IO.validInput("f","5"));
    assertTrue(IO.validInput("g","6"));
    assertTrue(IO.validInput("h","7"));
    assertTrue(IO.validInput("i","8"));
    assertTrue(IO.validInput("j","9"));
    assertTrue(IO.validInput("A","0"));
    assertTrue(IO.validInput("B","1"));
    assertTrue(IO.validInput("C","2"));
    assertTrue(IO.validInput("D","3"));
    assertTrue(IO.validInput("E","4"));
    assertTrue(IO.validInput("F","5"));
    assertTrue(IO.validInput("G","6"));
    assertTrue(IO.validInput("H","7"));
    assertTrue(IO.validInput("I","8"));
    assertTrue(IO.validInput("J","9"));

    //False
    assertFalse(IO.validInput("z","0"));
    assertFalse(IO.validInput("1","A"));
    assertFalse(IO.validInput(" "," "));
    assertFalse(IO.validInput("<",">"));



} 

/** 
* 
* Method: alphaToInt(String alpha) 
* Checks the alphabetic characters convert to the correct column number
*/ 
@Test
public void testAlphaToInt() throws Exception { 

    //Correct
    assertEquals(0, IO.alphaToInt("a"));
    assertEquals(1, IO.alphaToInt("b"));
    assertEquals(2, IO.alphaToInt("c"));
    assertEquals(3, IO.alphaToInt("d"));
    assertEquals(4, IO.alphaToInt("e"));
    assertEquals(5, IO.alphaToInt("f"));
    assertEquals(6, IO.alphaToInt("g"));
    assertEquals(7, IO.alphaToInt("h"));
    assertEquals(8, IO.alphaToInt("i"));
    assertEquals(9, IO.alphaToInt("j"));

    //Incorrect
    assertEquals(-1, IO.alphaToInt(" "));
    assertEquals(-1, IO.alphaToInt(""));
    assertEquals(-1, IO.alphaToInt("&"));
    assertEquals(-1, IO.alphaToInt(">"));
    assertEquals(-1, IO.alphaToInt("3"));
    assertEquals(-1, IO.alphaToInt("V"));
    assertEquals(-1, IO.alphaToInt("?"));




} 


} 
