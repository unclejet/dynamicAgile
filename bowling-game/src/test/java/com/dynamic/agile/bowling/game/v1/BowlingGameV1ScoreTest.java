package com.dynamic.agile.bowling.game.v1;

import com.dynamic.agile.bowling.game.v1.BowlingGameV1;
import com.dynamic.agile.bowling.game.v1.FrameV1;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/10 18:08
 * @description:
 * @modified By:
 */
public class BowlingGameV1ScoreTest {

    private BowlingGameV1 bowlingGame;

    @Before
    public void setUp() throws Exception {
        bowlingGame = new BowlingGameV1();
    }

    @Test
    public void whenIRollsAll0_IGetGameScore0() {
        bowlingGame.frames().forEach(frame -> {
            frame.roll(0);
            frame.roll(0);
        });
        assertThat(bowlingGame.statisticScore(), is(0));
    }

    @Test
    public void whenIRollsAll1_IGetGameScore20() {
        bowlingGame.frames().forEach(frame -> {
            frame.roll(1);
            frame.roll(1);
        });
        assertThat(bowlingGame.statisticScore(), is(20));
    }

    @Test
    public void rollOneSpare() {
        FrameV1 spareFrame = bowlingGame.getSpecialFrame(1);
        spareFrame.roll(4);
        spareFrame.roll(6);
        FrameV1 frame2 = bowlingGame.getSpecialFrame(2);
        frame2.roll(3);
        frame2.roll(0);
        bowlingGame.frames().filter(frame -> frame.getIndex() > 2).forEach(frame -> {
            frame.roll(0);
            frame.roll(0);
        });

        assertThat(bowlingGame.statisticScore(), is(16));
    }

    @Test
    public void rollTwoSpare() {
        FrameV1 spareFrame1 = bowlingGame.getSpecialFrame(1);
        spareFrame1.roll(4);
        spareFrame1.roll(6);

        FrameV1 spareFrame2 = bowlingGame.getSpecialFrame(2);
        spareFrame2.roll(5);
        spareFrame2.roll(5);

        FrameV1 frame3 = bowlingGame.getSpecialFrame(3);
        frame3.roll(3);
        frame3.roll(0);
        bowlingGame.frames().filter(frame -> frame.getIndex() > 3).forEach(frame -> {
            frame.roll(0);
            frame.roll(0);
        });

        assertThat(bowlingGame.statisticScore(), is(31));
    }

    @Test
    public void tenthFrameSpare() {
        FrameV1 spareFrame10 = bowlingGame.getSpecialFrame(10);
        spareFrame10.roll(4);
        spareFrame10.roll(6);
        spareFrame10.rollAdded(7);

        bowlingGame.frames().filter(frame -> frame.getIndex() < 10).forEach(frame -> {
            frame.roll(0);
            frame.roll(0);
        });

        assertThat(bowlingGame.statisticScore(), is(17));
    }

    @Test
    public void rollOneStrike() {
        FrameV1 strikeFrame1 = bowlingGame.getSpecialFrame(1);
        strikeFrame1.roll(10);
        FrameV1 frame2 = bowlingGame.getSpecialFrame(2);
        frame2.roll(3);
        frame2.roll(2);
        bowlingGame.frames().filter(frame -> frame.getIndex() > 2).forEach(frame -> {
            frame.roll(0);
            frame.roll(0);
        });

        assertThat(bowlingGame.statisticScore(), is(20));
    }

    @Test
    public void rollTheeStrikeContinuously() {
        FrameV1 strikeFrame1 = bowlingGame.getSpecialFrame(1);
        strikeFrame1.roll(10);
        FrameV1 strikeFrame2 = bowlingGame.getSpecialFrame(2);
        strikeFrame2.roll(10);
        FrameV1 strikeFrame3 = bowlingGame.getSpecialFrame(3);
        strikeFrame3.roll(10);
        FrameV1 frame4 = bowlingGame.getSpecialFrame(4);
        frame4.roll(3);
        frame4.roll(2);
        bowlingGame.frames().filter(frame -> frame.getIndex() > 4).forEach(frame -> {
            frame.roll(0);
            frame.roll(0);
        });

        assertThat(bowlingGame.statisticScore(), is(73));
    }

    @Test
    public void lastTwoFrameRollStrike() {
        FrameV1 spareFrame9 = bowlingGame.getSpecialFrame(9);
        spareFrame9.roll(10);
        FrameV1 spareFrame10 = bowlingGame.getSpecialFrame(10);
        spareFrame10.roll(10);
        spareFrame10.rollAdded(7);
        spareFrame10.rollAdded(1);

        bowlingGame.frames().filter(frame -> frame.getIndex() < 9).forEach(frame -> {
            frame.roll(0);
            frame.roll(0);
        });

        assertThat(bowlingGame.statisticScore(), is(45));
    }

    @Test
    public void allStrike() {
        bowlingGame.frames().forEach(frame -> frame.roll(10));
        FrameV1 frame10 = bowlingGame.getSpecialFrame(10);
        frame10.rollAdded(10);
        frame10.rollAdded(10);
        assertThat(bowlingGame.statisticScore(), is(300));
    }

    @Test
    public void complexRoll() {
        FrameV1 strikeFrame1 = bowlingGame.getSpecialFrame(1);
        strikeFrame1.roll(10);
        FrameV1 strikeFrame2 = bowlingGame.getSpecialFrame(2);
        strikeFrame2.roll(10);
        FrameV1 spareFrame3 = bowlingGame.getSpecialFrame(3);
        spareFrame3.roll(4);
        spareFrame3.roll(6);
        bowlingGame.frames().filter(frame -> frame.getIndex() > 3 && frame.getIndex() < 9).forEach(frame -> {
            frame.roll(1);
            frame.roll(1);
        });
        FrameV1 spareFrame9 = bowlingGame.getSpecialFrame(9);
        spareFrame9.roll(3);
        spareFrame9.roll(7);
        FrameV1 strikeFrame10 = bowlingGame.getSpecialFrame(10);
        strikeFrame10.roll(10);
        strikeFrame10.rollAdded(10);
        strikeFrame10.rollAdded(10);

        assertThat(bowlingGame.statisticScore(), is(115));
    }
}
