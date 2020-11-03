package com.dynamic.agile.kata.fizzbuzz.tdd;

import org.junit.Test;

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
    public void whenUserInputANumber_thenGetFizzbuzz() {
        assertThat(FizzBuzzTdd.getFizzBuzz("1"), contains("1"));
        assertThat(FizzBuzzTdd.getFizzBuzz("2"), contains("1", "2"));
        assertThat(FizzBuzzTdd.getFizzBuzz("3"), contains("1", "2", "fizz"));
        assertThat(FizzBuzzTdd.getFizzBuzz("4"), contains("1", "2", "fizz", "4"));
        assertThat(FizzBuzzTdd.getFizzBuzz("5"), contains("1", "2", "fizz", "4", "buzz"));
        assertThat(FizzBuzzTdd.getFizzBuzz("6"), contains("1", "2", "fizz", "4", "buzz", "fizz"));
        assertThat(FizzBuzzTdd.getFizzBuzz("7"), contains("1", "2", "fizz", "4", "buzz", "fizz", "7"));
        assertThat(FizzBuzzTdd.getFizzBuzz("100"), contains("1","2","fizz","4","buzz","fizz","7","8","fizz","buzz","11","fizz","13","14","fizzbuzz","16","17","fizz","19","buzz","fizz","22","23","fizz","buzz","26","fizz","28","29","fizzbuzz","31","32","fizz","34","buzz","fizz","37","38","fizz","buzz","41","fizz","43","44","fizzbuzz","46","47","fizz","49","buzz","fizz","52","53","fizz","buzz","56","fizz","58","59","fizzbuzz","61","62","fizz","64","buzz","fizz","67","68","fizz","buzz","71","fizz","73","74","fizzbuzz","76","77","fizz","79","buzz","fizz","82","83","fizz","buzz","86","fizz","88","89","fizzbuzz","91","92","fizz","94","buzz","fizz","97","98","fizz","buzz"));
    }
}
