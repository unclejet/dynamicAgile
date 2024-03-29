package com.dynamic.agile.bubblesort.dap.v1;

import org.junit.Test;

import java.util.ArrayList;
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
        assertSorted(intList(1, 3, 2), intList(1, 2, 3));
        assertSorted(intList(3, 2, 1), intList(1, 2, 3));
        assertSorted(intList(3, 2, 2, 1), intList(1, 2, 2, 3));
        sortBigList(1000);
    }

    //assign, split flow, constant to variable, if to while,while to for
    private List<Integer> sort(List<Integer> asList) {
        if (asList.size() <= 1)
            return asList;
        for (int size = asList.size(); size > 0; size--)
            for (int index = 0; index < size - 1; index++)
                if (outOfOrder(asList, index))
                    swap(asList, index);
        return asList;
    }

    private void sortBigList(int n) {
        List<Integer> unsorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            unsorted.add((int)(Math.random() * 10000.0));
        }
        List<Integer> sorted = sort(unsorted);
        for (int i = 0; i < n - 1; i++)
            assertThat(sorted.get(i) <= sorted.get(i + 1), is(true));
    }

    private boolean outOfOrder(List<Integer> asList, int index) {
        return asList.get(index) > asList.get(index + 1);
    }

    private void swap(List<Integer> asList, int index) {
        Integer temp = asList.get(index + 1);
        asList.set(index + 1, asList.get(index));
        asList.set(index, temp);
    }

    private void assertSorted(List<Integer> unsorted, List<Integer> sorted) {
        assertThat(sort(unsorted), is(sorted));
    }

    private List<Integer> intList(Integer... ints) {
        return Arrays.asList(ints);
    }
}
