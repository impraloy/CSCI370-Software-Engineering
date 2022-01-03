package edu.qc.seclass;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BuggyClassTestSC2 {

    private static BuggyClass buggyClass;

    @BeforeClass
    public static void beforeTest() {
        System.out.println("Before test calling");
        buggyClass = new BuggyClass();
    }

    @Test
    public void testTwo() {
    	assertEquals(170, buggyClass.buggyMethod2(10, 20));
    }
}
