package com.dynamic.agile.wordwrap.get_stuck;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/9/8 下午12:20
 * @description：
 */
public class WrapperTest {
    @Test
    public void shouldWrap() {
        assertThat(wrap("word word", 4), is("word\nword"));
    }

    private String wrap(String s, int width) {
        return null;
    }
}
