package com.dynamic.agile.bowling.game.dapv2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameDAPV2Test {
    private BowlingGameDAPV2 game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGameDAPV2();
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
        assertEquals(0, game.score());
    }

    @Test
    public void roll11() {
        rollMiss(1, 1);
        assertEquals(2, game.score());
    }

    @Test
    public void roll111() {
        rollMany(3, 1);
        assertEquals(2, game.score());
    }

    @Test
    public void roll11111() {
        rollMany(5, 1);
        assertEquals(4, game.score());
    }

    @Test
    public void roll1Spare() {
        rollSpare(6, 4);
        assertEquals(0, game.score());
    }

    @Test
    public void roll1SpareAnd2() {
        rollSpare(6, 4);
        roll(2);
        assertEquals(12, game.score());
    }

    @Test
    public void roll13Spare() {
        rollSpare(6, 4);
        rollSpare(3, 7);
        rollSpare(5, 5);
        assertEquals(13 + 15, game.score());
    }

    @Test
    public void roll1Strike() {
        rollStrike();
        assertEquals(0, game.score());
    }

    @Test
    public void roll1StrikeAnd22() {
        rollStrike();
        rollMiss(2, 2);
        assertEquals(18, game.score());
    }

    @Test
    public void roll12Strikes() {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }
}
