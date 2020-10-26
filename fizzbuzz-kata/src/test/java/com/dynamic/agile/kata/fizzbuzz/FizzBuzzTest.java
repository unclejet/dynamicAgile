package com.dynamic.agile.kata.fizzbuzz;

import javafx.scene.web.HTMLEditor;
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
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertThat(fizzBuzz, notNullValue());
    }

    @Test
    public void whenUserInput1_thenPrint1() {
        String userInput = "1";
        FizzBuzz fizzBuzz = new FizzBuzz(userInput);
        assertThat(fizzBuzz.print(), is("1"));
    }
}
