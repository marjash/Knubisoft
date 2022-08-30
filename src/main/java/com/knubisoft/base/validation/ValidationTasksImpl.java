package com.knubisoft.base.validation;

import com.knubisoft.base.validation.annotation.MaxLengthTracker;
import org.checkerframework.checker.units.qual.Length;

public class ValidationTasksImpl implements ValidationTasks {

    @Override
    public boolean validate(Object instance) {
        MaxLengthTracker maxLengthTracker = new MaxLengthTracker();
//        Class<?> cls = instance.getClass();
        return maxLengthTracker.trackMaxLength(instance);
    }


    @Override
    public User buildUser() {
        User user = new User();
        user.setId(1L);
        user.setName("Ivannnnnnn");
        user.setSurname("Mazepaaaaaaaaaaa");
        user.setMarried(true);
        user.setCountOfChildren(2);
        user.setCountOfPets(2);
        user.setFkUserGeneralDetails(5L);
        return user;
    }

    @Override
    public UserGeneralDetails buildUserGeneralDetails() {
        return null;
    }

    @Override
    public UserAddressDetails buildUserAddressDetails() {
        return null;
    }
}
