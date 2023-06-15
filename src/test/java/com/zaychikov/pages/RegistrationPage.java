package com.zaychikov.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            mobileNumberInput = $("#userNumber"),
            genderInput = $("#genterWrapper"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            userCityInput = $("#currentAddress"),
            stateSelector = $("#state"),
            stateInput = $("#state"),
            citySelector = $("#city"),
            cityOfStateInput = $("#react-select-4-input"),
            closeModalWindowSelector = $("#closeLargeModal");

    @Step("Открыть сайт: https://demoqa.com/automation-practice-form")
    public void openPage() {
        open("/automation-practice-form");
    }

    @Step("Заполнить Имя")
    public void typeFirstName(String value) {
        firstNameInput.setValue(value);
    }

    @Step("Заполнить Фамилию")
    public void typeLastName(String value) {
        lastNameInput.setValue(value);
    }

    @Step("Заполнить почту")
    public void typeUserEmail(String value) {
        emailInput.setValue(value);
    }

    @Step("Заполнить телефон")
    public void typeMobileNumber(String value) {
        mobileNumberInput.setValue(value);
    }

    @Step("Выбрать гендер")
    public void typeGender(String userGender) {
        genderInput.$(byText("Male")).click();
    }

    @Step("Выбрать предмет")
    public void typeSubjects(String value) {
        subjectInput.setValue(value).pressEnter();
    }

    @Step("Выбрать хобби")
    public void typeHobbies(String userHobbies) {
        hobbiesInput.$(byText("Sports")).click();
    }

    @Step("Заполнить улицу, дом")
    public void typeUserCity(String value) {
        userCityInput.setValue(value);
    }

    @Step("Заполнить Штат")
    public void typeState(String userState) {
        stateSelector.scrollTo().click();
        stateInput.$(byText("NCR")).click();
    }

    @Step("Заполнить Город")
    public void typeCityOfState(String value) {
        citySelector.click();
        cityOfStateInput.setValue(value).pressEnter().pressEnter();
    }

    @Step("Закрыть модальное окно результатов")
    public void closeModalWindow() {
        closeModalWindowSelector.click();
    }
}
