package com.dynamic.agile.bowling.game.gamescore.v3;

import org.junit.Before;
import org.junit.Test;


import static com.dynamic.agile.bowling.game.gamescore.v3.FrameV3.ALL_HIT_PINS_NUMBER;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/12 17:01
 * @description:
 */
public class BowlingGameV3Test {
    private BowlingGameV3 game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGameV3();
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            roll(pins);
        }
    }

    private void roll(int pins) {
        game.roll(pins);
    }

    @Test
    public void canGetGameScore() {
        rollFrame(5, 0);
        rollMany(18, 0);
        assertThat(game.getTotalScore(), is(5));
    }

    private void rollFrame(int firstPins, int secondPins) {
        assert  firstPins + secondPins < ALL_HIT_PINS_NUMBER;
        roll(firstPins);
        roll(secondPins);
    }

    @Test
    public void rollAll0() {
        rollMany(20, 0);
        assertThat(game.getTotalScore(), is(0));
    }

    @Test
    public void rollAll1() {
        rollMany(20, 1);
        assertThat(game.getTotalScore(), is(20));
    }

    @Test
    public void rollOneSpare() {
        rollSpare(5, 5);
        rollFrame(2, 0);
        rollMany(16, 0);
        assertThat(game.getTotalScore(), is(14));
    }

    private void rollSpare(int firstPins, int secondPins) {
        assert  firstPins + secondPins == ALL_HIT_PINS_NUMBER;
        roll(firstPins);
        roll(secondPins);
    }

    @Test
    public void rollTwoSpares() {
        rollSpare(5, 5);
        rollSpare(2, 8);
        rollFrame(3, 0);
        rollMany(14, 0);
        assertThat(game.getTotalScore(), is(12 + 13 + 3));
    }

    @Test
    public void rollLastSpare() {
        rollMany(18, 0);
        rollSpare(2, 8);
        roll(3);
        assertThat(game.getTotalScore(), is(13));
    }

    @Test
    public void rollOneStrike() {
        rollStrike();
        rollFrame(5, 2);
        rollMany(16, 0);
        assertThat(game.getTotalScore(), is(17 + 7));
    }

    @Test
    public void rollTwoStrikes() {
        rollStrike();
        rollStrike();
        rollFrame(5, 2);
        rollMany(14, 0);
        assertThat(game.getTotalScore(), is(25 + 17 + 7));
    }

    @Test
    public void rollLastStrike() {
        rollMany(18, 0);
        rollStrike();
        rollFrame(5, 2);
        assertThat(game.getTotalScore(), is(17));
    }

    @Test
    public void rollAllStrikes() {
        for (int i = 0; i < 12; i++) {
            rollStrike();
        }
        assertThat(game.getTotalScore(), is(300));
    }

    @Test
    public void complexRoll() {
        rollFrame(1,2);
        rollStrike();
        rollSpare(4, 6);
        rollMany(14, 1);
        assertThat(game.getTotalScore(), is(3 + 20 + 11 + 14));
    }

    private void rollStrike() {
        roll(10);
    }
}
