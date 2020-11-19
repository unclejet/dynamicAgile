package com.dynamic.agile.bowling.game.gamescore.v3.modeling;

import java.util.List;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/15 10:57
 * @description:
 */
public class StrikeFrameV3X extends FrameV3X {

    public static final String STRIKE = "X";

    public StrikeFrameV3X(int firstRollIndex) {
        super(firstRollIndex, -1);
    }

    @Override
    public int calculateScore(List<Integer> pins) {
        return hasNextTwoRolls(pins) ?
                PINS_IN_FRAME + pins.get(firstRollIndex + 1) + pins.get(firstRollIndex + 2) : 0;
    }

    @Override
    public String getPinsLeft(List<Integer> pins) {
        return STRIKE;
    }

    private boolean hasNextTwoRolls(List<Integer> pins) {
        return pins.size() >= firstRollIndex + 3;
    }
}
