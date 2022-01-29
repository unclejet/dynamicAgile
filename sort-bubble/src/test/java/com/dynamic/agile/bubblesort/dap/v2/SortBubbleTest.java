package com.dynamic.agile.bubblesort.dap.v2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：unclejet
 * @date ：Created in 2022/1/28 17:36
 * @description：
 * @modified By：
 * @version:
 */
public class SortBubbleTest {
    @Test
    public void sortIntegers() {
        assertThat(sort(Arrays.asList()), is(Arrays.asList()));
        assertThat(sort(Arrays.asList(1)), is(Arrays.asList(1)));
    }

    private List<Integer> sort(List<Integer> asList) {
        return asList;
    }
}
