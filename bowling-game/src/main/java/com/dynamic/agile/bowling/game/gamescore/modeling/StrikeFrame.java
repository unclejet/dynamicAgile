package com.dynamic.agile.bowling.game.gamescore.modeling;

import java.util.List;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/15 10:57
 * @description:
 */
public class StrikeFrame extends Frame {
    public StrikeFrame(int firstRollIndex) {
        super(firstRollIndex, -1);
    }

    @Override
    public int calculateScore(List<Integer> pins) {
        return pins.size() >= firstRollIndex + 3 ?
                PINS_IN_FRAME + pins.get(firstRollIndex + 1) + pins.get(firstRollIndex + 2) : 0;
    }
}
