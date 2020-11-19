package com.dynamic.agile.bowling.game.gamescore.v5;


import java.util.ArrayList;
import java.util.List;

/**
 * @author UncleJet
 * @date 11/18/2020 11:26 AM
 * @description
 */
public class BowlingGameV5 {
    private List<FrameV5> frames = new ArrayList<>();
    private List<Integer> rolls = new ArrayList<>();
    private int rollIndexInFrame;

    public void roll(int pins) {
        rollIndexInFrame++;
        rolls.add(pins);
        if (isMiss()) {
            frames.add(new MissFrameV5(getCurrentRollIndex()));
            rollIndexInFrame = 0;
        } else if (isSpare()) {
            frames.add(new SpareFrameV5(getCurrentRollIndex()));
            rollIndexInFrame = 0;
        } else if (isStrike()) {
            frames.add(new StrikeFrameV5(getCurrentRollIndex()));
            rollIndexInFrame = 0;
        }

    }

    private int getCurrentRollIndex() {
        return rolls.size() - 1;
    }

    private boolean isStrike() {
        return rolls.get(getCurrentRollIndex()) == 10;
    }

    private boolean isSpare() {
        return rollIndexInFrame == 2 && rolls.get(getCurrentRollIndex() - 1) + rolls.get(getCurrentRollIndex()) == 10;
    }

    private boolean isMiss() {
        return rollIndexInFrame == 2 && rolls.get(getCurrentRollIndex() - 1) + rolls.get(getCurrentRollIndex()) < 10;
    }

    public int score() {
        int score = 0;
        for (int i = 0; i < frames.size(); i++) {
            score += frames.get(i).score(rolls);
        }
        return score;
    }
}
