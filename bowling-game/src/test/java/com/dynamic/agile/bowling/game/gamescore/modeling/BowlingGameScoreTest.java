package com.dynamic.agile.bowling.game.gamescore.modeling;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static com.dynamic.agile.bowling.game.gamescore.modeling.Frame.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/15 7:34
 * @description:
 */
public class BowlingGameScoreTest extends BowlingGameTest {

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
        rollMany(20, 1);
        assertThat(game.getGameScore(), is(20));
    }

    @Test
    public void rollOneSpareButNoNextRoll_gameScore0() {
        rollSpare(5, 5);
        assertThat(game.getGameScore(), is(0));
    }

    @Test
    public void rollOneSpare() {
        rollSpare(5, 5);
        roll(6);
        assertThat(game.getGameScore(), is(10 + 6));
    }

    @Test
    public void rollTwoSpares() {
        rollSpare(5, 5);
        rollSpare(6, 4);
        assertThat(game.getGameScore(), is(10 + 6));
    }

    @Test
    public void rollTwoSparesWithNextRoll() {
        rollSpare(5, 5);
        rollSpare(6, 4);
        roll(3);
        assertThat(game.getGameScore(), is(16 + 13));
    }

    @Test
    public void rollSpareInLastFrame() {
        rollMany(18, 0);
        rollSpare(5, 5);
        assertThat(game.getGameScore(), is(0));
    }

    @Test
    public void rollSpareInLastFrame_hasNextRoll() {
        rollMany(18, 0);
        rollSpare(5, 5);
        roll(7);
        assertThat(game.getGameScore(), is(17));
    }

    @Test
    public void rollStrike_noNextRoll() {
        rollStrike();
        assertThat(game.getGameScore(), is(0));
    }

    @Test
    public void rollStrike_oneNextRoll() {
        rollStrike();
        roll(4);
        assertThat(game.getGameScore(), is(0));
    }

    @Test
    public void rollStrike_twoNextRoll() {
        rollStrike();
        rollFrame(4, 5);
        assertThat(game.getGameScore(), is(28));
    }

    @Test
    public void rollOneStrikeAndOneSpare() {
        rollStrike();
        rollSpare(5, 5);
        assertThat(game.getGameScore(), is(20));
    }

    @Test
    public void rollTwoStrikes() {
        rollStrike();
        rollStrike();
        assertThat(game.getGameScore(), is(0));
    }

    @Test
    public void roll3Strikes() {
        rollStrike();
        rollStrike();
        rollStrike();
        assertThat(game.getGameScore(), is(30));
    }

    @Test
    public void rollAllStrikes() {
        rollMany(12, 10);
        assertThat(game.getGameScore(), is(300));
    }

    @Test
    public void complexRolls_score() {
        rollFrame(2, 3);
        rollFrame(7, 0);
        rollSpare(5, 5);
        rollSpare(6, 4);
        rollFrame(5, 4);
        rollStrike();
        rollStrike();
        rollFrame(3, 6);
        rollStrike();
        rollSpare(6, 4);
        rollExtra(4);
        assertThat(game.getGameScore(), is(137));
    }
}
