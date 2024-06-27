import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class CheckBoxTest {

    public SelenideElement
            checkBox = $(".rct-checkbox");

    @BeforeAll
    @DisplayName("Настройки перед каждым тестом")
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/checkbox";
    }

   /* @Attachment(value = "Мой любимый скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenShot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
*/
    @Test
    @DisplayName("Проверка элемента CheckBox")
    public void selectAllBoxesByTitle() {

        //step("Открытие страницы", () -> {
        open("https://demoqa.com/checkbox");
        //  attachScreenShot();
        //});

        //step("Клик по CheckBox", () -> {
        //checkBox.click();
        checkBox.parent().$(byText("Home")).click();
        checkBox.parent().$(byText("Home")).click();
        //attachScreenShot();
        //});

        //step("Результат", () -> {
        checkBox.should(be(visible));
        checkBox.should(be(exist));
        //  attachScreenShot();
        //});
    }
}
