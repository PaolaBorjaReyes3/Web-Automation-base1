package com.bdd.lib;

import com.bdd.util.UtilWeb;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;

public final class WebDriverManager {
    private static final String CLASS_NAME = WebDriverManager.class.getName();
    private static final String USER_DIR = "user.dir";
    private static final String OS_NAME = "os.name";
    private static final String MSJ_OS = "Sistema Opertivo: ";
    private static WebDriver webDriver;


    public static void stopWebDriver() {
        if (webDriver != null) {
            UtilWeb.logger(WebDriverManager.class).log(Level.INFO, "Deteniendo el driver {0}", webDriver);
            webDriver.quit();
        }
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null)
            UtilWeb.logger(WebDriverManager.class).log(Level.WARNING, "Driver no existe");
        return webDriver;
    }

    public static void maximizeWindows() {
        getWebDriver().manage().window().maximize();
    }

    public static void fullScreenWindows() {
        getWebDriver().manage().window().fullscreen();
    }

}