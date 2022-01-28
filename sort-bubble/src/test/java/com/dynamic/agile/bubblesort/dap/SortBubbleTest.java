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
        assertSorted(intList(2, 1), intList(1, 2));
    }

    private List<Integer> sort(List<Integer> asList) {
        if (asList.size() == 2) {
            if (asList.get(0) > asList.get(1)) {
                Integer temp = asList.get(1);
                asList.set(1, asList.get(0));
                asList.set(0, temp);
            }
        }
        return asList;
    }

    private void assertSorted(List<Integer> unsorted, List<Integer> sorted) {
        assertThat(sort(unsorted), is(sorted));
    }

    private List<Integer> intList(Integer ... ints) {
        return Arrays.asList(ints);
    }
}
