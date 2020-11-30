package com.dynamic.agile.bowling.game.scoreboard.v1;

import java.util.List;

import static com.dynamic.agile.bowling.game.gamescore.vjet8.Frame.ALL_PINS_IN_FRAME;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/19 16:55
 * @description:
 */
public class StrikeScoreRule extends ScoreRule {
    public StrikeScoreRule(List<Integer> rolls) {
        super(rolls);
    }

    @Override
    public int score() {
        return hasNextTwoRolls() ? ALL_PINS_IN_FRAME + nextTwoRollPins() : 0;
    }

    private int nextTwoRollPins() {
        return getNextRollPins() + getNextNextRollPins();
    }

    private Integer getNextNextRollPins() {
        return rolls.get(lastRollIndex + 2);
    }

    private Integer getNextRollPins() {
        return rolls.get(lastRollIndex + 1);
    }

    private boolean hasNextTwoRolls() {
        int totalRollIndex = rolls.size() - 1;
        return totalRollIndex > lastRollIndex + 1;
    }
}
