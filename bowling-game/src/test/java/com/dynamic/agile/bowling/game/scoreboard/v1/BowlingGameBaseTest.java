package com.dynamic.agile.bowling.game.scoreboard.v1;

import org.junit.Before;

/**
 * @author: UncleJet
 * @date: Created in 2020/12/1 21:40
 * @description:
 */
public class BowlingGameBaseTest {

    protected BowlingGame game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGame();
    }

    protected void roll(int pins) {
        game.roll(pins);
    }

    protected void rollMiss(int firstRollPins, int secondRollPins) {
        assert firstRollPins + secondRollPins < Frame.ALL_PINS_IN_FRAME;
        roll(firstRollPins);
        roll(secondRollPins);
    }

    protected void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            roll(pins);
        }
    }

    protected void rollSpare(int firstRollPins, int secondRollPins) {
        assert firstRollPins + secondRollPins == Frame.ALL_PINS_IN_FRAME;
        roll(firstRollPins);
        roll(secondRollPins);
    }

    protected void rollStrike() {
        roll(Frame.ALL_PINS_IN_FRAME);
    }
}
