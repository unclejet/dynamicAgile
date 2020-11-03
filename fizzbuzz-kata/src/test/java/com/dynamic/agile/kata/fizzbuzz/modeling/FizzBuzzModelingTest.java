package com.dynamic.agile.kata.fizzbuzz.modeling;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
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
    public void whenUserInput1_thenGet1() {
        FizzBuzzModeling fizzBuzzModeling = new FizzBuzzModeling();
        assertThat(fizzBuzzModeling.getFizzBuzz("1"), contains("1"));
    }

    @Test
    public void whenUserInput2_thenGet1And2() {
        FizzBuzzModeling fizzBuzzModeling = new FizzBuzzModeling();
        assertThat(fizzBuzzModeling.getFizzBuzz("2"), contains("1", "2"));
    }
}
