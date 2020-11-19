package com.dynamic.agile.bowling.game.dapV1;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class BowlingGameDAPV1Test {
    private BowlingGameDAPV1 game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGameDAPV1();
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
        assert firstPins + secondPins < 10;
        roll(firstPins);
        roll(secondPins);
    }

    private void rollSpare(int firstPins, int secondPins) {
        assert firstPins + secondPins == 10;
        roll(firstPins);
        roll(secondPins);
    }

    private void rollStrike() {
        roll(10);
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
    public void roll11221() {
        rollMiss(1, 1);
        rollMiss(2, 2);
        roll(1);
        assertThat(game.score(), is(6));
    }

    @Test
    public void roll1Spare(){
        rollSpare(6,4);
        assertThat(game.score(),is(0));
    }
}
