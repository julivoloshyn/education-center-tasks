package com.knubisoft.base.bool;

import java.util.Locale;

public class BoolTasksImpl implements BoolTasks {

    @Override
    public Boolean isTrueAutobox(boolean value) {

        Boolean b = value;

        return b ? b : false;
    }

    @Override
    public Boolean isFalseAutobox(boolean value) {

        Boolean b = value;

        return b == false ? b : true;
    }

    @Override
    public boolean isTrueUnbox(Boolean value) {

        boolean b = value;

        return b;
    }

    @Override
    public Boolean isFalseUnbox(boolean value) {

        Boolean b = value;

        return b == false ? b : true;
    }

    @Override
    public boolean andFunction(int digit, String string) {

        int num;

        try {
            num = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }

        if(digit == num && string != null){
            return true;
        }

        return false;
    }

    @Override
    public boolean orFunction(int digit, String string) {

        int strNum;

        try {
            strNum = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }

        if(digit != strNum || string == null){
            return false;
        }

        return true;
    }

    @Override
    public boolean andComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int range) {

        double result = Math.round(generatedSecondDigit) & range;

        return result == generatedFirstDigit;
    }

    @Override
    public boolean orComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int generatedThirdDigit, int range) {

        double result1 = Math.round(generatedSecondDigit) | generatedFirstDigit;
        double result2 = Math.round(generatedThirdDigit) | generatedFirstDigit;

        return  ((result1) < (range) && (range) < result2) || (result2 < range && range < result1);
    }

    @Override
    public boolean isSameSizeArray(Object[] firstArray, Object... secondArray) {

        if(firstArray == null || secondArray == null){
            return false;
        } else return firstArray.length == secondArray.length;
    }

    @Override
    public boolean isSameCharactersCount(String username, String name, int maxLength) {

        if (username == null || name == null || maxLength == 0) {
            return false;
        } else {
            return username.toCharArray().length == name.toCharArray().length;
        }
    }
}
