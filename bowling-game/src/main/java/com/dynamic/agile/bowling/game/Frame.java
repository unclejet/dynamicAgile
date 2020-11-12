package com.dynamic.agile.bowling.game;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/12 20:18
 * @description:
 */
public class Frame {
    public static final int ALL_HIT_PINS_NUMBER = 10;

    protected int[] rollIndex = new int[2];

    public void addFirstRollIndex(int index) {
        rollIndex[0] = index;
    }

    public void addSecondRollIndex(int index) {
        rollIndex[1] = index;
    }


    public int calculateScore(int[] rolls) {
        return rolls[rollIndex[0]] + rolls[rollIndex[1]];
    }
}
