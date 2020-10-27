package com.dynamic.agile.kata.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Uncle Jet(韩金田)
 * @date 10/27/2020 5:35 AM
 */
public class FizzBuzzTest {
    @Test
    public void whenUserInputNumber_thenGetFizzBuzz() {
        Assert.assertEquals(Arrays.asList("1"), FizzBuzz.doFizzBuzz("1"));
        Assert.assertEquals(Arrays.asList("1", "2"), FizzBuzz.doFizzBuzz("2"));
        Assert.assertEquals(Arrays.asList("1", "2","fizz"), FizzBuzz.doFizzBuzz("3"));
    }
}
