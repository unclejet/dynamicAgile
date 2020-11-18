package com.dynamic.agile.bowling.game.gamescore.v5;

import java.util.List;

/**
 * @author UncleJet
 * @date 11/18/2020 12:13 PM
 * @description
 */
public class StrikeFrameV5 extends FrameV5 {
    public StrikeFrameV5(int lastRollIndex) {
        super(lastRollIndex);
    }

    @Override
    public int score(List<Integer> rolls) {
        if (rolls.size() -1 < lastRollIndex+2){
            return 0;
        }
        return 10 + rolls.get(lastRollIndex + 1) + rolls.get(lastRollIndex + 2);
    }
}
