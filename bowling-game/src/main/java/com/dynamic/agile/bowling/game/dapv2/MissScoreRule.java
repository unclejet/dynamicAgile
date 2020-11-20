package com.dynamic.agile.bowling.game.dapv2;

import java.util.ArrayList;

class MissScoreRule extends ScoreRule {
    MissScoreRule(ArrayList<Integer> rollPins) {
        super(rollPins);
    }

    @Override
    int score() {
        return rollPins.get(frameLastRollIndex - 1) + rollPins.get(frameLastRollIndex);
    }
}
