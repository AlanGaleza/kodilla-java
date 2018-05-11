package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_DAY = "//span[contains(@class, \"_5k_4\")]/span/select[1]";
    public static final String XPATH_MONTH = "//span[contains(@class, \"_5k_4\")]/span/select[2]";
    public static final String XPATH_YEAR = "//span[contains(@class, \"_5k_4\")]/span/select[3]";


    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com");

        WebElement selectDayElement = driver.findElement(By.xpath(XPATH_DAY));
        Select selectDay = new Select(selectDayElement);
        selectDay.selectByValue("22");

        WebElement selectMonthElement = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(selectMonthElement);
        selectMonth.selectByValue("6");

        WebElement selectYearElement = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(selectYearElement);
        selectYear.selectByVisibleText("2018");
    }
}
