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
        assertSorted(intList(), intList());
        assertSorted(intList(1), intList(1));
    }

    private void assertSorted(List<Integer> unsorted, List<Integer> sorted) {
        assertThat(sort(unsorted), is(sorted));
    }

    private List<Integer> intList(Integer ... ints) {
        return Arrays.asList(ints);
    }

    private List<Integer> sort(List<Integer> asList) {
        return asList;
    }
}
