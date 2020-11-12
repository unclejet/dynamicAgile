package com.dynamic.agile.bowling.game.v2;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static com.dynamic.agile.bowling.game.v2.Frame.ALL_HIT_PINS;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/12 9:31
 * @description:
 * @modified By:
 */
public class BowlingGameScoreTest {

    private BowlingGameScore gameScore;

    @Before
    public void setUp() throws Exception {
        gameScore = new BowlingGameScore();
    }

    private void roll(int pins) {
        gameScore.roll(pins);
    }

    private void rollFrame(int firstRollPins, int secondRollPins) {
        assert firstRollPins + secondRollPins <= 10;
        roll(firstRollPins);
        roll(secondRollPins);
    }

    private void rollSpare(int firstRollPins, int secondRollPins) {
        assert firstRollPins + secondRollPins == ALL_HIT_PINS;
        rollFrame(firstRollPins, secondRollPins);
    }

    private void rollStrike() {
        roll(10);
    }

    private void rollAll(int pins) {
        rollMany(1, 10, pins, pins);
    }

    private void rollMany(int startFrame, int endFrame, int firstRollPins, int secondRollPins) {
        IntStream.rangeClosed(startFrame, endFrame)
                .forEach(i -> {
                    rollFrame(firstRollPins, secondRollPins);
                });
    }

    @Test
    public void playerCanGetGameScore() {
        assertThat(gameScore.getScore(), is(0));
    }

    @Test
    public void rollAll0_gameScoreIs0() {
        rollAll(0);
        assertThat(gameScore.getScore(), is(0));
    }

    @Test
    public void rollAll1_gameScoreIs20() {
        rollAll(1);
        assertThat(gameScore.getScore(), is(20));
    }

    @Test
    public void rollOneSpare() {
        rollSpare(5, 5);
        rollFrame(3, 0);
        rollMany(3, 10, 0, 0);
        assertThat(gameScore.getScore(), is(16));
    }

    @Test
    public void rollTwoSpares() {
        rollSpare(5, 5);
        rollSpare(3, 7);
        rollFrame(6, 0);
        rollMany(4, 10, 0, 0);
        assertThat(gameScore.getScore(), is(35));
    }

    @Test
    public void rollLastSpares() {
        rollMany(1, 8, 0, 0);
        rollFrame(5, 1);
        rollSpare(3, 7);
        roll(6);
        assertThat(gameScore.getScore(), is(22));
    }

    @Test
    public void rollOneStrike() {
        rollStrike();
        rollFrame(2, 5);
        rollMany(3, 10, 0, 0);
        assertThat(gameScore.getScore(), is(24));
    }

    @Test
    public void rollTwoStrikes() {
        rollStrike();
        rollStrike();
        rollFrame(2, 3);
        rollMany(4, 10, 0, 0);
        assertThat(gameScore.getScore(), is(42));
    }

    @Test
    public void rollLastStrikes() {
        rollMany(1, 8, 0, 0);
        rollStrike();
        rollStrike();
        rollFrame(2, 3);
        assertThat(gameScore.getScore(), is(37));
    }

    @Test
    public void rollAllStrikes() {
        for (int i = 0; i < 12; i++) {
            rollStrike();
        }
        assertThat(gameScore.getScore(), is(300));
    }

    @Test
    public void complexRoll() {
        rollFrame(1,2);
        rollStrike();
        rollSpare(4, 6);
        rollMany(4, 10, 1, 1);
        assertThat(gameScore.getScore(), is(3 + 20 + 11 + 14));
    }
}
