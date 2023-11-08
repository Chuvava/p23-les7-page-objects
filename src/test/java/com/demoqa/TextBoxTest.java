package com.demoqa;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxTest extends BaseTest {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    public void successfulSubmittingForm() {

        //Open page, fill all fields and submit
        textBoxPage.openPage()
                .setFullName("Sir Alex Ferguson")
                .setEmail("mu1900@gmail.com")
                .setCurrentAddress("Manchester, Old Trafford")
                .setPermanentAddress("Manchester, Old Trafford")
                .submit();

        //Verify values
        textBoxPage.verifyOutputValue("Name", "Sir Alex Ferguson")
                .verifyOutputValue("Email", "mu1900@gmail.com")
                .verifyOutputValue("Current Address", "Manchester, Old Trafford")
                .verifyOutputValue("Permananet Address", "Manchester, Old Trafford");
    }
}
