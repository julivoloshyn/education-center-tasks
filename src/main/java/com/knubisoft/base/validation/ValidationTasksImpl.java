package com.knubisoft.base.validation;

public class ValidationTasksImpl implements ValidationTasks {

    @Override
    public boolean validate(Object instance) {
        AnnotationCheck checker = new AnnotationCheck();
        if (!checker.trackEntity(instance.getClass()))
            return false;
        return checker.trackNotNull(instance) && checker.trackMaxLength(instance) &&
                checker.trackPrimaryKey(instance) && checker.trackReferClass(instance);
    }

    @Override
    public User buildUser() {
        User user = new User();
        user.setId(1L);
        user.setName("Yulia");
        user.setSurname("Voloshyna");
        user.setMarried(true);
        user.setCountOfChildren(1);
        user.setCountOfPets(4);
        user.setFkUserGeneralDetails(1L);
        return user;
    }

    @Override
    public UserGeneralDetails buildUserGeneralDetails() {
        UserGeneralDetails userGeneralDetails = new UserGeneralDetails();
        userGeneralDetails.setId(2L);
        userGeneralDetails.setPreviousProfession("programmer");
        userGeneralDetails.setCountry("Ukraine");
        userGeneralDetails.setOblast("Kyivska");
        userGeneralDetails.setCity("Kyiv");
        userGeneralDetails.setFkUserAddressDetails(2L);
        return userGeneralDetails;
    }

    @Override
    public UserAddressDetails buildUserAddressDetails() {
        UserAddressDetails userAddressDetails = new UserAddressDetails();
        userAddressDetails.setId(1L);
        userAddressDetails.setZipCode("123456");
        userAddressDetails.setStreet("Harmatna");
        userAddressDetails.setNumberOfHouse("38");
        return userAddressDetails;
    }
}
