package com.vi.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {
    @Test
    void addTest(){
        MathUtils mathUtils = new MathUtils();
        int expexted = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expexted,actual);
        System.out.println("This test run");

    }
    @Test
    void  testComputeCircleRadiusTest(){
        MathUtils mathUtils = new MathUtils();
        assertEquals(314.1592653589793,mathUtils.computeCircleArea(10), "should return right area value");
    }


}