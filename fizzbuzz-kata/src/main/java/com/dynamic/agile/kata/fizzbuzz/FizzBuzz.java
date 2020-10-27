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

    public List<String> print() {
        int number = Integer.parseInt(userInput);
        List<String> result = new ArrayList<String>(number);
        for (int i = 1; i <= number; i++) {
            result.add(String.valueOf(i));
        }
        return result;
    }
}
