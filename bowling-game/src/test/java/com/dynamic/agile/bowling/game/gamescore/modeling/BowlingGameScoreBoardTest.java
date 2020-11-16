package com.dynamic.agile.bowling.game.gamescore.modeling;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author UncleJet
 * @date 11/16/2020 8:26 AM
 * @description
 */
public class BowlingGameScoreBoardTest {

    private BowlingGame game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGame();
    }

    private void verifyScoreBoard(int frameNumber, int rollIndexOfFrame, String pinsLeft, int score) {
        assertThat(game.getScoreBoard(), is(String.format("Frame:%d;Roll:%d;Pins Left:%s;Score:%d", frameNumber, rollIndexOfFrame, pinsLeft, score)));
    }

    @Test
    public void whenGameStart_ICanSeeScoreBoard() {
        verifyScoreBoard(1, 1, "10", 0);
    }

    @Test
    public void roll7() {
        game.roll(7);
        verifyScoreBoard(1, 1, "3", 0);
    }

    @Test
    public void rollSpareNoNextRoll() {
        game.roll(7);
        game.roll(3); //spare
        verifyScoreBoard(1, 2, "/", 0);
    }
}
