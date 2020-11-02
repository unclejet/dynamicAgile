package com.dynamic.agile.kata.fizzbuzz.notdd;

/**
 * @author ：unclejet
 * @date ：Created in 2020/11/3 7:23
 * @description：
 * @modified By：
 * @version:
 */
public class FizzBuzzNoTDDV1 {
    public static void main(String[] args) {
        int n = 15;
        String[] fizzbuzz = fizzbuzzPrint(n);
        System.out.println(fizzbuzz);
    }

    public static String[] fizzbuzzPrint(int n) {
        if (n < 1) {
            return null;
        }
        String[] result = new String[n];
        for (int i = 1; i < n; i++) {
            if (n % 3 == 0 && n % 5 == 0) {
                result[i] = "fizz buzz";
                continue;
            }
            if (n % 3 == 0) {
                result[i] = "fizz";
                continue;
            }
            if (n % 5 == 0) {
                result[i] = "buzz";
                continue;
            }
            result[i] = Integer.toString(i);
        }
        return result;
    }
}
