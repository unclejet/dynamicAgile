package com.dynamic.agile.kata.fizzbuzz;

import org.junit.Test;

import static com.dynamic.agile.kata.fizzbuzz.FizzBuzz.doFizzBuzz;
import static com.dynamic.agile.kata.fizzbuzz.FizzBuzz.fizzBuzzList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author Uncle Jet(韩金田)
 * @date 10/27/2020 5:35 AM
 */
public class FizzBuzzTest {
    @Test
    public void whenUserInputNumber_thenGetFizzBuzz() {
        assertThat(fizzBuzzList("1"), contains("1"));
        assertThat(fizzBuzzList("2"), contains("1", "2"));
        assertThat(fizzBuzzList("3"), contains("1", "2", "fizz"));
        assertThat(fizzBuzzList("4"), contains("1", "2", "fizz","4"));
        assertThat(fizzBuzzList("5"), contains("1", "2", "fizz","4", "buzz"));
        assertThat(fizzBuzzList("15"), contains("1", "2", "fizz","4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz"));
    }

    @Test
    public void verifyDoFizzBuzz() {
        assertThat(doFizzBuzz(10000), is("buzz"));
        assertThat(doFizzBuzz(10002), is("fizz"));
        assertThat(doFizzBuzz(10005), is("fizzbuzz"));
    }
}
