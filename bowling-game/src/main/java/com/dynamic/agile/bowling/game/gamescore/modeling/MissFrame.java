package com.dynamic.agile.bowling.game.gamescore.modeling;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/15 9:05
 * @description:
 */
public class MissFrame extends Frame {
    public MissFrame(int firstRollIndex, int secondRollIndex) {
        super(firstRollIndex, secondRollIndex);
    }

    @Override
    public int calculateScore(int[] pins) {
        return pins[firstRollIndex] + pins[secondRollIndex];
    }
}
