package com.bdd.util;

import com.bdd.generic.Constants;
import com.bdd.lib.WebDriverManager;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.PropertiesFileLocalPreferences;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilWeb {

    public static final String TYPESAFE_CONFIG_FILE = "serenity.conf";
    private static EnvironmentVariables environmentVariables;

    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PropertiesFileLocalPreferences.class);
    private String PROPERTIES;
    private String SERENITY_CONF_FILE;
    public static final String CLASS_NAME = "UtilWeb";
    private static final String DOWNLOAD_DIRECTORY = "/download/";

    private static final EnvironmentVariables ENVIRONMENT_VARIABLES = SystemEnvironmentVariables.createEnvironmentVariables();

    public static void takeScreenshot(WebDriver driver) throws Throwable {
        String filePath = System.getProperty("user.dir") + UtilWeb.getStringEvironmentProperty(environmentVariables, "evidencia.outputDirectory");

        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
        File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
        filePath = filePath + getScenarioName() + ".png";
        try {
            FileHandler.copy(screenshotFile, new File(filePath));
            System.out.println("Captura de pantalla guardada en: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al guardar la captura de pantalla: " + e.getMessage());
        }
    }

    public static String getCurrentDateWithFormat(String format) {
        return (new SimpleDateFormat(format)).format(Calendar.getInstance().getTime());
    }

    public static Logger logger(@NotNull Class clase) {
        return Logger.getLogger(clase.getName());
    }

    public static void configureDownload(ChromeOptions chromeOptions) {
        String base = (new File("")).getAbsolutePath() + "/download/";
        if (!(new File(base)).exists() && (new File(base)).mkdir())
            logger(WebDriverManager.class).log(Level.INFO, "Se creo el directorio de descargas.");
        HashMap<String, Object> chromePrefs = new HashMap<>();
        try {
            chromePrefs.put("download.default_directory", base);
            chromeOptions.setExperimentalOption("prefs", chromePrefs);
        } catch (Exception e) {
            logger(WebDriverManager.class).log(Level.INFO, "No existe el directorio o es nulo");
        }
    }


    /**
     * Obtener la fecha actual a partir de un formato especifico
     *
     * @return la fecha formateada
     */
    public static String currentDateString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Constants.FORMAT_DATE);
        return dtf.format(LocalDateTime.now());
    }

    /**
     * Obteniene caracter por caracter de una cadena de caracteres
     *
     * @param value Cadena de caracteres
     * @return retorna un solo caracter de la cadena de caracteres
     */
    public static String getChartByChart(String value) {
        String chart = StringUtils.EMPTY;
        for (int i = 0; i < value.length(); i++) {
            chart = String.valueOf(value.charAt(i));
        }
        return chart;
    }

    public static EnvironmentVariables createEnvironmentVariables() {
        Properties properties = loadProperties("serenity.properties");
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        environmentVariables.getProperties().putAll(properties);
        return environmentVariables;
    }

    public static boolean getBooleanEvironmentProperty(EnvironmentVariables environmentVariables, String property) throws Throwable {
        return Boolean.parseBoolean(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(property));
    }

    public static String getStringEvironmentProperty(EnvironmentVariables environmentVariables, String property) throws Throwable {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(property);
    }

    public static EnvironmentVariables getEnvironment() {
        return environmentVariables;
    }

    public static void setEnvironment(EnvironmentVariables environment) {
        UtilWeb.environmentVariables = environment;
    }

    public static String getPropertyValue(String propertyName) {
        return EnvironmentSpecificConfiguration.from(ENVIRONMENT_VARIABLES).getProperty(propertyName);
    }

    private static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(fileName);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return properties;
    }


    public static void setScenarioName(String name) {
        Constants.SCENARIO = name;
    }

    public static String getScenarioName() {
        return Constants.SCENARIO;
    }
}

