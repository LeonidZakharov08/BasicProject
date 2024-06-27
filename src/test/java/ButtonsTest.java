import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Configuration.baseUrl;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class ButtonsTest {

    SelenideElement
            doubleClick = $("#doubleClickBtn"),
            rightClick = $("#rightClickBtn"),
            //dynamicClick = $("#iZBTf"),
            doubleMessage = $("#doubleClickMessage"),
            rightMessage = $("#rightClickMessage");
            //dynamicMessage = $("#dynamicClickMessage");


    /*@Attachment(value = "Мой любимый скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenShot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }*/


    @BeforeAll
    @DisplayName("Настройки перед каждым новым тестом")
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        baseUrl = "https://demoqa.com/buttons";
    }

    @Test
    @DisplayName("Проверка кликабельности кнопок")
    public void buttonsClick() {

        //open

        //step("Открытие страницы", () -> {
            open("https://demoqa.com/buttons");
          //  attachScreenShot();
        //});

        //action

        //step("Клик по кнопкам", () -> {
            doubleClick.doubleClick();
            rightClick.contextClick();
           // dynamicClick.click();
            //attachScreenShot();
        //});

        //assert

        //step("Результат", () -> {
            doubleMessage.shouldHave(text("You have done a double click"));
            rightMessage.shouldHave(text("You have done a right click"));
            //dynamicMessage.shouldHave(text("You have done a dynamic click"));
           // attachScreenShot();
        //});
    }
}
