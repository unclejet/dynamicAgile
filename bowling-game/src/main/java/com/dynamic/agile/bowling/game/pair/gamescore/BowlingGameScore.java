package com.dynamic.agile.bowling.game.pair.gamescore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author UncleJet & DavidZhang33
 * @date 11/8/2020 5:02 PM
 * @description 计算一个人打一局保龄球的得分
 * 该算法参考过uncle bob clean code视频TDD partII
 */
public class BowlingGameScore {
    public static final int FRAMES_OF_GAME = 10;
    public static final int PINS_OF_FRAME = 10;
    private int gameScore;
    private List<Integer> rolls = new ArrayList<>();

    public int getGameScore() {
        int rollIndexForTheFrame = 0;
        for (int frame = 0; frame < FRAMES_OF_GAME; frame++) {
            int frameScore;
            if (isStrike(rollIndexForTheFrame)) {
                frameScore = PINS_OF_FRAME + rolls.get(rollIndexForTheFrame + 1) + rolls.get(rollIndexForTheFrame + 2);
                rollIndexForTheFrame += 1;
            } else if (isSpare(getTwoRollsScore(rollIndexForTheFrame))) {
                int firstRollInNextFrame = rollIndexForTheFrame + 2;
                frameScore = PINS_OF_FRAME + rolls.get(firstRollInNextFrame);
                rollIndexForTheFrame += 2;
            } else {
                frameScore = getTwoRollsScore(rollIndexForTheFrame);
                rollIndexForTheFrame += 2;
            }
            gameScore += frameScore;

        }
        return gameScore;
    }

    private int getTwoRollsScore(int rollIndexForTheFrame) {
        return rolls.get(rollIndexForTheFrame) + rolls.get(rollIndexForTheFrame + 1);
    }

    private boolean isStrike(int rollIndexForTheFrame) {
        return rolls.get(rollIndexForTheFrame) == 10;
    }

    private boolean isSpare(int frameScore) {
        return frameScore == 10;
    }

    public void roll(int pins) {
        rolls.add(pins);
    }
}
