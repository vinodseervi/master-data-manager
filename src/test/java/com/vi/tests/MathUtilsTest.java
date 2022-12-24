package com.vi.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When Running mathutils")
class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeAll
    void beforeAll() {
        System.out.println("This need to Run Before All");
    }

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanUp() {
        System.out.println("Cleaning up.....");
    }

    @Nested
    @DisplayName("when running AddTest")
    class AddTest {
        @Test
        @DisplayName("Testing add method for +")
        void testAddPositive() {
            assertEquals(4, mathUtils.add(2, 2));
        }

        @Test
        @DisplayName("Testing add method for -")
        void testAddNegative() {
            assertEquals(-4, mathUtils.add(-2, -2));
        }

    }

    @DisplayName("Adding Method")
    @Test
        // @EnabledOnOs(OS.LINUX)
    void addTest() {
        boolean isture = true;

        assumeTrue(isture);
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual);
        System.out.println("This test run");

    }

    @Test
    void divideTest() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(5, 0), "divide by zero should thow");


    }

    @Test
    @DisplayName("Using AssertAll Anotation")
    void multiplyTest() {
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(-1, 2))
        );
    }

    @Test
   // @RepeatedTest(4)
    void testComputeCircleRadiusTest() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "should return right area value");
    }

    @Test
    @Disabled
    @DisplayName("TDD method. shoould not run")

    void testDisabled() {
        fail("this test should be Disabled");
    }


}