package com.dynamic.agile.bowling.game.gamescore.v3.modeling;

import org.junit.Before;

import static com.dynamic.agile.bowling.game.gamescore.v3.modeling.FrameV3X.PINS_IN_FRAME;

/**
 * @author UncleJet
 * @date 11/16/2020 12:50 PM
 * @description
 */
public class BowlingGameTest {
    protected BowlingGame game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGame();
    }

    protected void roll(int pins) {
        game.roll(pins);
    }

    protected void rollFrame(int firstRollPins, int secondRollPins) {
        assert firstRollPins + secondRollPins < PINS_IN_FRAME;
        roll(firstRollPins);
        roll(secondRollPins);
    }

    protected void rollSpare(int firstRollPins, int secondRollPins) {
        assert firstRollPins + secondRollPins == PINS_IN_FRAME;
        roll(firstRollPins);
        roll(secondRollPins);
    }

    protected void rollStrike() {
        roll(10);
    }

    protected void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            roll(pins);
        }
    }

    protected void rollExtra(int pins) {
        roll(pins);
    }
}
