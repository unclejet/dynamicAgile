package com.dynamic.agile.bowling.game.gamescore.modeling;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/15 7:37
 * @description:
 */
public class BowlingGame {
    public static final int MAX_ROLL_NUMBER = 21;
    private int[] pins = new int[MAX_ROLL_NUMBER];
    private int rollIndex;
    private List<Frame> frames = new ArrayList<>();

    public int getGameScore() {
        return frames.stream().mapToInt(Frame::calculateScore).sum();
    }

    public void roll(int pins) {
        this.pins[rollIndex++] = pins;
    }
}
