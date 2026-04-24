package tests.exemple;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import testData.TestData;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testData.TestData.*;


public class PageFormTest extends TestBase {

    @Test
    void positiveForm() {
        open (baseUrl+"/automation-practice-form/");
        $("[data-testid='ClearIcon']").click();
        $("input[data-testid='firstName']").setValue(firstName);
        $("input[data-testid='lastName']").setValue(lastName);
        $("input[data-testid='email']").setValue(email);
        $("input[data-testid='phone']").setValue(TestData.phone);
        $("div[class=\"MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb\"]").click();
        $$("[data-value ='Russian']").findBy(text("Russian")).click();
        $$(".MuiFormControlLabel-root").findBy(text("Male")).click();
        $$(".MuiFormControlLabel-root").findBy(text("Music")).click();
        $("div[aria-controls=':r8:']").click();
        $("li[data-value ='Arts']").click();
        $("li[data-value ='Arts']").pressEscape();
        $("div[aria-controls=':r9:']").click();
        $$("li[data-value='Delaware']").findBy(text("Delaware")).click();
        $$(".MuiFormControl-root").findBy(text("Wilmington")).click();
        $("input[aria-valuenow='0']").setValue("10");

        $("textarea[data-testid='address']").setValue("Качан");
        $("div[class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-adornedEnd css-hnugqc']").click();
        $("input[data-testid='dateOfBirth']").click();
        $("input[data-testid='dateOfBirth']").sendKeys("12121993");
        $("input[type='file']").uploadFromClasspath("43321174-68799a9f1df8a.jpg");
        $("span[class='MuiTouchRipple-root css-w0pj6f']").scrollTo();
        $("button[class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary css-lm5zpm']").click();
        $("h4[class='MuiTypography-root MuiTypography-h4 css-rq8zac']").shouldHave(text("Thank you for submitting the form\n"));

        $(By.xpath("//p[text()='firstName']/following::p[1]")).scrollTo().shouldBe(visible).shouldHave(text(firstName));
        $(By.xpath("//p[text()='lastName']/following::p[1]")).shouldHave(text(lastName));
        $(By.xpath("//p[text()='email']/following::p[1]")).scrollTo().shouldHave(text(TestData.email));
        $(By.xpath("//p[text()='phone']/following::p[1]")).shouldHave(text(phone));
        $(By.xpath("//p[text()='dateOfBirth']/following::p[1]")).shouldHave(text(dateOfbirth));
        $(By.xpath("//p[text()='subjects']/following::p[1]")).shouldHave(text(subject));
        $(By.xpath("//p[text()='hobbies']/following::p[1]")).shouldHave(text(hobbies));
        $(By.xpath("//p[text()='slider']/following::p[1]")).shouldHave(text("50"));
        $(By.xpath("//p[text()='language']/following::p[1]")).shouldHave(text(language));
        $(By.xpath("//p[text()='address']/following::p[1]")).shouldHave(text(address));
        $(By.xpath("//p[text()='file']/following::p[1]")).shouldHave(text("43321174-68799a9f1df8a.jpg"));


    }
    @Test
    void resetButtom() {
        open (baseUrl+"/automation-practice-form/");
        $("[data-testid='ClearIcon']").click();
        $("input[data-testid='firstName']").setValue((firstName));
        $("span[class='MuiTouchRipple-root css-w0pj6f']").scrollTo();
        $("button[class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorSecondary MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorSecondary css-173njfa']").click();
        $("input[data-testid='firstName']").shouldNotHave(text(firstName));
        System.out.println("ds");
    }

    @Test
    void firsNameSymbolLittle() {
        open (baseUrl+"/automation-practice-form/");
        $("[data-testid='ClearIcon']").click();
        $("input[data-testid='firstName']").setValue("Br");
        $("p[class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeMedium MuiFormHelperText-contained css-a3adt4']").shouldHave(text("First Name must be at least 3 symbols long"));

    }

    @Test
    void firstNameSymbolLong () {
        open (baseUrl+"/automation-practice-form/");
        $("[data-testid='ClearIcon']").click();
        $("input[data-testid='firstName']").setValue("Brhgfyjhfvjhbhjhiukkhjujb");
        $("p[class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeMedium MuiFormHelperText-contained css-a3adt4']").shouldHave(text("First Name must be less than 15 symbols long"));




    }

}
