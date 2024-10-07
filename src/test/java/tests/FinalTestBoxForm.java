package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TestBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FinalTestBoxForm extends TestBase {

    TestBoxPage testboxPage = new TestBoxPage();

    @Test
    void positiveTest() {
        testboxPage
                .openPage()
                .setUserName("Max ivanov")
                .setUserEmail("synch@mail.ru")
                .setCurrentAddress("Street Lubyanka 11")
                .setPermanentAddress("Street Sovetskya 96")
                .submitClick();

        testboxPage
                .checkResult("UserName", "Max ivanov")
                .checkResult("Email", "synch@mail.ru")
                .checkResult("CurrentAddress", "Street Lubyanka 11")
                .checkResult("PermanentAddress", "Street Sovetskya 96");

    }
}
