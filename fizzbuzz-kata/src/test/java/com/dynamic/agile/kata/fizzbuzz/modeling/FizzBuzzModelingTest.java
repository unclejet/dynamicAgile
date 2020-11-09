package com.dynamic.agile.kata.fizzbuzz.modeling;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
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
        assertThat(FizzBuzzModeling.getFizzBuzz("6"), contains("1", "2", "fizz", "4", "buzz", "fizz"));
        assertThat(FizzBuzzModeling.getFizzBuzz("7"), contains("1", "2", "fizz", "4", "buzz", "fizz", "7"));
        assertThat(FizzBuzzModeling.getFizzBuzz("15"), contains("1","2","fizz","4","buzz","fizz","7","8","fizz","buzz","11","fizz","13","14","fizzbuzz"));
    }

    @Test
    public void whenUserInputInvalidCharacter_thenGetEmpty() {
        assertThat(FizzBuzzModeling.getFizzBuzz("0"), empty());
        assertThat(FizzBuzzModeling.getFizzBuzz("a"), empty());
        assertThat(FizzBuzzModeling.getFizzBuzz("3.14159"), empty());
        assertThat(FizzBuzzModeling.getFizzBuzz("\t"), empty());
        assertThat(FizzBuzzModeling.getFizzBuzz("1001"), empty());
    }
}
