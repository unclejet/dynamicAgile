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

    private void roll(int pins) {
        game.roll(pins);
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            roll(pins);
        }
    }

    @Test
    public void whenIRoll0InOneGame_thenIHaveGameScore0() {
        BowlingGame game = new BowlingGame();
        rollMany(20, 0);
        assertThat(game.getGameScore(), is(0));
    }

    @Test
    public void whenIRoll1InOneGame_thenIHaveGameScore20() {
        rollMany(20, 1);
        assertThat(game.getGameScore(), is(20));
    }

    @Test
    public void whenIRollOneSpareInOneGame_thenIHaveGameScore22() {
        rollMany(2, 5);//spare
        rollMany(1, 6);
        rollMany(17, 0);
        assertThat(game.getGameScore(), is(22));
    }
}
