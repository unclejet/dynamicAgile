package com.dynamic.agile.wordwrap.get_unstuck;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/9/9 上午11:56
 * Episode 19 ATDD-part2
 * @description：
 */
public class WrapperTest {
    @Test
    public void shouldWrap() {
        assertThat(wrap(null, 1), is(""));
        assertThat(wrap("", 1), is(""));
        assertThat(wrap("x", 1), is("x"));
        assertThat(wrap("xx", 1), is("x\nx"));
        assertThat(wrap("xxx", 1), is("x\nx\nx")); //找到高频互动行为，让其反复发生
        assertThat(wrap("x x", 1), is("x\nx"));
        assertThat(wrap("x xx", 3), is("x\nxx"));
        assertThat(wrap("x x", 3), is("x\nx"));
        assertThat(wrap("four score and seven years ago our fathers brought forth upon this continent", 7),
                is("four\nscore\nand\nseven\nyears\nago\nour\nfathers\nbrought\nforth\nupon\nthis\ncontine\nnt"));
    }

    private String wrap(String s, int width) {
        if (s == null)
            return "";
        if (s.length() <= width) {
            return s.replaceAll(" ", "\n");
        } else {
            int breakPoint = s.lastIndexOf(" ", width);
            if (breakPoint == -1) {
                breakPoint = width;
            }
            return s.substring(0, breakPoint).replaceAll(" ", "\n") + "\n" + wrap(s.substring(breakPoint).trim(), width); //代码是业务的抽象，业务的重复发生必然在代码上显现
        }
    }
}
