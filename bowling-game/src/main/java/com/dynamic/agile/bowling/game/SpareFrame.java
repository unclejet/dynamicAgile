package com.dynamic.agile.bowling.game;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/12 20:28
 * @description:
 */
public class SpareFrame extends Frame {
    @Override
    public int calculateScore(int[] rolls) {
        return ALL_HIT_PINS_NUMBER + rolls[rollIndex[1] + 1];
    }

}
