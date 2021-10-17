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
        assertThat(wrap("x x", 1), is("x\nx"));
        assertThat(wrap("x x x", 1), is("x\nx\nx"));
        assertThat(wrap(" x ", 1), is("x"));
        assertThat(wrap("xx xxxx xxxxxxx xx", 3), is("xx\nxxx\nx x\nxxx\nxxx\nxx"));
        assertThat(wrap("a dog with a bone", 6), is("a dog\nwith a\nbone"));

        assertThat(wrap("four score and seven years ago our fathers brought forth upon this continent", 7),
                is("four\nscore\nand\nseven\nyears\nago\nour\nfathers\nbrought\nforth\nupon\nthis\ncontine\nnt"));
    }

    private String wrap(String s, int width) {
        return s.length() <= width ? s.trim() :
                (s.substring(0, width).trim() + "\n" + wrap(s.substring(width).trim(), width)).trim();
    }
}
