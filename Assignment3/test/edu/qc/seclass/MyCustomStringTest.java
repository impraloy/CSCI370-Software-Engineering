package edu.qc.seclass;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        this.mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        this.mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, this.mycustomstring.countNumbers());
    }

    @Test //checking multiple number with digits
    public void testCountNumbers2() {
    	mycustomstring.setString("we are testing these 332 532 33 12 1 numbers ");
        assertEquals(5, mycustomstring.countNumbers());
    }

    @Test //nullpointerexception going to be thrown
    public void testCountNumbers3() {
    	mycustomstring.setString(null);
        mycustomstring.countNumbers();
    }

    @Test //checking a string with no number
    public void testCountNumbers4() {
    	mycustomstring.setString("There is nothing to test");
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test //a number with a space is treated as two numbers
    public void testCountNumbers5() {
    	 mycustomstring.setString("let's see how it is treated 4 7");
         assertEquals(2, mycustomstring.countNumbers());
    }

    @Test //checking for empty string
    public void testCountNumbers6() {
    	 mycustomstring.setString("");
         assertEquals(0, mycustomstring.countNumbers());
    }

    @Test //checking if it returns a string in n, 2n, 3n.. position
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test // Incorrect testing to returns a string  of the characters in positions n, 2n, 3n
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test //checking if it returns empty string when string is empty
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
    	mycustomstring.setString("");  
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test (expected=IllegalArgumentException.class) //IllegalArgumentException checks If "n" less than or equal to zero startFromEnd=false
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
    	mycustomstring.setString("ok");  //Length=2
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, false);
    }

    @Test //checking if it returns emptyString when length is less then n
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
    	 mycustomstring.setString("ok");
         assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test (expected=NullPointerException.class) //NullPointerException checks when string is null and n is greater then 0 startFromEnd=false
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
    	mycustomstring.setString(null);  //string is null
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false);
    }

    @Test (expected=NullPointerException.class) //NullPointerException checks when string is null and n is greater then 0 startFromEnd=true
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
    	mycustomstring.setString(null);  //string is null
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true);  //here n is greater then 0
    }

    @Test (expected=IllegalArgumentException.class) //IllegalArgumentException If "n" less than or equal to zero startFromEnd=true
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
    	mycustomstring.setString("ok");  //Length=2
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, true);
    }

    @Test //testing returns a string of characters of position n=1 and startFromEnd=false
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
    	mycustomstring.setString("I'm going home");  
      	 assertEquals("I'm going home", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }

    @Test //testing returns a string of characters of position n=1 and startFromEnd=true
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
    	mycustomstring.setString("I'm going home");  
     	 assertEquals("I'm going home", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
    }

    @Test //testing returns a string of characters of position n=5 and startFromEnd=false
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
    	mycustomstring.setString("I'm going home");  
     	 assertEquals("g ", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, false));
    }

    @Test //testing returns a string of characters of position n=4 and startFromEnd=true
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
    	mycustomstring.setString("That’s crazy high for an event like this");  
    	 assertEquals("T’r hr nit", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(4, true));
    }

    @Test //testing returns a string of characters of position n=4 and startFromEnd=false
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
    	mycustomstring.setString("That’s crazy high for an event like this");  
   	    assertEquals("tcygonel s", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(4, false));
    }

    @Test (expected=IllegalArgumentException.class) //it is throwing IllegalArgumentException If "n" less then zero
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
    	mycustomstring.setString("I'm tired of all these testing)");  
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-4, false);
    }

    @Test //testing returns right convert digit to name in string when startIndex and endIndex are between
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test //returns right output when startPosition and endPosition are inBetween
    public void testConvertDigitsToNamesInSubstring2() {
    	mycustomstring.setString("What happened on the 4th of July 1776?");
        mycustomstring.convertDigitsToNamesInSubstring(34,35 );
        assertEquals("What happened on the 4th of July OneSeven76?", mycustomstring.getString());
    }

    @Test //NullPointerException when startPosition" <= "endPosition", "startPosition" and  "endPosition" are greater than 0, and the current string is null
    public void testConvertDigitsToNamesInSubstring3() {
    	mycustomstring.setString(null);
    	mycustomstring.convertDigitsToNamesInSubstring(2, 3);
    }

    @Test //MyIndexOutOfBounds end position outOfBounds 
    public void testConvertDigitsToNamesInSubstring4() { 
    	mycustomstring.setString("I'm tired of all these unit testing");
        mycustomstring.convertDigitsToNamesInSubstring(2, mycustomstring.getString().length()+1);
    }

    @Test //MyIndexOutOfBounds exception when startPosition" <= "endPosition", but either "startPosition" or "endPosition" are out of bounds
    public void testConvertDigitsToNamesInSubstring5() {
    	mycustomstring.setString("I'm tired of all these unit testing");
        mycustomstring.convertDigitsToNamesInSubstring(0, 6);
    }

    @Test //testing returns right output when startPosition is the first element and endPosition is the last element(begining to end)
    public void testConvertDigitsToNamesInSubstring6() { 
    	mycustomstring.setString("What happened on the 4th of July 1776?");
        mycustomstring.convertDigitsToNamesInSubstring(1,38 );
        assertEquals("What happened on the Fourth of July OneSevenSevenSix?", mycustomstring.getString());
    }

    @Test //testing returns right output when startPosition and endPosition is the same element
    public void testConvertDigitsToNamesInSubstring7() {
    	mycustomstring.setString("What happened on the 4th of July 1776?");
        mycustomstring.convertDigitsToNamesInSubstring(22,22 );
        assertEquals("What happened on the Fourth of July 1776?", mycustomstring.getString());
    }

    @Test //IllegalArgumentException when "startPosition" > "endPosition"
    public void testConvertDigitsToNamesInSubstring8() {
    	mycustomstring.setString("I'm tired of all these unit testing");
    	mycustomstring.convertDigitsToNamesInSubstring(4, 3);
    }

}
