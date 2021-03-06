package com.dynamic.agile.bowling.game.gamescore.v3.modeling;

import org.junit.Test;

import static com.dynamic.agile.bowling.game.gamescore.v3.modeling.SpareFrameV3X.SPARE;
import static com.dynamic.agile.bowling.game.gamescore.v3.modeling.StrikeFrameV3X.STRIKE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author UncleJet
 * @date 11/16/2020 8:26 AM
 * @description
 */
public class BowlingGameScoreBoardTest extends BowlingGameTest {
    private void verifyScoreBoard(int frameNumber, String rollIndexOfFrame, String pinsLeft, int score) {
        assertThat(game.getScoreBoard(), is(String.format("Frame:%d;Roll:%s;Pins Left:%s;Score:%d", frameNumber, rollIndexOfFrame, pinsLeft, score)));
    }

    @Test
    public void whenGameStart_ICanSeeScoreBoard() {
        verifyScoreBoard(1, "1", "10", 0);
    }

    @Test
    public void roll7() {
        roll(7);
        verifyScoreBoard(1, "1", "3", 0);
    }

    @Test
    public void rollSpareNoNextRoll() {
        rollSpare(7, 3);
        verifyScoreBoard(1, "2", SPARE, 0);
    }

    @Test
    public void rollSpareHasNextRoll() {
        rollSpare(7, 3);
        rollStrike();
        verifyScoreBoard(2, "1", STRIKE, 20);
    }

    @Test
    public void rollSpareAndStrikeHasNextRoll() {
        rollSpare(7, 3);
        rollStrike();
        roll(4);
        verifyScoreBoard(3, "1", "6", 20);
    }

    @Test
    public void rollSpareAndStrikeHasNextTwoRolls() {
        rollSpare(7, 3);
        rollStrike();
        rollFrame(4, 5);
        verifyScoreBoard(3, "2", "1", 48);
    }

    @Test
    public void rollStrike_noNextRoll() {
        rollStrike();
        verifyScoreBoard(1, "1", STRIKE, 0);
    }

    @Test
    public void rollStrike_oneNextRoll() {
        rollStrike();
        roll(4);
        verifyScoreBoard(2, "1", "6", 0);
    }

    @Test
    public void rollStrike_twoNextRoll() {
        rollStrike();
        rollFrame(4, 5);
        verifyScoreBoard(2, "2", "1", 28);
    }

    @Test
    public void rollMiss() {
        rollFrame(4, 5);
        verifyScoreBoard(1, "2", "1", 9);
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
        roll(4);
        verifyScoreBoard(10, "added 1", SPARE, 137);
    }

    @Test
    public void rollLastStrikes() {
        rollMany(18, 0);
        rollStrike();
        rollStrike();
        rollStrike();
        verifyScoreBoard(10, "added 2", STRIKE, 30);
    }

    @Test
    public void rollLastStrike_nextTwoRolls() {
        rollMany(18, 0);
        rollStrike();
        rollFrame(4, 4);
        verifyScoreBoard(10, "added 2", STRIKE, 18);
    }
}
