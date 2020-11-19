package com.dynamic.agile.bowling.game.gamescore.vjet8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/19 14:54
 * @description:
 */
public class Frame {
    public static final int ALL_PINS_IN_FRAME = 10;
    private List<Integer> pins = new ArrayList<>();
    private int lastRollIndex = -1;
    private ScoreRule scoreRule;

    public int score(List<Integer> rolls) {
        if (!isFinished()) {
            return 0;
        }
        if (isMiss() && scoreRule != null) {
            return scoreRule.score();
        }
        if (isSpare() && hasNextRoll(rolls)) {
            return ALL_PINS_IN_FRAME + nextRollPins(rolls);
        }
        if (isStrike() && hasNextTwoRolls(rolls)) {
            return ALL_PINS_IN_FRAME + nextTwoRollPins(rolls);
        }
        return 0;
    }

    private int nextTwoRollPins(List<Integer> rolls) {
        return rolls.get(lastRollIndex + 1) + rolls.get(lastRollIndex + 2);
    }

    private boolean hasNextTwoRolls(List<Integer> rolls) {
        return lastRollIndex >= 0 && rolls.size() - 2 > lastRollIndex;
    }

    private boolean isStrike() {
        return pins.size() == 1 && pins.get(0) == ALL_PINS_IN_FRAME;
    }

    private boolean hasNextRoll(List<Integer> rolls) {
        return lastRollIndex > 0 && rolls.size() - 1 > lastRollIndex;
    }

    private boolean isSpare() {
        return pins.size() == 2 && firstRollPins() + secondRollPins() == ALL_PINS_IN_FRAME;
    }

    private int nextRollPins(List<Integer> rolls) {
        return rolls.get(lastRollIndex + 1);
    }

    private Integer secondRollPins() {
        return pins.get(1);
    }

    private Integer firstRollPins() {
        return pins.get(0);
    }

    private boolean isMiss() {
        return pins.size() == 2 && firstRollPins() + secondRollPins() < ALL_PINS_IN_FRAME;
    }

    public void hitPins(int pins) {
        this.pins.add(pins);
    }

    public boolean isFinished() {
        return pins.size() == 2 || isStrike();
    }

    public void setLastRollIndex(int lastRollIndex) {
        this.lastRollIndex = lastRollIndex;
    }

    public void makeSureScoreRule(List<Integer> rolls) {
        if (isMiss()) {
            scoreRule = new MissScoreRule(rolls);
        }
    }
}
