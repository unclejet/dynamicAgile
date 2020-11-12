package com.dynamic.agile.bowling.game;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/12 16:16
 * @description:
 * @modified By:
 */
public class Roll {
    private int index;
    private int pins;

    public Roll(int index, int pins) {
        this.index = index;
        this.pins = pins;
    }

    public int getIndex() {
        return index;
    }

    public int getPins() {
        return pins;
    }
}
