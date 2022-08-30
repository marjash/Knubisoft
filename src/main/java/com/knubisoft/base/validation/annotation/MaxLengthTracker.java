package com.knubisoft.base.validation.annotation;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MaxLengthTracker {
    @SneakyThrows
    public boolean trackMaxLength(Object user) {
//        Constructor<?> constructor = cls.forName(cls.getName()).getConstructor(null);
//        Object user = constructor.newInstance();
        List<String> field = getNameOfField(user);
        for (String s : field) {
            Field name = user.getClass().getDeclaredField(s);
            s = s.substring(0, 1).toUpperCase() + s.substring(1);
            Method method = user.getClass().getMethod("get" + s);
            Object invoke = method.invoke(user);
            MaxLength length = name.getAnnotation(MaxLength.class);
            if (((String) invoke).length() > length.maxLength()) {
                System.out.println("You can't use for " + s + " more than " + length.maxLength() + " symbols");
                return false;
            }
        }
        System.out.println("is Ok");
        return true;
    }

    private List<String> getNameOfField(Object user) {
        Field[] fields = user.getClass().getDeclaredFields();
        List<String> field = new ArrayList<>();
        for (Field f : fields) {
            if(f.isAnnotationPresent(MaxLength.class)){
                String name = f.getName();
                field.add(name);
            }
        }
        return field;
    }
}
