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


    public int addPins() {
        return hitPins.stream().reduce(0, Integer::sum);
    }

    public boolean isFinished() {
        if (isMiss()) {
            return true;
        }
        return false;
    }

    private boolean isMiss() {
        return hitPins.size() == 2 && hitPins.get(0) + hitPins.get(1) < TOTAL_PINS;
    }

}
