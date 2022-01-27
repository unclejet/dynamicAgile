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
        assertSorted(intList(2, 1, 3), Arrays.asList(1, 2, 3));
        assertSorted(intList(2, 3, 1), Arrays.asList(1, 2, 3));

        assertSorted(intList(1, 3, 2), Arrays.asList(1, 2, 3));
        assertSorted(intList(3, 2, 1), Arrays.asList(1, 2, 3));
        assertSorted(intList(3, 2, 2, 1), Arrays.asList(1, 2, 2, 3));
        sortBigList(100000 * 5);
    }

    private List<Integer> sort(List<Integer> asList) {
        List<Integer> sorted = new ArrayList<>();
        if (asList.size() == 0)
            return asList;

        List<Integer> l = new ArrayList<>();
        Integer m = asList.get(0);
        List<Integer> h = new ArrayList<>();
        for (int i : asList.subList(1, asList.size())) { //asList from 0 index will cause stack overflow
            if (i > m)
                h.add(i);
            else
                l.add(i);
        }
        sorted.addAll(sort(l));
        sorted.add(m);
        sorted.addAll(sort(h));

        return sorted;
    }

    private void sortBigList(int n) {
        List<Integer> unsorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            unsorted.add((int) (Math.random() * 10000.0));
        }
        List<Integer> sorted = sort(unsorted);
        for (int i = 0; i < n - 1; i++)
            assertThat(sorted.get(i) <= sorted.get(i + 1), is(true));
    }

    private void assertSorted(List<Integer> unsorted, List<Integer> sorted) {
        assertThat(sort(unsorted), is(sorted));
    }

    private List<Integer> intList(Integer... ints) {
        return Arrays.asList(ints);
    }
}
