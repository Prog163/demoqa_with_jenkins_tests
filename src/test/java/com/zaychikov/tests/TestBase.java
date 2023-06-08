package com.zaychikov.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterAll
    static void afterAll() {
        //Оставляю браузер открытым для проверки введённых значений, т.к. он закрывается автоматически
        Configuration.holdBrowserOpen = true;
    }
}