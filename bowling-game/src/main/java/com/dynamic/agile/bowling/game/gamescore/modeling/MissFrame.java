package com.dynamic.agile.bowling.game.gamescore.modeling;

import java.util.List;

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
    public int calculateScore(List<Integer> pins) {
        return pins.get(firstRollIndex) + pins.get(secondRollIndex);
    }

    @Override
    public String getPinsLeft(List<Integer> pins) {
        return String.valueOf(PINS_IN_FRAME - pins.get(firstRollIndex) - pins.get(secondRollIndex));
    }
}
