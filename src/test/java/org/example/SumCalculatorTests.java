package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SumCalculatorTests {
    private SumCalculator sumCalculator;

    @BeforeEach
    void setUp() {
        sumCalculator = new SumCalculator();
    }

    @AfterEach
    void cleanUp() {
        sumCalculator = null;
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource ("getValidInputParams")
    void testValidParamSum(String name, int input, int expected) {

        //when
        int result = sumCalculator.sum(input);

        //then
        assertEquals(expected, result);
    }

    @Test
    void testInvalidParamSum() {
        //then
        assertThrows(IllegalArgumentException.class,
                () -> sumCalculator.sum(0));
    }

    private static Stream<Arguments> getValidInputParams() {
        return Stream.of(
                Arguments.of("Valid parameter 1",
                        1,
                        1),
                Arguments.of("Valid parameter 3",
                        3,
                        6));
    }
}
