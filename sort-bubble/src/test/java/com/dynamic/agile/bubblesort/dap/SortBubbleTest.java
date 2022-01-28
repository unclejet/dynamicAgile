package com.dynamic.agile.bubblesort.dap;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：unclejet
 * @date ：Created in 2022/1/28 11:20
 * @description：
 * @modified By：
 * @version:
 */
public class SortBubbleTest {
    @Test
    public void sortIntegerList() {
        assertThat(sort(Arrays.asList()), is(Arrays.asList()));
    }

    private List<Integer> sort(List<Integer> asList) {
        return asList;
    }
}
