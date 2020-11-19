package com.dynamic.agile.bowling.game.gamescore.vjet8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/19 14:54
 * @description:
 */
public class Frame {
    private List<Integer> pins = new ArrayList<>();
    public int score() {
        if (isMiss()) {
            return pins.get(0) + pins.get(1);
        }
        return 0;
    }

    private boolean isMiss() {
        return pins.size() == 2 && pins.get(0) + pins.get(1) < 10;
    }

    public void hitPins(int pins) {
        this.pins.add(pins);
    }
}
