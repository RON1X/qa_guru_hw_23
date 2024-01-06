package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${deviceHost}.properties"
})
public interface LocalConfig extends Config {

    @Key("deviceModel")
    @DefaultValue("Google Pixel 3")
    String getDeviceModel();

    @Key("systemVersion")
    @DefaultValue("9.0")
    String getSystemVersion();

    @Key("appVersion")
    String getAppVersion();

    @Key("appUrl")
    String getAppUrl();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();
}