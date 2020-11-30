package com.dynamic.agile.bowling.game.scoreboard.v1;

import java.util.List;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/19 16:33
 * @description:
 */
public abstract class ScoreRule {
    protected List<Integer> rolls;
    protected int lastRollIndex;

    public ScoreRule(List<Integer> rolls) {
        lastRollIndex = rolls.size() - 1;
        this.rolls = rolls;
    }

    public abstract int score();

}
