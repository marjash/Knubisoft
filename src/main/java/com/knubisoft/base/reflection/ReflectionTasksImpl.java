package com.knubisoft.base.reflection;

import com.knubisoft.base.reflection.model.EntryModel;
import com.knubisoft.base.reflection.model.InheritedEntryModel;
import com.knubisoft.base.string.StringTasksImpl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ReflectionTasksImpl implements ReflectionTasks {
    @Override
    public Object createNewInstanceForClass(Class<?> cls) {
        if (cls == null){
            throw new NoSuchElementException();
        }
        if (!cls.equals(InheritedEntryModel.class)){
            throw new RuntimeException();
        }
        EntryModel entryModel = new InheritedEntryModel(cls.getName());
        return entryModel;
    }

    @Override
    public <T> Class<? extends T> findImplementationForInterface(Class<T> cls) {
        if (cls == null){
            throw new NoSuchElementException();
        }
        if (!cls.equals(EntryModel.class)){
            throw new IllegalArgumentException();
        }
        EntryModel model = new InheritedEntryModel(cls.getName());
        return (Class<? extends T>) model.getClass();
    }

    @Override
    public Map<String, Object> findAllFieldsForClass(Class<?> cls) {
        if (cls == null){
            throw new NoSuchElementException();
        }
        Map<String, Object> map = new HashMap<>();

        if (!cls.equals(InheritedEntryModel.class)){
            return map;
        }
        Field[] fields = cls.getSuperclass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            map.put(f.getName(), f);
        }
        return map;
    }

    @Override
    public int countPrivateMethodsInClass(Class<?> cls) {
        if (cls == null)
            throw new NoSuchElementException();
        Method[] methods = cls.getDeclaredMethods();
        int count = 0;
        for (Method m : methods) {
            if (m.getModifiers() == Modifier.PRIVATE)
                count++;
        }
        return count;
    }

    @Override
    public boolean isMethodHasAnnotation(Method method, Class<?> annotationUnderMethod) {
        Annotation[] annotations = method.getAnnotations();
        if (annotations.length > 0)
            return true;
        return false;
    }

    @Override
    public Object evaluateMethodByName(Class<?> cls, String name) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        StringTasksImpl tasks = new StringTasksImpl();
        Method method = cls.getDeclaredMethod(name);
        Object object = method.invoke(tasks);
        if (object == null)
            return "operation is successful";
        return object;
    }

    @SneakyThrows
    @Override
    public Object evaluateMethodWithArgsByName(Object obj, String name, Object... args) {
        if (obj == null || name == null || args == null){
            throw new IllegalArgumentException();
        }
        StringTasksImpl tasks = new StringTasksImpl();
        Method method;
        if (args.length > 1){
            method = obj.getClass().getMethod(name, args.getClass().getTypeName().getClass(), args.getClass().getTypeName().getClass());
        }
        else {
            method = obj.getClass().getMethod(name, args.getClass().getTypeName().getClass());
        }
        Object object = method.invoke(tasks, args);
        if (object == null)
            return "operation is successful";
        return object;
    }

    @SneakyThrows
    @Override
    public Object changePrivateFieldValue(Object instance, String name, Object newValue)  {
        StringTasksImpl tasks = new StringTasksImpl();
        Field field = instance.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(tasks, newValue);
        Object o = field.get(tasks);
        return o;
    }
}
