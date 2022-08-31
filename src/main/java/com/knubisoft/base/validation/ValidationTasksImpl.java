package com.knubisoft.base.validation;

import com.knubisoft.base.validation.annotationimpl.AnnotationTracker;

public class ValidationTasksImpl implements ValidationTasks {

    @Override
    public boolean validate(Object instance) {
        AnnotationTracker annotationTracker = new AnnotationTracker();
        if (!annotationTracker.trackEntity(instance.getClass()))
            return false;
        return annotationTracker.trackNotNull(instance) && annotationTracker.trackMaxLength(instance);
    }


    @Override
    public User buildUser() {
        User user = new User();
        user.setId(1L);
        user.setName("Ivan");
        user.setSurname("Mazepa");
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
