package com.dynamic.agile.kata.fizzbuzz;

import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Uncle Jet(韩金田)
 * @date 10/27/2020 7:16 AM
 */
public class FizzBuzz {
    public static List<String> doFizzBuzz(String userInput) {
        return IntStream.rangeClosed(1, Integer.parseInt(userInput))
                .mapToObj(int2String())
                .collect(Collectors.toList());
    }

    private static IntFunction<String> int2String() {
        return i -> i % 3 == 0 ? "fizz" : String.valueOf(i);
    }
}
