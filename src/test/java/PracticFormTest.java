import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticFormTest {


    @BeforeAll
    @DisplayName("Настройки перед каждым тестом")
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
    }

    @Test
    @DisplayName("Заполнение PracticForm")
    public void practicFormTraning() {

        //open
        open("https://demoqa.com/automation-practice-form");

        //action
        $("#firstName").sendKeys("Lyonya");
        $("#lastName").sendKeys("Zakharov");
        $("#userEmail").sendKeys("Zakharov290895@yahoo.com");
        $("#gender-radio-1").parent().$(byText("Male")).click();
        $("#gender-radio-1").scrollTo();

        $("#userNumber").sendKeys("1234567890");
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--015").click();
        $("#subjectsInput").setValue("Mat").pressEnter();
        $("#subjectsInput").setValue("P").pressEnter();
        $("#subjectsInput").setValue("Che").pressEnter();
        $("#hobbies-checkbox-1").parent().$(byText("Sports")).click();
        //$("#uploadPicture").uploadFromClasspath("pic1.jpg");
        $("#uploadPicture").uploadFile(new File("src/test/resources/pic1.jpg"));
        $("#currentAddress").sendKeys("Address");
        //
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#city").$(byText("Noida")).click();
        //$("#submit").click(ClickOptions.usingJavaScript());
        $("#submit").click();

        //asserts

        $(".modal-dialog").shouldHave(appear);
        $(".modal-dialog").shouldHave(text("Thanks for submitting the form"));
        sleep(5000);

    }
}
