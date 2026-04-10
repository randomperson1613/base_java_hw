package tests.exemple;


import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
      //  Configuration.browserVersion = "145.0";
        Configuration.browserSize = "1800x1800";
        Configuration.baseUrl = "https://app.qa.guru";
        Configuration.timeout = 4000;
       // Configuration.pageLoadStrategy = "eager";


    }
}
