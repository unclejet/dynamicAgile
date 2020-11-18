package com.dynamic.agile.bowling.game.v6;

import java.util.ArrayList;

class SpareRule extends ScoreRule {
    SpareRule(ArrayList<Integer> rolls) {
        super(rolls);
    }

    int score() {
        return hasNextRoll() ?
                FrameV6.PINS_OF_FRAME + getNextRollPins() : 0;
    }

    private Integer getNextRollPins() {
        return rolls.get(lastRollIndexOfFrame + 1);
    }

    private boolean hasNextRoll() {
        return getLastRollIndexOfGame() > lastRollIndexOfFrame;
    }
}
