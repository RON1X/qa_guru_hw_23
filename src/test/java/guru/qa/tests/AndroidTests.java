package guru.qa.tests;


import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class AndroidTests extends TestBase {

    @Test
    @DisplayName("Прохождение онбординга")
    @Tag("android")
    void onboardingTest() {
        step("Открыта 1-ая страница онбординга", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });
        step("Нажать continue", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Открыта 2-ая страница онбординга", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"));
        });
        step("Нажать continue", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Открыта 3-ая страница онбординга", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync"));
        });
        step("Нажать continue", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Открыта 4-ая страница онбординга", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Send anonymous data"));
        });
        step("Нажать Accept", () -> {
            $(id("org.wikipedia.alpha:id/acceptButton")).click();
        });
        step("Открыта вкладка Explore", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/navigation_bar_item_large_label_view")).shouldHave(text("Explore"));
        });
    }
}