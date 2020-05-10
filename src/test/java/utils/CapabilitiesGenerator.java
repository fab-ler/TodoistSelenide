package utils;


import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Class presents functionality for generation of {@link org.openqa.selenium.remote.DesiredCapabilities} object
 * need for some browsers start
 */

public class CapabilitiesGenerator {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        String driverPath = "src/test/resources/webdrivers";
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println(("Operational system: " + os + "; Driver path: " + driverPath));
        System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        return options;
    }
}
