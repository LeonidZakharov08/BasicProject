import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TrivioSearchAvio {

    @BeforeAll
    @DisplayName("Настройки перед каждым тестом")
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://corporate.trivio.ru/avia/addservice";
    }

    @Test
    @DisplayName("Поиск Авиабилетов")
    public void searchAvioTickets() {

        open("https://corporate.trivio.ru/avia/addservice");

        //action

        $("#1719416628846").sendKeys("Москва");

    }
}
