package com.example;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void addTwoNumber() {
        assertEquals(Calculator.add(1, 1), 2);
    }

    @DataProvider(name = "numbers")
    public static Object[][] addDataProvider() {
        return new Object[][] { { 1, 3, 4 }, { 2, 2, 4 }, { 4, 0, 4 } };
    }

    @Test(dataProvider = "numbers")
    public void addTwoNumberWithParameter(Integer n1, Integer n2, Integer sum) {
        assertEquals(Calculator.add(n1, n2), sum.intValue());
    }

}
