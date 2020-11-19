package com.dynamic.agile.bowling.game.dapV1;


import java.util.ArrayList;

class FrameDAPV1 {
    static final int PINS_OF_FRAME = 10;
    private static final int SCORE_IS_NOT_READY_TO_COUNT = 0;
    private ScoreRuleDAPV1 scoreRule;
    private ArrayList<Integer> hitPins = new ArrayList<>();

    private boolean hasTwoRolls() {
        return hitPins.size() == 2;
    }

    int score() {
        return isFinished() ? scoreRule.score() : SCORE_IS_NOT_READY_TO_COUNT;
    }

    boolean isMiss() {
        return hasTwoRolls() && countTwoRollPins() < PINS_OF_FRAME;
    }

    boolean isSpare() {
        return hasTwoRolls() && countTwoRollPins() == PINS_OF_FRAME;
    }

    private int countTwoRollPins() {
        return hitPins.get(0) + hitPins.get(1);
    }

    void hitPins(int pins) {
        hitPins.add(pins);
    }

    void setScoreRule(ArrayList<Integer> rolls) {
        if (isSpare()) {
            scoreRule = new SpareRule(rolls);
        }
        if (isMiss()) {
            scoreRule = new MissRule(rolls);
        }
        if (isStrike()) {
            scoreRule = new StrikeRule(rolls);
        }
    }

    boolean isFinished() {
        return isStrike() || hasTwoRolls();
    }

    boolean isStrike() {
        return hasRolls() && hitPins.get(0) == PINS_OF_FRAME;
    }

    private boolean hasRolls() {
        return hitPins.size() > 0;
    }

    String frameRollIndex() {
        return String.valueOf(hitPins.size());
    }

    String showHitPins() {
        return isStrike() ? "x" : isSpare() ? "/" : String.valueOf(frameHitPins());
    }

    private int frameHitPins() {
        return hitPins.stream().mapToInt(Integer::intValue).sum();
    }

    boolean isNew() {
        return hitPins.size() == 0;
    }
}
