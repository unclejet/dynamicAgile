package com.dynamic.agile.bowling.game.gamescore.modeling;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/15 7:34
 * @description:
 */
public class BowlingGameScoreTest {

    private BowlingGame game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGame();
    }

    @Test
    public void givenGameStart_whenIRoll2_thenGetGameScore0() {
        game.roll(2);
        assertThat(game.getGameScore(), is(0));
    }

    @Test
    public void givenGameStart_whenIRoll2And3_thenGetGameScore5() {
        game.roll(2);
        game.roll(3);
        assertThat(game.getGameScore(), is(5));
    }
}
