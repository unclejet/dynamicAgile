package com.dynamic.agile.bowling.game.gamescore.modeling;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/15 8:57
 * @description:
 */
public abstract class Frame {
    public static final int PINS_IN_FRAME = 10;
    public static final int MAX_ROLL_NUMBER_IN_FRAME = 2;

    protected int firstRollIndex;
    protected int secondRollIndex;

    public Frame(int firstRollIndex, int secondRollIndex) {
        this.firstRollIndex = firstRollIndex;
        this.secondRollIndex = secondRollIndex;
    }

    public abstract int calculateScore(int[] pins);
}
