package com.dynamic.agile.bowling.game.gamescore.v3;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/12 21:19
 * @description:
 */
public class StrikeFrameV3 extends FrameV3 {
    @Override
    public int calculateScore(int[] rolls) {
        return ALL_HIT_PINS_NUMBER + rolls[rollIndex[0] + 1] + rolls[rollIndex[0] + 2];
    }
}
