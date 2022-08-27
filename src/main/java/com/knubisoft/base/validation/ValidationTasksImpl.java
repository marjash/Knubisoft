package com.knubisoft.base.validation;

public class ValidationTasksImpl implements ValidationTasks {

    @Override
    public void validate(Object instance) {

    }

    @Override
    public User buildUser() {
        User user = new User();
        user.setId(1L);
        return null;
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
