package com.dynamic.agile.bowling.game.gamescore.modeling;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/15 10:00
 * @description:
 */
public class SpareFrame extends Frame {
    public SpareFrame(int firstRollIndex, int secondRollIndex) {
        super(firstRollIndex, secondRollIndex);
    }

    @Override
    public int calculateScore(int[] pins) {
        return PINS_IN_FRAME + pins[secondRollIndex + 1];
    }
}
