package com.knubisoft.base.numbers;

import javax.xml.crypto.Data;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

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
        boolean b = false;
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0)
                return false;
            else
                b = true;
        }
        return b;
    }

    @Override
    public boolean isArmstrongNumber(int number) {
        String s = String.valueOf(number);
        int num = number;
        double n = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            n = number % 10;
            n = Math.pow(n, 3);
            sum += n;
            number = number / 10;
        }
        return sum == num;
    }

    @Override
    public BigInteger factorial(int number) {
        BigInteger bigInteger = BigInteger.valueOf(1);
        if (number == 0)
            return BigInteger.valueOf(1);
        else
            return factorial(number - 1).multiply(BigInteger.valueOf(number));
    }

    @Override
    public boolean palindrome(int number) {
        String s = String.valueOf(number);
        if (s.length() == 1)
            return true;
        int[] num = new int[s.length()];
        int n = 0;
        boolean b = false;
        for (int i = 0; i < s.length(); i++) {
            n = number % 10;
            num[i] = n;
            number = number / 10;
        }
        for (int i = 0; i < num.length / 2; i++) {
            if (num[i] == num[num.length - 1 - i]){
                b = true;
            }
            else {
                return false;
            }
        }
        return b;
    }

    @Override
    public boolean isAutomorphic(int number) {
        long num = (long) number * number;
        String str = String.valueOf(number);
//        char[] ch = str.toCharArray();
        String str2 = String.valueOf(num);
//        char[] ch2 = str2.toCharArray();
        boolean b = false;
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
//            System.out.println("num " + str2.charAt(i) + " number " + str.charAt(str.length() - 1 - count));
            if (str.charAt(i) == str2.charAt(str2.length() - 1 - count)){
                b = true;
                count++;
            }
            else
                return false;
        }
        return b;
    }

}
