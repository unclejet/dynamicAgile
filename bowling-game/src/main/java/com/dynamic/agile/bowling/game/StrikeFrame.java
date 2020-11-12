package com.dynamic.agile.bowling.game;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/12 21:19
 * @description:
 */
public class StrikeFrame extends Frame {
    @Override
    public int calculateScore(int[] rolls) {
        return ALL_HIT_PINS_NUMBER + rolls[rollIndex[0] + 1] + rolls[rollIndex[0] + 2];
    }
}
