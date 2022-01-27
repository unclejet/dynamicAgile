package com.dynamic.agile.bubblesort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/1/27 上午8:37
 * @description：
 */
public class SortTest {
    @Test
    public void sortings() {
        assertSorted(intList(), Arrays.asList());
        assertSorted(intList(1), Arrays.asList(1));
        assertSorted(intList(2, 1), Arrays.asList(1, 2));
        assertSorted(intList(1, 3, 2), Arrays.asList(1, 2, 3));
    }

    private void assertSorted(List<Integer> unsorted, List<Integer> sorted) {
        assertThat(sort(unsorted), is(sorted));
    }

    private List<Integer> sort(List<Integer> asList) {
        for (int index = 0; asList.size() > index + 1; index++) {
            if (outOfOrder(asList, index))
                swap(asList, index);
        }
        return asList;
    }

    private boolean outOfOrder(List<Integer> asList, int index) {
        return asList.get(index) > asList.get(index + 1);
    }

    private void swap(List<Integer> asList, int index) {
        Integer temp = asList.get(index);
        asList.set(index, asList.get(index + 1));
        asList.set(index + 1, temp);
    }

    private List<Integer> intList(Integer... ints) {
        return Arrays.asList(ints);
    }
}
