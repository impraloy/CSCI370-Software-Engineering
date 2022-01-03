package edu.qc.seclass;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class BuggyClassTestSC3 {

    private static BuggyClass buggyClass;

    @BeforeClass
    public static void beforeTest() {
        System.out.println("Before test calling");
        buggyClass = new BuggyClass();
    }

    @Test
    public void testFil() {
        assertEquals(170, buggyClass.buggyMethod3(10, 20));
    }
}