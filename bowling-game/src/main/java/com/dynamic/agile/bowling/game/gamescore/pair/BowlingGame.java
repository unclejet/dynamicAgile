package com.dynamic.agile.bowling.game.gamescore.pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author UncleJet & DavidZhang33
 * @date 11/8/2020 5:02 PM
 * @description 计算一个人打一局保龄球的得分
 * 该算法参考过uncle bob clean code视频TDD partII
 */
public class BowlingGame {
    public static final int FRAMES_OF_GAME = 10;
    public static final int PINS_OF_FRAME = 10;
    private final ScoreBoard scoreBoard;
    private int gameScore;
    private List<Integer> rolls = new ArrayList<>();

    public BowlingGame() {
        scoreBoard = new ScoreBoard();
    }

    public int getGameScore() {
        int rollIndexForTheFrame = 0;
        for (int frame = 0; frame < FRAMES_OF_GAME; frame++) {
            int frameScore;
            if (isStrike(rollIndexForTheFrame)) {
                frameScore = PINS_OF_FRAME + getTwoRollsScore(rollIndexForTheFrame + 1);
                rollIndexForTheFrame += 1;
            } else if (isSpare(rollIndexForTheFrame)) {
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

    private boolean isStrike(int roll) {
        return rolls.get(roll) == 10;
    }

    private boolean isSpare(int roll) {
        return getTwoRollsScore(roll) == 10;
    }

    public void roll(int pins) {
        rolls.add(pins);
    }

    public int getScore() {
        return scoreBoard.getScore();
    }

    public String getScoreBoard() {
        return scoreBoard.getBoardContent();
    }


    private class ScoreBoard {
        private int frameIndex = 1;
        private int rollInFrame = 1;
        private String pinsLeft = "10";

        public int getScore() {
            int score = 0;
            for (int roll = 0; roll < rolls.size(); roll++) {
                int pins = rolls.get(roll);
                if (rollInFrame == 1) {
                    if (roll > 1 && isStrike(roll - 1) && isStrike(roll - 2)) {
                        score += PINS_OF_FRAME + PINS_OF_FRAME + pins;
                    }
                    if (roll > 1 && isSpare(roll - 2)) {
                        score += PINS_OF_FRAME + pins;
                    }
                } else if (rollInFrame == 2) {
                    if (roll > 1 && isStrike(roll - 2)) {
                        score += PINS_OF_FRAME + getTwoRollsScore(roll - 1);
                    }
                    if (isMiss(roll - 1)) {
                        score += getTwoRollsScore(roll - 1);
                    }
                }

                if (rollInFrame == 1) {
                    if (isStrike(roll)) {
                        frameIndex++;
                        pinsLeft = "x";
                    } else {
                        pinsLeft = "" + (PINS_OF_FRAME - rolls.get(roll));
                        rollInFrame = 2;
                    }
                } else if (rollInFrame == 2) {
                    if (isSpare(roll - 1)) {
                        pinsLeft = "/";
                    } else {
                        pinsLeft = "" + (PINS_OF_FRAME - getTwoRollsScore(roll - 1));
                    }
                    frameIndex++;
                    rollInFrame = 1;
                }
            }
            return score;
        }

        private boolean isMiss(int roll) {
            return getTwoRollsScore(roll) < 10;
        }

        public String getBoardContent() {
            int score = getScore();
            int frameIndex = getFrameIndex();
            String pinsLeft = getPinsLeft();
            int rollInFrame = getRollInFrame();
            return String.format("Frame:%d;Roll:%d;Pins Left:%s;Score:%d", frameIndex, rollInFrame, pinsLeft, score);
        }

        private int getFrameIndex() {
            if (rollInFrame == 2) {
                return frameIndex;
            }
            return frameIndex - 1;
        }

        private int getRollInFrame() {
            if (rollInFrame == 2) {
                return 1;
            } else if (rollInFrame == 1) {
                return pinsLeft.equals("x") ? 1 : 2;
            }
            return -1;
        }

        private String getPinsLeft() {
            return pinsLeft;
        }
    }
}
