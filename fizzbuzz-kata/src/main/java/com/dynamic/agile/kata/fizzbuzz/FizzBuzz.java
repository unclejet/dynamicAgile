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
    public static List<String> getFizzBuzz(String userInput) {
        return IntStream.rangeClosed(1, Integer.parseInt(userInput))
                .mapToObj(doFizzBuzz())
                .collect(Collectors.toList());
    }

    private static IntFunction<String> doFizzBuzz() {
        return number -> number % 15 == 0 ?
                "fizzbuzz" : number % 3 == 0 ?
                "fizz" : number % 5 == 0 ?
                "buzz" : String.valueOf(number);
    }
}
