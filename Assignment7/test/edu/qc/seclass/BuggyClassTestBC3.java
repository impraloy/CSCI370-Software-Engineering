package edu.qc.seclass;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BuggyClassTestBC3 {

    private static BuggyClass buggyClass;

    @BeforeClass
    public static void beforeTest() {
        System.out.println("Before test calling");
        buggyClass = new BuggyClass();
    }

    @Test
    public void testThree() {
    	assertEquals(170, buggyClass.buggyMethod3(10, 20));
    }
}
