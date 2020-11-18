package com.dynamic.agile.bowling.game.v7;

import com.dynamic.agile.bowling.game.v6.BowlingGameV6;
import com.dynamic.agile.bowling.game.v6.FrameV6;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author: DavidZhang33
 * @date: Created in 2020/11/18 21：26
 * @description:
 */
public class BowlingGameV7Test {
    private BowlingGameV7 game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGameV7();
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            roll(pins);
        }
    }

    private void roll(int pins) {
        game.roll(pins);
    }

    private void rollMiss(int firstPins, int secondPins) {
        assert firstPins + secondPins < 10;
        roll(firstPins);
        roll(secondPins);
    }

    private void rollSpare(int firstPins, int secondPins) {
        assert firstPins + secondPins == 10;
        roll(firstPins);
        roll(secondPins);
    }

    private void rollStrike() {
        roll(10);
    }

    @Test
    public void roll1(){
        game.roll(1);
        assertThat(game.score(),is(0));
    }

    @Test
    public void roll11(){
        rollMiss(1,1);
        assertThat(game.score(),is(2));
    }
}
