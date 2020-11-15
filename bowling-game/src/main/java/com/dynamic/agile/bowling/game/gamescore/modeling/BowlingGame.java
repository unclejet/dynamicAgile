package com.dynamic.agile.bowling.game.gamescore.modeling;

import java.util.ArrayList;
import java.util.List;

import static com.dynamic.agile.bowling.game.gamescore.modeling.Frame.MAX_ROLL_NUMBER_IN_FRAME;
import static com.dynamic.agile.bowling.game.gamescore.modeling.Frame.PINS_IN_FRAME;

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

    private int rollIndexOfFrame;


    public int getGameScore() {
        return frames.stream()
                .mapToInt(frame -> frame.calculateScore(pins))
                .sum();
    }

    public void roll(int pins) {
        rollIndexOfFrame++;
        this.pins[rollIndex] = pins;
        if (isMiss()) {
            frames.add(new MissFrame(rollIndex - 1, rollIndex));
            resetRollIndexOfFrame();
        }
        rollIndex++;
    }

    private void resetRollIndexOfFrame() {
        rollIndexOfFrame = 0;
    }

    private boolean isMiss() {
        return rollIndexOfFrame == MAX_ROLL_NUMBER_IN_FRAME
                && pins[rollIndex - 1] + pins[rollIndex] < PINS_IN_FRAME;
    }
}
