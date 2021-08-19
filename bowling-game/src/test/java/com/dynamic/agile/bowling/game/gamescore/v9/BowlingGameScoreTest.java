package com.dynamic.agile.bowling.game.gamescore.v9;

import org.junit.Before;
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

    private void rollMiss(int pins1, int pins2) {
        assert pins1 + pins2 < 10;
        roll(pins1);
        roll(pins2);
    }

    @Test
    public void roll5And5_score5() {
        game.roll(0);
        game.roll(5);
        assertThat(game.score(), is(5));
    }


    private void roll(int hitPins) {
        game.roll(hitPins);
    }
}
