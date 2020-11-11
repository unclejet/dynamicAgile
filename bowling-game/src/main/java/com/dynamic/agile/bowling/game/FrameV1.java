package com.dynamic.agile.bowling.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/10 18:37
 * @description:
 * @modified By:
 */
public class FrameV1 {
    public static final int TOTAL_PINS = 10;
    private List<Integer> rollPins = new ArrayList<>();
    private List<Integer> rollAddedPins = new ArrayList<>();
    private int index;
    private int score;

    public FrameV1(int index) {
        this.index = index;
    }

    public int addPins() {
        return rollPins.stream().mapToInt(Integer::intValue).sum();
    }

    public int addAddedPins() {
        return Stream.concat(rollPins.stream(), rollAddedPins.stream())
                .mapToInt(Integer::intValue)
                .sum();
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void roll(int pins) {
        rollPins.add(pins);
    }

    public void rollAdded(int pins) {
        rollAddedPins.add(pins);
    }

    public int getIndex() {
        return index;
    }

    public boolean isSpare() {
        return addPins() == TOTAL_PINS && hasSecondRoll();
    }

    public boolean isStrike() {
        return addPins() == TOTAL_PINS && !hasSecondRoll();
    }

    public int getFirstRollPins() {
        return rollPins.size() > 0 ? rollPins.get(0) : 0;
    }
    public int getFirstAddedRollPins() {
        return rollAddedPins.size() > 0 ? rollAddedPins.get(0) : 0;
    }


    private boolean hasSecondRoll() {
        return rollPins.size() == 2;
    }
}
