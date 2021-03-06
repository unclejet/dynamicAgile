package com.dynamic.agile.bowling.game.gamescore.v3.modeling;

import java.util.List;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/15 10:00
 * @description:
 */
public class SpareFrameV3X extends FrameV3X {

    public static final String SPARE = "/";

    public SpareFrameV3X(int firstRollIndex, int secondRollIndex) {
        super(firstRollIndex, secondRollIndex);
    }

    @Override
    public int calculateScore(List<Integer> pins) {
        return hasNextRoll(pins) ? PINS_IN_FRAME + nextRollPins(pins) : 0;
    }

    @Override
    public String getPinsLeft(List<Integer> pins) {
        return SPARE;
    }

    private Integer nextRollPins(List<Integer> pins) {
        return pins.get(secondRollIndex + 1);
    }

    private boolean hasNextRoll(List<Integer> pins) {
        return pins.size() > secondRollIndex + 1;
    }
}
