package com.dynamic.agile.bowling.game.gamescore.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/12 9:51
 * @description:
 * @modified By:
 */
public class FrameV2 {
    public static final int ALL_HIT_PINS = 10;
    private List<RollV2> rolls = new ArrayList<>();

    public FrameV2() {
    }

    public void add(RollV2 roll) {
        rolls.add(roll);
    }

    public boolean isRolledFinished() {
        return rolls.size() >= 2 || isStrike();
    }

    public int calculateScore(RollV2[] rolls) {
        int score = 0;
        if (isSpare()) {
            score += ALL_HIT_PINS + rolls[getLastRollIndex() + 1].getPins();
        } else if (isStrike()) {
            score += ALL_HIT_PINS + rolls[getLastRollIndex() + 1].getPins() + rolls[getLastRollIndex() + 2].getPins();
        } else {
            score += getPins();
        }
        return score;
    }

    private int getPins() {
        return rolls.stream().map(RollV2::getPins).mapToInt(Integer::intValue).sum();
    }

    private boolean isSpare() {
        return rolls.size() >= 2
                && rolls.get(0).getPins() != ALL_HIT_PINS
                && getPins() >= ALL_HIT_PINS;
    }

    private boolean isStrike() {
        return rolls.size() >= 1
                && rolls.get(0).getPins() == ALL_HIT_PINS;
    }

    private int getLastRollIndex() {
            return isStrike() ? rolls.get(0).getIndex() : rolls.get(1).getIndex();
    }
}
