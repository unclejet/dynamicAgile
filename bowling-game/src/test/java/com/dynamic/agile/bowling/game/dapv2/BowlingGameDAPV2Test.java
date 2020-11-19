package com.dynamic.agile.bowling.game.dapv2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameDAPV2Test {
    @Test
    public void roll1() {
        BowlingGameDAPV2 game = new BowlingGameDAPV2();
        game.roll(1);
        assertEquals(0, game.score());
    }
}
