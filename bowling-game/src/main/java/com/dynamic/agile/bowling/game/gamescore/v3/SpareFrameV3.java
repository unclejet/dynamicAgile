package com.dynamic.agile.bowling.game.gamescore.v3;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/12 20:28
 * @description:
 */
public class SpareFrameV3 extends FrameV3 {
    @Override
    public int calculateScore(int[] rolls) {
        return ALL_HIT_PINS_NUMBER + rolls[rollIndex[1] + 1];
    }

}
