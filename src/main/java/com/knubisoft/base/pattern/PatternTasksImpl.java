package com.knubisoft.base.pattern;

import java.util.regex.Pattern;

public class PatternTasksImpl implements PatternTasks {

    @Override
    public boolean haveSetOfCharacters(String text) {
        if(text == null || text.length() == 0 || text.equals(" ")){
            throw new IllegalArgumentException();
        }

        return Pattern.compile("^[a-zA-Z0-9]*$").matcher(text).find() ;
    }

    @Override
    public String matchByCharacters(String text) {
        if(text == null){
            throw new IllegalArgumentException();
        }

        if (text.matches("pq*")) {
            return "Found a match!";
        } else {
            return "Not matched!";
        }
    }

    @Override
    public String matchStartAndEnd(String text) {
        if(text == null || text.length() == 0 || text.equals(" ")){
            throw new IllegalArgumentException();
        }

        String result = "";
        text = text.trim().replaceAll("\\.", "");
        String[] str = text.split(" ");

        Pattern pattern1 = Pattern.compile("^[^g].*[^g]$");
        Pattern pattern2 = Pattern.compile("g+");

        for(String s : str) {

            if (pattern1.matcher(s).find() && pattern2.matcher(s).find()) {
                result = "Found a match!";
            } else {
                result = "Not matched!";
            }
        }

        return result;
    }

    @Override
    public String matchIpAddress(String text) {
        if(text == null || text.length() == 0 || text.equals(" ")){
            throw new IllegalArgumentException();
        }

        return text.replaceAll("(?<=^|\\.)0+(?!\\.|$)", "");
    }

    @Override
    public String matchVowels(String text) {
        if(text == null || text.length() == 0 || text.equals(" ")){
            throw new IllegalArgumentException();
        }

        return text.replaceAll("(?i)[aeiou]", "");
    }

    @Override
    public boolean validatePIN(String text) {
        if(text == null || text.length() == 0 || text.equals(" ")){
            throw new IllegalArgumentException();
        }

        return text.matches("^\\d{4}$|^\\d{6}$|^\\d{8}$");
    }

    @Override
    public String divideDigit(int digit) {
        String str = String.valueOf(digit);

        return str.replaceAll("[0]{3}$", "#000");
    }

    @Override
    public String removeAllNonAlphanumericCharacters(String text) {
        if(text == null || text.length() == 0 || text.equals(" ")){
            throw new RuntimeException();
        }

        return text.replaceAll("\\W", "");
    }

    @Override
    public boolean validatePhoneNumber(String text) {
        if (text == null || text.equals("") || text.equals(" ")) {
            throw new IllegalArgumentException();
        }

        return text.matches("(\\d{10})|(\\(\\d{3}\\)\\d{3}\\-\\d{4})|(\\(\\d{3}\\)\\d{7})|(\\d{3}\\-\\d{3}\\-\\d{4})");
    }

    @Override
    public String getLastVowelsByConstraint(String text, int n) {
        if (text == null || text.equals("") || text.equals(" ") || n <= 0 || n > text.length()) {
            throw new IllegalArgumentException();
        }

        text = text.replaceAll("[^euioa]+", "");
        if(text.length() == n){
            return text;
        }

        return text.substring(text.length() - n);
    }

    @Override
    public boolean isMathematicalExpression(String text) {
        if ( text == null || text.equals("") || text.equals(" ") ) {
            throw new IllegalArgumentException();
        }

        return text.matches(String.format("\\d{%d}|(^\\s?\\d+\\s*(\\s*[-+*/]\\s*\\d+\\s*)+)", text.length()));
    }

    @Override
    public String insertDash(String text) {
        if (text == null || text.equals("") || text.equals(" ")) {
            throw new IllegalArgumentException();
        }

        return text.replaceAll("([A-Z])","$1-");
    }
}
