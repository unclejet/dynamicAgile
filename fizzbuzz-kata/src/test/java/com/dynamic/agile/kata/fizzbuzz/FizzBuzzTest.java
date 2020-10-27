package com.dynamic.agile.kata.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Uncle Jet(韩金田)
 * @date 10/27/2020 5:35 AM
 */
public class FizzBuzzTest {
    @Test
    public void whenUserInput1_thenPrint1() {
        String userInput = "1";
        FizzBuzz fizzBuzz = new FizzBuzz(userInput);
        Assert.assertArrayEquals(new String[]{"1"}, fizzBuzz.print());
    }

    @Test
    public void whenUserInput2_thenPrint1And2() {
        String userInput = "2";
        FizzBuzz fizzBuzz = new FizzBuzz(userInput);
        Assert.assertArrayEquals(new String[]{"1", "2"}, fizzBuzz.print());
    }
}
