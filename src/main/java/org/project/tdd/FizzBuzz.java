package org.project.tdd;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public List<String> getNumbers() {
        List<String> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numbers.add(getNumber(i));
        }
        numbers.add("1");
        return numbers;
    }

    private String getNumber(int i) {
        if (isMultiple(i, 3) && isMultiple(i, 5)) {
           return FIZZ + BUZZ;
        }
        else if (isMultiple(i, 3)){
            return FIZZ;
        }
        else if (isMultiple(i, 5)){
            return BUZZ;
        }
            return "" + i;
    }

    private boolean isMultiple(int value, int mulitple) {
        return value % mulitple == 0;
    }
}
