package com.dynamic.agile.bowling.game.dapV3;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    private BowlingGameDAPV3 game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGameDAPV3();
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
    public void roll3() {
        roll(3);
        assertEquals(0, game.score());
    }

    @Test
    public void roll31() {
        rollMiss(3, 1);
        assertEquals(4, game.score());
    }

    @Test
    public void roll312() {
        rollMiss(3, 1);
        roll(2);
        assertEquals(4, game.score());
    }

    @Test
    public void roll31245() {
        rollMiss(3, 1);
        rollMiss(2, 4);
        roll(5);
        assertEquals(10, game.score());
    }

    @Test
    public void roll1Spare() {
        rollSpare(5, 5);
        assertEquals(0, game.score());
    }

    @Test
    public void roll1SpareAnd3() {
        rollSpare(4, 6);
        roll(3);
        assertEquals(13, game.score());
    }

    @Test
    public void roll1Strike() {
        rollStrike();
        assertEquals(0, game.score());
    }

    @Test
    public void roll1StrikeAnd7() {
        rollStrike();
        roll(7);
        assertEquals(0, game.score());
    }

    @Test
    public void roll1StrikeAnd72() {
        rollStrike();
        rollMiss(7, 2);
        assertEquals(28, game.score());
    }

    @Test
    public void rollAllStrikes() {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }

    @Test
    public void roll11Strikes() {
        rollMany(11, 10);
        assertEquals(270, game.score());
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

    @Test
    public void sb_roll1() {
        roll(1);
        assertThat(game.scoreBoard(), is("1,1,1,0"));
    }

    @Test
    public void sb_roll34() {
        rollMiss(3, 4);
        assertThat(game.scoreBoard(), is("1,2,7,7"));
    }

    @Test
    public void sb_roll1Spare() {
        rollSpare(6, 4);
        assertThat(game.scoreBoard(), is("1,2,/,0"));
    }

    @Test
    public void sb_roll1Strike() {
        rollStrike();
        assertThat(game.scoreBoard(), is("1,1,x,0"));
    }

    @Test
    public void sb_roll3for20() {
        rollMany(20, 3);
        assertThat(game.scoreBoard(), is("10,2,6,60"));
    }

    @Test
    public void sb_roll5for20() {
        rollMany(20, 5);
        assertThat(game.scoreBoard(), is("10,2,/,135"));
        assertThat(game.isFinished(), is(false));
    }

    @Test
    public void sb_roll5for21() {
        rollMany(21, 5);
        assertThat(game.scoreBoard(), is("10,/1,5,150"));
        assertThat(game.isFinished(), is(true));
    }

    @Test
    public void sb_roll5for20AndStrike() {
        rollMany(20, 5);
        rollStrike();
        assertThat(game.scoreBoard(), is("10,/1,x,155"));
        assertThat(game.isFinished(), is(true));
    }

    @Test
    public void sb_roll10for10And5() {
        rollMany(10, 10);
        roll(5);
        assertThat(game.scoreBoard(), is("10,x1,5,265"));
        assertThat(game.isFinished(), is(false));
    }

    @Test
    public void sb_roll10for10And55() {
        rollMany(10, 10);
        rollSpare(5, 5);
        assertThat(game.scoreBoard(), is("10,x2,5,285"));
        assertThat(game.isFinished(), is(true));
    }

    @Test
    public void sb_roll10for11() {
        rollMany(11, 10);
        assertThat(game.scoreBoard(), is("10,x1,x,270"));
        assertThat(game.isFinished(), is(false));
    }

    @Test
    public void sb_roll10for10() {
        rollMany(10, 10);
        assertThat(game.scoreBoard(), is("10,1,x,240"));
        assertThat(game.isFinished(), is(false));
    }

    @Test
    public void sb_roll10for12() {
        rollMany(12, 10);
        assertThat(game.scoreBoard(), is("10,x2,x,300"));
        assertThat(game.isFinished(), is(true));
    }

    @Test
    public void sb_roll10for11And5() {
        rollMany(11, 10);
        roll(5);
        assertThat(game.scoreBoard(), is("10,x2,5,295"));
        assertThat(game.isFinished(), is(true));
    }
}
