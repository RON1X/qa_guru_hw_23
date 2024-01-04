package guru.qa.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static io.appium.java_client.AppiumBy.name;


public class IosTests extends TestBase {
    @Test
    @Tag("ios")
    void visibleMainPageTest() {
        step("Check main page", () -> {
            $(name("Alert")).shouldBe(visible);
            $(name("Text")).shouldBe(visible);
        });
    }
}