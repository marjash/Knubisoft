package com.knubisoft.tasks.algorithm.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorUtilsImpl implements ConstructorUtils{
    @Override
    public <T> T invokeConstructor(Class<T> cls, Object... args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (cls == null || args == null)
            return null;
        Constructor<?>[] constructors = cls.getConstructors();
        Class<?>[] classes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            classes[i] = args[i].getClass();
        }
        return null;
    }

    @Override
    public <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>... parameterTypes) {
        return null;
    }
}
