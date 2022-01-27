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
        if (asList.size() > 1) {
            if (asList.get(0) > asList.get(1)) {
                Integer temp = asList.get(0);
                asList.set(0, asList.get(1));
                asList.set(1, temp);
            }
            if (asList.size() > 2) {
                if (asList.get(1) > asList.get(2)) {
                    Integer temp = asList.get(1);
                    asList.set(1, asList.get(2));
                    asList.set(2, temp);
                }
            }
        }
        return asList;
    }

    private List<Integer> intList(Integer... ints) {
        return Arrays.asList(ints);
    }
}
