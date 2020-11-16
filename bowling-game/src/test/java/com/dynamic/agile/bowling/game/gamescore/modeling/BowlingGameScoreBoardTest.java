package com.dynamic.agile.bowling.game.gamescore.modeling;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author UncleJet
 * @date 11/16/2020 8:26 AM
 * @description
 */
public class BowlingGameScoreBoardTest {
    @Test
    public void whenGameStart_ICanSeeScoreBoard() {
        BowlingGame game = new BowlingGame();
        assertThat(game.getScoreBoard(), is(String.format("Frame:%d;Roll:%d;Pins Left:%s;Score:%d", 1, 1, 10, 0)));
    }
}
