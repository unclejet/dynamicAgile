package com.dynamic.agile.wordwrap.jetv2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author: UncleJet
 * @date: Created in 2021/9/19 11:05
 * @description:
 */
public class WrapperTest {
    @Test
    public void shouldWrap() {
        assertThat(wrap("", 1), is(""));
        assertThat(wrap("x", 1), is("x"));
        assertThat(wrap("xx", 1), is("x\nx"));
        assertThat(wrap("xxx", 1), is("x\nx\nx"));
        assertThat(wrap("x ", 1), is("x"));
        assertThat(wrap(" x ", 1), is("x"));
        assertThat(wrap("x x", 1), is("x\nx"));
        assertThat(wrap("x x", 3), is("x\nx"));
        assertThat(wrap("xxxx xx", 3), is("xxx\nx\nxx"));
        assertThat(wrap("x xx", 3), is("x\nxx"));
        assertThat(wrap("x x x", 1), is("x\nx\nx"));

        assertThat(wrap("four score and seven years ago our fathers brought forth upon this continent", 7),
                is("four\nscore\nand\nseven\nyears\nago\nour\nfathers\nbrought\nforth\nupon\nthis\ncontine\nnt"));
    }

    private String wrap(String s, int width) {
        s = s.trim();
        if (s.length() <= width) {
            return s.replaceAll(" ", "\n");
        }
        int breakPoint = s.lastIndexOf(" ", width);
        breakPoint = breakPoint == -1 ? width : breakPoint;
        return s.substring(0, breakPoint).replaceAll(" ", "\n") + "\n" + wrap(s.substring(breakPoint), width);
    }
}
