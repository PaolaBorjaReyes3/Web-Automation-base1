package com.bdd.runner;

import com.bdd.lib.WebDriverManager;
import com.bdd.util.UtilWeb;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.bdd.util.UtilWeb.setEnvironment;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = {"json:target/build/cucumber.json"},
        features = {"src/test/resources/feature"},
        stepNotifications = true,
        glue = {"com.bdd.web.stepdefinition","com.intuit.karate"},
        tags = "@SauceTest"
)

public class RunnerCucumber {

    @BeforeClass
    public static void beforeExecution() {
        UtilWeb.logger(RunnerCucumber.class).info("BEFORE >>>");
        setEnvironment(UtilWeb.createEnvironmentVariables());
    }

    @AfterClass
    public static void afterExecution() {
        UtilWeb.logger(RunnerCucumber.class).info("AFTER >>>");
        if (WebDriverManager.getWebDriver() != null) {
            WebDriverManager.stopWebDriver();
        }
    }
}
