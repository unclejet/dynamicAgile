package com.dynamic.agile.bowling.game.v6;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/12 17:01
 * @description:
 */
public class BowlingGameV6Test {
    private BowlingGameV6 game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGameV6();
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            roll(pins);
        }
    }

    private void roll(int pins) {
        game.roll(pins);
    }

    private void rollMiss(int firstPins, int secondPins) {
        assert firstPins + secondPins < FrameV6.PINS_OF_FRAME;
        roll(firstPins);
        roll(secondPins);
    }

    private void rollSpare(int firstPins, int secondPins) {
        assert firstPins + secondPins == FrameV6.PINS_OF_FRAME;
        roll(firstPins);
        roll(secondPins);
    }

    private void rollStrike() {
        roll(FrameV6.PINS_OF_FRAME);
    }

    @Test
    public void roll1() {
        roll(1);
        assertThat(game.score(), is(0));
    }

    @Test
    public void roll11() {
        rollMiss(1, 1);
        assertThat(game.score(), is(2));
    }

    @Test
    public void roll111() {
        rollMiss(1, 1);
        roll(1);
        assertThat(game.score(), is(2));
    }

    @Test
    public void roll1for20() {
        rollMany(20, 1);
        assertThat(game.score(), is(20));
    }

    @Test
    public void roll55() {
        rollSpare(5, 5);
        assertThat(game.score(), is(0));
    }

    @Test
    public void roll551() {
        rollSpare(5, 5);
        roll(1);
        assertThat(game.score(), is(11));
    }

    @Test
    public void roll555511() {
        rollSpare(5, 5);
        rollSpare(5, 5);
        rollMiss(1, 1);
        assertThat(game.score(), is(15 + 11 + 2));
    }

    @Test
    public void roll1for18and55() {
        rollMany(18, 1);
        rollSpare(5, 5);
        assertThat(game.score(), is(18));
    }

    @Test
    public void roll1Strike() {
        rollStrike();
        assertThat(game.score(), is(0));
    }

    @Test
    public void roll2Strikes() {
        rollStrike();
        rollStrike();
        assertThat(game.score(), is(0));
    }

    @Test
    public void rollStrike11() {
        rollStrike();
        rollMiss(1, 1);
        assertThat(game.score(), is(14));
    }

    @Test
    public void rollAllStrikes() {
        rollMany(12, 10);
        assertThat(game.score(), is(300));
    }
}
