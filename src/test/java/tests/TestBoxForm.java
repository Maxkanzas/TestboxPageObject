package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxForm {
    @BeforeAll
    public static void beforeAll()
    {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager"; // команда для того, чтобы селенид не ждал загрузки всех картинок и тяжелых элементов. Только html.
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }
    @Test
    void positiveTest() {
        open("/text-box"); // открываем страницу Selenide в GitHub (относительный путь)
//        executeJavaScript("$('#fixedban').remove()"); //убрать окна и баннеры
//        executeJavaScript("$('footer').remove()"); //убрать окна и баннеры

        $("#userName").setValue("Max ivanov");
        $("#userEmail").setValue("synch@mail.ru");
        $("#currentAddress").setValue("Street Lubyanka 11");
        $("#permanentAddress").setValue("Street Sovetskya 96");
        $("#submit").click();

        $(".col-md-12").$("#name").shouldHave(text("Max ivanov"));
        $(".col-md-12").$("#email").shouldHave(text("synch@mail.ru"));
        $(".col-md-12").$("#currentAddress").shouldHave(text("Street Lubyanka 11"));
        $(".col-md-12").$("#permanentAddress").shouldHave(text("Street Sovetskya 96"));
    }
}
