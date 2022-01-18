import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

    @Test
    public void Login(){
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password);
        $("#btnLogin").click();
        $(By.id("createButton")).shouldBe(Condition.visible, Duration.ofSeconds(60));
    }
    @Test
    public void Login2(){
        open("/login");
        $("#inputEmail").sendKeys("taeyeononni@gmail.com");
        $(By.xpath("//*[@id='inputPassword']")).setValue("12345678");
        $("#btnLogin").click();
        $(By.id("createButton")).shouldBe(Condition.visible);
    }
}
