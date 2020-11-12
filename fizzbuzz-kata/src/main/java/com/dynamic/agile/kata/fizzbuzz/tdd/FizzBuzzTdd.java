package com.dynamic.agile.kata.fizzbuzz.tdd;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ：unclejet
 * @date ：Created in 2020/11/4 5:46
 * @description：
 * @modified By：
 * @version:
 */
public class FizzBuzzTdd {

    public static final int MIN_ALLOWED_INPUT_NUMBER = 1;
    public static final int MAX_ALLOWED_INPUT_NUMBER = 1000;

    public static List<String> getFizzBuzz(String inputNumber) {
        int number = readInputNumber(inputNumber);
        return isValidNumber(number) ? getFizzbuzz(number) : Collections.emptyList();
    }

    private static boolean isValidNumber(int number) {
        return number >= MIN_ALLOWED_INPUT_NUMBER && number <= MAX_ALLOWED_INPUT_NUMBER;
    }

    private static int readInputNumber(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            e.printStackTrace(); //use log.error instead for biz project.
        }
        return -1;
    }

    private static List<String> getFizzbuzz(int number) {
        return IntStream.rangeClosed(1, number)
                .mapToObj(FizzBuzzTdd::calculateFizzbuzz)
                .collect(Collectors.toList());
    }

    private static String calculateFizzbuzz(int i) {
        String fizzbuzz;
        if (i % 15 == 0) {
            fizzbuzz = "fizzbuzz";
        } else if (i % 3 == 0) {
            fizzbuzz = "fizz";
        } else if (i % 5 == 0) {
            fizzbuzz = "buzz";
        } else {
            fizzbuzz = "" + i;
        }
        return fizzbuzz;
    }
}
