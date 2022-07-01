package com.dynamic.agile.wordwrap.get_stuck.v1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/6/27 下午12:38
 * @description：
 */
public class WrapperTest {
    @Test
    public void shouldWrap() {
        assertThat(wrap("word word", 4), is("word\nword"));
        assertThat(wrap("a dog", 5), is("a dog"));
        assertThat(wrap("a dog with a bone", 6), is("a dog\nwith a\nbone"));
    }

    private String wrap(String s, int width) {
        return s.length() > width ? s.replaceAll(" ", "\n") : s;

    }
}
