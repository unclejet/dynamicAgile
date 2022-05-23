package com.uj.study;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/5/23 下午12:24
 * @description：
 */
public class PrimeFactorsTest {
    @Test
    public void canFactorIntoPrimes() {
        Assert.assertEquals(list(), of(1));
    }

    private List<Integer> of(int n) {
        return new ArrayList<>();
    }

    private List<Integer> list() {
        return Arrays.asList();
    }
}
