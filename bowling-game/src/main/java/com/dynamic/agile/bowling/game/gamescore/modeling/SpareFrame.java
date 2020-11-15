package com.dynamic.agile.bowling.game.gamescore.modeling;

import java.util.List;

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
    public int calculateScore(List<Integer> pins) {
        return pins.size() > secondRollIndex + 1? PINS_IN_FRAME + pins.get(secondRollIndex + 1) : 0;
    }
}
