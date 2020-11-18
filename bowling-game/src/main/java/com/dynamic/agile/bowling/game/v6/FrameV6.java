package com.dynamic.agile.bowling.game.v6;

import java.util.ArrayList;

public class FrameV6 {

    static final int PINS_OF_FRAME = 10;
    private static final int SCORE_NOT_READY_TO_COUNT = 0;
    private ArrayList<Integer> framePins = new ArrayList<>();
    private ScoreRule rule;

    void hitPins(int pins) {
        framePins.add(pins);
    }

    boolean isFinished() {
        return isStrike() || hasTwoRolls();
    }

    void prepareCalRule(ArrayList<Integer> rolls) {
        if (isMiss()) {
            rule = new MissRule(rolls);
        } else if (isSpare()) {
            rule = new SpareRule(rolls);
        } else if (isStrike()) {
            rule = new StrikeRule(rolls);
        }
    }

    public int score() {
        return rule != null ? rule.score() : SCORE_NOT_READY_TO_COUNT;
    }

    private int countTwoRollPins() {
        return firstRollPins() + secondRollPins();
    }

    private Integer secondRollPins() {
        return framePins.get(1);
    }

    private boolean isSpare() {
        return hasTwoRolls() && countTwoRollPins() == PINS_OF_FRAME;
    }

    private boolean isMiss() {
        return hasTwoRolls() && countTwoRollPins() < PINS_OF_FRAME;
    }

    private boolean hasTwoRolls() {
        return framePins.size() == 2;
    }

    private boolean isStrike() {
        return firstRollPins() == PINS_OF_FRAME;
    }

    private Integer firstRollPins() {
        return framePins.get(0);
    }

}
