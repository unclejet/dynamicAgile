package com.dynamic.agile.bowling.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.dynamic.agile.bowling.game.Frame.ALL_HIT_PINS_NUMBER;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/12 17:01
 * @description:计算一局(game)的分数
 * 根据投手roll的进行，判断是否一轮完成了，根据完成的情况生成不同类型的Frame；
 * Frame保存当前轮的第一个roll和第二个roll的索引
 * rolls属于game，每一次投球都必须保存下来
 * 因为spare和strike的算法是拿到下一投或下两投，所以需要把rolls传给Frame来算轮分
 */
public class BowlingGame {
    public static final int MAX_FRAMES_IN_GAME = 10;
    public static final int MAX_ROLLS_NUMBER = 21;

    private int[] rolls = new int[MAX_ROLLS_NUMBER];
    private int rollIndex;

    private List<Frame> frames = new ArrayList<>(); //size可能大于10
    private int rollInFrame;

    public void roll(int pins) {
        rolls[rollIndex] = pins;
        handleFrame();
        rollIndex++;
    }

    private void handleFrame() {
        rollInFrame++;
        if (isStrike()) {
            handleRollStrike();
        } else if (isSpare()) {
            handleRollSpare();
        } else if (isMissed()) {
            handleRollMissed();
        }
    }

    private boolean isStrike() {
        return rollInFrame == 1
                && rolls[rollIndex] == ALL_HIT_PINS_NUMBER;
    }

    private boolean isMissed() {
        return rollInFrame == 2
                && rolls[rollIndex - 1]+ rolls[rollIndex] < ALL_HIT_PINS_NUMBER;
    }

    private boolean isSpare() {
        return rollInFrame == 2
                && rolls[rollIndex - 1] + rolls[rollIndex] == ALL_HIT_PINS_NUMBER;
    }

    private void handleRollMissed() {
        Frame frame = new Frame();
        handleFrame(frame);
    }

    private void handleRollSpare() {
        SpareFrame spareFrame = new SpareFrame();
        handleFrame(spareFrame);
    }

    private void handleRollStrike() {
        StrikeFrame strikeFrame = new StrikeFrame();
        strikeFrame.addFirstRollIndex(rollIndex);
        frames.add(strikeFrame);
        rollInFrame = 0;
    }

    private void handleFrame(Frame frame) {
        addRollInFrame(frame);
        frames.add(frame);
        rollInFrame = 0;
    }

    private void addRollInFrame(Frame frame) {
        frame.addFirstRollIndex(rollIndex - 1);
        frame.addSecondRollIndex(rollIndex);
    }

    /**
     * 一定是在一局结束后开始算分
     * @return
     */
    public int getTotalScore() {
        return IntStream.range(0, MAX_FRAMES_IN_GAME)
                .map(i -> frames.get(i).calculateScore(rolls))
                .sum();
    }
}
