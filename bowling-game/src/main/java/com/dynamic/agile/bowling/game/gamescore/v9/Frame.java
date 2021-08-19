package com.dynamic.agile.bowling.game.gamescore.v9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/8/18 下午12:23
 * @description：
 */
public class Frame {
    public static final int TOTAL_PINS = 10;
    private List<Integer> hitPins = new ArrayList<>(2);

    public void record(int pins) {
        assert hitPins.size() <= 2;
        hitPins.add(pins);
    }

    public int getFramePins() {
        return  hitPins.stream().reduce(0, Integer::sum);
    }

    public boolean isFinished() {
       return hitPins.size() == 2;
    }

    public boolean isMiss() {
        return isFinished() && getFramePins() < TOTAL_PINS;
    }

    public boolean isSpare() {
        return isFinished() && getFramePins() == TOTAL_PINS;
    }

    public int getFirstRollPins() {
        return hitPins.get(0);
    }
}
