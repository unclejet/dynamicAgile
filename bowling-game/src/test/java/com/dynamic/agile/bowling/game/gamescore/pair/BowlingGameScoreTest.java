package com.dynamic.agile.bowling.game.gamescore.pair;

import com.dynamic.agile.bowling.game.gamescore.pair.BowlingGameScore;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author UncleJet & DavidZhang33
 * @date 11/8/2020 4:59 PM
 *
 */
public class BowlingGameScoreTest {

    private BowlingGameScore game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGameScore();
    }

    private void roll(int pins) {
        game.roll(pins);
    }

    private void rollMany(int rollTimes, int pins) {
        for (int i = 0; i < rollTimes; i++) {
            roll(pins);
        }
    }

    private void rollFrame(int firstPins, int secondPins) {
        roll(firstPins);
        roll(secondPins);
    }

    private void rollSpare(int firstRollPins, int secondRollPins) {
        rollFrame(firstRollPins, secondRollPins);
    }

    private void rollStrike() {
        roll(10);
    }

    @Test
    public void whenIRoll0InOneGame_thenIHaveGameScore0() {
        rollMany(20, 0);
        assertThat(game.getGameScore(), is(0));
    }

    @Test
    public void whenIRoll1InOneGame_thenIHaveGameScore20() {
        rollMany(20, 1);
        assertThat(game.getGameScore(), is(20));
    }

    @Test
    public void whenIRollOneSpareInOneGame_thenIHaveGameScore22() {
        rollSpare(4, 6);
        rollFrame(6, 0);
        rollMany(16, 0);
        assertThat(game.getGameScore(), is(22));
    }

    @Test
    public void whenIRollOneStrikeInOneGame_thenIHaveGameScore22() {
        rollStrike();
        rollFrame(6, 0);
        rollMany(16, 0);
        assertThat(game.getGameScore(), is(22));
    }

    @Test
    public void whenIRollAllStrike_thenGameScore300() {
        rollMany(12, 10);
        assertThat(game.getGameScore(), is(300));
    }

    @Test
    public void complexRolls_gameScore() {
        rollFrame(1,2);
        rollStrike();
        rollSpare(4, 6);
        rollMany(14, 1);
        assertThat(game.getGameScore(), is(3 + 20 + 11 + 14));
    }

    @Test
    public void roll5_getScore0() {
        roll(5);
        assertThat(game.getScore(), is(0));
    }

    @Test
    public void roll5And4_getScore9() {
        rollFrame(5, 4);
        assertThat(game.getScore(), is(9));
    }
    @Test
    public void roll5And4And5_getScore9() {
        rollFrame(5, 4);
        roll(5);
        assertThat(game.getScore(), is(9));
    }
    @Test
    public void roll3Balls_getScore9() {
        rollFrame(5, 4);
        rollFrame(5, 4);
        rollFrame(5, 4);
        rollFrame(5, 4);
        roll(5);
        assertThat(game.getScore(), is(36));
    }

    @Test
    public void rollSpare() {
        rollSpare(5, 5);
        assertThat(game.getScore(), is(0));
    }

    @Test
    public void rollSpareAndNextRoll() {
        rollSpare(5, 5);
        roll(3);
        assertThat(game.getScore(), is(13));
    }

    @Test
    public void rollSomeSpares() {
        rollSpare(5, 5);
        rollSpare(3, 7);
        roll(3);
        assertThat(game.getScore(), is(13 + 13));
    }

    @Test
    public void rollMissAndSpares() {
        rollMany(18, 1);
        rollSpare(5, 5);
        roll(3);
        assertThat(game.getScore(), is(18 + 13));
    }

    @Test
    public void rollOneStrike() {
        rollStrike();
        assertThat(game.getScore(), is(0));
    }
    @Test
    public void rollStrikes() {
        rollFrame(3, 4);
        rollStrike();
        rollFrame(3, 4);
        roll(5);
        assertThat(game.getScore(), is(7 + 17 + 7));
    }
    @Test
    public void roll2Strikes() {
        rollFrame(3, 4);
        rollStrike();
        rollStrike();
        rollFrame(3, 4);
        roll(5);
        assertThat(game.getScore(), is(7 + 23 + 17 + 7));
    }

    @Test
    public void rollAllStrikes() {
        rollMany(12, 10);
        assertThat(game.getScore(), is(300));
    }

    @Test
    public void complexRolls() {
        rollFrame(1,2);
        rollStrike();
        rollSpare(4, 6);
        rollMany(14, 1);
        assertThat(game.getScore(), is(3 + 20 + 11 + 14));
    }

    @Test
    public void ICanSeeScoreBoard() {

    }
}
