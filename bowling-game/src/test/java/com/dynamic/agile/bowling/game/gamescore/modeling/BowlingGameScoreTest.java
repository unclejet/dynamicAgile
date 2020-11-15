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

    private void roll(int pins) {
        game.roll(pins);
    }

    private void rollFrame(int firstRollPins, int secondRollPins) {
        roll(firstRollPins);
        roll(secondRollPins);
    }

    @Test
    public void givenGameStart_whenIRoll2_thenGetGameScore0() {
        roll(2);
        assertThat(game.getGameScore(), is(0));
    }

    @Test
    public void givenGameStart_whenIRoll2And3_thenGetGameScore5() {
        rollFrame(2, 3);
        assertThat(game.getGameScore(), is(5));
    }

    @Test
    public void rollAll1_thenGetGameScore20() {
        for (int i = 0; i < 20; i++) {
            roll(1);
        }
        assertThat(game.getGameScore(), is(20));
    }
}
