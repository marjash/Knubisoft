package com.knubisoft.tasks.algorithm.reflection;

import lombok.SneakyThrows;
import net.minidev.asm.ex.NoSuchFieldException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FieldUtilsImpl implements FieldUtils{

    @SneakyThrows
    @Override
    public Field getField(Class<?> cls, String fieldName) {
        if (cls == null || fieldName == null)
            throw new NullPointerException();
        if (fieldName.isEmpty())
            throw new NoSuchFieldException();
        return cls.getField(fieldName);
    }

    @SneakyThrows
    @Override
    public Field getField(Class<?> cls, String fieldName, boolean forceAccess) {
        if (cls == null || fieldName == null)
            throw new NullPointerException();
        if (fieldName.isEmpty())
            throw new NoSuchFieldException();
        Field field = cls.getField(fieldName);
        if (forceAccess)
            field.setAccessible(true);
        return field;
    }

    @SneakyThrows
    @Override
    public Field getDeclaredField(Class<?> cls, String fieldName) {
        if (cls == null || fieldName == null)
            throw new NullPointerException();
        if (fieldName.isEmpty())
            throw new NoSuchFieldException();
        return cls.getDeclaredField(fieldName);
    }

    @Override
    public Field[] getAllFields(Class<?> cls) {
        if (cls == null)
            throw new NullPointerException();
        return cls.getDeclaredFields();
    }

    @SneakyThrows
    @Override
    public Field[] getFieldsWithAnnotation(Class<?> cls, Class<? extends Annotation> annotationCls) {
        if (cls == null || annotationCls == null)
            throw new NullPointerException();
        Field[] fields = cls.getDeclaredFields();
        List<Field> fieldsWithAnnotation = new ArrayList<>();
        for (Field f : fields) {
            if (f.isAnnotationPresent(annotationCls))
                fieldsWithAnnotation.add(f);
        }
        Field[] fieldsArray = new Field[fieldsWithAnnotation.size()];
        for (int i = 0; i < fieldsArray.length; i++) {
            fieldsArray[i] = fieldsWithAnnotation.get(i);
        }
        return fieldsArray;
    }
}
