package com.dynamic.agile.wordwrap.get_unstuck.v1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/7/1 上午8:48
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
        assertThat(wrap("x x", 1), is("x\nx"));
        assertThat(wrap("x xx", 3), is("x\nxx"));
        assertThat(wrap("x x", 3), is("x x"));
        assertThat(wrap("four score and seven years ago our fathers brought forth upon this continent", 7),
                is("four\nscore\nand\nseven\nyears\nago our\nfathers\nbrought\nforth\nupon\nthis\ncontine\nnt"));
    }

    private String wrap(String s, int width) {
        if (s == null)
            return "";
        if (s.length() <= width)
            return s;
        else {
            int breakpoint = s.lastIndexOf(" ", width);
            if (breakpoint == -1)
                breakpoint = width;
            return s.substring(0, breakpoint) + "\n" + wrap(s.substring(breakpoint).trim(), width);
        }
    }
}
