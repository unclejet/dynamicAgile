package com.dynamic.agile.bowling.game.dapv2;

import java.util.ArrayList;

class SpareScoreRule extends ScoreRule {

    SpareScoreRule(ArrayList<Integer> rollPins) {
        super(rollPins);
    }

    @Override
    int score() {
        return hasNextRoll() ? FrameDAPV2.PINS_OF_FRAME + rollPins.get(frameLastRollIndex + 1) : FrameDAPV2.SCORE_IS_NOT_READY_TO_COUNT;
    }

    private boolean hasNextRoll() {
        return lastRollIndex() >= frameLastRollIndex + 1;
    }
}
