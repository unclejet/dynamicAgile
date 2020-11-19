package com.dynamic.agile.bowling.game.gamescore.v5;

import java.util.List;

/**
 * @author UncleJet
 * @date 11/18/2020 11:36 AM
 * @description
 */
public class FrameV5 {
    protected int lastRollIndex;

    public FrameV5(int lastRollIndex) {
        this.lastRollIndex = lastRollIndex;
    }

    public int score(List<Integer> rolls) {
        return 0;
    }
}
