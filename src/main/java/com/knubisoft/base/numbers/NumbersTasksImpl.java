package com.knubisoft.base.numbers;

import java.math.BigInteger;

public class NumbersTasksImpl implements NumbersTasks {

    @Override
    public void swapTwoNumbersWithoutUsingTemporaryVariable(int firstNumber, int secondNumber) {

        firstNumber = firstNumber + secondNumber;
        secondNumber = firstNumber - secondNumber;
        firstNumber = firstNumber - secondNumber;
    }

    @Override
    public boolean isUglyInt(int number) {

        boolean isUgly = true;

        if(number == 0){
            isUgly = false;
        } else{
            while (number != 1) {

                if (number % 5 == 0) {
                    number /= 5;
                } else if (number % 3 == 0) {
                    number /= 3;
                } else if (number % 2 == 0) {
                    number /= 2;
                } else {
                    isUgly = false;
                    break;
                }
            }
        }

        return isUgly;
    }

    @Override
    public int addDigits(int number) {

        while (number > 9){
            number = number % 10 + number / 10;
        }
        return number;
    }

    @Override
    public boolean isHarshadNumber(int number) {

        boolean isHarshad = false;
        int temp;
        int changedNumber = number;
        int sum = 0;

        if(number == 0){
            isHarshad = false;
        } else {

            while (changedNumber > 0) {
                temp = changedNumber % 10;
                sum += temp;
                changedNumber /= 10;
            }

            if (number % sum == 0) {
                isHarshad = true;
            }

        }

        return isHarshad;
    }

    @Override
    public boolean isPrime(int number) {

        boolean isPrime = true;

        if (number <= 1){
            isPrime = false;
        }

        for (int i = 2; i < number; i++) {

            if (number % i == 0) {
                isPrime = false;
            }
        }

        return isPrime;
    }

    @Override
    public boolean isArmstrongNumber(int number) {

        boolean isArmstrong = false;
        int changedNumber = number;
        int result = 0;
        int temp;

        while (changedNumber > 0){
            temp = changedNumber % 10;
            result += Math.pow(temp, 3);
            changedNumber /= 10;
        }

        if(result == number){
            isArmstrong = true;
        }

        return isArmstrong;
    }

    @Override
    public BigInteger factorial(int number) {

        BigInteger factorial = BigInteger.valueOf(1);

        for(int i = 2; i <= number; i++){

            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }

    @Override
    public boolean palindrome(int number) {

        int reversedNum = 0, remainder;

        int originalNum = number;

        while (number != 0) {
            remainder = number % 10;
            reversedNum = reversedNum * 10 + remainder;
            number /= 10;
        }

        if (originalNum == reversedNum) {
             return true;
        } else {
             return false;
        }

    }

    @Override
    public boolean isAutomorphic(int number) {

        int count = 0;
        int temp = number;
        long square = (long) number * number;

        while(temp > 0){
            count++;
            temp /= 10;
        }

        return number == (int) (square % (Math.pow(10, count)));
    }
}
