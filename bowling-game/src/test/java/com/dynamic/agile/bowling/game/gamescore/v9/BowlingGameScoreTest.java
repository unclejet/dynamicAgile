package com.dynamic.agile.bowling.game.gamescore.v9;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BowlingGameScoreTest {
    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void roll0_score0() {
        roll(0);
        assertThat(game.score(), is(0));
    }

    @Test
    public void roll0And5_score5() {
        rollMiss(0, 5);
        assertThat(game.score(), is(5));
    }

    @Test
    public void rollAllMiss_score6() {
        rollMany(18, 0);
        rollMiss(5, 1);
        assertThat(game.score(), is(6));
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }

    @Test
    public void roll5_5_3_score5() {
        rollSpare(5, 5);
        assertThat(game.score(), is(0));
        roll(3);
        assertThat(game.score(), is(13));
    }

    @Test
    public void rollMissAndSpare() {
        rollSpare(4, 6);
        rollMiss(4, 4);
        rollMany(16, 0);
        assertThat(game.score(), is(14 + 8));
    }

    @Test
    public void rollStrike() {
        roll(10);
        assertThat(game.score(), is(0));
        roll(5);
        assertThat(game.score(), is(0));
        roll(4);
        assertThat(game.score(), is(0));
    }

    private void rollSpare(int p1, int p2) {
        assert p1 + p2 == 10;
        roll(p1);
        roll(p2);
    }

    private void rollMiss(int pins1, int pins2) {
        assert pins1 + pins2 < 10;
        roll(pins1);
        roll(pins2);
    }


    private void roll(int hitPins) {
        game.roll(hitPins);
    }
}
