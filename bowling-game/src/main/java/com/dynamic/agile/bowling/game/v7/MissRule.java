package com.dynamic.agile.bowling.game.v7;

import java.util.ArrayList;

class MissRule extends CalRule {
    MissRule(ArrayList<Integer> rolls) {
        super(rolls);
    }

    @Override
    int score() {
        return rolls.get(lastFrameRollIndex - 1) + rolls.get(lastFrameRollIndex);
    }
}
