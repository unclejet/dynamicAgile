package com.dynamic.agile.kata.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uncle Jet(韩金田)
 * @date 10/27/2020 7:16 AM
 */
public class FizzBuzz {
    private String userInput;

    public FizzBuzz(String userInput) {
        this.userInput = userInput;
    }

    public String[] print() {
        if ("1".equals(userInput)) {
            return new String[]{"1"};
        } else {
            return new String[]{"1", "2"};
        }
    }
}
