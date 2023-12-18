package com.lo02.Karmaka.objects;


import com.lo02.Karmaka.enums.Strategy;

public class VirtualPlayer extends Player {

    private final Strategy strategy;

    public VirtualPlayer(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }
}
