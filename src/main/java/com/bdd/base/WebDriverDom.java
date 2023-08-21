package com.bdd.base;

import com.bdd.util.UtilWeb;
import io.cucumber.java.Scenario;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class WebDriverDom extends PageObject {
    private static final String DOCUMENT_QUERY_SELECTOR = "return document.querySelector(";

    public int IMPLICIT_WAIT_TIME_SECONDS;

    public WebDriverDom() {
        this.IMPLICIT_WAIT_TIME_SECONDS = 30;
        PageFactory.initElements(getDriver(), this);
    }

    protected WebElement waitUntilElementIsVisible(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), this.IMPLICIT_WAIT_TIME_SECONDS);
        return (WebElement) webDriverWait.until((Function) ExpectedConditions.visibilityOf(webElement));
    }

    protected void clickElement(WebElement element) {
        element.click();
    }

    protected WebElement waitUntilElementIsClickable(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), this.IMPLICIT_WAIT_TIME_SECONDS);
        return (WebElement) webDriverWait.until((Function) ExpectedConditions.elementToBeClickable(webElement));
    }


    protected WebElement webDriverWait(WebElement element, int timeOnSeconds) {
        return (WebElement) (new WebDriverWait(getDriver(), timeOnSeconds)).until((Function) ExpectedConditions.visibilityOf(element));
    }

    protected WebElement webElement(WebElement element) {
        return new WebDriverWait(getDriver(), 60).until(ExpectedConditions.visibilityOf(element));
    }

    protected String getTextFromElement(WebElement element) {
        return element.getText();
    }

    protected void sendKeysElement(WebElement webElement, String value) {
        webElement.sendKeys(new CharSequence[]{value});
    }

    protected void waitForElement(WebElement element, int timeOnSeconds) {
        webDriverWait(element, timeOnSeconds);
    }

    protected void waitUntilVisible(WebElement element, int timeOutOnSeconds) {
        waitUntilElementIsVisible(element);
        do {
            if (element.isDisplayed() && element.isEnabled())
                return;
            --timeOutOnSeconds;
        } while (timeOutOnSeconds > 0);
    }

    protected void scrollToElement(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element);
        actions.perform();
    }

    protected void scrollByJavaScriptToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", new Object[]{element});
    }

    protected void typeOnElement(WebElement webElement, String value) {
        webElement.sendKeys(new CharSequence[]{value});
    }

    protected boolean waitElementIsVisible(WebElement element, int timeOutOnSeconds) {
        boolean value = false;
        for (int c = 0; c <= timeOutOnSeconds; c++) {
            try {
                Thread.sleep(1000L);
                value = element.isDisplayed();
                break;
            } catch (Exception e) {
                UtilWeb.logger(getClass()).throwing(getClass().getName(), "waitElementIsVisible", e);
            }
        }
        return value;
    }

    protected void scrollFromElements(WebElement appBase, String pathCss, int indice) {
        JavascriptExecutor ex = (JavascriptExecutor) getDriver();
        String[] parts = String.valueOf(appBase).split(":");
        String elementBase = parts[2].replace("//", "").replace("]", "").trim();
        String query = shadowRootQuerySelectorAll(elementBase, pathCss) + "[" + indice + "].scrollIntoView()";
        ex.executeScript(query, new Object[0]);
    }

    protected void actionScroll(String action) {
        JavascriptExecutor ex = (JavascriptExecutor) getDriver();
        String e = "window.scrollTo(0,document.body.action)";
        switch (action) {
            case "top":
                e = e.replace("action", "scrollTop");
                break;
            case "down":
                e = e.replace("action", "scrollHeight");
                break;
        }
        ex.executeScript(e, new Object[0]);
    }

    protected WebElement waitElement(WebElement element, int timeOnSeconds) {
        return (WebElement) (new WebDriverWait(getDriver(), timeOnSeconds)).until((Function) ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitElementIsClickeable(WebElement element, int timeOnSeconds) {
        return (WebElement) (new WebDriverWait(getDriver(), timeOnSeconds)).until((Function) ExpectedConditions.elementToBeClickable(element));
    }

    protected void generarEvidencia(Scenario scenario) {
        byte[] screenshot = (byte[]) ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "evidencia");
    }

    protected void clicDerechoEnElemento(WebElement elemento) {
        Actions acciones = new Actions(getDriver());
        acciones.contextClick(elemento);
        acciones.perform();
    }

    protected String shadowRootQuerySelectorAll(String elementBase, String pathCss) {
        return "return document.querySelector(\"" + elementBase + "\").shadowRoot.querySelectorAll(\"" + pathCss + "\")";
    }

}
