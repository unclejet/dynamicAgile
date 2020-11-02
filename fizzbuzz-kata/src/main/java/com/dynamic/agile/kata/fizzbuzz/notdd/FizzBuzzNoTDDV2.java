package com.dynamic.agile.kata.fizzbuzz.notdd;

import java.util.Arrays;

/**
 * @author ：unclejet
 * @date ：Created in 2020/11/3 7:32
 * @description：
 * @modified By：
 * @version:
 */
public class FizzBuzzNoTDDV2 {
    public static void main(String[] args) {
        int n = 15;
        String[] fizzbuzz = fizzbuzzPrint(n);
        System.out.println(Arrays.toString(fizzbuzz));
    }

    public static String[] fizzbuzzPrint(int n) {
        if (n < 1) {
            return null;
        }
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            int numTem = i + 1;
            if (numTem % 3 == 0 && numTem % 5 == 0) {
                result[i] = "fizz buzz";
                continue;
            }
            if (numTem % 3 == 0) {
                result[i] = "fizz";
                continue;
            }
            if (numTem % 5 == 0) {
                result[i] = "buzz";
                continue;
            }
            result[i] = Integer.toString(numTem);
        }
        return result;
    }
}
