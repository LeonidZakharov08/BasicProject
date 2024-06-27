import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class TextBoxTest {

    Faker faker = new Faker(new Locale("en"));

    String name = faker.name().name();
    String email = faker.internet().emailAddress();
    String address = faker.address().fullAddress();

    SelenideElement
            userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submit = $("#submit"),
            output = $("#output");

    @BeforeAll
    @DisplayName("Настройки перед каждым тестом")
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        baseUrl = "https://demoqa.com/text-box/";
        //  Configuration.holdBrowserOpen = true;
        //  Configuration.browser = "Edge";
    }

   /* @Attachment(value = "Мой любимый скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }*/

    @Test
    @DisplayName("Форма TextBox")
    public void textForInput() {

        //SelenideLogger.addListener("allure", new AllureSelenide());

        //step("Открытие страницы", () -> {
        open(baseUrl);
        //  attachScreenshot();
        //});

        //step("Заполнение формы", () -> {
        userName.val(name);
        userEmail.val(email);
        currentAddress.val(address);
        permanentAddress.val(address);
        submit.click();
        //  attachScreenshot();
        //});

        //step("Результат заполнения формы", () -> {
        output.shouldHave(text("Name:" + name),
                text("Email:" + email),
                text("Current Address :" + address),
                text("Permananet Address :" + address));
        //  attachScreenshot();
        //});

    }
}
