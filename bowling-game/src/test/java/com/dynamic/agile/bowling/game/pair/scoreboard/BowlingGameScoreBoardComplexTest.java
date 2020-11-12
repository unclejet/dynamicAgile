package com.dynamic.agile.bowling.game.pair.scoreboard;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author UncleJet & DavidZhang33
 * @date 11/8/2020 4:59 PM
 * @description：显示记分牌，个人打一局的
 * Frame:第几轮;Roll:第几投;Pins Left:;Score:
 *
 */
public class BowlingGameScoreBoardComplexTest {

    private BowlingGameScoreBoardComplex game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGameScoreBoardComplex();
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
    public void whenIRollAllStrike_thenScore300() {
        rollMany(12, 10);
        assertThat(game.getGameScore(), is(300));
    }

    @Test
    public void complexRolls_score() {
        rollFrame(1, 2);
        rollStrike();
        rollSpare(4, 6);
        rollMany(14, 1);
        assertThat(game.getGameScore(), is(3 + 20 + 11 + 14));
    }

    private void verifyScoreBoard(int pins, String frame, int roll, int pinsLeft, int score) {
        String expected;
        roll(pins);
        expected = String.format("Frame:%s;Roll:%d;Pins Left:%d;Score:%d", frame, roll, pinsLeft, score);
        assertThat(game.showScoreBoard(), is(expected));
    }

    @Test
    public void givenGameStart_showScoreBoard() {
        String expected = String.format("Frame:%d;Roll:%d;Pins Left:%d;Score:%d", 1, 1, 10, 0);
        assertThat(game.showScoreBoard(), is(expected));
    }

    @Test
    public void givenRollsAllMissInOneGame_showScoreBoard() {
        game.showScoreBoard();
        verifyScoreBoard(3, String.valueOf(1), 2, 7, 0);
        verifyScoreBoard(4, String.valueOf(2), 1, 10, 7);

        verifyScoreBoard(5, String.valueOf(2), 2, 5, 7);
        verifyScoreBoard(4, String.valueOf(3), 1, 10, 16);

        verifyScoreBoard(1, String.valueOf(3), 2, 9, 16);
        verifyScoreBoard(1, String.valueOf(4), 1, 10, 18);

    }

    @Test
    public void givenRollsSpareInOneGame_showScoreBoard() {
        game.showScoreBoard();
        verifyScoreBoard(3, String.valueOf(1), 2, 7, 0);
        verifyScoreBoard(4, String.valueOf(2), 1, 10, 7);

        verifyScoreBoard(5, String.valueOf(2), 2, 5, 7);
        verifyScoreBoard(5, String.valueOf(3), 1, 10, 7);

        verifyScoreBoard(6, String.valueOf(3), 2, 4, 23);
        verifyScoreBoard(4, String.valueOf(4), 1, 10, 23);

        verifyScoreBoard(3, String.valueOf(4), 2, 7, 23 + 13);
        verifyScoreBoard(4, String.valueOf(5), 1, 10, 23 + 13 + 7);

        verifyScoreBoard(0, String.valueOf(5), 2, 10, 43);
        verifyScoreBoard(0, String.valueOf(6), 1, 10, 43);

        verifyScoreBoard(0, String.valueOf(6), 2, 10, 43);
        verifyScoreBoard(0, String.valueOf(7), 1, 10, 43);
        verifyScoreBoard(0, String.valueOf(7), 2, 10, 43);
        verifyScoreBoard(0, String.valueOf(8), 1, 10, 43);
        verifyScoreBoard(0, String.valueOf(8), 2, 10, 43);
        verifyScoreBoard(0, String.valueOf(9), 1, 10, 43);
        verifyScoreBoard(0, String.valueOf(9), 2, 10, 43);
        verifyScoreBoard(0, String.valueOf(10), 1, 10, 43);

        verifyScoreBoard(6, String.valueOf(10), 2, 4, 43);
        verifyScoreBoard(4, String.valueOf(11), 1, 10, 43);
        verifyScoreBoard(4, String.valueOf(11), 2, 6, 57);
    }
    @Test
    public void givenRollsStrikeInOneGame_showScoreBoard() {
        game.showScoreBoard();
        verifyScoreBoard(3, String.valueOf(1), 2, 7, 0);
        verifyScoreBoard(4, String.valueOf(2), 1, 10, 7);

        verifyScoreBoard(10, String.valueOf(3), 1, 10, 7);

        verifyScoreBoard(5, String.valueOf(3), 2, 5, 7);
        verifyScoreBoard(3, String.valueOf(4), 1, 10, 33);

        verifyScoreBoard(10, String.valueOf(5), 1, 10, 33);

        verifyScoreBoard(5, String.valueOf(5), 2, 5, 33);
        verifyScoreBoard(3, String.valueOf(6), 1, 10, 59);

        verifyScoreBoard(10, String.valueOf(7), 1, 10, 59);

        verifyScoreBoard(10, String.valueOf(8), 1, 10, 59);

        verifyScoreBoard(10, String.valueOf(9), 1, 10, 89);

        verifyScoreBoard(10, String.valueOf(10), 1, 10, 119);

        verifyScoreBoard(10, String.valueOf(11), 1, 10, 149);
        verifyScoreBoard(10, String.valueOf(12), 1, 10, 179);
        verifyScoreBoard(10, String.valueOf(13), 1, 10, 209);
    }
}
