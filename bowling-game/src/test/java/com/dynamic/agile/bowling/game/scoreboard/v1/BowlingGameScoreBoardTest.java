package com.dynamic.agile.bowling.game.scoreboard.v1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/30 22:06
 * @description:
 */
public class BowlingGameScoreBoardTest {
    @Test
    public void frame1roll1hit2Pins() {
        BowlingGame game = new BowlingGame();
        game.roll(2);
        assertThat(game.showScoreBoard(), is("1, 1, 2, 0"));
    }
}
