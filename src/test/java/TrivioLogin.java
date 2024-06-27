import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TrivioLogin {

    @BeforeAll
    @DisplayName("Настройки перед каждым тестом")
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://login.trivio.ru/";
    }

    @Test
    @DisplayName("Авторизация существующего пользователю")
    public void trivioLogin() {

        //open
        open("https://login.trivio.ru/");


        //action
        $("#inputLogin").sendKeys("Demo3");
        $("#inputPassword").sendKeys("demo");
        $("#button_submit").click();

        //asserts
        $(".DesktopIndex_title_h0RlW").shouldBe(text("Привет, Владимир!"));

    }




}
