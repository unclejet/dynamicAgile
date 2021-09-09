package com.dynamic.agile.wordwrap.jetv1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/9/9 上午11:57
 * @description：
 */
public class WrapperTest {
    @Test
    public void shouldWrap() {
        assertThat(wrap("x", 1), is("x"));
        assertThat(wrap("xx", 2), is("xx"));
        assertThat(wrap("xx", 1), is("x\nx"));
        assertThat(wrap("xxx", 1), is("x\nx\nx"));
        assertThat(wrap("x ", 1), is("x"));
    }

    private String wrap(String s, int width) {
        if (s.length() <= width)
            return s.trim();
        return (s.substring(0, width) + "\n" + wrap(s.substring(width), width)).trim();
    }
}
