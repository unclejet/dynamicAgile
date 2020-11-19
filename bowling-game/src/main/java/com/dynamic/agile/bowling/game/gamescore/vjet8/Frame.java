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
    public int score() {
        if (isMiss()) {
            return firstRollPins() + secondRollPins();
        }
        return 0;
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
}
