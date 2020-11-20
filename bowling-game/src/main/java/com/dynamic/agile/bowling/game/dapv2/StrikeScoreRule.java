package com.dynamic.agile.bowling.game.dapv2;

import java.util.ArrayList;

class StrikeScoreRule extends ScoreRule {
    StrikeScoreRule(ArrayList<Integer> rollPins) {
        super(rollPins);
    }

    @Override
    int score() {
        return hasNextTwoRolls() ? FrameDAPV2.PINS_OF_FRAME + nextTwoRollPins() : FrameDAPV2.SCORE_IS_NOT_READY_TO_COUNT;
    }

    private int nextTwoRollPins() {
        return rollPins.get(frameLastRollIndex + 1) + rollPins.get(frameLastRollIndex + 2);
    }

    private boolean hasNextTwoRolls() {
        return lastRollIndex() >= frameLastRollIndex + 2;
    }


}
