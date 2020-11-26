package com.dynamic.agile.bowling.game.dapV3;

import org.junit.Before;
import org.junit.Test;

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
}
