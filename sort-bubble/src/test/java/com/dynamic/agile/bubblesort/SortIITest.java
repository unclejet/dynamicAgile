package com.dynamic.agile.bubblesort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/1/27 上午11:32
 * @description：
 */
public class SortIITest {
    @Test
    public void sortings() {
        assertSorted(intList(), Arrays.asList());
        assertSorted(intList(1), Arrays.asList(1));
        assertSorted(intList(2, 1), Arrays.asList(1, 2));
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

    private void assertSorted(List<Integer> unsorted, List<Integer> sorted) {
        assertThat(sort(unsorted), is(sorted));
    }

    private List<Integer> sort(List<Integer> asList) {
        return asList;
    }

    private List<Integer> intList(Integer... ints) {
        return Arrays.asList(ints);
    }
}
