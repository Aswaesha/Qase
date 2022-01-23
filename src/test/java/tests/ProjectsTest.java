package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsTest extends BaseTest {

    @Test(description = "Create new project")
    public void createNewProject() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password);
        $("#btnLogin").click();

        $("#createButton").click();
        $("#inputTitle").sendKeys("Qase");
        $("#inputDescription").sendKeys("Testing website qase.io");
        $("#private-access-type").shouldBe(Condition.selected);
        $("#accessNone").click();
        $("#accessNone").shouldBe(Condition.selected);
        $(By.xpath("//button[text()='Create project']")).click();

        $(By.id("create-suite-button")).shouldBe(Condition.visible, Duration.ofSeconds(60));
    }
}
