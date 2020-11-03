package com.dynamic.agile.kata.fizzbuzz.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：unclejet
 * @date ：Created in 2020/11/4 5:46
 * @description：
 * @modified By：
 * @version:
 */
public class FizzBuzzTdd {
    public static List<String> getFizzBuzz(String inputNumber) {
        int number = Integer.parseInt(inputNumber);
        List<String> fizzbuzzList = new ArrayList<>(number);
        for (int i = 1; i <= number; i++) {
            if (i % 15 == 0) {
                fizzbuzzList.add("fizzbuzz");
            }else if (i % 3 == 0) {
                fizzbuzzList.add("fizz");
            } else if (i % 5 == 0) {
                fizzbuzzList.add("buzz");
            } else {
                fizzbuzzList.add("" + i);
            }
        }
        return fizzbuzzList;
    }
}
