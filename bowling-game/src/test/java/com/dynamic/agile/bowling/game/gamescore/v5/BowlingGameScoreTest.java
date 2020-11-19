package com.dynamic.agile.bowling.game.gamescore.v5;

import org.junit.Before;
import org.junit.Test;

import static com.dynamic.agile.bowling.game.gamescore.v3.modeling.FrameV3X.PINS_IN_FRAME;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/15 7:34
 * @description:
 */
public class BowlingGameScoreTest {
    protected BowlingGameV5 game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGameV5();
    }

    protected void roll(int pins) {
        game.roll(pins);
    }

    protected void rollFrame(int firstRollPins, int secondRollPins) {
        assert firstRollPins + secondRollPins < PINS_IN_FRAME;
        roll(firstRollPins);
        roll(secondRollPins);
    }

    protected void rollSpare(int firstRollPins, int secondRollPins) {
        assert firstRollPins + secondRollPins == PINS_IN_FRAME;
        roll(firstRollPins);
        roll(secondRollPins);
    }

    protected void rollStrike() {
        roll(10);
    }

    protected void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            roll(pins);
        }
    }

    protected void rollExtra(int pins) {
        roll(pins);
    }

    @Test
    public void roll1_score0() {
        roll(1);
        assertThat(game.score(), is (0));
    }

    @Test
    public void roll11() {
        rollFrame(1, 1);
        assertThat(game.score(), is (2));
    }

    @Test
    public void roll111() {
        rollFrame(1, 1);
        roll(1);
        assertThat(game.score(), is (2));
    }

    @Test
    public void rollAll1() {
        rollMany(20, 1);
        assertThat(game.score(), is (20));
    }

    @Test
    public void roll55() {
        rollSpare(5, 5);
        assertThat(game.score(), is(0));
    }

    @Test
    public void roll551() {
        rollSpare(5, 5);
        roll(1);
        assertThat(game.score(), is(11));
    }
    @Test
    public void roll5511() {
        rollSpare(5, 5);
        rollFrame(1, 1);
        assertThat(game.score(), is(13));
    }

    @Test
    public void roll555511() {
        rollSpare(5, 5);
        rollSpare(5, 5);
        rollFrame(1, 1);
        assertThat(game.score(), is(13 + 15));
    }

    @Test
    public void roll10() {
        rollStrike();
        assertThat(game.score(), is(0));
    }

    @Test
    public void roll2Strike() {
        rollStrike();
        rollStrike();
        assertThat(game.score(), is(0));
    }

    @Test
    public void roll1StrikeAnd11() {
        rollStrike();
        rollFrame(1, 1);
        assertThat(game.score(), is(14));
    }

    @Test
    public void rollAllStrikes() {
        rollMany(12, 10);
        assertThat(game.score(), is(300));
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
        assertThat(game.score(), is(137));
    }
}
