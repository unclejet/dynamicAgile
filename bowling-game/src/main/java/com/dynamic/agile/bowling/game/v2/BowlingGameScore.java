package com.dynamic.agile.bowling.game.v2;

import com.dynamic.agile.bowling.game.Roll;

import java.util.stream.IntStream;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/12 9:34
 * @description: 计算一局(game)的分数
 * V2版意识到roll应该是属于game发起，而frame只是维护当前自己轮的rolls就可以了
 * 这一版的roll方法有些复杂，因为这一版和第一版一样，都是先把10格frame创建好了再进行game的
 * 下一版可以考虑通过roll动作来创建不同的frame(比如SpareFrame，StrikeFrame等)
 */
public class BowlingGameScore {
    public static final int FRAME_NUMBER_IN_GAME = 10;
    public static final int MAX_ALLOWED_ROLLS_NUMBER = 21;

    private Frame[] frames = new Frame[FRAME_NUMBER_IN_GAME];
    private Roll[] rolls = new Roll[MAX_ALLOWED_ROLLS_NUMBER];

    private int frameIndex;
    private int rollIndex;
    private int score;

    public BowlingGameScore() {
        IntStream.range(0, 10)
                .forEach(i -> frames[i] = new Frame());
    }

    public void roll(int pins) {
        Roll roll = new Roll(rollIndex, pins);
        rolls[rollIndex++] = roll;
        Frame frame = getSpecialFrame(frameIndex);
        frame.add(roll);
        if (frame.isRolledFinished()) {
            frameIndex++;
        }
    }

    public Frame getSpecialFrame(int i) {
        if (i >= FRAME_NUMBER_IN_GAME) {
            return frames[FRAME_NUMBER_IN_GAME - 1];
        }
        return frames[i];
    }

    public int getScore() {
        IntStream.range(0, 10)
                .forEach(i -> score += frames[i].calculateScore(rolls));
        return score;
    }

}
