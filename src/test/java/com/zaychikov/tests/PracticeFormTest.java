package com.zaychikov.tests;

import com.zaychikov.pages.Calendar;
import com.zaychikov.pages.RegistrationPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.zaychikov.tests.TestData.*;

public class PracticeFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationPage closeModalWindowButton = new RegistrationPage();
    Calendar calendar = new Calendar();

    @Description(value = "Проверка заполнения данных студента для: https://demoqa.com/automation-practice-form")
    @Feature(value = "automation-practice-form")
    @Story(value = "Заполнить и проверить форму с данными студента")
    @DisplayName("Проверка заполнения данных студента")
    @Test
    @Tag("practiceFormTest")
    void practiceFormTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeUserEmail(userEmail);
        registrationPage.typeMobileNumber(userNumber);
        registrationPage.typeGender(userGender);
        calendar.selectDateOfBirth();
        registrationPage.typeSubjects(userSubjects);
        registrationPage.typeHobbies(userHobbies);
        registrationPage.typeUserCity(userCity);
        registrationPage.typeState(userState);
        registrationPage.typeCityOfState(userCityOfState);

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

        closeModalWindowButton.closeModalWindow();
    }
}
