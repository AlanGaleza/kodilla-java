package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://alangaleza.github.io/";
    private WebDriver driver;
    private ThreadLocalRandom generator;

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }

    private void sendTestTaskToTrello (String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement((By.xpath(".//select[1]")));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard = theForm.findElement((By.xpath(".//button[contains(@class, \"card-creation\")]")));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);
    }

    public boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("alangaleza");
        driverTrello.findElement(By.id("password")).sendKeys("Trello2018#");
        driverTrello.findElement(By.id("login")).submit();

        Thread.sleep(2000);

        driverTrello.get("https://trello.com/alangaleza/boards");
        driverTrello.findElements(By.xpath("//a[@class=\"board-tile mod-light-background\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//span[@title=\"Kodilla Application\"]")).size() > 0)
                .forEach(aHref -> aHref.click());

        Thread.sleep(2000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .anyMatch(t -> t.getText().contains(taskName));

        driverTrello.quit();

        return result;
    }

    public boolean shouldDeleteTask(String taskName) {
        boolean result = false;
        result = driver.findElements(By.xpath("//p")).stream()
                .filter(p -> p.getText().equals(taskName))
                .collect(Collectors.toList())
                .size() > 0;

        if(result) {
            driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                    .filter(anyForm -> anyForm.findElement(By.xpath(".//p"))
                        .getText().equals(taskName))
                    .forEach(thisForm -> {
                        WebElement deleteElement = thisForm.findElement(By.xpath(".//button[4]"));
                        deleteElement.click();
                    });
        }

        return result;
    }

    @Before
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get(BASE_URL);
        generator = ThreadLocalRandom.current();
    }

    @After
    public void cleanUpAfterTest() {
        driver.quit();
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);

        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println(e);
        }

        assertThat(checkTaskExistsInTrello(taskName)).isTrue();
        assertThat(shouldDeleteTask(taskName)).isTrue();
    }
}
