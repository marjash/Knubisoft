package com.knubisoft.base.pattern;

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
        return null;
    }

    @Override
    public String matchVowels(String text) {
        return null;
    }

    @Override
    public boolean validatePIN(String text) {
        return false;
    }

    @Override
    public String divideDigit(int digit) {
        return null;
    }

    @Override
    public String removeAllNonAlphanumericCharacters(String text) {
        return null;
    }

    @Override
    public boolean validatePhoneNumber(String text) {
        return false;
    }

    @Override
    public String getLastVowelsByConstraint(String text, int n) {
        return null;
    }

    @Override
    public boolean isMathematicalExpression(String text) {
        return false;
    }

    @Override
    public String insertDash(String text) {
        return null;
    }
}
