package com.dynamic.agile.bowling.game.gamescore.v5;


import java.util.List;

/**
 * @author UncleJet
 * @date 11/18/2020 11:44 AM
 * @description
 */
public class MissFrameV5 extends FrameV5 {

    public MissFrameV5(int currentRollIndex) {
        super(currentRollIndex);
    }

    @Override
    public int score(List<Integer> rolls) {
        return rolls.get(lastRollIndex - 1) + rolls.get(lastRollIndex);
    }
}
