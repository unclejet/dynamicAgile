package com.dynamic.agile.bubblesort.dap.v1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：unclejet
 * @date ：Created in 2022/1/29 10:53
 * @description：
 * @modified By：
 * @version:
 */
public class QuickSortTest {

    @Test
    public void sortIntegerList() {
        assertSorted(intList(), intList());
        assertSorted(intList(1), intList(1));
        assertSorted(intList(2, 1), intList(1, 2));
        assertSorted(intList(1, 2), intList(1, 2));
        assertSorted(intList(2, 1, 3), intList(1, 2, 3));
        assertSorted(intList(2, 3, 1), intList(1, 2, 3));
        assertSorted(intList(1, 2, 3), intList(1, 2, 3));
        assertSorted(intList(1, 3, 2), intList(1, 2, 3));
        assertSorted(intList(3, 2, 1), intList(1, 2, 3));
        assertSorted(intList(3, 1, 2), intList(1, 2, 3));
        assertSorted(intList(3, 2, 2, 1), intList(1, 2, 2, 3));
        sortBigList(10000);

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

    private List<Integer> sort(List<Integer> asList) {
        List<Integer> sorted = new ArrayList<>(asList.size());
        if (asList.size() == 0) {
            return asList;
        }
        List<Integer> l = new ArrayList<>();
        Integer m = asList.get(0);
        List<Integer> h = new ArrayList<>();
        for (int i : asList.subList(1, asList.size())) {
            if (i < m)
                l.add(i);
            else
                h.add(i);
        }
        if (l != null) sorted.addAll(sort(l));
        sorted.add(m);
        if (h != null) sorted.addAll(sort(h));
        return sorted;
    }

    private void assertSorted(List<Integer> unsorted, List<Integer> sorted) {
        assertThat(sort(unsorted), is(sorted));
    }

    private List<Integer> intList(Integer... ints) {
        return Arrays.asList(ints);
    }
}
