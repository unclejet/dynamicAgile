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
    private ScoreRule scoreRule;

    public int score() {
        return isRuleMakeSure() ? scoreRule.score() : 0;
    }

    public void hitPins(int pins) {
        this.pins.add(pins);
    }

    public boolean isFinished() {
        return pins.size() == 2 || isStrike();
    }

    public void makeSureScoreRule(List<Integer> rolls) {
        if (isMiss()) {
            scoreRule = new MissScoreRule(rolls);
        } else if (isSpare()) {
            scoreRule = new SpareScoreRule(rolls);
        } else if (isStrike()) {
            scoreRule = new StrikeScoreRule(rolls);
        }
    }

    private boolean isRuleMakeSure() {
        return scoreRule != null;
    }

    private boolean isStrike() {
        return pins.size() == 1 && pins.get(0) == ALL_PINS_IN_FRAME;
    }

    private boolean isSpare() {
        return pins.size() == 2 && firstRollPins() + secondRollPins() == ALL_PINS_IN_FRAME;
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
}
