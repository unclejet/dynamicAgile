package com.dynamic.agile.bowling.game.gamescore.v10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: UncleJet
 * @date: Created in 2021/8/21 17:24
 * @description:
 */
public class Frame {
    public static final int FRAME_MAX_PINS = 10;
    private List<Integer> hitPins = new ArrayList<>(2);

    public Frame() {
        //notify pins machine layout pins
    }

    public void record(int pins) {
        hitPins.add(pins);
    }

    public boolean isMiss() {
        return hitPins.size() == 2 && getFramePins() < FRAME_MAX_PINS;
    }

    public boolean isSpare() {
        return hitPins.size() == 2 && getFramePins() == FRAME_MAX_PINS;
    }

    public boolean isStrike() {
        return hitPins.size() == 1 && hitPins.get(0) == FRAME_MAX_PINS;
    }

    public int getFramePins() {
        return hitPins.get(0) + hitPins.get(1);
    }

    public boolean isFinished() {
        return isMiss() || isSpare() || isStrike();
    }

    public int getFirstRollPins() {
        return hitPins.get(0);
    }
}
