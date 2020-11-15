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
        assert firstRollPins + secondRollPins < PINS_IN_FRAME;
        roll(firstRollPins);
        roll(secondRollPins);
    }

    private void rollSpare(int firstRollPins, int secondRollPins) {
        assert firstRollPins + secondRollPins == PINS_IN_FRAME;
        roll(firstRollPins);
        roll(secondRollPins);
    }

    private void rollStrike() {
        roll(10);
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            roll(pins);
        }
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


}
