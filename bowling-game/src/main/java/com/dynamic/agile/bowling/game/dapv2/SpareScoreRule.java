package com.dynamic.agile.bowling.game.dapv2;

import java.util.ArrayList;

class SpareScoreRule extends ScoreRule {

    SpareScoreRule(ArrayList<Integer> rollPins) {
        super(rollPins);
    }

    @Override
    int score() {
        return hasNextRoll() ? 10 + rollPins.get(frameLastRollIndex + 1) : 0;
    }

    private boolean hasNextRoll() {
        return lastRollIndex() >= frameLastRollIndex + 1;
    }
}
