package com.dynamic.agile.bowling.game.gamescore.v5;

import java.util.List;

/**
 * @author UncleJet
 * @date 11/18/2020 11:58 AM
 * @description
 */
public class SpareFrameV5 extends FrameV5 {
    public SpareFrameV5(int lastRollIndex) {
        super(lastRollIndex);
    }


    @Override
    public int score(List<Integer> rolls) {
        if (rolls.size() < lastRollIndex + 2) {
            return 0;
        }
        return rolls.get(lastRollIndex - 1) + rolls.get(lastRollIndex) + rolls.get(lastRollIndex + 1);
    }
}
