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
    public void roll1Spare() {
        rollSpare(6, 4);
        assertThat(game.score(), is(0));
    }

    @Test
    public void roll1SpareAnd2() {
        rollSpare(3, 7);
        roll(2);
        assertThat(game.score(), is(12));
    }

    @Test
    public void roll2SpareAnd2() {
        rollSpare(3, 7);
        rollSpare(5, 5);
        roll(2);
        assertThat(game.score(), is(15 + 12));
    }

    @Test
    public void roll1Strike() {
        rollStrike();
        assertThat(game.score(), is(0));
    }

    @Test
    public void roll1StrikeAnd2() {
        rollStrike();
        roll(2);
        assertThat(game.score(), is(0));
    }

    @Test
    public void roll1StrikeAnd22() {
        rollStrike();
        rollMiss(2, 2);
        assertThat(game.score(), is(14 + 4));
    }

    @Test
    public void rollAllStrikes() {
        rollMany(12, 10);
        assertThat(game.score(), is(300));
    }

    @Test
    public void roll1_1110() {
        roll(1);
        assertThat(game.scoreBoard(), is("1,1,1,0"));
    }

    @Test
    public void roll11_1222() {
        rollMiss(1, 1);
        assertThat(game.scoreBoard(), is("1,2,2,2"));
    }

    @Test
    public void roll113_2132() {
        rollMiss(1, 1);
        roll(3);
        assertThat(game.scoreBoard(), is("2,1,3,2"));
    }

    @Test
    public void roll1Spare_64s0() {
        rollSpare(6, 4);
        assertThat(game.scoreBoard(), is("1,2,/,0"));
    }

    @Test
    public void roll1Strike_11x0() {
        rollStrike();
        assertThat(game.scoreBoard(), is("1,1,x,0"));
    }

    @Test
    public void rollAR1() {
        rollMany(10, 10);
        roll(5);
        assertThat(game.scoreBoard(), is("-,-,5,265"));
    }

    @Test
    public void rollAR2() {
        rollMany(10, 10);
        rollMiss(5, 4);
        assertThat(game.scoreBoard(), is("-,-,4,293"));
    }

    @Test
    public void roll1_isFinished() {
        roll(1);
        assertThat(game.isFinished(), is(false));
    }

    @Test
    public void roll2for20_isFinished() {
        rollMany(20, 2);
        assertThat(game.isFinished(), is(true));
    }

    @Test
    public void roll5for20_isFinished() {
        rollMany(20, 5);
        assertThat(game.isFinished(), is(false));
    }

    @Test
    public void roll5for21_isFinished() {
        rollMany(20, 5);
        roll(5);
        assertThat(game.isFinished(), is(true));
    }

    @Test
    public void roll10Strikes_isFinished() {
        rollMany(10, 10);
        assertThat(game.isFinished(), is(false));
    }

    @Test
    public void roll10Strikes2_isFinished() {
        rollMany(10, 10);
        roll(2);
        assertThat(game.isFinished(), is(false));
    }

    @Test
    public void roll10Strikes23_isFinished() {
        rollMany(10, 10);
        rollMiss(2, 3);
        assertThat(game.isFinished(), is(true));
    }

    @Test
    public void roll11Strikes_isFinished() {
        rollMany(11, 10);
        assertThat(game.isFinished(), is(false));
    }

    @Test
    public void roll12Strikes_isFinished() {
        rollMany(12, 10);
        assertThat(game.isFinished(), is(true));
    }

}
