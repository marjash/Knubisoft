package com.knubisoft.base.bool;

public class BoolTasksImpl implements BoolTasks {

    public static void main(String[] args) {
        BoolTasksImpl boolTasks = new BoolTasksImpl();
        System.out.println(boolTasks.orComplexFunction(5, 5.5, 6, 6));
    }

    @Override
    public Boolean isTrueAutobox(boolean value) {
        Boolean b = value;
        if (b){
            return b;
        }
        return false;
    }

    @Override
    public Boolean isFalseAutobox(boolean value) {
        Boolean b = value;
        if (!b){
            return b;
        }
        return true;
    }

    @Override
    public boolean isTrueUnbox(Boolean value) {
        boolean b = value;
        if (b) {
            return b;
        }
        return false;
    }

    @Override
    public Boolean isFalseUnbox(boolean value) {
        Boolean b = value;
        if (!b) {
            return b;
        }
        return true;
    }

    @Override
    public boolean andFunction(int digit, String string) {
        if (string != null && string.matches(".*\\d.*")) {
            int num = Integer.parseInt(string);
            return digit == num;
        }
        return false;
    }

    @Override
    public boolean orFunction(int digit, String string) {
        if ((string == null || (string.contains(" ")))) {
            return false;
        }
        if (string.matches(".*\\d.*")) {
            int num = Integer.parseInt(string);
            return digit == num;
        }
        else
            return false;
    }

    @Override
    public boolean andComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int range) {
        if (range >= 3 && range <= 5 && generatedFirstDigit >= 3 && generatedFirstDigit <= 5 && generatedSecondDigit >= 3 && generatedSecondDigit <= 5)
            return generatedFirstDigit == Math.round(generatedSecondDigit);
        return false;
    }

    @Override
    public boolean orComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int generatedThirdDigit, int range) {
        if (range >= 5) {
            if (range <= 7)
                return (generatedFirstDigit == Math.round(generatedSecondDigit)) || (generatedFirstDigit == generatedThirdDigit);
        }
        return false;
    }

    @Override
    public boolean isSameSizeArray(Object[] firstArray, Object... secondArray) {
        String str = "";
        String str2 = "";
        if (firstArray != null && secondArray != null) {
            for (Object o : firstArray) {
                str += o;
            }
            for (Object o2 : secondArray) {
                str2 += o2;
            }
            return (str.length() == str2.length());
        }
        else
            return false;
    }

    @Override
    public boolean isSameCharactersCount(String username, String name, int maxLength) {
        if (username == null || username.length() == 0 || name == null || name.length() == 0 || maxLength == 0) {
            return false;
        }
        int i = 0;
        int j = 0;
        for (char c : username.toCharArray()) {
            i++;
        }
        for (char c : name.toCharArray()) {
            j++;
        }
        return i <= maxLength && j <= maxLength;
    }
}
