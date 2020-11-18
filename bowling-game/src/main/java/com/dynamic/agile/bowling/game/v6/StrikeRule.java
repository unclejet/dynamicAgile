package com.dynamic.agile.bowling.game.v6;

import java.util.ArrayList;

class StrikeRule extends ScoreRule {
    StrikeRule(ArrayList<Integer> rolls) {
        super(rolls);
    }

    int score() {
        return hasNextTwoRolls() ?
                FrameV6.PINS_OF_FRAME + getNextTwoRollPins() : 0;
    }

    private boolean hasNextTwoRolls() {
        return getLastRollIndexOfGame() > lastRollIndexOfFrame + 1;
    }

    private int getNextTwoRollPins() {
        return rolls.get(lastRollIndexOfFrame + 1) + rolls.get(lastRollIndexOfFrame + 2);
    }
}
