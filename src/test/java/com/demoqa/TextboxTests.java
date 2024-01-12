package com.demoqa;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextboxTests {
    @BeforeAll
    static void configureBrowser() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
//        Configuration.browser = FIREFOX;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successTest(){
        open("/text-box");
        $("#userName").setValue("Alex Maximov");
        $("#userEmail").setValue("AlMax@mail.ru");
        $("#currentAddress").setValue("address 1");
        $("#permanentAddress").setValue("address 2");
        $("#submit").click();
        $("#output #name").shouldHave(text("Alex Maximov"));
        $("#output #email").shouldHave(text("AlMax@mail.ru"));
        $("#output #currentAddress").shouldHave(text("address 1"));
        $("#output #permanentAddress").shouldHave(text("address 2"));
    }
}