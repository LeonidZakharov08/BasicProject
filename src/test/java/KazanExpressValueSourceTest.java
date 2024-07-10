import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.*;

public class KazanExpressValueSourceTest {

    @BeforeAll
    @DisplayName("Настройки перед каждым тестом")
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://mm.ru/";
    }

    @BeforeEach
    void setupTwo() {
        open("https://mm.ru");
    }

    @ParameterizedTest(name = "В поисковой выдаче на kazanexpress должно отображаться 48 результатов по запросу {0}")
    @ValueSource(strings = {"шампунь для собак", "шампунь для детей"})
    void SearchWithValueSource(String asserts) {

        $("[data-test-id=input__search]").setValue(asserts);
        $("[data-test-id=button__search]").click();
        $$("[data-test-id=list__products]>div").shouldHave(sizeGreaterThanOrEqual(48));
    }

}
