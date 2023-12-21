package com.lo02.Karmaka.enums;

public enum KarmicScale {
    DUNG_BEETLE(4), SNAKE(5), WOLF(6), APE(7), TRANSCENDENCE(0);

    private final int value;

    KarmicScale(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
