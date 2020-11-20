package com.dynamic.agile.bowling.game.gamescore.vjet8;

import java.util.List;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/19 16:33
 * @description:
 */
class MissScoreRule extends ScoreRule {
    MissScoreRule(List<Integer> rolls) {
        super(rolls);
    }

    @Override
    public int score() {
        return getFirstRollPins() + getSecondRollPins();
    }

    private Integer getSecondRollPins() {
        return rolls.get(lastRollIndex);
    }

    private Integer getFirstRollPins() {
        return rolls.get(lastRollIndex - 1);
    }
}
