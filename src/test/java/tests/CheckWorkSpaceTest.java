package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckWorkSpaceTest extends BaseTest {

    @Test(description = "Check page Groups at WorkSpace")
    public void checkWorkSpaceGroups(){
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password);
        $("#btnLogin").click();
        $(By.xpath("//span[text()='Workspace']")).click();
        $(By.xpath("//span[text()='Groups']")).click();
        $(By.xpath("//div[@class='col-lg-12']//h1[text()='Groups']")).shouldBe(Condition.visible, Duration.ofSeconds(60));
    }

}
