package com.dynamic.agile.bowling.game.v6;

import java.util.ArrayList;

class MissRule extends ScoreRule {
    MissRule(ArrayList<Integer> rolls) {
        super(rolls);
    }

    int score() {
        return firstRollPins() + secondRollPins();
    }

    private Integer secondRollPins() {
        return rolls.get(lastRollIndexOfFrame);
    }

    private Integer firstRollPins() {
        return rolls.get(lastRollIndexOfFrame - 1);
    }
}
