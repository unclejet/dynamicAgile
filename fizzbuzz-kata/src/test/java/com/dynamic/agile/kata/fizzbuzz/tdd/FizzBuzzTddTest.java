package com.dynamic.agile.kata.fizzbuzz.tdd;

import com.dynamic.agile.kata.fizzbuzz.FizzBuzz;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
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
    public void nothing() {

    }

    @Test
    public void createFizzBuzzObject() {
        FizzBuzzTdd fizzBuzz = new FizzBuzzTdd();
    }

    @Test
    public void whenUserInput1_thenGet1() {
        FizzBuzzTdd fizzbuzz = new FizzBuzzTdd();
        assertThat(fizzbuzz.getFizzBuzz("1"), is("1"));
    }
}
