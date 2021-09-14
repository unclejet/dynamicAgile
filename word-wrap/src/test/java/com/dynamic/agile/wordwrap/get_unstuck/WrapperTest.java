package com.dynamic.agile.wordwrap.get_unstuck;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/9/9 上午11:56
 * @description：
 */
public class WrapperTest {
    @Test
    public void shouldWrap() {
        assertThat(wrap(null, 1), is(""));
        assertThat(wrap("", 1), is(""));
        assertThat(wrap("x", 1), is("x"));
        assertThat(wrap("xx", 1), is("x\nx"));
        assertThat(wrap("xxx", 1), is("x\nx\nx"));
    }

    private String wrap(String s, int width) {
        if (s == null)
            return "";
        if (s.length() <= width) {
            return s;
        } else {
            return s.substring(0, width) + "\n" + s.substring(width);
        }
    }
}
