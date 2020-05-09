package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AllureUtils {
    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
/*
  @Attachment(type = "image/png")
  public byte[] screenshot() throws IOException {
    File screenshot = Screenshots.getScreenShotAsFile();
    return Files.toByteArray(screenshot);
  }
 */