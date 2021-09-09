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
        assertThat(wrap("", 1), is(""));
    }

    private String wrap(String s, int width) {
        return s;
    }
}
