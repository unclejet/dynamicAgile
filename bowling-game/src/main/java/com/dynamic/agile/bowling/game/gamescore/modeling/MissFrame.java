package com.dynamic.agile.bowling.game.gamescore.modeling;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/15 9:05
 * @description:
 */
public class MissFrame extends Frame {
    public MissFrame(int firstRollPins, int secondRollPins) {
        super(firstRollPins, secondRollPins);
    }

    @Override
    public int calculateScore() {
        return firstRollPins + secondRollPins;
    }
}
