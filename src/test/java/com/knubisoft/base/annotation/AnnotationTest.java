package com.knubisoft.base.annotation;

import com.knubisoft.base.validation.ValidationTasks;
import com.knubisoft.base.validation.ValidationTasksImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnnotationTest {

    ValidationTasks instance = new ValidationTasksImpl();

    @Test
    public void maxLengthSuccessful(){

        ValidationTasks.User user = instance.buildUser();
//        assertTrue(instance.validate(user));
        assertFalse(instance.validate(user));
    }
}
