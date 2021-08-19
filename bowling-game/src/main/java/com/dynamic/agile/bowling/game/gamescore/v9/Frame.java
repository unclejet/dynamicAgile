package com.dynamic.agile.bowling.game.gamescore.v9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/8/18 下午12:23
 * @description：
 */
public class Frame {
    private List<Integer> hitPins = new ArrayList<>();

    public void record(int pins) {
        hitPins.add(pins);
    }


    public int addPins() {
        return hitPins.stream().reduce(0, Integer::sum);
    }
}
