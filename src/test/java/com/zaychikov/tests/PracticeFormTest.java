package com.zaychikov.tests;

import com.zaychikov.pages.Calendar;
import com.zaychikov.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.zaychikov.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class PracticeFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationPage closeModalWindowButton = new RegistrationPage();
    Calendar calendar = new Calendar();

    @Test
    void practiceFormTest() {
        step("Open page: https://demoqa.com/automation-practice-form", () -> {
            registrationPage.openPage();
        });
        step("Type firstname", () -> {
            registrationPage.typeFirstName(firstName);
        });
        step("Type lastname", () -> {
            registrationPage.typeLastName(lastName);
        });
        step("Type user email", () -> {
            registrationPage.typeUserEmail(userEmail);
        });
        step("Type user mobile number", () -> {
            registrationPage.typeMobileNumber(userNumber);
        });
        step("Type user gender", () -> {
            registrationPage.typeGender(userGender);
        });
        step("Type user Birthday", () -> {
            calendar.selectDateOfBirth();
        });
        step("Type user subjects", () -> {
            registrationPage.typeSubjects(userSubjects);
        });
        step("Type user hobbies", () -> {
            registrationPage.typeHobbies(userHobbies);
        });
        step("Type user City", () -> {
            registrationPage.typeUserCity(userCity);
        });
        step("Type user State", () -> {
            registrationPage.typeState(userState);
        });
        step("Type user City of State", () -> {
            registrationPage.typeCityOfState(userCityOfState);
        });

        //Проверяем правильность заполнения
        step("Check results of filling in", () -> {
            $(".table-responsive").shouldHave(
                    text(firstName + " " + lastName),
                    text(userEmail),
                    text(userGender),
                    text(userNumber),
                    text("07 October,1991"),
                    text(userSubjects),
                    text(userHobbies),
                    text(userCity),
                    text(userState + " " + userCityOfState));
        });

        //Закрываем модальное окно с результатами заполнения после сверки
        step("Close modal window", () -> {
            closeModalWindowButton.closeModalWindow();
        });
    }
}
