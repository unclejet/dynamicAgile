package com.dynamic.agile.kata.fizzbuzz.modeling;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
/**
 * @author ：unclejet
 * @date ：Created in 2020/11/4 6:13
 * @description：
 * @modified By：
 * @version:
 */
public class FizzBuzzModelingTest {
    @Test
    public void whenUserInputAnumber_thenGetFizzbuzz() {
        assertThat(FizzBuzzModeling.getFizzBuzz("1"), contains("1"));
        assertThat(FizzBuzzModeling.getFizzBuzz("2"), contains("1", "2"));
        assertThat(FizzBuzzModeling.getFizzBuzz("3"), contains("1", "2", "fizz"));
        assertThat(FizzBuzzModeling.getFizzBuzz("4"), contains("1", "2", "fizz", "4"));
        assertThat(FizzBuzzModeling.getFizzBuzz("5"), contains("1", "2", "fizz", "4", "buzz"));
    }
}