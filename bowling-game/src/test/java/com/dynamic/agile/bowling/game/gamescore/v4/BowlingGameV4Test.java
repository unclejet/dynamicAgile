package com.dynamic.agile.bowling.game.gamescore.v4;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author: UncleJet
 * @date: Created in 2020/11/12 17:01
 * @description:
 */
public class BowlingGameV4Test {
    private BowlingGameV4 game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGameV4();
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            roll(pins);
        }
    }

    private void roll(int pins) {
        game.roll(pins);
    }

    private void rollFrame(int firstPins, int secondPins) {
        roll(firstPins);
        roll(secondPins);
    }

    private void rollStrike() {
        roll(10);
    }

    @Test
    public void roll0For20_0(){
        rollMany(20,0);
        assertThat(game.score(),is(0));
    }

    @Test
    public void roll1For20_20(){
        rollMany(20,1);
        assertThat(game.score(),is(20));
    }

    @Test
    public void roll2For20_40(){
        rollMany(20,2);
        assertThat(game.score(),is(40));
    }
    @Test
    public void roll551For18_29(){
        rollFrame(5,5);
        rollMany(18,1);
        assertThat(game.score(),is(29));
    }
    @Test
    public void roll5555551For14_29(){
        rollFrame(5,5);
        rollFrame(5,5);
        rollFrame(5,5);
        rollMany(14,1);
        assertThat(game.score(),is(15+15+11+14));
    }
    @Test
    public void roll55551For14554_29(){
        rollFrame(5,5);
        rollFrame(5,5);
        rollMany(14,1);
        rollFrame(5,5);
        roll(4);
        assertThat(game.score(),is(15+11+14+14));
    }

    @Test
    public void rollStrike1For18_30(){
        rollStrike();
        rollMany(18,1);
        assertThat(game.score(),is(12+18));
    }

    @Test
    public void roll2Strikes2For16_30(){
        rollStrike();
        rollStrike();
        rollMany(16,2);
        assertThat(game.score(),is(22+14+32));
    }
    @Test
    public void roll12Strikes_300(){
        rollMany(12,10);
        assertThat(game.score(),is(300));
    }
}
