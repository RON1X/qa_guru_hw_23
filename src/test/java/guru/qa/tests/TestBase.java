package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.drivers.BrowserstackDriver;
import guru.qa.drivers.LocalDriver;
import guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        switch (System.getProperty("deviceHost")) {
            case "browserstack" -> {
                Configuration.browser = BrowserstackDriver.class.getName();
            }
            case "local" -> {
                Configuration.browser = LocalDriver.class.getName();
            }
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        closeWebDriver();
        /*if (System.getProperty("deviceHost").equals("browserstack")) { TODO разобраться с ошибкой
            Attach.addVideo(sessionId().toString());
        }*/
    }
}