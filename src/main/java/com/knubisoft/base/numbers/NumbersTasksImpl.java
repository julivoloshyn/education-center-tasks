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
        return false;
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

        while(changedNumber > 0){
            temp = changedNumber % 10;
            sum += temp;
            changedNumber /= 10;
        }

        if(number % sum == 0){
            isHarshad = true;
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

        boolean isPalindrome = false;
        int reversedNumber = 0;
        int changedNumber = 0;
        int temp;

        while(changedNumber > 0){
            temp = changedNumber % 10;
            reversedNumber = reversedNumber * 10 + temp;
            changedNumber /= 10;
        }

        if(reversedNumber == number){
            isPalindrome = true;
        }

        return isPalindrome;
    }

    @Override
    public boolean isAutomorphic(int number) {

        boolean isAutomorphic = false;
        int square = number * number;

        while (number > 0){

            if (number % 10 == square % 10) {
                isAutomorphic = true;
            }
            number /= 10;
            square /= 10;
        }

        return isAutomorphic;
    }
}
