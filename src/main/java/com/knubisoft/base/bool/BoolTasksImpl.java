package com.knubisoft.base.bool;

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
        return null;
    }

    @Override
    public boolean andFunction(int digit, String string) {
        return false;
    }

    @Override
    public boolean orFunction(int digit, String string) {
        return false;
    }

    @Override
    public boolean andComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int range) {
        return false;
    }

    @Override
    public boolean orComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int generatedThirdDigit, int range) {
        return false;
    }

    @Override
    public boolean isSameSizeArray(Object[] firstArray, Object... secondArray) {
        return false;
    }

    @Override
    public boolean isSameCharactersCount(String username, String name, int maxLength) {
        return false;
    }
}
