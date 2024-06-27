import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RadioButtonTest {


    @BeforeAll
    @DisplayName("Настройки перед каждым тестом")
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/radio-button";
    }

    @Test
    @DisplayName("Проверка кликабельности RadioButton")
    public void clickRadioButton(){

        //open
        open("https://demoqa.com/radio-button");

        //action
        $("#yesRadio").doubleClick();

        //asserts
        $("#yesRadio").isSelected();
        //$("#yesRadio").should(be(visible));
        $("#impressiveRadio").shouldNotBe((visible));

    }
}
