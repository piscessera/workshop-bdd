package com.workshop.tdd.demo;

import java.text.DecimalFormat;

public class CommonUtil {
    public int[] convertStringToNumbers(String text) {
        String[] parameters = text.split(",");
        int[] result = new int[parameters.length];
        for(int index = 0; index < parameters.length; index++) {
            result[index] = Integer.parseInt(parameters[index]);
        }
        return result;
    }

    public float findAverage(int[] numbers) {
        DecimalFormat df2 = new DecimalFormat("#.##");
        float total = 0;
        for(int index = 0; index < numbers.length; index++) {
            total += numbers[index];
        }
        return Float.valueOf(df2.format(total / numbers.length));
    }
}
