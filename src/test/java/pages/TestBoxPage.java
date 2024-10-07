package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestBoxPage {
    public SelenideElement
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitClick = $("#submit"),
            textCheck =  $(".col-md-12");

    public TestBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()"); //убрать окна и баннеры
        executeJavaScript("$('footer').remove()"); //убрать окна и баннеры

    return this;
}
    public TestBoxPage setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }
    public TestBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    public TestBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }
    public TestBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }
    public void submitClick() {
        submitClick.click();

    }
    public TestBoxPage checkResult(String key, String value) {
        textCheck.shouldHave(text(value));

        return this;
    }
}