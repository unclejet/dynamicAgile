package com.dynamic.agile.kata.fizzbuzz.modeling;

import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ：unclejet
 * @date ：Created in 2020/11/4 6:20
 * @description：
 * @modified By：
 * @version:
 */
public class FizzBuzzModeling {

    public static final int MIN_ALLOWED_INPUT_NUMBER = 1;
    public static final int MAX_ALLOWED_INPUT_NUMBER = 1000;

    public static List<String> getFizzBuzz(String inputNumber) {
        int number = parseInputNumber(inputNumber);
        return isValidNumber(number) ? doFizzBuzz(number) : Collections.emptyList();
    }

    private static boolean isValidNumber(int number) {
        return number >= MIN_ALLOWED_INPUT_NUMBER && number <= MAX_ALLOWED_INPUT_NUMBER;
    }

    private static int parseInputNumber(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static List<String> doFizzBuzz(int number) {
        return IntStream.rangeClosed(1, number)
                .mapToObj(calculateFizzbuzz())
                .collect(Collectors.toList());
    }

    private static IntFunction<String> calculateFizzbuzz() {
        return n -> n % 15 == 0 ? "fizzbuzz" :
                    n % 3 == 0 ? "fizz" :
                            n % 5 == 0 ? "buzz" :
                                "" + n;
    }
}
