package tests.exemple;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import testData.TestData;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testData.TestData.email;
import static testData.TestData.lastName;


public class PageFormTest extends TestBase {

    @Test
    void positiveForm() {
        open (baseUrl+"/automation-practice-form/");
        $("[data-testid='ClearIcon']").click();
        $("input[data-testid='firstName']").setValue(TestData.firstName);
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




        $("[class='MuiGrid-root MuiGrid-container MuiGrid-wrap-xs-nowrap css-1gya3ze']").shouldHave(text("Drake"));
        $("[class='MuiGrid-root MuiGrid-container MuiGrid-wrap-xs-nowrap css-1gya3ze']").shouldHave(text("Lower"));
        $("[class='MuiTypography-root MuiTypography-body1 css-1qye57c']").shouldHave(text("plackplackkutac@mail.com"));
        $("[class='MuiTypography-root MuiTypography-body1 css-1qye57c']").shouldHave(text("Female"));
        $("[class='MuiTypography-root MuiTypography-body1 css-1qye57c']").shouldHave(text("+1 333 444 5555\n"));
        $("[class='MuiTypography-root MuiTypography-body1 css-1qye57c']").shouldHave(text("12/12/1993"));
        $("[class='MuiTypography-root MuiTypography-body1 css-1qye57c']").shouldHave(text("Arts"));
        $("[class='MuiTypography-root MuiTypography-body1 css-1qye57c']").shouldHave(text("Music"));
        $("[class='MuiTypography-root MuiTypography-body1 css-1qye57c']").shouldHave(text("50"));
        $("[class='MuiTypography-root MuiTypography-body1 css-1qye57c']").shouldHave(text("Russian"));
        $("[class='MuiTypography-root MuiTypography-body1 css-1qye57c']").shouldHave(text("Качан"));
        $("[class='MuiTypography-root MuiTypography-body1 css-1qye57c']").shouldHave(text("43321174-68799a9f1df8a.jpg"));






    }
    @Test
    void resetButtom() {
        open (baseUrl+"/automation-practice-form/");
        $("[data-testid='ClearIcon']").click();
        $("input[data-testid='firstName']").setValue((TestData.firstName));
        $("span[class='MuiTouchRipple-root css-w0pj6f']").scrollTo();
        $("button[class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorSecondary MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorSecondary css-173njfa']").click();
        $("input[data-testid='firstName']").shouldNotHave(text("Drake"));
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
