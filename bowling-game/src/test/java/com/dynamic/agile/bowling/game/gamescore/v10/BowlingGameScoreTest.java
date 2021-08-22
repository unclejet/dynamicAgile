package com.dynamic.agile.bowling.game.gamescore.v10;

import org.hamcrest.core.IsNot;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;

/**
 * @author: UncleJet
 * @date: Created in 2021/8/21 17:12
 * @description:
 */
public class BowlingGameScoreTest {
    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void newGame() {
        assertPinsIsLayoutReady();
    }

    @Test
    public void roll5_score0() {
        game.roll(5);
        assertThat(game.score(), is(0));
    }

    @Test
    public void rollMiss5_4_score9() {
        rollMiss(5, 4);
        assertThat(game.score(), is(9));
    }

    @Test
    public void rollFirstMiss5_4AndLastMiss3_3AndOthersAll0() {
        rollMiss(5, 4);
        rollMany(16, 0);
        rollMiss(3, 3);
        assertThat(game.score(), is(9 + 6));
    }

    @Test
    public void rollSpare5_5thenRoll3_score13() {
        roll(5);
        assertThat(game.score(), is(0));
        roll(5);
        assertThat(game.score(), is(0));
        roll(3);
        assertThat(game.score(), is(13));
    }

    @Test
    public void rollMissAndSpareAndMissAndOthers0() {
        rollMiss(3, 4);
        rollSpare(4, 6);
        rollMiss(2, 7);
        rollMany(14, 0);
        assertThat(game.score(), is(7 + 12 + 9));
    }

    @Test
    public void rollStrikeAndMiss() {
        rollStrike();
        assertThat(game.score(), is(0));
        roll(5);
        assertThat(game.score(), is(0));
        roll(3);
        assertThat(game.score(), is(26));
    }

    @Test
    public void rollAllStrike() {
        rollMany(12 ,10);
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

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare(int pins1, int pins2) {
        assert pins1 + pins2 == 10;
        game.roll(pins1);
        game.roll(pins2);
    }

    private void roll(int pins) {
        game.roll(pins);
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }

    private void rollMiss(int pins1, int pins2) {
        assert pins1 + pins2 < 10;
        game.roll(pins1);
        game.roll(pins2);
    }

    private void assertPinsIsLayoutReady() {
        assertThat(game.getFrames(), is(not(empty())));
    }
}
