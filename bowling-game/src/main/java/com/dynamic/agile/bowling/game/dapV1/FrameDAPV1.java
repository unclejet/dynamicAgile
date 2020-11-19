package com.dynamic.agile.bowling.game.dapV1;


import java.util.ArrayList;

class FrameDAPV1 {
    public static final int PINS_OF_FRAME = 10;
    public static final int SCORE_IS_NOT_READY_TO_COUNT = 0;
    private ScoreRuleDAPV1 scoreRule;
    private ArrayList<Integer> hitPins = new ArrayList<>();

    boolean hasTwoRolls() {
        return hitPins.size() == 2;
    }

    int score() {
        if (isSpare()) {
            return hasNextRoll() ? PINS_OF_FRAME + nextRollPins() : 0;
        }
        if (isMiss()) {
            return scoreRule.score();
        }
        return SCORE_IS_NOT_READY_TO_COUNT;
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

    void hitPins(int pins) {
        hitPins.add(pins);
    }

    private boolean hasNextRoll() {
        return false;
    }

    private int nextRollPins() {
        return 2;
    }

    public void setScoreRule(ArrayList<Integer> rolls) {
        if (isSpare()) {
//            scoreRule = new SpareRule(rolls);
        }
        if (isMiss()) {
            scoreRule = new MissRule(rolls);
        }
    }
}
