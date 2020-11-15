package com.dynamic.agile.bowling.game.gamescore.modeling;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/15 8:57
 * @description:
 */
public abstract class Frame {
    public static final int PINS_IN_FRAME = 10;
    public static final int MAX_ROLL_NUMBER_IN_FRAME = 2;

    protected int firstRollPins;
    protected int secondRollPins;

    public Frame(int firstRollPins, int secondRollPins) {
        this.firstRollPins = firstRollPins;
        this.secondRollPins = secondRollPins;
    }

    public abstract int calculateScore(int[] pins);
}
