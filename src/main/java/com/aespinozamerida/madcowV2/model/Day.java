package com.aespinozamerida.madcowV2.model;

public enum Day {

    DAY1(5), DAY2(4), DAY3(6);

    private final int value;

    Day(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
