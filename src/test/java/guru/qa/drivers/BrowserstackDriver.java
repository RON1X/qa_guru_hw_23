package guru.qa.drivers;

import com.codeborne.selenide.WebDriverProvider;
import guru.qa.config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", config.getUserName());
        caps.setCapability("browserstack.key", config.getAccessKey());
        caps.setCapability("app", config.getApp());
        caps.setCapability("device", config.getDevice());
        caps.setCapability("os_version", config.getOSVersion());
        caps.setCapability("project", "First Browserstack Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        System.out.println("browserstack.user:" + config.getUserName());
        System.out.println("browserstack.key:" + config.getAccessKey());
        System.out.println("app:" + config.getApp());
        System.out.println("device:" + config.getDevice());
        System.out.println("os_version:" + config.getOSVersion());
        System.out.println("URL:" + config.getUrl());

        try {
            return new RemoteWebDriver(new URL(config.getUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
