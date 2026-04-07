package tests.exemple;
import org.junit.jupiter.api.Test;
import testData.TestData;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class PageFormTest extends TestConfig{

    @Test
    void positiveForm() {
        open ("https://app.qa.guru/automation-practice-form/");
        $("[data-testid='ClearIcon']").click();
        $("input[data-testid='firstName']").setValue(TestData.firstName);
        $("input[data-testid='lastName']").setValue(TestData.lastName);
        $("input[data-testid='email']").setValue(TestData.email);
        $("input[data-testid='phone']").setValue(TestData.phone);
        $("div[class=\"MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb\"]").click();
        $("[data-value ='Russian']").click();
        $("input[value='Male']").click();
        $("input[value='Music']").click();
        $("div[aria-controls=':r8:']").click();
        $("li[data-value ='Arts']").click();
        $("li[data-value ='Arts']").pressEscape();
        $("div[aria-controls=':r9:']").click();
        $("li[data-value='Delaware']").click();
        $("select[data-testid='stateCity']").click();
        $("input[aria-valuenow='0']").setValue("40");
        $("textarea[data-testid='address']").setValue("Качан");
        $("div[class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-adornedEnd css-hnugqc']").click();
        $("input[data-testid='dateOfBirth']").click();
        $("input[data-testid='dateOfBirth']").sendKeys("12121993");
        File test=new File("src/test/java/tests/exemple/43321174-68799a9f1df8a.jpg");
        $("input[type='file']").uploadFile(test);
        $("span[class='MuiTouchRipple-root css-w0pj6f']").scrollTo();
        $("button[class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary css-lm5zpm']").click();
        $("h4[class='MuiTypography-root MuiTypography-h4 css-rq8zac']").shouldHave(text("Thank you for submitting the form\n"));


    }
    @Test
    void ResetButtom() {
        open ("https://app.qa.guru/automation-practice-form/");
        $("[data-testid='ClearIcon']").click();
        $("input[data-testid='firstName']").setValue((TestData.firstName));
        $("span[class='MuiTouchRipple-root css-w0pj6f']").scrollTo();
        $("button[class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorSecondary MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorSecondary css-173njfa']").click();
        $("input[data-testid='firstName']").shouldNotHave(text("Drake"));
        System.out.println("ds");
    }

    @Test
    void FirsNameSymbolLittle() {
        open ("https://app.qa.guru/automation-practice-form/");
        $("[data-testid='ClearIcon']").click();
        $("input[data-testid='firstName']").setValue("Br");
        $("p[class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeMedium MuiFormHelperText-contained css-a3adt4']").shouldHave(text("First Name must be at least 3 symbols long"));

    }

    @Test
    void FirstNameSymbolLong () {
        open ("https://app.qa.guru/automation-practice-form/");
        $("[data-testid='ClearIcon']").click();
        $("input[data-testid='firstName']").setValue("Brhgfyjhfvjhbhjhiukkhjujb");
        $("p[class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeMedium MuiFormHelperText-contained css-a3adt4']").shouldHave(text("First Name must be less than 15 symbols long"));






    }

}
