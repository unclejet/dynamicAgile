package com.dynamic.agile.bubblesort.dap.v2;

import org.junit.Test;

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
        assertSorted(intList(), intList());
        assertSorted(intList(1), intList(1));
        assertSorted(intList(1, 2), intList(1, 2));
        assertSorted(intList(2, 1), intList(1, 2));
        assertSorted(intList(2, 1, 3), intList(1, 2, 3));
        assertSorted(intList(1, 2, 3), intList(1, 2, 3));
        assertSorted(intList(1, 3, 2), intList(1, 2, 3));
    }

    private List<Integer> sort(List<Integer> asList) {
        for (int index = 0; asList.size() > index + 1; index++)
            extracted(asList, index);
        return asList;
    }

    private void extracted(List<Integer> asList, int index) {
        if (outOfOrder(asList, index)) {
            swap(asList, index);
        }
    }

    private boolean outOfOrder(List<Integer> asList, int index) {
        return asList.get(index) > asList.get(index + 1);
    }

    private void swap(List<Integer> asList, int index) {
        Integer temp = asList.get(index);
        asList.set(index, asList.get(index + 1));
        asList.set(index + 1, temp);
    }

    private void assertSorted(List<Integer> unsorted, List<Integer> sorted) {
        assertThat(sort(unsorted), is(sorted));
    }

    private List<Integer> intList(Integer... ints) {
        return Arrays.asList(ints);
    }
}
