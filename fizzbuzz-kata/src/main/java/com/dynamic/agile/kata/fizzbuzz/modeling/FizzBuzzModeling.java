package com.dynamic.agile.kata.fizzbuzz.modeling;

import java.util.ArrayList;
import java.util.List;

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
        List<String> fizzbuzzList = new ArrayList<>(number);
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0) {
                fizzbuzzList.add("fizz");
            } else {
                fizzbuzzList.add("" + i);
            }
        }
        return fizzbuzzList;
    }
}
