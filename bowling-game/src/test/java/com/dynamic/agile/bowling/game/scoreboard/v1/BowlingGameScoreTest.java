package com.dynamic.agile.bowling.game.scoreboard.v1;

import com.dynamic.agile.bowling.game.gamescore.vjet8.Frame;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/19 14:37
 * @description:
 */
public class BowlingGameScoreTest extends BowlingGameBaseTest {

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

    @Test
    public void rollMissAndNextRoll() {
        rollMiss(3, 2);
        roll(4);
        assertThat(game.score(), is(5));
    }

    @Test
    public void rollTwoMiss() {
        rollMiss(3, 2);
        rollMiss(4, 5);
        assertThat(game.score(), is(5 + 9));
    }

    @Test
    public void rollAllMiss() {
        rollMany(20, 1);
        assertThat(game.score(), is(20));
    }

    @Test
    public void rollSpare() {
        rollSpare(5, 5);
        assertThat(game.score(), is(0));
    }

    @Test
    public void rollSpareAndNextRoll() {
        rollSpare(5, 5);
        roll(3);
        assertThat(game.score(), is(13));
    }

    @Test
    public void rollTwoSpare() {
        rollSpare(5, 5);
        rollSpare(3, 7);
        assertThat(game.score(), is(13));
    }

    @Test
    public void rollTwoSpareAndNextRoll() {
        rollSpare(5, 5);
        rollSpare(3, 7);
        roll(8);
        assertThat(game.score(), is(13 + 18));
    }

    @Test
    public void rollTwoSpareAndRollMiss() {
        rollSpare(5, 5);
        rollSpare(3, 7);
        rollMiss(8, 1);
        assertThat(game.score(), is(13 + 18 + 9));
    }

    @Test
    public void rollAllMissAndLastFrameRollSpare() {
        rollMany(18, 1);
        rollSpare(4, 6);
        assertThat(game.score(), is(18));
    }

    @Test
    public void rollAllMissAndLastFrameRollSpareAndNextRoll() {
        rollMany(18, 1);
        rollSpare(4, 6);
        roll(9);
        assertThat(game.score(), is(18 + 19));
    }

    @Test
    public void rollOneStrike() {
        rollStrike();
        assertThat(game.score(), is(0));
    }

    @Test
    public void rollTwoStrike() {
        rollStrike();
        rollStrike();
        assertThat(game.score(), is(0));
    }

    @Test
    public void roll3Strike() {
        rollStrike();
        rollStrike();
        rollStrike();
        assertThat(game.score(), is(30));
    }

    @Test
    public void rollAllStrike() {
        rollMany(12 , Frame.ALL_PINS_IN_FRAME);
        assertThat(game.score(), is(300));
    }

    @Test
    public void complexRolls_score() {
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
        roll(4);
        assertThat(game.score(), is(137));
    }
}
