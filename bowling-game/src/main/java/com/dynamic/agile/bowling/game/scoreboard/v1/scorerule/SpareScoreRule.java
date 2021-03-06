package com.dynamic.agile.bowling.game.scoreboard.v1.scorerule;

import com.dynamic.agile.bowling.game.scoreboard.v1.Frame;

import java.util.List;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/19 16:50
 * @description:
 */
public class SpareScoreRule extends ScoreRule {
    public SpareScoreRule(List<Integer> rolls) {
        super(rolls);
    }

    @Override
    public int score() {
        return hasNextRoll() ? Frame.ALL_PINS_IN_FRAME + getNextRollPins() : 0;
    }

    private Integer getNextRollPins() {
        return rolls.get(lastRollIndex + 1);
    }

    private boolean hasNextRoll() {
        int totalRollIndex = rolls.size() - 1;
        return totalRollIndex > lastRollIndex;
    }
}
