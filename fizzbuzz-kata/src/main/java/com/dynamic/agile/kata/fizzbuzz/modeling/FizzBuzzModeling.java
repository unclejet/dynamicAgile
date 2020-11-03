package com.dynamic.agile.kata.fizzbuzz.modeling;

import java.util.ArrayList;
import java.util.List;
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
    public static List<String> getFizzBuzz(String inputNumber) {
        int number = Integer.parseInt(inputNumber);
        return IntStream.rangeClosed(1, number)
                .mapToObj(n -> n % 3 == 0 ? "fizz" :
                    n % 5== 0 ? "buzz" :
                        "" + n)
                .collect(Collectors.toList());
    }
}
