package com.dynamic.agile.bowling.game.gamescore.vjet8;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/19 14:37
 * @description:
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

    private void rollMiss(int firstRollPins, int secondRollPins) {
        roll(firstRollPins);
        roll(secondRollPins);
    }

    @Test
    public void rollOneBallHit3Pins() {
        int pins = 3;
        roll(pins);
        assertThat(game.score(), is(0));
    }

    @Test
    public void rollMiss() {
        rollMiss(3, 2);
        assertThat(game.score(), is(5));
    }
}
