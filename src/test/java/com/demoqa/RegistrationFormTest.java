package com.demoqa;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationFormTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTestWithFullData() {

        //Open page, fill in form and submit
        registrationPage.openPage()
                .killBanners()
                .setFirstName("Piotr")
                .setLastName("Kurochkin")
                .setEmail("kura@gmail.com")
                .setGenderArea("Male")
                .setMobileNumber("2020327000")
                .setDateOfBirth("20", "September", "1994")
                .setSubject("Hindi")
                .setSubject("Computer Science")
                .setSubject("Economics")
                .setHobbies("Reading")
                .setHobbies("Music")
                .uploadPicture("branch.jpg")
                .setCurrentAddress("str. Jenkins 15, 7, 98-452")
                .setState("Haryana")
                .setCity("Panipat")
                .submit();

        //Verify values
        registrationPage.verifyTableIsAppeared()
                .verifyInfoInFinalTable("Student Name", "Piotr Kurochkin")
                .verifyInfoInFinalTable("Student Email", "kura@gmail.com")
                .verifyInfoInFinalTable("Gender", "Male")
                .verifyInfoInFinalTable("Mobile", "2020327000")
                .verifyInfoInFinalTable("Date of Birth", "20 September,1994")
                .verifyInfoInFinalTable("Subjects", "Hindi, Computer Science, Economics")
                .verifyInfoInFinalTable("Hobbies", "Reading, Music")
                .verifyInfoInFinalTable("Picture", "branch.jpg")
                .verifyInfoInFinalTable("Address", "str. Jenkins 15, 7, 98-452")
                .verifyInfoInFinalTable("State and City", "Haryana Panipat");
    }

    @Test
    void successfulRegistrationTestWithMinimalData() {

        //Open page, fill in form and submit
        registrationPage.openPage()
                .killBanners()
                .setFirstName("Piotr")
                .setLastName("Kurochkin")
                .setGenderArea("Male")
                .setMobileNumber("2020327000")
                .submit();

        //Verify values
        registrationPage.verifyTableIsAppeared()
                .verifyInfoInFinalTable("Student Name", "Piotr Kurochkin")
                .verifyInfoInFinalTable("Gender", "Male")
                .verifyInfoInFinalTable("Mobile", "2020327000");
    }

    @Test
    void tryingToRegisterWithoutSelectingGender() {

        //Open page, fill in form and submit
        registrationPage.openPage()
                .killBanners()
                .setFirstName("Piotr")
                .setLastName("Kurochkin")
                .setMobileNumber("2020327000")
                .submit();

        //Verify table with data is not appeared and gender area borders became red
        registrationPage.verifyTableIsNotAppeared()
                .verifyGenderOptionsAreRed();
    }

    @Test
    void tryingToRegisterWithoutDefiningNumber() {

        //Open page, fill in form and submit
        registrationPage.openPage()
                .killBanners()
                .setFirstName("Piotr")
                .setLastName("Kurochkin")
                .setGenderArea("Male")
                .submit();

        //Verify table with data is not appeared and mobile number field borders became red
        registrationPage.verifyTableIsNotAppeared()
                .verifyMobileNumberFieldIsRed();
    }
}
