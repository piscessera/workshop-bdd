package com.workshop.tdd.demo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class CalcStatTests {
    @Before
    public void setup() {

    }

    @After
    public void teardown() {

    }

    @Test
    public void test_convert_string_6_9_15_minus2_92_11_into_set_of_numbers_should_be_successfully() {
        CommonUtil commonUtil = new CommonUtil();
        int[] result = commonUtil.convertStringToNumbers("6,9,15,-2,92,11");
        int[] expected = {6,9,15,-2,92,11};
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void test_convert_string_1_5_0_into_set_of_numbers_should_be_successfully() {
        CommonUtil commonUtil = new CommonUtil();
        int[] result = commonUtil.convertStringToNumbers("1,5,0");
        int[] expected = {1,5,0};
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void test_find_average_value_of_6_9_15_minus2_92_11_should_be_21point83() {
        CommonUtil commonUtil = new CommonUtil();
        int[] numbers = {6,9,15,-2,92,11};
        float averageValue = commonUtil.findAverage(numbers);
        float expected = 21.83f;
        Assert.assertThat(averageValue, is(expected));
    }

    @Test
    public void test_get_average_value_of_6_9_15_minus2_92_11_should_be_21point83() {
        CalculateStatistic calculateStatistic = new CalculateStatistic();
        calculateStatistic.process("6,9,15,-2,92,11");
        float averageValue = calculateStatistic.getAverageValue();
        float expected = 21.83f;
        Assert.assertThat(averageValue, is(expected));
    }
}
