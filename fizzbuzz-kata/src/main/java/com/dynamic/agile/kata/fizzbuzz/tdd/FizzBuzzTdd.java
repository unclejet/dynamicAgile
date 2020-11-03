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
    public List<String> getFizzBuzz(String s) {
        List<String> fizzbuzzList = new ArrayList<>();
        if ("1".equals(s)) {
            fizzbuzzList.add("1");
        } else {
            fizzbuzzList.add("1");
            fizzbuzzList.add("2");
        }
        return fizzbuzzList;
    }
}
