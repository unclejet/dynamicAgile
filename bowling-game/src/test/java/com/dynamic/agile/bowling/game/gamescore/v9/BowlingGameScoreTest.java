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
        game.roll(0);
        assertThat(game.score(), is(0));
    }

}
