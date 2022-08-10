package com.knubisoft.base.string;

import java.util.Locale;

public class StringTasksImpl implements StringTasks {
    private String str = "Java";

    @Override
    public String reverseString(String original) {
        String str = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            str += original.charAt(i);
        }
        return str;
    }

    @Override
    public String insertStringInMiddle(String original, String toInsert) {
        String substring = original.substring(0, (original.length() / 2));
        String substring2 = original.substring((original.length() / 2));
        String result = substring + toInsert + substring2;
        return result;
    }

    @Override
    public String insertSymbolInString(String original, char toInsert, int position) {
        return null;
    }

    @Override
    public String appendToString(StringBuilder original, String toAppend) {
        return null;
    }

    @Override
    public boolean isPalindrome(String palindrome) {
        return false;
    }

    @Override
    public boolean hasLowerCase(String str) {
        return false;
    }

    @Override
    public String uniqueCharacters(String str) {
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
        return null;
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
        return null;
    }

    public String bla(){
        return "hello";
    }

    public void blabla(){
    }
}
