package com.knubisoft.base.string;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class StringTasksImpl implements StringTasks {
    private String str = "Java";

    @Override
    public String reverseString(String original) {
        if (original == null){
            throw new IllegalArgumentException();
        }
        String str = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            str += original.charAt(i);
        }
        return str;
    }

    @Override
    public String insertStringInMiddle(String original, String toInsert) {
        if (original == null || toInsert == null || original.equals("") || toInsert.equals("")){
            throw new IllegalArgumentException();
        }
        String substring = original.substring(0, (original.length() / 2));
        String substring2 = original.substring((original.length() / 2));
        String result = substring + toInsert + substring2;
        return result;
    }

    @Override
    public String insertSymbolInString(String original, char toInsert, int position) {
        if (original == null || original.equals("") || position < 0 || position > original.length()){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < original.length(); i++) {
            if (i == position){
                String substring = original.substring(0, position);
                String substring2 = original.substring(position);
                original = substring + toInsert + substring2;
            }
        }
        return original;
    }

    @Override
    public String appendToString(StringBuilder original, String toAppend) {
        if (original == null || toAppend == null || original.toString().equals("") || toAppend.equals("")){
            throw new NoSuchElementException();
        }
        return original.append(toAppend).toString();
    }

    @Override
    public boolean isPalindrome(String palindrome) {
        if (palindrome == null)
            throw new RuntimeException();
        if (palindrome.equals(""))
            return true;
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (!(palindrome.charAt(i) == palindrome.charAt(palindrome.length() - 1 - i)))
                return false;
        }
        return true;
    }

    @Override
    public boolean hasLowerCase(String str) {
        if (str == null){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c))
                return false;
        }
        return true;
    }

    @Override
    public String uniqueCharacters(String str) {
        if (str == null)
            throw  new IllegalArgumentException();
        boolean b = false;
        String res = "";
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 1 + i; j < str.length(); j++) {
                if (!(str.charAt(i) == str.charAt(j))) {
                    b = true;
                }
                else {
                    str = str.replace(str.charAt(i), ' ');
                    b = false;
                    break;
                }
            }
            if (b){
                res += String.valueOf(str.charAt(i));
            }
        }
        return res.trim();
    }

    @Override
    public String removeAllCharacters(String str, char charToRemove) {
        if (str == null)
            throw new IllegalArgumentException();
        str = str.replaceAll(String.valueOf(charToRemove), "");
        return str;
    }

    @Override
    public String toCamelCase(String str) {
        if (str == null || str.equals(""))
            throw new IllegalArgumentException();
        String result = "";
        boolean b = false;
        for (int i = 0; i < str.length(); i++) {
            if(Character.isLetter(str.charAt(i))) {
                if (b) {
                    result += Character.toUpperCase(str.charAt(i));
                    b = false;
                    continue;
                }
                result += str.charAt(i);
            }
            else {
                b = true;
            }
        }
        return result;
    }

    @Override
    public String getCountRepeatableString(String str) {
        if (str == null)
            throw new IllegalArgumentException();
        String result = "";
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }
            }
            if (count > 9){
                for (int k = 1; k <= 9; k++) {
                    result += String.valueOf(k);
                }
                count = count - 9;
            }
            for (int k = 1; k <= count; k++) {
                result += String.valueOf(k);
            }
            count = 1;
        }
        return result;
    }

    @Override
    public String sortStringCharactersAsc(String str) {
        if (str == null)
            throw new IllegalArgumentException();
        char[] c = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length() - 1; j++) {
                if (c[j] == c[j+1]){
                    continue;
                }
                if (c[j] > c[j+1]){
                    char temp = c[j];
                    c[j] = c[j+1];
                    c[j+1] = temp;
                }
            }
        }
        str = String.valueOf(c);
        return str;
    }
}
