package edu.qc.seclass;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class BuggyClassTestSC1b {

    private static BuggyClass buggyClass;

    @BeforeClass
    public static void beforeTest() {
        System.out.println("Before test calling");
        buggyClass = new BuggyClass();
    }

    @Test
    public void testFail() {
        assertEquals(170, buggyClass.buggyMethod1(3, 1));
    }
}
