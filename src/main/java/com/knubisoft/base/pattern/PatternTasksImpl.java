package com.knubisoft.base.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTasksImpl implements PatternTasks {

    @Override
    public boolean haveSetOfCharacters(String text) {
        if (text == null || text.equals("") || text.equals(" "))
            throw new IllegalArgumentException();
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        return pattern.matcher(text).find();
    }

    @Override
    public String matchByCharacters(String text) {
        if (text == null)
            throw new IllegalArgumentException();
        Pattern pattern = Pattern.compile("^pq*$");
        if (pattern.matcher(text).find()){
            return "Found a match!";
        }
        else
            return "Not matched!";
    }

    @Override
    public String matchStartAndEnd(String text) {
        if (text == null)
            throw new IllegalArgumentException();
        Pattern pattern = Pattern.compile("(?!\\b)g(?!\\b)");
        if (pattern.matcher(text).find()){
            return "Found a match!";
        }
        else
            return "Not matched!";
    }

    @Override
    public String matchIpAddress(String text) {
        if (text == null || text.equals("") || text.equals(" "))
            throw new IllegalArgumentException();
        return text.replaceAll("\\b0+", "");
    }

    @Override
    public String matchVowels(String text) {
        if (text == null || text.equals("") || text.equals(" "))
            throw new IllegalArgumentException();
        return text.replaceAll("[aAeEiIoOuU]", "");
    }

    @Override
    public boolean validatePIN(String text) {
        if (text == null || text.equals("") || text.equals(" "))
            throw new IllegalArgumentException();
        Pattern pattern = Pattern.compile("^\\d{4}$|^\\d{6}$|^\\d{8}$");
        return pattern.matcher(text).find();
    }

    @Override
    public String divideDigit(int digit) {
        String text = String.valueOf(digit);
        return text.replaceAll("0{3}$", "#000");
    }

    @Override
    public String removeAllNonAlphanumericCharacters(String text) {
        if (text == null || text.equals("") || text.equals(" "))
            throw new IllegalArgumentException();
        return text.replaceAll("\\W", "");
    }

    @Override
    public boolean validatePhoneNumber(String text) {
        if (text == null || text.equals("") || text.equals(" "))
            throw new IllegalArgumentException();
        Pattern pattern = Pattern.compile("(\\(([1-3]{3})\\)|([1-3]{3}))([-]([4-6]{3})[-]|([4-6]{3}))([-]?)([7890]{4}$)");
        return pattern.matcher(text).find();
    }

    @Override
    public String getLastVowelsByConstraint(String text, int n) {
        if (text == null || text.equals("") || text.equals(" ") || n == 0)
            throw new IllegalArgumentException();
        String str = text.replaceAll("[^aAeEiIoOuU]", "");
        str = str.substring(str.length() - n);
        return str;
    }

    @Override
    public boolean isMathematicalExpression(String text) {
        if (text == null || text.equals("") || text.equals(" "))
            throw new IllegalArgumentException();
        Pattern pattern = Pattern.compile("^([0-9]+\\s[-+/*]\\s[0-9]+$)|^[0-9]+$");
        return pattern.matcher(text).find();
    }

    @Override
    public String insertDash(String text) {
        if (text == null || text.equals("") || text.equals(" "))
            throw new IllegalArgumentException();
        char[] c = text.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (Character.isUpperCase(c[i])){
                text = text.replaceAll(String.valueOf(c[i]), c[i] + "-");
            }
        }
        return text;
    }
}
