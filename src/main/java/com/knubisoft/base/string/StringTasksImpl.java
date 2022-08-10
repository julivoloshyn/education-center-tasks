package com.knubisoft.base.string;

import java.util.NoSuchElementException;

public class StringTasksImpl implements StringTasks {

    @Override
    public String reverseString(String original) {

        try {
            original.equalsIgnoreCase(null);
        }
        catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }

        StringBuilder stringBuilder = new StringBuilder();

            char[] stringArray = original.toCharArray();

            for (int i = stringArray.length - 1; i >= 0; i--) {

                stringBuilder.append(stringArray[i]);

            }

        return stringBuilder.toString();
    }

    @Override
    public String insertStringInMiddle(String original, String toInsert) {
        return null;
    }

    @Override
    public String insertSymbolInString(String original, char toInsert, int position) {

        try {
            original.equalsIgnoreCase(null);
        }
        catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }

        if(position > original.length() || position < original.length() || original == ""){
            throw new IllegalArgumentException();
        }

        StringBuilder stringBuilder = new StringBuilder(original);
        stringBuilder.insert(position, toInsert);

        return stringBuilder.toString();
    }

    @Override
    public String appendToString(StringBuilder original, String toAppend) {

        try {
            original.toString().equalsIgnoreCase(null);
            toAppend.equalsIgnoreCase(null);
        }
        catch (NullPointerException e) {
            throw new NoSuchElementException();
        }

        if(original.toString().isEmpty()){
            throw new NoSuchElementException();
        }

        StringBuilder stringBuilderResult = original.append(toAppend);

        return stringBuilderResult.toString();
    }

    @Override
    public boolean isPalindrome(String palindrome) {

        char[] stringArray = palindrome.toCharArray();
        char[] reversedStringArray = palindrome.toCharArray();

        int j = reversedStringArray.length - 1;
        int count = 0;

        boolean isPalindrome = false;

        for(int i = 0; i < j; i++, j--){

            char temp = reversedStringArray[i];
            reversedStringArray[i] = reversedStringArray[j];
            reversedStringArray[j] = temp;
        }

        for(int i = 0; i < stringArray.length; i++) {

            if (Character.toLowerCase(stringArray[i]) != Character.toLowerCase(reversedStringArray[i])){
                count++;
            }
        }

        if(count == 0){
            isPalindrome = true;
        }

        return isPalindrome;
    }

    @Override
    public boolean hasLowerCase(String str) {

        try {
            str.equalsIgnoreCase(null);
        }
        catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }

        int count = 0;
        boolean hasOnlyLowerCase = true;
        char[] strArray = str.toCharArray();


        for(int i = 0; i < strArray.length; i++){

            char ch = strArray[i];

            if(Character.isUpperCase(ch)){
                count++;
            }

            if(count != 0){
                hasOnlyLowerCase = false;
            }
        }
        return hasOnlyLowerCase;
    }

    @Override
    public String uniqueCharacters(String str) {

        try {
            str.equalsIgnoreCase(null);
        }
        catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }

        StringBuilder stringBuilder = new StringBuilder(str.toLowerCase());

        for (int i = 0; i < stringBuilder.length(); i++){
            int count = 0;

            for(int j = i + 1; j < stringBuilder.length(); j++){
                if(stringBuilder.charAt(i) == stringBuilder.charAt(j)) {
                    stringBuilder.deleteCharAt(j);
                    j--;
                    count++;
                }
                }
            if(count >= 1){
                stringBuilder.deleteCharAt(i);
                i--;
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String removeAllCharacters(String str, char charToRemove) {

        try {
            str.equalsIgnoreCase(null);
        }
        catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }

        StringBuilder stringBuilder = new StringBuilder(str);

        for(int i = 0; i < stringBuilder.length(); i++){

            if(stringBuilder.charAt(i) == charToRemove){
                stringBuilder.deleteCharAt(i);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String toCamelCase(String str) {
        return null;
    }

    @Override
    public String getCountRepeatableString(String str) {
        return null;
    }

    @Override
    public String sortStringCharactersAsc(String str) {

        try {
            str.equalsIgnoreCase(null);
        }
        catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }

        char[] strArray = str.toCharArray();

        for(int i = 0; i < strArray.length; i++){

            for(int j = i + 1; j < strArray.length; j++){

                if(Character.toLowerCase(strArray[j]) < Character.toLowerCase(strArray[i])){

                    char temp = strArray[i];
                    strArray[i] = strArray[j];
                    strArray[j] = temp;
                }
            }
        }

        return String.valueOf(strArray);
    }
}
