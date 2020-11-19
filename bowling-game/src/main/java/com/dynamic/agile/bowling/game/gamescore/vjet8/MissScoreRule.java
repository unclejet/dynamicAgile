package com.dynamic.agile.bowling.game.gamescore.vjet8;

import java.util.List;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/19 16:33
 * @description:
 */
public class MissScoreRule extends ScoreRule {
    public MissScoreRule(List<Integer> rolls) {
        super(rolls);
    }

    @Override
    public int score() {
        return rolls.get(lastRollIndex - 1) + rolls.get(lastRollIndex);
    }
}
