package com.knubisoft.tasks.algorithm.charsinstring;

import java.util.HashMap;
import java.util.Map;

public class CharsInStringImpl implements CharsInString {
    @Override
    public Map<Character, Integer> charactersCount(String text) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    count++;
                }
            }
            if (text.charAt(i) != ' ')
                map.put(text.charAt(i), count);
            count = 0;
        }
        return map;
    }
}
