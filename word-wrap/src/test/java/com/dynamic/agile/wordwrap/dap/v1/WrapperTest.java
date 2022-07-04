package com.dynamic.agile.wordwrap.dap.v1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/7/4 上午8:45
 * @description：
 */
public class WrapperTest {
    @Test
    public void shouldWrap() {
        assertThat(wrap("", 1), is(""));
        assertThat(wrap("x", 1), is("x"));
        assertThat(wrap("xx", 1), is("x\nx"));
        assertThat(wrap("xxx", 1), is("x\nx\nx"));
        assertThat(wrap("xxx", 4), is("xxx"));

        assertThat(wrap("x ", 1), is("x"));
        assertThat(wrap(" x", 1), is("x"));
        assertThat(wrap(" x ", 1), is("x"));
        assertThat(wrap("x x", 1), is("x\nx"));
        assertThat(wrap("x x", 3), is("x x"));
        assertThat(wrap("xxxx xx", 3), is("xxx\nx\nxx"));
        assertThat(wrap("xx xxxx", 3), is("xx\nxxx\nx"));
        assertThat(wrap("a dog with a bone", 6), is("a dog\nwith a\nbone"));
        assertThat(wrap("four score and seven years ago our fathers brought forth upon this continent", 7),
                is("four\nscore\nand\nseven\nyears\nago our\nfathers\nbrought\nforth\nupon\nthis\ncontine\nnt"));
    }

    private String wrap(String s, int width) {
        if (s.trim().length() <= width)
            return s.trim();
        int breakpoint = s.lastIndexOf(" ", width);
        breakpoint = breakpoint <=0 ? width : breakpoint;
        return s.substring(0, breakpoint) + "\n" + wrap(s.substring(breakpoint).trim(), width);
    }
}
