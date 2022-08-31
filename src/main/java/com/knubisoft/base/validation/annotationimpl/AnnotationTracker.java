package com.knubisoft.base.validation.annotationimpl;

import com.knubisoft.base.validation.annotation.MaxLength;
import com.knubisoft.base.validation.annotation.NotNull;
import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AnnotationTracker {
    @SneakyThrows
    public boolean trackMaxLength(Object user) {
        List<Field> fields = getNameOfField(user, MaxLength.class);
        List<Method> methods = getNameOfMethod(user, fields);
        for (int i = 0; i < fields.size(); i++) {
            Object invoke = methods.get(i).invoke(user);
            MaxLength length = fields.get(i).getAnnotation(MaxLength.class);
            if (((String) invoke).length() > length.maxLength()) {
                System.out.println("You can't use for " + fields.get(i).getName() + " more than " + length.maxLength() + " symbols");
                return false;
            }
        }
        System.out.println("is Ok");
        return true;
    }

    private List<Field> getNameOfField(Object user, Class<? extends Annotation> cls) {
        Field[] fields = user.getClass().getDeclaredFields();
        List<Field> annotationField = new ArrayList<>();
        for (Field f : fields) {
            if (f.isAnnotationPresent(cls))
                annotationField.add(f);
        }
        return annotationField;
    }

    @SneakyThrows
    private List<Method> getNameOfMethod(Object user, List<Field> fields) {
        List<Method> methods = new ArrayList<>();
        for (Field f : fields) {
            String s = f.getName();
            s = s.substring(0, 1).toUpperCase() + s.substring(1);
            Method method = user.getClass().getMethod("get" + s);
            methods.add(method);
        }
        return methods;
    }

    @SneakyThrows
    public boolean trackNotNull(Object user) {
        List<Field> fields = getNameOfField(user, NotNull.class);
        List<Method> methods = getNameOfMethod(user, fields);
        for (int i = 0; i < fields.size(); i++) {
            Object invoke = methods.get(i).invoke(user);
            if (invoke == null || invoke == "") {
                System.out.println(fields.get(i).getName() + " can't be null");
                return false;
            }
        }
        return true;
    }
}
