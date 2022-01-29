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
        if (asList.size() > 1) {
            int index = 0;
            if (asList.get(index) > asList.get(index + 1)) {
                Integer temp = asList.get(index);
                asList.set(index, asList.get(index + 1));
                asList.set(index + 1, temp);
            }
            if (asList.size() > 2) {
                if (asList.get(index + 1) > asList.get(index + 2)) {
                    Integer temp = asList.get(index + 1);
                    asList.set(index + 1, asList.get(index + 2));
                    asList.set(index + 2, temp);
                }
            }
        }
        return asList;
    }

    private void assertSorted(List<Integer> unsorted, List<Integer> sorted) {
        assertThat(sort(unsorted), is(sorted));
    }

    private List<Integer> intList(Integer... ints) {
        return Arrays.asList(ints);
    }
}
