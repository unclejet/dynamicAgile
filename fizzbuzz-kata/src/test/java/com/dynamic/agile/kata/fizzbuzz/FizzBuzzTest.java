package com.dynamic.agile.kata.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author Uncle Jet(韩金田)
 * @date 10/27/2020 5:35 AM
 */
public class FizzBuzzTest {
    @Test
    public void fizzBuzzSystem_exist() {
        FizzBuzz fizzBuzz = null;
        assertThat(fizzBuzz, notNullValue());
    }
}
