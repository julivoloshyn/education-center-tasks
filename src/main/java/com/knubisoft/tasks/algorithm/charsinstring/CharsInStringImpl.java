package com.knubisoft.tasks.algorithm.charsinstring;

import java.util.HashMap;
import java.util.Map;

public class CharsInStringImpl implements CharsInString {

    @Override
    public Map<Character, Integer> charactersCount(String text) {

        Map<Character, Integer> charCount = new HashMap<>();
        text = text.replaceAll(" ", "");

        for(Character c : text.toCharArray()){

            if(charCount.containsKey(c)){
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }

        return charCount;
    }
}
