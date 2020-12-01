package com.dynamic.agile.bowling.game.scoreboard.v1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/30 22:06
 * @description:
 */
public class BowlingGameScoreBoardTest extends BowlingGameBaseTest {
    @Test
    public void frame1roll1hit2Pins() {
        roll(2);
        assertThat(game.showScoreBoard(), is("1, 1, 2, 0"));
    }

    @Test
    public void frame1rollMiss2And3() {
        rollMiss(2, 3);
        assertThat(game.showScoreBoard(), is("1, 2, 5, 5"));
    }

    @Test
    public void frame2roll7() {
        rollMiss(2, 3);
        roll(7);
        assertThat(game.showScoreBoard(), is("2, 1, 7, 5"));
    }

    @Test
    public void frame2rollMiss7And0() {
        rollMiss(2, 3);
        rollMiss(7, 0);
        assertThat(game.showScoreBoard(), is("2, 2, 7, 12"));
    }

    @Test
    public void frame3roll5() {
        rollMiss(2, 3);
        rollMiss(7, 0);
        roll(5);
        assertThat(game.showScoreBoard(), is("3, 1, 5, 12"));
    }

    @Test
    public void frame3rollSpare() {
        rollMiss(2, 3);
        rollMiss(7, 0);
        rollSpare(5, 5);
        assertThat(game.showScoreBoard(), is("3, 2, /, 12"));
    }
}
