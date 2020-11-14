package com.dynamic.agile.bowling.game.gamescore;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author UncleJet
 * @date 11/14/2020 9:01 AM
 * @description
 */
public class BowlingGameScoreTest {

    private BowlingGame game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGame();
    }

    @Test
    public void whenIPlayBowlingGame_IHaveAScore() {
        assertThat(game.getScore(), is(-1));
    }
}
