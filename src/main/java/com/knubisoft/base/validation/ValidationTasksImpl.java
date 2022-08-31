package com.knubisoft.base.validation;

import com.knubisoft.base.validation.annotationimpl.AnnotationTracker;

import java.util.ArrayList;
import java.util.List;

public class ValidationTasksImpl implements ValidationTasks {

    @Override
    public boolean validate(Object instance) {
        AnnotationTracker annotationTracker = new AnnotationTracker();
        if (!annotationTracker.trackEntity(instance.getClass()))
            return false;
        return annotationTracker.trackNotNull(instance) && annotationTracker.trackMaxLength(instance) &&
                annotationTracker.trackPrimaryKey(instance);
    }

    List<User> users = new ArrayList<>();


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
        UserGeneralDetails userGeneralDetails = new UserGeneralDetails();
        userGeneralDetails.setId(2L);
        userGeneralDetails.setPreviousProfession("driver");
        userGeneralDetails.setCountry("Ukraine");
        userGeneralDetails.setOblast("Lvivska");
        userGeneralDetails.setCity("Lviv");
        userGeneralDetails.setFkUserAddressDetails(1L);
        return userGeneralDetails;
    }

    @Override
    public UserAddressDetails buildUserAddressDetails() {
        return null;
    }
}
