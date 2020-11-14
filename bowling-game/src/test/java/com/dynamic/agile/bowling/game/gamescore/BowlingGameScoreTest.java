package com.dynamic.agile.bowling.game.gamescore;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static com.dynamic.agile.bowling.game.gamescore.BowlingGame.PINS_IN_FRAME;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author UncleJet
 * @date 11/14/2020 9:01 AM
 * @description
 */
public class BowlingGameScoreTest {

    private BowlingGame game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGame();
    }

    private void roll(int pins) {
        game.roll(pins);
    }

    private void rollFrame(int firstPins, int secondPins) {
        roll(firstPins);
        roll(secondPins);
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            roll(pins);
        }
    }

    private void rollSpare(int firstPins, int secondPins) {
        roll(firstPins);
        roll(secondPins);
    }

    private void rollStrike() {
        roll(PINS_IN_FRAME);
    }

    @Test
    public void whenIRoll0InOneGame_thenIHaveGameScore0() {
        rollMany(20, 0);
        assertThat(game.getGameScore(), is(0));
    }

    @Test
    public void whenIRoll1InOneGame_thenIHaveGameScore20() {
        rollMany(20, 1);
        assertThat(game.getGameScore(), is(20));
    }

    @Test
    public void whenIRollOneSpareInOneGame_thenIHaveGameScore22() {
        rollSpare(5, 5);
        rollMany(1, 6);
        rollMany(17, 0);
        assertThat(game.getGameScore(), is(22));
    }


    @Test
    public void whenIRollOneStrikeInOneGame_thenIHaveGameScore22() {
        rollStrike();
        rollFrame(6, 0);
        rollMany(17, 0);
        assertThat(game.getGameScore(), is(22));
    }
}
