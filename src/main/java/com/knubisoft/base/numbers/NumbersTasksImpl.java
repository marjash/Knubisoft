package com.knubisoft.base.numbers;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class NumbersTasksImpl implements NumbersTasks {
    public static void main(String[] args) {

//        System.out.println(numbersTasks);
//        numbersTasks.swapTwoNumbersWithoutUsingTemporaryVariable(2, 3);
    }

    @Override
    public void swapTwoNumbersWithoutUsingTemporaryVariable(int firstNumber, int secondNumber) {
        firstNumber = firstNumber + secondNumber;
        secondNumber = firstNumber - secondNumber;
        firstNumber = firstNumber - secondNumber;
        System.out.println(firstNumber + " " + secondNumber);
    }

    @Override
    public boolean isUglyInt(int number) {
        int[] num = new int[]{2, 3, 5};
        while (number > 1) {
            for (int j : num) {
                if (number % j == 0) {
                    number = number / j;
                }
                if (number == 1)
                    return true;
            }
            if (number % 2 != 0 && number % 3 != 0 && number % 5 != 0)
                return false;
        }
        return number == 1;
    }

    @Override
    public int addDigits(int number) {
        String num = String.valueOf(number);
        char[] c = num.toCharArray();
        int n = 0;
        boolean b = true;
        while (b) {
            for (char value : c) {
                n += Character.getNumericValue(value);
            }
                if (n > 9) {
                    num = String.valueOf(n);
                    c = num.toCharArray();
                    n = 0;
                }
                else {
                    b = false;
                }
            }
        return n;
    }

    @Override
    public boolean isHarshadNumber(int number) {
        if (number == 0) {
            return false;
        }
        String num = String.valueOf(number);
        char[] c = num.toCharArray();
        int n = 0;
        for (char value : c) {
            n += Character.getNumericValue(value);
        }
        return number % n == 0;
    }

    @Override
    public boolean isPrime(int number) {
        return false;
    }

    @Override
    public boolean isArmstrongNumber(int number) {
        return false;
    }

    @Override
    public BigInteger factorial(int number) {
        return BigInteger.ZERO;
    }

    @Override
    public boolean palindrome(int number) {
        return false;
    }

    @Override
    public boolean isAutomorphic(int number) {
        return false;
    }

}
