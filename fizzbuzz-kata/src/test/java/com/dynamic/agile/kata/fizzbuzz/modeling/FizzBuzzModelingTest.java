package com.dynamic.agile.kata.fizzbuzz.modeling;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
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
    public void systemGrowsEnvIsOk() {

    }

    @Test
    public void thereIsASystemExist() {
        FizzBuzzModeling fizzBuzzModeling = new FizzBuzzModeling();
        assertThat(fizzBuzzModeling, is(notNullValue()));
    }

    @Test
    public void whenUserInput1_thenGet1() {
        FizzBuzzModeling fizzBuzzModeling = new FizzBuzzModeling();
        assertThat(fizzBuzzModeling.getFizzBuzz("1"), is("1"));
    }
}
