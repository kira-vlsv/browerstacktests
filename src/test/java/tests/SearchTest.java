package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

class SearchTest extends BaseTest {

    @Test
    @DisplayName("Test search field in wikipedia app")
    void successfulSearchTest() {
        step("Open wikipedia app and search by text 'Appium'", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                    .shouldHave(sizeGreaterThan(0));
        });
    }
}