package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest extends BaseTest {

    @Test
    void successfulRegistrationTestWithFullData() {
        open("/automation-practice-form");

        //Kill banners and footers
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //Setup first Name
        $("#firstName").setValue("Piotr");
        //Setup last Name
        $("#lastName").setValue("Kurochkin");
        //Setup email
        $("#userEmail").setValue("kura@gmail.com");
        //Setup gender
        $("#genterWrapper").$(byText("Male")).click();
        //Setup mobile
        $("#userNumber").setValue("2020327000");
        //Setup date of birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("September");
        $(".react-datepicker__year-select").selectOptionContainingText("1994");
        $(".react-datepicker__day--020").click();

        //Setup subjects input - 3 items
        $("#subjectsContainer input").setValue("Hindi").pressEnter();
        $("#subjectsContainer input").setValue("Computer Science").pressEnter();
        $("#subjectsContainer input").setValue("Economics").pressEnter();

        //Setup hobbies
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        //Setup picture
        $("#uploadPicture").uploadFromClasspath("branch.jpg");
        //Setup current address
        $("#currentAddress").setValue("str. Jenkins 15, 7, 98-452");
        //Setup State
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        //Setup City
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        //Submit
        $("#submit").click();


        //Verify values
        $("tbody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Piotr Kurochkin"));
        $("tbody tr:nth-child(2) td:nth-child(2)").shouldHave(text("kura@gmail.com"));
        $("tbody tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $("tbody tr:nth-child(4) td:nth-child(2)").shouldHave(text("2020327000"));
        $("tbody tr:nth-child(5) td:nth-child(2)").shouldHave(text("20 September,1994"));
        $("tbody tr:nth-child(6) td:nth-child(2)").shouldHave(text("Hindi, Computer Science, Economics"));
        $("tbody tr:nth-child(7) td:nth-child(2)").shouldHave(text("Reading, Music"));
        $("tbody tr:nth-child(8) td:nth-child(2)").shouldHave(text("branch.jpg"));
        $("tbody tr:nth-child(9) td:nth-child(2)").shouldHave(text("str. Jenkins 15, 7, 98-452"));
        $("tbody tr:nth-child(10) td:nth-child(2)").shouldHave(text("Haryana Panipat"));
    }

    @Test
    void successfulRegistrationTestWithMinimalData() {

    }

    @Test
    void unSuccessfulRegistrationTest() {

    }
}
