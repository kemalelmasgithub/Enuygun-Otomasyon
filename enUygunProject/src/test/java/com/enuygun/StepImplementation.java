package com.enuygun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class StepImplementation extends BaseTest {
    private static final Logger logger = LogManager.getLogger(StepImplementation.class);
    private static final int DEFAULT_WAIT_TIME = 10;

    // Dinamik bekleme - Elementin tıklanabilir olmasını bekler
    public void waitForElementToBeClickable(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIME))
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    // Dinamik bekleme - Elementin görünür olmasını bekler
    public void waitForElementToBeVisible(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIME))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @Step("<second> saniye bekle")
    public void waitForsecond(int second) throws InterruptedException {
        Thread.sleep(1000 * second);
    }

    @Step("<Key> İd'li elemente tıkla")
    public void clickElementByid(String Key) {
        By by = By.id(Key);
        waitForElementToBeClickable(by);
        driver.findElement(by).click();
        logger.info("Elemente tıklandı: " + Key);
    }

    @Step("<Key> İd'li elemente <keywordc> değerini yaz")
    public void SendkeyElementByid(String Key, String keywordc) {
        By by = By.id(Key);
        waitForElementToBeVisible(by);
        driver.findElement(by).sendKeys(keywordc);
        logger.info("Elemente değer yazıldı: " + keywordc + " - Element ID: " + Key);
    }

    @Step("<Key> xpath'li elemente tıkla")
    public void clickElementByxpath(String Key) {
        By by = By.xpath(Key);
        waitForElementToBeClickable(by);
        driver.findElement(by).click();
        logger.info("Elemente tıklandı: " + Key);
    }

    @Step("<Key> xpath'li elemente <keywordc> değerini yaz")
    public void SendkeyElementByxpath(String Key, String keywordc) {
        By by = By.xpath(Key);
        waitForElementToBeVisible(by);
        driver.findElement(by).sendKeys(keywordc);
        logger.info("Elemente değer yazıldı: " + keywordc + " - Element Xpath: " + Key);
    }

    @Step("Elementi <xpath> bul ve <keyword> değerini kontrol et")
    public void textControl(String xpath, String keyword) {
        By by = By.xpath(xpath);
        waitForElementToBeVisible(by);
        String text = driver.findElement(by).getText();
        Assert.assertTrue("Text değeri bulunamadı ", text.equals(keyword));
        logger.info("Text kontrol edildi. Beklenen: " + keyword + ", Bulunan: " + text);
    }

    public List<WebElement> listElements(String xpath) {
        By by = By.xpath(xpath);
        waitForElementToBeVisible(by);
        return driver.findElements(by);
    }

    @Step("Rastgele ürün seç <xpath> ifadesine göre ve <wait> saniye bekle")
    public void randomClick(String xpath, int wait) throws InterruptedException {
        List<WebElement> elements = listElements(xpath);
        if (!elements.isEmpty()) {
            elements.get(new Random().nextInt(elements.size())).click();
            logger.info("Rastgele elemente tıklandı.");
        } else {
            logger.warn("Hiçbir element bulunamadı. XPath: " + xpath);
        }
        waitForsecond(wait);
    }
    @Step("<Key> xpath'li elemente kalkış bilgisi icin <keywordc> değerini yaz")
    public void FirstFlight(String Key, String keywordc) {
        By by = By.xpath(Key);
        waitForElementToBeVisible(by);
        driver.findElement(by).sendKeys(keywordc);
        logger.info("Elemente değer yazıldı: " + keywordc + " - Element Xpath: " + Key);
    }
    @Step("<Key> xpath'li elemente inis bilgisi icin <keywordc> değerini yaz")
    public void SecondFlight(String Key, String keywordc) {
        By by = By.xpath(Key);
        waitForElementToBeVisible(by);
        driver.findElement(by).sendKeys(keywordc);
        logger.info("Elemente değer yazıldı: " + keywordc + " - Element Xpath: " + Key);
    }


}

