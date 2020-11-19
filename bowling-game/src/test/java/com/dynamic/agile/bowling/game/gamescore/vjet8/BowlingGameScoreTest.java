package com.dynamic.agile.bowling.game.gamescore.vjet8;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/19 14:37
 * @description:
 */
public class BowlingGameScoreTest {
    @Test
    public void rollOneBallHit3Pins() {
        BowlingGame game = new BowlingGame();
        game.roll(3);
        assertThat(game.score(), is(0));
    }

    @Test
    public void rollMiss() {
        BowlingGame game = new BowlingGame();
        game.roll(3);
        game.roll(2);
        assertThat(game.score(), is(5));
    }
}
