package com.dynamic.agile.bowling.game.dapV1;

import java.util.ArrayList;

class MissRule extends ScoreRuleDAPV1 {
    MissRule(ArrayList<Integer> rolls) {
        super(rolls);
    }

    @Override
    int score() {
        return rolls.get(frameLastRollIndex - 1) + rolls.get(frameLastRollIndex);
    }
}
