package com.uj.study;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/5/23 下午12:24
 * @description：
 */
public class PrimeFactorsTest {
    @Test
    public void canFactorIntoPrimes() {
        assertEquals(list(), of(1));
        assertEquals(list(2), of(2));
    }

    private List<Integer> of(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        if (n == 2) {
            factors.add(2);
        }
        return factors;
    }

    private List<Integer> list(Integer ... ints) {
        return Arrays.asList(ints);
    }
}
