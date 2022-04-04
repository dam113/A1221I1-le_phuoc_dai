package com.SS8_CleanCode_Refactoring.thuc_hanh;

public class FizzBuzz {
    public static String fizzBuzz(int number) {
        final boolean isFizz = number % 3 == 0;
        final boolean isBuzz = number % 5 == 0;
        if (isFizz && isBuzz)
            return "FizzBuzz";

        if (isFizz)
            return "Fizz";

        if (isBuzz)
            return "Buzz";

        return number + "";
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
        System.out.println(fizzBuzz(10));
        System.out.println(fizzBuzz(3));
    }
}
