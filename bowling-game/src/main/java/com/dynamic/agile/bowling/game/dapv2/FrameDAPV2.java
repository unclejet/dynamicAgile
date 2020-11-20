package com.dynamic.agile.bowling.game.dapv2;


import java.util.ArrayList;

class FrameDAPV2 {
    private static final int PINS_OF_FRAME = 10;
    private static final int SCORE_IS_NOT_READY_TO_COUNT = 0;
    private ArrayList<Integer> hitPins = new ArrayList<>();
    private ScoreRule scoreRule;

    int score() {
        if (isSpare()) {
            scoreRule = new SpareScoreRule();
        }
        if (isMiss()) {
            scoreRule = new MissScoreRule();
        }
        return scoreRule != null ? scoreRule.score() : SCORE_IS_NOT_READY_TO_COUNT;
//        return SCORE_IS_NOT_READY_TO_COUNT;
    }

    private boolean isMiss() {
        return hasTwoRolls() && countTwoRollPins() < PINS_OF_FRAME;
    }

    private boolean isSpare() {
        return hasTwoRolls() && countTwoRollPins() == PINS_OF_FRAME;
    }

    private int countTwoRollPins() {
        return hitPins.get(0) + hitPins.get(1);
    }

    boolean hasTwoRolls() {
        return hitPins.size() == 2;
    }

    void hitPins(int pins) {
        hitPins.add(pins);
    }
}
