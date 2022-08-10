package com.knubisoft.tasks.algorithm.charsinstring;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CharsInStringImpl implements CharsInString {

    @Override
    public Map<Character, Integer> charactersCount(String text) {

        Map<Character, Integer> charCount = new HashMap<>();

        int k = 1;

        for(int i = 0; i < text.length(); i++){

            if(text.charAt(i) == ' '){
                continue;
            } else {
                charCount.put(text.charAt(i), k);
                k++;
            }
        }

        return charCount;
    }
}
