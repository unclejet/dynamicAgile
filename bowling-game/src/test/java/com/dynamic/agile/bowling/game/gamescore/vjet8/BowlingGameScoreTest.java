package com.dynamic.agile.bowling.game.gamescore.vjet8;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/19 14:37
 * @description:
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

    private void rollMiss(int firstRollPins, int secondRollPins) {
        assert firstRollPins + secondRollPins < Frame.ALL_PINS_IN_FRAME;
        roll(firstRollPins);
        roll(secondRollPins);
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            roll(pins);
        }
    }

    private void rollSpare(int firstRollPins, int secondRollPins) {
        assert firstRollPins + secondRollPins == Frame.ALL_PINS_IN_FRAME;
        roll(firstRollPins);
        roll(secondRollPins);
    }

    @Test
    public void rollOneBallHit3Pins() {
        int pins = 3;
        roll(pins);
        assertThat(game.score(), is(0));
    }

    @Test
    public void rollMiss() {
        rollMiss(3, 2);
        assertThat(game.score(), is(5));
    }

    @Test
    public void rollMissAndNextRoll() {
        rollMiss(3, 2);
        roll(4);
        assertThat(game.score(), is(5));
    }

    @Test
    public void rollTwoMiss() {
        rollMiss(3, 2);
        rollMiss(4, 5);
        assertThat(game.score(), is(5 + 9));
    }

    @Test
    public void rollAllMiss() {
        rollMany(20, 1);
        assertThat(game.score(), is(20));
    }

    @Test
    public void rollSpare() {
        rollSpare(5, 5);
        assertThat(game.score(), is(0));
    }

    @Test
    public void rollSpareAndNextRoll() {
        rollSpare(5, 5);
        roll(3);
        assertThat(game.score(), is(13));
    }
}
