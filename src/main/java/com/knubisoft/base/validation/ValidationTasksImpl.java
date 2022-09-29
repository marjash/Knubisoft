package com.knubisoft.base.validation;

import com.knubisoft.base.validation.annotationimpl.AnnotationTracker;

import java.util.ArrayList;
import java.util.List;

public class ValidationTasksImpl implements ValidationTasks {

    @Override
    public boolean validate(Object instance) {
        AnnotationTracker tracker = new AnnotationTracker();
        if (!tracker.trackEntity(instance.getClass()))
            return false;
        return tracker.trackNotNull(instance) && tracker.trackMaxLength(instance) &&
                tracker.trackPrimaryKey(instance) && tracker.trackReferClass(instance);
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
        user.setFkUserGeneralDetails(2L);
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
        userGeneralDetails.setFkUserAddressDetails(2L);
        return userGeneralDetails;
    }

    @Override
    public UserAddressDetails buildUserAddressDetails() {
        UserAddressDetails userAddressDetails = new UserAddressDetails();
        userAddressDetails.setId(1L);
        userAddressDetails.setZipCode("81100");
        userAddressDetails.setStreet("Kotlyarevskoho");
        userAddressDetails.setNumberOfHouse("35");
        return userAddressDetails;
    }
}
