package com.dynamic.agile.bowling.game.v2;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/12 16:16
 * @description:
 * @modified By:
 */
public class RollV2 {
    private int index;
    private int pins;

    public RollV2(int index, int pins) {
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
