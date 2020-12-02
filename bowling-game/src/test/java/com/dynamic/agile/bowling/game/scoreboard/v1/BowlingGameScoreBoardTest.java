package com.dynamic.agile.bowling.game.scoreboard.v1;

import org.junit.Ignore;
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

    @Test
    public void frame4roll6() {
        rollMiss(2, 3);
        rollMiss(7, 0);
        rollSpare(5, 5);
        roll(6);
        assertThat(game.showScoreBoard(), is("4, 1, 6, 28"));
    }

    @Test
    public void frame4rollSpare() {
        rollMiss(2, 3);
        rollMiss(7, 0);
        rollSpare(5, 5);
        rollSpare(6, 4);
        assertThat(game.showScoreBoard(), is("4, 2, /, 28"));
    }

    @Test
    public void frame5roll5() {
        rollMiss(2, 3);
        rollMiss(7, 0);
        rollSpare(5, 5);
        rollSpare(6, 4);
        roll(5);
        assertThat(game.showScoreBoard(), is("5, 1, 5, 43"));
    }

    @Test
    public void frame5rollMiss() {
        rollMiss(2, 3);
        rollMiss(7, 0);
        rollSpare(5, 5);
        rollSpare(6, 4);
        rollMiss(5, 4);
        assertThat(game.showScoreBoard(), is("5, 2, 9, 52"));
    }

    @Test
    public void frame6rollStrike() {
        rollMiss(2, 3);
        rollMiss(7, 0);
        rollSpare(5, 5);
        rollSpare(6, 4);
        rollMiss(5, 4);
        rollStrike();
        assertThat(game.showScoreBoard(), is("6, 1, x, 52"));
    }

    @Test
    public void frame7rollStrike() {
        rollMiss(2, 3);
        rollMiss(7, 0);
        rollSpare(5, 5);
        rollSpare(6, 4);
        rollMiss(5, 4);
        rollStrike();
        rollStrike();
        assertThat(game.showScoreBoard(), is("7, 1, x, 52"));
    }

    @Test
    public void frame8roll3() {
        rollMiss(2, 3);
        rollMiss(7, 0);
        rollSpare(5, 5);
        rollSpare(6, 4);
        rollMiss(5, 4);
        rollStrike();
        rollStrike();
        roll(3);
        assertThat(game.showScoreBoard(), is("8, 1, 3, 75"));
    }

    @Test
    public void frame8rollMiss() {
        rollMiss(2, 3);
        rollMiss(7, 0);
        rollSpare(5, 5);
        rollSpare(6, 4);
        rollMiss(5, 4);
        rollStrike();
        rollStrike();
        rollMiss(3, 6);
        assertThat(game.showScoreBoard(), is("8, 2, 9, 103"));
    }

    @Test
    public void frame9rollStrike() {
        rollMiss(2, 3);
        rollMiss(7, 0);
        rollSpare(5, 5);
        rollSpare(6, 4);
        rollMiss(5, 4);
        rollStrike();
        rollStrike();
        rollMiss(3, 6);
        rollStrike();
        assertThat(game.showScoreBoard(), is("9, 1, x, 103"));
    }

    @Test
    public void frame10roll6() {
        rollMiss(2, 3);
        rollMiss(7, 0);
        rollSpare(5, 5);
        rollSpare(6, 4);
        rollMiss(5, 4);
        rollStrike();
        rollStrike();
        rollMiss(3, 6);
        rollStrike();
        roll(6);
        assertThat(game.showScoreBoard(), is("10, 1, 6, 103"));
    }

    @Test
    public void frame10rollSpare() {
        rollMiss(2, 3);
        rollMiss(7, 0);
        rollSpare(5, 5);
        rollSpare(6, 4);
        rollMiss(5, 4);
        rollStrike();
        rollStrike();
        rollMiss(3, 6);
        rollStrike();
        rollSpare(6, 4);
        assertThat(game.showScoreBoard(), is("10, 2, /, 123"));
    }


}
