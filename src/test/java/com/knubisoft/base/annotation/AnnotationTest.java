package com.knubisoft.base.annotation;

import com.knubisoft.base.validation.ValidationTasks;
import com.knubisoft.base.validation.ValidationTasksImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnnotationTest {

    ValidationTasks instance = new ValidationTasksImpl();

    @Test
    public void maxLengthSuccessful(){
        assertTrue(instance.validate(instance.buildUserAddressDetails()));
        assertFalse(instance.validate(instance.buildUserGeneralDetails()));
        assertTrue(instance.validate(instance.buildUser()));
    }
}
