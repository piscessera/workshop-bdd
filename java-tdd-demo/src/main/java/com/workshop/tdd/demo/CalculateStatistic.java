package com.workshop.tdd.demo;

public class CalculateStatistic {
    private float averageValue;

    public void process(String text) {
        CommonUtil commonUtil = new CommonUtil();
        int[] temp = commonUtil.convertStringToNumbers(text);
        this.averageValue = commonUtil.findAverage(temp);
    }

    public float getAverageValue() {
        return this.averageValue;
    }
}
