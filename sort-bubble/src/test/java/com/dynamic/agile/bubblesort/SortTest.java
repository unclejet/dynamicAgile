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
        assertThat(sort(intList()), is(Arrays.asList()));
        assertThat(sort(intList(1)), is(Arrays.asList(1)));
    }

    private List<Integer> sort(List<Integer> asList) {
        return new ArrayList<Integer>();
    }

    private List<Integer> intList(Integer ... ints) {
        return Arrays.asList(ints);
    }
}
