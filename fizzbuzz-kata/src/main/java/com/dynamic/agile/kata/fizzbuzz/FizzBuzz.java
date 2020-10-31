package com.dynamic.agile.kata.fizzbuzz;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Uncle Jet(韩金田)
 * @date 10/27/2020 7:16 AM
 */
public class FizzBuzz {
    public static List<String> fizzBuzzList(String userInput) {
        return IntStream.rangeClosed(1, Integer.parseInt(userInput))
                .mapToObj(i -> doFizzBuzz(i))
                .collect(Collectors.toList());
    }

    private static String doFizzBuzz(int number) {
        return number % 3 == 0 ? "fizz" : number % 5 == 0 ? "buzz" : String.valueOf(number);
    }
}
