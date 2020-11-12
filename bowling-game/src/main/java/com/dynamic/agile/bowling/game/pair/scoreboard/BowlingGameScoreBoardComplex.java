package com.dynamic.agile.bowling.game.pair.scoreboard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author UncleJet & DavidZhang33
 * @date 11/8/2020 5:02 PM
 * @description
 * 采用当前roll逆向倒推的方式计算计分板
 * 事实证明算法很复杂，不具备可读性
 * 还是要复用gamescore计算局分的算法比较好
 */
public class BowlingGameScoreBoardComplex {
    public static final int FRAMES_OF_GAME = 10;
    public static final int PINS_OF_FRAME = 10;
    private int gameScore;
    private List<Integer> rolls = new ArrayList<Integer>();
    private int rollIndexForTheFrame = 0;

    public int getGameScore() {
        for (int frame = 0; frame < FRAMES_OF_GAME; frame++) {
            int frameScore;
            frameScore = getFrameScore();
            gameScore += frameScore;

        }
        return gameScore;
    }

    private int getFrameScore() {
        int frameScore;
        if (isStrike(rollIndexForTheFrame)) {
            frameScore = PINS_OF_FRAME + rolls.get(rollIndexForTheFrame + 1) + rolls.get(rollIndexForTheFrame + 2);
            rollIndexForTheFrame += 1;
        } else if (isSpare(getTwoRollsScore(rollIndexForTheFrame))) {
            frameScore = PINS_OF_FRAME + rolls.get(rollIndexForTheFrame + 2);
            rollIndexForTheFrame += 2;
        } else {
            frameScore = getTwoRollsScore(rollIndexForTheFrame);
            rollIndexForTheFrame += 2;
        }
        return frameScore;
    }

    private int getTwoRollsScore(int rollIndexForTheFrame) {
        return rolls.get(rollIndexForTheFrame) + rolls.get(rollIndexForTheFrame + 1);
    }

    private boolean isStrike(int rollIndexForTheFrame) {
        return rolls.get(rollIndexForTheFrame) == PINS_OF_FRAME;
    }

    private boolean isSpare(int frameScore) {
        return frameScore == PINS_OF_FRAME;
    }

    public void roll(int pins) {
        rolls.add(pins);
        lastRollPins = pins;
    }

    private int totalScore;
    int currentFrame = 0;
    int rollInCurrentFrame = 0;
    int lastRollPins = 0;
    int rollIndexOfLastFrame = 0;
    int pinsLeftInCurrentFrame = 0;

    public String showScoreBoard() {
        if (rollInCurrentFrame == 0) {
            rollInCurrentFrame = 1;
            pinsLeftInCurrentFrame = 10;
            rollIndexOfLastFrame = -2;
        } else {
            if (rollInCurrentFrame == 1) {
                if (lastRollPins == 10) {
                    currentFrame++;
                    rollInCurrentFrame = 1;
                    pinsLeftInCurrentFrame = 10;
                    rollIndexOfLastFrame++;
                    if (rollIndexOfLastFrame >=1 && rolls.get(rollIndexOfLastFrame - 1) == 10) {
                        if (rollIndexOfLastFrame >=1 && rolls.get(rollIndexOfLastFrame - 1) == 10) { //神来之笔
                            totalScore += (10 + rolls.get(rollIndexOfLastFrame) + rolls.get(rollIndexOfLastFrame + 1));
                        }
                    }
                } else {
                    rollInCurrentFrame = 2;
                    pinsLeftInCurrentFrame = 10 - lastRollPins;
                    if (currentFrame != 0 && rolls.get(rollIndexOfLastFrame) + rolls.get(rollIndexOfLastFrame + 1) == 10) {
                        totalScore += (10 + lastRollPins);
                    }
                }
            } else if (rollInCurrentFrame == 2) {
                currentFrame++;
                pinsLeftInCurrentFrame = 10;
                rollInCurrentFrame = 1;
                rollIndexOfLastFrame += 2;
                if (rolls.get(rollIndexOfLastFrame) + rolls.get(rollIndexOfLastFrame + 1) == 10) {
//                    totalScore += (10 + lastRollPins);
                } else {
                    if (rollIndexOfLastFrame >=1 && rolls.get(rollIndexOfLastFrame - 1) == 10) {
                        totalScore += (10 + rolls.get(rollIndexOfLastFrame) + rolls.get(rollIndexOfLastFrame + 1));
                    }
                    totalScore += (rolls.get(rollIndexOfLastFrame) + rolls.get(rollIndexOfLastFrame + 1));
                }
            }
        }
        return String.format("Frame:%d;Roll:%d;Pins Left:%d;Score:%d", currentFrame + 1, rollInCurrentFrame, pinsLeftInCurrentFrame, totalScore);
    }

}
