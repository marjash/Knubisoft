package com.knubisoft.tasks.algorithm.reflection;

import com.knubisoft.base.validation.ValidationTasks;
import com.knubisoft.base.validation.annotation.MaxLength;
import lombok.SneakyThrows;
import net.minidev.asm.ex.NoSuchFieldException;
import org.junit.jupiter.api.Test;

import java.io.ObjectStreamField;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FieldUtilsImplTest {

    private final FieldUtils fieldUtils = new FieldUtilsImpl();

    @Test
    void getFieldSuccess() {
        Field[] fields = String.class.getFields();
        assertEquals(fields[0],  fieldUtils.getField(String.class, "CASE_INSENSITIVE_ORDER"));
    }

    @Test
    void getFieldFail(){
        assertThrows(NullPointerException.class, () -> fieldUtils.getField(null, "null"));
        assertThrows(NoSuchFieldException.class, () -> fieldUtils.getField(String.class, ""));
        assertThrows(NoSuchFieldException.class, () -> fieldUtils.getField(Object.class, ""));

    }

    @Test
    void testGetField() {
        Field[] fields = String.class.getFields();
        assertEquals(fields[0],  fieldUtils.getField(String.class, "CASE_INSENSITIVE_ORDER", true));
    }

    @Test
    void getDeclaredField() {
        Field[] declaredFields = String.class.getDeclaredFields();
        assertEquals(declaredFields[0],  fieldUtils.getDeclaredField(String.class, "value"));
    }

    @SneakyThrows
    @Test
    void getAllFields() {
        assertEquals(String.class.getDeclaredField("value"),  fieldUtils.getDeclaredField(String.class, "value"));
    }

    @Test
    void getFieldsWithAnnotationSuccess() {
        assertEquals(2, fieldUtils.getFieldsWithAnnotation(ValidationTasks.User.class, MaxLength.class).length);
    }

    @Test
    void getFieldsWithAnnotationFail(){
        assertThrows(NullPointerException.class, () -> fieldUtils.getFieldsWithAnnotation(null, MaxLength.class));
        assertThrows(NullPointerException.class, () -> fieldUtils.getFieldsWithAnnotation(ValidationTasks.User.class, null));
    }
}