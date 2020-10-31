package com.dynamic.agile.kata.fizzbuzz;

import org.junit.Test;

import static com.dynamic.agile.kata.fizzbuzz.FizzBuzz.fizzBuzzList;
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
    }
}
