import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TrivioTests {

    @BeforeAll
    @DisplayName("Настройки перед каждым тестом")
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://login.trivio.ru/";
        Configuration.browser = "edge";
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

    @Test
    @DisplayName("Поиск Авиабилетов")
    public void searchAvioTickets() {

        open("https://login.trivio.ru/");


        //action
        $("#inputLogin").sendKeys("Demo3");
        $("#inputPassword").sendKeys("demo");
        $("#button_submit").click();
        $(By.className("TopServiceSelect_navLink_ftWUt")).click();
        $(By.className("Search_submit_XjSeY")).shouldBe(text("Найти"));


        /* -так же можем прокинуться так, но в крайнем случае, лучше убедиться, что тест проходит и поискать другой локатор
        $(By.xpath("//*[@id=\"app\"]/div/main/div/div/div[1]/div[2]/div[2]/div[2]")).shouldBe(visible);
*/
    }

}
