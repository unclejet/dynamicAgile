package com.dynamic.agile.bowling.game.v7;

import java.util.ArrayList;

class StrikeRule extends CalRule {
    StrikeRule(ArrayList<Integer> rolls) {
        super(rolls);
    }

    @Override
    int score() {
        return hasNext2Rolls() ? FrameV7.PINS_OF_FRAME + pinsOfNext2RollPins() : 0;
    }

    private int pinsOfNext2RollPins() {
        return rolls.get(lastFrameRollIndex + 1) + rolls.get(next2RollIndex());
    }

    private boolean hasNext2Rolls() {
        return lastRollIndex() >= next2RollIndex();
    }

    private int next2RollIndex() {
        return lastFrameRollIndex + 2;
    }

}
