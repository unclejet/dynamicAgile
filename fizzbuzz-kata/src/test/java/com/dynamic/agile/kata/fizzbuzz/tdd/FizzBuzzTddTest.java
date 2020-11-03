package com.dynamic.agile.kata.fizzbuzz.tdd;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：unclejet
 * @date ：Created in 2020/11/4 5:41
 * @description：
 * @modified By：
 * @version:
 */
public class FizzBuzzTddTest {
    @Test
    public void whenUserInputANumber_thenGetFizzbuzz() {
        assertThat(FizzBuzzTdd.getFizzBuzz("1"), contains("1"));
        assertThat(FizzBuzzTdd.getFizzBuzz("2"), contains("1", "2"));
        assertThat(FizzBuzzTdd.getFizzBuzz("3"), contains("1", "2", "fizz"));
    }
}
