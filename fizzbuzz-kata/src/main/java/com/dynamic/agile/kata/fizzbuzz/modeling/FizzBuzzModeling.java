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
        List<String> fizzbuzzList = new ArrayList<>();
        if ("1".equals(inputNumber)) {
            fizzbuzzList.add("1");
        } else {
            fizzbuzzList.add("1");
            fizzbuzzList.add("2");
        }
        return fizzbuzzList;
    }
}
